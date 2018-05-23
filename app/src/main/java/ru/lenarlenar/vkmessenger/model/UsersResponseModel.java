package ru.lenarlenar.vkmessenger.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by zvezdy.lord on 23.05.18.
 */

public class UsersResponseModel {

    @SerializedName("response")
    private VkUser[] users;

    public VkUser[] getUsers() {
        return users;
    }

    public void setUsers(VkUser[] user) {
        this.users = users;
    }
}
