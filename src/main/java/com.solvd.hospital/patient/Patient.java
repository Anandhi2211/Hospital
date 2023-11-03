package com.solvd.hospital.patient;

import com.solvd.hospital.medicalCategory.MedicalCategory;
import com.solvd.hospital.personalInformation.PersonalInformation;
import com.solvd.hospital.billing.Billing;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.medication.Medication;

import java.util.ArrayList;

public class Patient extends PersonalInformation {


    private String patientId;

    public MedicalCategory getCategory() {
        return category;
    }

    public void setCategory(MedicalCategory category) {
        this.category = category;
    }

    //  private String symptoms;
    private MedicalCategory category = new MedicalCategory();
    private PersonalInformation personalInfo;
    private ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
    private ArrayList<Medication> medicationInfoList = new ArrayList<Medication>();
    private ArrayList<Billing> BillingInfoList = new ArrayList<Billing>();

    public Patient() {
    }

    public String getPatientId() {

        return patientId;
    }

    public void setPatientId(String patientId) {

        this.patientId = patientId;
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

    public void setMedicationInfoList(Medication medication) {

        this.medicationInfoList.add(medication);
    }


    public void setPersonalInfo(PersonalInformation personalInfo) {

        this.personalInfo = personalInfo;
    }

    public PersonalInformation getPersonalInfo() {

        return personalInfo;
    }


    public ArrayList<Medication> getMedicationInfo() {

        return this.medicationInfoList;
    }


    public Patient(String patientId) {

        this.patientId = patientId;
    }


    @Override //Prints patients Id and First name
    public void printInformation() {

        System.out.println("Inside Abstract method");
        System.out.println("Patient Id: " + this.patientId);
        System.out.println("Patient Name: " + personalInfo.getFistName());
    }

    public void printPatientSymtoms(MedicalCategory category)
    {
        System.out.println("Symptoms: "+ category.getPatientSymtom());
    }

    @Override //prints Patients FirstName has Patient class as parameter
    public void printInformation(Patient patient) {

        System.out.println(patient.getFistName());
    }



    public String toString() {
        return "\tPatient Id: " + this.getPatientId() + "\n" +
                " First Name: " + personalInfo.getFistName() + "\n" +
                " Last Name: " + personalInfo.getLastName() + "\n" +
                " Gender: " + personalInfo.getGender() + "\n" +
                " Age: " + personalInfo.getAge() + "\n" +
                " Contact Number: " + personalInfo.getContactNumber() + "\n" +
                " Email Address: " + personalInfo.getEmailAddress() + "\n" +
                " Illness Category: " +  category.getPatientSymtom() + "\n" +
                " Medication Status: " + medicationInfoList.toString() + "\n" +
                "Billing Number: " + BillingInfoList.toString() ;

    }
}
