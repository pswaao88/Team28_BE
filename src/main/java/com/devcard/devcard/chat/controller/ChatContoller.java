package com.devcard.devcard.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatContoller {

    @GetMapping("/chat")
    public String chatGET() {
        return "chat";
    }
}
