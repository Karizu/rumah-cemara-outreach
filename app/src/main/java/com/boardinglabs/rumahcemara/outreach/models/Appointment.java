package com.boardinglabs.rumahcemara.outreach.models;

import android.support.v4.app.FragmentManager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Appointment extends RealmObject {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("group_id")
    @Expose
    private String group_id;
    @SerializedName("user_id")
    @Expose
    private String user_id;
    @SerializedName("provider_id")
    @Expose
    private String provider_id;
    @SerializedName("service_type_id")
    @Expose
    private String service_type_id;
    @SerializedName("worker_id")
    @Expose
    private String worker_id;
    @SerializedName("start_date")
    @Expose
    private String start_date;
    @SerializedName("end_date")
    @Expose
    private String end_date;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("attachment")
    @Expose
    private String attachment;
    @SerializedName("type_provider")
    @Expose
    private String type_provider;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("status_report")
    @Expose
    private int status_report;
    @SerializedName("group")
    @Expose
    private Group group;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("service_type")
    @Expose
    private ServiceType serviceType;
    @SerializedName("worker")
    @Expose
    private Worker worker;
    @SerializedName("provider_worker")
    @Expose
    private ProviderWorker providerWorker;
    @SerializedName("created_at")
    @Expose
    private Rating rating;
    @SerializedName("rating")
    @Expose
    private String created_at;
    @SerializedName("updated_at")
    @Expose
    private String updated_at;
    @SerializedName("deleted_at")
    @Expose
    private String deleted_at;
    @SerializedName("type")
    @Expose
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(String provider_id) {
        this.provider_id = provider_id;
    }

    public String getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(String service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(String worker_id) {
        this.worker_id = worker_id;
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

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getType_provider() {
        return type_provider;
    }

    public void setType_provider(String type_provider) {
        this.type_provider = type_provider;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus_report() {
        return status_report;
    }

    public void setStatus_report(int status_report) {
        this.status_report = status_report;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public ProviderWorker getProviderWorker() {
        return providerWorker;
    }

    public void setProviderWorker(ProviderWorker providerWorker) {
        this.providerWorker = providerWorker;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
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

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
