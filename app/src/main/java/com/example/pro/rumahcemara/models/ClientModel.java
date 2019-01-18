package com.example.pro.rumahcemara.models;

import android.support.v4.app.FragmentManager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientModel {

    @SerializedName("id")
    @Expose
    private String id;
    private String srcImage;
    private String fullName;
    private String phoneNumber;
    private String email;
    private User user;

    private FragmentManager fragmentManager;

    public ClientModel(String id, String srcImage, String fullName, String phoneNumber, String email, User user, FragmentManager fragmentManager) {
        this.id = id;
        this.srcImage = srcImage;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.user = user;
        this.fragmentManager = fragmentManager;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }
}
