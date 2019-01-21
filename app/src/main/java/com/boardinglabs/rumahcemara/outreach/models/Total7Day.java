package com.boardinglabs.rumahcemara.outreach.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.Date;

import io.realm.RealmObject;

public class Total7Day extends RealmObject {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("total")
    @Expose
    private String total;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
