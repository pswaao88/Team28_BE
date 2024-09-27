package com.devcard.devcard.chat.repository;

import com.devcard.devcard.chat.model.ChatUser;
import com.devcard.devcard.chat.model.ChatRoom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    List<ChatUser> findByIdIn(List<Integer> participantsId);
}
