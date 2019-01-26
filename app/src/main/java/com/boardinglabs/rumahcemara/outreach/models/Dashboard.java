package com.boardinglabs.rumahcemara.outreach.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;

public class Dashboard {
    @SerializedName("totalRange")
    @Expose
    private String totalRange;
    @SerializedName("totalMonth")
    @Expose
    private String totalMonth;
    @SerializedName("Total7day")
    @Expose
    private List<Total7Day> Total7day;

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

    public List<Total7Day> getTotal7day() {
        return Total7day;
    }

    public void setTotal7day(List<Total7Day> total7day) {
        Total7day = total7day;
    }
}
