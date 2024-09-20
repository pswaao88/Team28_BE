package chat.dto;

import java.util.List;

public record ChatRoomResponse(
    String chatId,
    List<String> participants,
    List<ChatMessageResponse> messages
) {

}
