package com.devcard.devcard.chat.dto;

import java.time.LocalDateTime;

public class ChatRoomListResponse {
    private String id;
    private String[] participants; // => 멤버
    private String lastMessage;
    private LocalDateTime lastMessageTime;

    public ChatRoomListResponse(long id, String[] participants, String lastMessage,
        LocalDateTime lastMessageTime) {
        this.id = "msg_" + id;
        this.participants = participants;
        this.lastMessage = lastMessage;
        this.lastMessageTime = lastMessageTime;
    }

    public String getId() {
        return id;
    }

    public String[] getParticipants() {
        return participants;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public LocalDateTime getLastMessageTime() {
        return lastMessageTime;
    }

    public void setId(long id) {
        this.id = "msg_"+id;
    }

    public void setParticipants(String[] participants) {
        this.participants = participants;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public void setLastMessageTime(LocalDateTime lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }
}
