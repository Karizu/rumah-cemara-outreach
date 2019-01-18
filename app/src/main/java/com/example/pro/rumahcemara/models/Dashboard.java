package com.example.pro.rumahcemara.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Dashboard extends RealmObject {
    @SerializedName("totalRange")
    @Expose
    private String totalRange;
    @SerializedName("totalMonth")
    @Expose
    private String totalMonth;

    public String getTotalRange() {
        return totalRange;
    }

    public void setTotalRange(String totalRange) {
        this.totalRange = totalRange;
    }

    public String getTotalMonth() {
        return totalMonth;
    }

    public void setTotalMonth(String totalMonth) {
        this.totalMonth = totalMonth;
    }

}
