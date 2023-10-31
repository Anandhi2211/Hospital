package main.java.com.solvd.hospital.patient;

import main.java.com.solvd.hospital.appointment.Appointment;
import main.java.com.solvd.hospital.billing.Billing;
import main.java.com.solvd.hospital.doctor.Doctor;
import main.java.com.solvd.hospital.insurance.Insurance;
import main.java.com.solvd.hospital.labresults.LabResults;
import main.java.com.solvd.hospital.medication.Medication;
import main.java.com.solvd.hospital.personalInformation.PersonalInformation;

import java.util.ArrayList;

public class Patient {


    private String patientId;
    private String illnessCategory;
    private PersonalInformation personalInfo;

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(Doctor doctorList) {
        this.doctorList.add(doctorList);
    }

    private ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
    private ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
    private ArrayList<Medication> medicationInfoList = new ArrayList<Medication>();
    private ArrayList<Billing> billingInfoList = new ArrayList<Billing>();
    private ArrayList<LabResults> labResultsInfo = new ArrayList<LabResults>();
    private Insurance insuranceInfo = new Insurance();

    public Patient() {

    }


    public ArrayList<Billing> getBillingInfoList() {
        return billingInfoList;
    }

    public void setAppointmentInfo(ArrayList<Appointment> appointmentInfo) {
        this.appointmentList = appointmentInfo;
    }

    public void setAppointmentInfo(Appointment appointmentInfo) {
        this.appointmentList.add(appointmentInfo);
    }

    public void setMedicationInfoList(Medication medication) {
        this.medicationInfoList.add(medication);
    }

    public void setMedicationInfoList(ArrayList<Medication> medication) {
        this.medicationInfoList = medication;
    }

    public void setPersonalInfo(PersonalInformation personalInfo) {
        this.personalInfo = personalInfo;
    }

    public PersonalInformation getPersonalInfo() {
        return personalInfo;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }


    public String getIllnessCategory() {
        return illnessCategory;
    }

    public void setIllnessCategory(String illnessCategory) {
        this.illnessCategory = illnessCategory;
    }


    public ArrayList<Appointment> getAppointmentInfo() {
        return this.appointmentList;
    }

    public ArrayList<Medication> getMedicationInfo() {
        return this.medicationInfoList;
    }


    public Patient(String patientId) {
        this.patientId = patientId;
    }


}
