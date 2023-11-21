package com.solvd.hospital.patientrecord;

import com.solvd.hospital.billing.Billing;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.medicalrecords.IMedicalRecords;
import com.solvd.hospital.medicalrecords.MedicalRecord;
import com.solvd.hospital.patient.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PatientRecord implements IMedicalRecords {
    private static final Logger logger = LogManager.getLogger(PatientRecord.class);
    private Patient patient;
    private ArrayList<Billing> billingsList;
    private ArrayList<Doctor> assignedDoctorList;
    private ArrayList<MedicalRecord> medicalRecordList;
    private Boolean patientAssignedDoctor = false;
    private MedicalRecord medicalRecord = new MedicalRecord();
    public PatientRecord() {
    }
    public Patient getPatient() {
        return this.patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public ArrayList<Billing> getBillingsList() {

        return this.billingsList;
    }
    public void setBillingsList(Billing billingNumber) {

        if (billingsList == null) {
            this.billingsList = new ArrayList<>();
        }
        this.billingsList.add(billingNumber);
    }
    public ArrayList<Doctor> getAssignedDoctorList() {
        return this.assignedDoctorList;
    }
    public void setAssignedDoctor(Doctor doctor) {

        if (this.assignedDoctorList == null) {
            this.assignedDoctorList = new ArrayList<>();
        }
        this.assignedDoctorList.add(doctor);
    }
    public Boolean getPatientAssignedDoctor() {

        return this.patientAssignedDoctor;
    }
    public void setPatientAssignedDoctor(Boolean patientAssignedDoctor) {

        this.patientAssignedDoctor = patientAssignedDoctor;
    }
    public ArrayList<MedicalRecord> getMedicalRecords() {

        return this.medicalRecordList;
    }
    public void setMedicalRecords(MedicalRecord medicalRecord) {

        if (this.medicalRecordList == null) {
            this.medicalRecordList = new ArrayList<>();
        } else {
            this.medicalRecordList.add(medicalRecord);
        }
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
    public Boolean printPrescriptionStatus() {
        Boolean status = false;
        if (medicalRecordList != null) {
            for (MedicalRecord medicalRecord : medicalRecordList) {
                status = true;
            }
        }
        return status;
    }
    public String printTestName() {
        String testName = "No Test is assigned";
        if (medicalRecordList != null) {
            for (MedicalRecord medicalRecord : medicalRecordList) {
                testName = medicalRecord.getTestName();
            }
        }
        return testName;
    }
    private String printBillNumber() {
        String billNumber = "Bill Not Genereated";
        if (billingsList != null) {
            for (Billing billing : billingsList) {
                billNumber = billing.getBillingNumber();
            }
        }
        return billNumber;
    }
    public String toString() {
        return "\tPatient Id: " + this.getPatient().getPatientId() + "\n" +
                "\tDoctor Id: " + this.printDoctorInfo() + "\n" +
                "\tFirst Name: " + this.getPatient().getFirstName() + "\n" +
                "\tGender: " + this.getPatient().getGender() + "\n" +
                "\tContact Number: " + this.getPatient().getContactNumber() + "\n" +
                "\tEmail Address: " + this.getPatient().getEmailAddress() + "\n" +
                "\tInsurance Name: " + this.getPatient().getInsurance().getInsuranceName() + "\n" +
                "\tInsurance Number: " + this.getPatient().getInsurance().getInsuranceNumber() + "\n" +
                "\tAnnual Income : " + this.getPatient().getAnnualIncome()+ "\n" +
                "\tIllness Category: " + this.getPatient().getSymptoms().getPatientSymptom() + "\n" +
                "\tVisited status: " + this.getPatientAssignedDoctor() + "\n" +
                "\tPrescription Status: " + this.printPrescriptionStatus() + "\n" +
                "\tTest Name: " + this.printTestName() + "\n";
    }
    public void printInformation() {
        logger.info("Patient Id: " + this.getPatient().getPatientId());
        logger.info("Patient Name: " + this.getPatient().getFirstName());
        logger.info("Patient Symptoms: " + this.getPatient().getSymptoms().getPatientSymptom());
    }
    @Override
    public void printPatientMedicalRecords() {

        logger.info("Patient Id: " + this.getPatient().getPatientId());
        logger.info("Patient Name: " + this.getPatient().getFirstName());
        logger.info("Patient Symptoms: " + this.getPatient().getSymptoms().getPatientSymptom());
        for (MedicalRecord record : medicalRecordList) {
            logger.info("Patient Test Name: " + record.getTestName());
            logger.info("Patient Prescription Status: " + record.getPrescriptionStatus());
        }
    }
}
