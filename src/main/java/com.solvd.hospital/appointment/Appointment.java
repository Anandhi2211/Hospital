package com.solvd.hospital.appointment;

public class Appointment {

    private String appointmentStatus;
    private String nextAppointment;

    public void setAppointmentStatus(String appointmentStatus) {

        this.appointmentStatus = appointmentStatus;
    }

    public void setNextAppointment(String nextAppointment) {

        this.nextAppointment = nextAppointment;
    }

    public String getAppointmentStatus() {

        return appointmentStatus;
    }

    public String getNextAppointment() {

        return nextAppointment;
    }
}
