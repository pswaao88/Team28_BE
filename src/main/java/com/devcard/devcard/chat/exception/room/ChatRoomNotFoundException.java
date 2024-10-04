package com.devcard.devcard.chat.exception.room;

import org.springframework.http.HttpStatus;

public class ChatRoomNotFoundException extends ChatRoomException {

    public ChatRoomNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
