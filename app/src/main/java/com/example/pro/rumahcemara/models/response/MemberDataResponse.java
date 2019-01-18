package com.example.pro.rumahcemara.models.response;

import com.example.pro.rumahcemara.models.Appointment;
import com.example.pro.rumahcemara.models.MemberProfile;

public class MemberDataResponse extends GeneralDataResponse{
    private MemberProfile profile;

    public MemberProfile getProfile() {
        return profile;
    }

    public void setProfile(MemberProfile profile) {
        this.profile = profile;
    }
}