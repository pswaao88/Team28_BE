package com.devcard.devcard.card.service;

import com.devcard.devcard.card.repository.CardRepository;
import com.devcard.devcard.card.entity.Card;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void createCard(Card card) {
        cardRepository.save(card);
    }

    public Card getCard(Long cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 명함을 찾을 수 없습니다."));
    }

    public Card updateCard(Long id, Card updatedCard) {
        Card existingCard = cardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 명함을 찾을 수 없습니다."));

        existingCard.update(updatedCard);
        return cardRepository.save(existingCard);
    }

    public void deleteCard(Long id) {
        if (!cardRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 명함을 찾을 수 없습니다.");
        }
        cardRepository.deleteById(id);
    }


}
