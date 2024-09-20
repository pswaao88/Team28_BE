package chat.repository;

import chat.model.ChatMessage;
import chat.model.ChatRoom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    List<ChatMessage> findByChatRoomOrderByTimestampAsc(ChatRoom chatRoom);

    void deleteByChatRoomId(Long chatRoomId);
}
