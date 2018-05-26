package ru.lenarlenar.vkmessenger.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetail {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("photo_50")
    @Expose
    private String photo50;
    @SerializedName("verified")
    @Expose
    private Integer verified;

/*    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName ;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getFullName() {
        return firstName + " " + lastName ;
    }

//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public City getCity() {
//        return city;
//    }
//
//    public void setCity(City city) {
//        this.city = city;
//    }
//
//    public String getPhoto50() {
//        return photo50;
//    }
//
//    public void setPhoto50(String photo50) {
//        this.photo50 = photo50;
//    }
//
//    public Integer getVerified() {
//        return verified;
//    }
//
//    public void setVerified(Integer verified) {
//        this.verified = verified;
//    }

}