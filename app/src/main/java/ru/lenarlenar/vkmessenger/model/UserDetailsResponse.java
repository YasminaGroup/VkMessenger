package ru.lenarlenar.vkmessenger.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by zvezdy.lord on 23.05.18.
 */

public class UserDetailsResponse {

    @SerializedName("response")
    private UserDetail[] userDetails;

    public UserDetail[] getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetail[] user) {
        this.userDetails = userDetails;
    }
}
