package com.devcard.devcard.card.dto;

import com.devcard.devcard.card.vo.Card;

public record CardRequestDto (
        String name,
        String company,
        String position,
        String email,
        String phone
        // @Todo add : socialLinks
        // @Todo add: Tag
) {
    public Card toEntity() {
        return new Card(name, company, position, email, phone);
    }
}
