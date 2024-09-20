package chat.controller;

import chat.dto.ChatRoomResponse;
import chat.service.ChatRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chats")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    // 3. 특정 채팅방 조회
    @GetMapping("/{chatId}")
    public ResponseEntity<ChatRoomResponse> getChatRoomById(@PathVariable String chatId) {
        return ResponseEntity.ok(chatRoomService.getChatRoomById(chatId));
    }

    // 4. 특정 채팅방 삭제
    @DeleteMapping("/{chatId}")
    public ResponseEntity<Void> deleteChatRoom(@PathVariable String chatId) {
        chatRoomService.deleteChatRoom(chatId);
        return ResponseEntity.ok().build();
    }
}
