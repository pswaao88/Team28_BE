package com.devcard.devcard.chat.handler;

import com.devcard.devcard.chat.service.ChatRoomService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatHandler extends TextWebSocketHandler {

    // service 계층 사용
    private final ChatRoomService chatRoomService;
    // 의존성 주입
    public ChatHandler(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        String payload = textMessage.getPayload();
        String chatId = chatRoomService.extractChatId(payload);
        String message = chatRoomService.extractMessage(payload);
        List<WebSocketSession> chatRoom = chatRoomService.getChatRoomSessions(chatId);

        if(chatRoom != null){ // 채팅방이 있을 때
            for(WebSocketSession webSocketSession : chatRoom){ // 해당 채팅방의 모든 세션에 대해서 메세지 보내기
                if(webSocketSession.isOpen()){ // 세션이 열려있다면
                    try {
                        webSocketSession.sendMessage(new TextMessage(message)); // 세션에 메세지 보내기
                    }catch (IOException e){ // 오류 일시적 처리
                        // 추가적으로 로그를 남길지? 고민하기
                    }
                }
            }
        }
    }

    // 클라이언트 접속 시 호출
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        webSocketSessionList.add(session);
    }

    // 클라이언트 접속 해제 시 호출
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        webSocketSessionList.remove(session);
    }
}
