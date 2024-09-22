package com.devcard.devcard.chat.service;

import com.devcard.devcard.chat.dto.ChatMessageResponse;
import com.devcard.devcard.chat.dto.ChatRoomResponse;
import com.devcard.devcard.chat.model.Card;
import com.devcard.devcard.chat.model.ChatMessage;
import com.devcard.devcard.chat.model.ChatRoom;
import com.devcard.devcard.chat.repository.ChatMessageRepository;
import com.devcard.devcard.chat.repository.ChatRoomRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository, ChatMessageRepository chatMessageRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.chatMessageRepository = chatMessageRepository;
    }

    // 3. 특정 채팅방 조회
    @Transactional(readOnly = true)
    public ChatRoomResponse getChatRoomById(String chatId) {
        Long chatRoomId = extractChatRoomId(chatId);

        // 채팅방 조회
        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId)
            .orElseThrow(() -> new IllegalArgumentException("채팅방을 찾을 수 없습니다."));

        // 메시지 조회
        List<ChatMessage> messages = chatMessageRepository.findByChatRoomOrderByTimestampAsc(chatRoom);
        List<ChatMessageResponse> messageResponses = messages.stream()
            .map(message -> new ChatMessageResponse(
                message.getSender(),
                message.getContent(),
                message.getTimestamp()
            ))
            .collect(Collectors.toList());

        // 참가자 이름 조회
        List<String> participants = chatRoom.getParticipants().stream()
            .map(Card::getName)
            .collect(Collectors.toList());

        return new ChatRoomResponse(
            "chat_" + chatRoomId,
            participants,
            messageResponses
        );
    }

    // 4. 채팅방 삭제
    public void deleteChatRoom(String chatId) {
        Long chatRoomId = extractChatRoomId(chatId);
        // 관련된 메시지를 먼저 삭제
        chatMessageRepository.deleteByChatRoomId(chatRoomId);

        // 채팅방 삭제
        chatRoomRepository.deleteById(chatRoomId);
    }

    // chatId 에서 숫자만 추출하는 메서드
    private Long extractChatRoomId(String chatId) {
        return Long.parseLong(chatId.replace("chat_", ""));
    }
}
