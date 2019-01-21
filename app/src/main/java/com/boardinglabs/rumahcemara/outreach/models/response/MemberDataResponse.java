package com.boardinglabs.rumahcemara.outreach.models.response;

import com.boardinglabs.rumahcemara.outreach.models.Appointment;
import com.boardinglabs.rumahcemara.outreach.models.MemberProfile;

public class MemberDataResponse extends GeneralDataResponse{
    private MemberProfile profile;

    public MemberProfile getProfile() {
        return profile;
    }

    public void setProfile(MemberProfile profile) {
        this.profile = profile;
    }
}