package com.devcard.devcard.repository;

import com.devcard.devcard.vo.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long>{
}
