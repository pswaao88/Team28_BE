package com.devcard.devcard.chat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "chat_room")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "chat_room_participants")
    private List<chatUser> participants;
    private LocalDateTime createdAt;
    private String lastMessage;
    private LocalDateTime lastMessageTime;

    protected ChatRoom() {

    }

    public List<chatUser> getParticipants() {
        return participants;
    }
}
