package com.example.pro.rumahcemara.models.response;

import com.example.pro.rumahcemara.models.Appointment;


public class AppointmentDataResponse extends GeneralDataResponse {
    private Appointment appointmentRequest;

    public Appointment getAppointment() {
        return appointmentRequest;
    }

    public void setAppointment(Appointment appointmentRequest) {
        this.appointmentRequest = appointmentRequest;
    }
}
