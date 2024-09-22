package com.devcard.devcard.card.dto;

import com.devcard.devcard.card.vo.Card;

import java.time.LocalDateTime;

public record CardResponseDto (
        Long id,
        String name,
        String company,
        String position,
        String email,
        String phone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
        // @Todo add : socialLinks
        // @Todo add: Tag
) {
    public static CardResponseDto fromEntity (Card card) {
        return new CardResponseDto(
                card.getId(),
                card.getName(),
                card.getCompany(),
                card.getPosition(),
                card.getEmail(),
                card.getPhone(),
                card.getCreatedAt(),
                card.getUpdatedAt()
        );
    }
}
