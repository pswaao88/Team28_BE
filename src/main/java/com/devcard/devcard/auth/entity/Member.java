package com.devcard.devcard.auth.entity;

import jakarta.persistence.Entity;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String profileImg;
    private String username;
    private String nickname;
    private String role;

    @CreationTimestamp
    private Timestamp createDate;

    public Member() {
    }

    public Member(String email, String profileImg, String username, String nickname, String role, Timestamp createDate) {
        this.email = email;
        this.profileImg = profileImg;
        this.username = username;
        this.nickname = nickname;
        this.role = role;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public String getRole() {
        return role;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }
}


