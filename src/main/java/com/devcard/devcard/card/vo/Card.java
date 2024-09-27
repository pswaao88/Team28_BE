package com.devcard.devcard.card.vo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String githubId;
    private String name;
    private String company;
    private String position;
    private String email;
    private String phone;
    private String profilePicture;
    private String bio;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // @Todo add: socialLinks
    // @Todo add: tags

    protected Card() {

    }

    public Card(String name, String company, String email, String position, String phone) {
        this.name = name;
        this.company = company;
        this.email = email;
        this.position = position;
        this.phone = phone;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getGithubId() { return githubId; }
    public String getName() { return name; }
    public String getCompany() { return company; }
    public String getPosition() { return position; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getProfilePicture() { return profilePicture; }
    public String getBio() { return bio; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void update(Card updatedCard) {
        this.name = updatedCard.getName();
        this.company = updatedCard.getCompany();
        this.position = updatedCard.getPosition();
        this.email = updatedCard.getEmail();
        this.phone = updatedCard.getPhone();
        this.profilePicture = updatedCard.getProfilePicture();
        this.bio = updatedCard.getBio();
        this.updatedAt = LocalDateTime.now();
        // @Todo: 필요한 다른 필드도 업데이트
    }
}