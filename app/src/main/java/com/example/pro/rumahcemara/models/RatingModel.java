package com.example.pro.rumahcemara.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingModel {

    @SerializedName("id")
    @Expose
    private String id;
    private String serviceName;
    private String fullName;
    private String phoneNumber;
    private String imgUrl;
    private String type;
    private String rating;
    private String description;
    private String created_at;
    private String updated_at;
    private Appointment service_transaction;

    public RatingModel(String id, String serviceName, String fullName, String phoneNumber, String imgUrl, String type, String rating, String description, String created_at, String updated_at, Appointment service_transaction) {
        this.id = id;
        this.serviceName = serviceName;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.imgUrl = imgUrl;
        this.type = type;
        this.rating = rating;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.service_transaction = service_transaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Appointment getService_transaction() {
        return service_transaction;
    }

    public void setService_transaction(Appointment service_transaction) {
        this.service_transaction = service_transaction;
    }
}
