package ru.lenarlenar.vkmessenger.model;

/**
 * Created by Ленар on 22.05.2018.
 */

import lombok.Getter;

@Getter
public class User {

    private final String name;
    private final String screenName;
    private final String profileImageUrl;

    public User(String name, String screenName, String profileImageUrl) {
        this.name = name;
        this.screenName = screenName;
        this.profileImageUrl = profileImageUrl;
    }
}