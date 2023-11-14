package com.solvd.hospital.PatientRecord;

import com.solvd.hospital.billing.Billing;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.medicalCategory.MedicalCategory;
import com.solvd.hospital.medicalrecords.IMedicalRecords;
import com.solvd.hospital.medicalrecords.MedicalRecords;
import com.solvd.hospital.patient.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PatientRecord extends Patient implements IMedicalRecords {
    private static final Logger logger = LogManager.getLogger(PatientRecord.class);

    private Boolean patientAssignedDoctor = false;

    private Boolean prescriptionStatus;

    private MedicalCategory category;

    private ArrayList<Billing> billingsList;
    private ArrayList<Doctor> assignedDoctorList;

    private ArrayList<MedicalRecords> medicalRecordsList;

    public PatientRecord() {

        if (this.assignedDoctorList == null) {
            this.assignedDoctorList = new ArrayList<>();
        }
        if (this.category == null) {
            this.category = new MedicalCategory();

        }
        if (this.medicalRecordsList == null) {
            this.medicalRecordsList = new ArrayList<>();
        }
        if (this.billingsList == null) {
            this.billingsList = new ArrayList<Billing>();
        }
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

    public MedicalCategory getCategory() {

        return category;
    }

    public void setCategory(MedicalCategory category) {

        this.category = category;
    }

    public ArrayList<MedicalRecords> getMedicalRecords() {
        return this.medicalRecordsList;
    }

    public void setMedicalRecords(MedicalRecords medicalRecord) {

        if (this.medicalRecordsList == null) {
            this.medicalRecordsList = new ArrayList<>();
        } else {
            this.medicalRecordsList.add(medicalRecord);
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
        Boolean prescriptionStatus = false;
        if (medicalRecordsList != null) {
            for (MedicalRecords medicalRecords : medicalRecordsList) {

                prescriptionStatus = true;
            }
        }
        return prescriptionStatus;
    }

    public String printTestName() {
        String testName = "No Test is assigned";
        if (medicalRecordsList != null) {
            for (MedicalRecords medicalRecords : medicalRecordsList) {
                testName = medicalRecords.getTestName();
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
        return "\tPatient Id: " + this.getPatientId() + "\n" +
                "\tDoctor Id: " + this.printDoctorInfo() + "\n" +
                "\tFirst Name: " + this.getFirstName() + "\n" +
                "\tGender: " + this.getGender() + "\n" +
                "\tAge: " + this.getAge() + "\n" +
                "\tContact Number: " + this.getContactNumber() + "\n" +
                "\tEmail Address: " + this.getEmailAddress() + "\n" +
                "\tIllness Category: " + this.getCategory().getPatientSymtom() + "\n" +
                "\tVisited status: " + this.getPatientAssignedDoctor() + "\n" +
                "\tPrescription status: " + this.printPrescriptionStatus() + "\n" +
                "\tTest Name: " + this.printTestName() + "\n" +
                "\t Billing Number: " + this.printBillNumber() + "\n";
    }

    public void printInformation() {
        logger.info("Patient Id: " + this.getPatientId());
        logger.info("Patient Name: " + this.getFirstName());
        logger.info("Patient Symtoms: " + this.getCategory().getPatientSymtom());
    }

    @Override
    public void printPatientMedicalRecords() {

        logger.info("Patient Id: " + this.getPatientId());
        logger.info("Patient Name: " + this.getFirstName());
        logger.info("Patient Symtoms: " + this.getCategory().getPatientSymtom());
        logger.info("Patient Prescription Status: " + this.printPrescriptionStatus());
        logger.info("Patient Test Name: " + this.printTestName());
    }
}
