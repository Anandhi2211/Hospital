package com.solvd.hospital.PatientRecord;

import com.solvd.hospital.billing.IBilling;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.medicalCategory.MedicalCategory;
import com.solvd.hospital.patient.Patient;
import com.solvd.hospital.patient.IHospitalAdmin;

import java.util.ArrayList;

public class PatientRecord extends Patient {
    private Boolean patientVisitedHospital = false;

    private MedicalCategory category = new MedicalCategory();
    private ArrayList<Doctor> assignedDoctorList = new ArrayList<Doctor>();
    private ArrayList<IBilling> IBillingInfoList = new ArrayList<IBilling>();


    public ArrayList<Doctor> getAssignedDoctorList() {

        return assignedDoctorList;
    }

    public void setAssignedDoctor(Doctor doctor) {

        this.assignedDoctorList.add(doctor);
    }

    public Boolean getPatientVisitedHospital() {

        return this.patientVisitedHospital;
    }

    public void setPatientVisitedHospital(Boolean patientVisitedHospital) {

        this.patientVisitedHospital = patientVisitedHospital;
    }

    public MedicalCategory getCategory() {

        return category;
    }

    public void setCategory(MedicalCategory category) {

        this.category = category;
    }

    public ArrayList<IBilling> getBillingInfoList() {

        return this.IBillingInfoList;
    }

    public void setBillingInfoList(IBilling IBilling) {

        this.IBillingInfoList.add(IBilling);
    }

    public String printDoctorInfo() {
        String infoToPrint = "No Doctor is assigned";
        if (assignedDoctorList != null) {
            for (Doctor assignedDocctor : assignedDoctorList) {
                infoToPrint = assignedDocctor.getDoctorId();
            }
        }
        return infoToPrint;
    }

    public String toString() {
        return "\tPatient Id: " + this.getPatientId() + "\n" +
                "\tDoctor Id: " + this.printDoctorInfo() + "\n" +
                " \tFirst Name: " + this.getFistName() + "\n" +
                " \tGender: " + this.getGender() + "\n" +
                " \tAge: " + this.getAge() + "\n" +
                " \tContact Number: " + this.getContactNumber() + "\n" +
                " \tEmail Address: " + this.getEmailAddress() + "\n" +
                " \tIllness Category: " + getCategory().getPatientSymtom() + "\n" +
                "\tVisited status: " + this.getPatientVisitedHospital() + "\n";
    }

    public void printInformation() {
        System.out.println("Patient Id: " + this.getPatientId());
        System.out.println("Patient Name: " + this.getFistName());
    }
}
