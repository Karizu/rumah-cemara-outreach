package com.boardinglabs.rumahcemara.outreach.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryModel {

    @SerializedName("id")
    @Expose
    private String serviceId;
    private String serviceName;
    private String imgUrl;
    private String fullName;
    private String phoneNumber;
    private String start_date;
    private String end_date;
    private String description;
    private String rating;
    private String comment;
    private String attachment;
    private Appointment appointment;

    public HistoryModel(String serviceId, String serviceName, String imgUrl, String fullName, String phoneNumber, String start_date, String end_date, String description, String rating, String comment, String attachment, Appointment appointment) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.imgUrl = imgUrl;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
        this.rating = rating;
        this.comment = comment;
        this.attachment = attachment;
        this.appointment = appointment;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

}