package com.devcard.devcard.chat.exception.room;

import com.devcard.devcard.chat.exception.ChatException;
import org.springframework.http.HttpStatus;

public class ChatRoomException extends ChatException {

    public ChatRoomException(String message, HttpStatus status) {
        super(message, status);
    }
}
