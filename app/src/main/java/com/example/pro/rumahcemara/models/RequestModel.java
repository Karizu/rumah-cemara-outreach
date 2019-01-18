package com.example.pro.rumahcemara.models;

import android.support.v4.app.FragmentManager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestModel {

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
    private String location;
    private Appointment appointment;
    private FragmentManager fragmentManager;

    public RequestModel(String serviceId, String serviceName, String imgUrl, String fullName, String phoneNumber, String start_date, String end_date, String description, String location, Appointment appointment, FragmentManager fragmentManager) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.imgUrl = imgUrl;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
        this.location = location;
        this.appointment = appointment;
        this.fragmentManager = fragmentManager;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }
}
