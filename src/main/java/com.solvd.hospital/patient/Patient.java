package com.solvd.hospital.patient;

import com.solvd.hospital.medicalCategory.MedicalCategory;
import com.solvd.hospital.personalInformation.PersonalInformation;
import com.solvd.hospital.billing.Billing;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.medication.Medication;

import java.util.ArrayList;

public class Patient extends PersonalInformation {

    private String patientId;

    public void setPersonalInfo(PersonalInformation personalInfo) {
        this.personalInfo = personalInfo;
    }

    private PersonalInformation personalInfo;

    private ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
    private ArrayList<Medication> medicationInfoList = new ArrayList<Medication>();
    private ArrayList<Billing> BillingInfoList = new ArrayList<Billing>();

    private MedicalCategory category = new MedicalCategory();

    public Patient() {
    }
    public String getPatientId() {

        return patientId;
    }

    public void setPatientId(String patientId) {

        this.patientId = patientId;
    }

    public MedicalCategory getCategory() {

        return category;
    }
    public void setCategory(MedicalCategory category) {

        this.category = category;
    }

    public ArrayList<Doctor> getDoctorList() {

        return doctorList;
    }

    public void setDoctorList(Doctor doctorList) {

        this.doctorList.add(doctorList);
    }

    public void setBillingInfoList(Billing billing) {

        this.BillingInfoList.add(billing);
    }

    public PersonalInformation getPersonalInfo() {

        return personalInfo;
    }


    @Override //Prints patients Id and First name
    public void printInformation() {

        System.out.println("Inside Abstract method");
        System.out.println("Patient Id: " + this.patientId);
        System.out.println("Patient Name: " + personalInfo.getFistName());
    }

    public void printPatientSymtoms(MedicalCategory category) {
        System.out.println("Symptoms: " + category.getPatientSymtom());
    }

    @Override //prints Patients FirstName has Patient class as parameter
    public void printInformation(Patient patient) {

        System.out.println(patient.getFistName());
    }

    public String toString() {
        return "\tPatient Id: " + this.getPatientId() + "\n" +
                " \tFirst Name: " + personalInfo.getFistName() + "\n" +
                " \tLast Name: " + personalInfo.getLastName() + "\n" +
                " \tGender: " + personalInfo.getGender() + "\n" +
                " \tAge: " + personalInfo.getAge() + "\n" +
                " \tContact Number: " + personalInfo.getContactNumber() + "\n" +
                " \tEmail Address: " + personalInfo.getEmailAddress() + "\n" +
                " \tIllness Category: " + category.getPatientSymtom() + "\n" +
                " \tMedication Status: " + medicationInfoList.toString() + "\n" +
                "\tBilling Number: " + BillingInfoList.toString() + "\n";

    }
}
