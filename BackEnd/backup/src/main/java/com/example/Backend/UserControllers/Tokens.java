package com.example.Backend.UserControllers;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "Tokens")
public class Tokens {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @NotFound(action = NotFoundAction.IGNORE)
    private int tokenId;

    @Column(name = "token")
    @NotFound(action = NotFoundAction.IGNORE)
    private String token;

    @Column(name = "expires")
    @NotFound(action = NotFoundAction.IGNORE)
    private long expires;

    public void setUserId(int tokenId) {
        this.tokenId = tokenId;
    }

    public int getUserId() {
        return tokenId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }
}
