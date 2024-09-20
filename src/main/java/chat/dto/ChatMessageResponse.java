package chat.dto;

import java.time.LocalDateTime;

public record ChatMessageResponse(
    String sender,
    String content,
    LocalDateTime timestamp
) {

}
