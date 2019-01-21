package com.boardinglabs.rumahcemara.outreach.models.response;

import com.boardinglabs.rumahcemara.outreach.models.Appointment;


public class AppointmentDataResponse extends GeneralDataResponse {
    private Appointment appointmentRequest;

    public Appointment getAppointment() {
        return appointmentRequest;
    }

    public void setAppointment(Appointment appointmentRequest) {
        this.appointmentRequest = appointmentRequest;
    }
}
