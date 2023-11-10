package com.solvd.hospital.PatientRecord;

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

    private Boolean patientVisitedHospital = false;

    private Boolean prescriptionStatus;

    private MedicalCategory category;

    private ArrayList<Doctor> assignedDoctorList;

    private ArrayList<MedicalRecords> medicalRecordsList;

    public PatientRecord() {

        if (this.assignedDoctorList == null) {
            this.assignedDoctorList = new ArrayList<Doctor>();
        }
        if (this.category == null) {
            this.category = new MedicalCategory();

        }
        if (this.medicalRecordsList == null) {
            this.medicalRecordsList = new ArrayList<MedicalRecords>();
        }
    }

    public ArrayList<Doctor> getAssignedDoctorList() {
        return this.assignedDoctorList;
    }

    public void setAssignedDoctor(Doctor doctor) {

        if (this.assignedDoctorList == null) {
            this.assignedDoctorList = new ArrayList<Doctor>();
        }
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

    public ArrayList<MedicalRecords> getMedicalRecords() {
        return this.medicalRecordsList;
    }

    public void setMedicalRecords(MedicalRecords medicalRecord) {

        if (this.medicalRecordsList == null) {
            this.medicalRecordsList = new ArrayList<MedicalRecords>();
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

    public String toString() {
        return "\tPatient Id: " + this.getPatientId() + "\n" +
                "\tDoctor Id: " + this.printDoctorInfo() + "\n" +
                " \tFirst Name: " + this.getFirstName() + "\n" +
                " \tGender: " + this.getGender() + "\n" +
                " \tAge: " + this.getAge() + "\n" +
                " \tContact Number: " + this.getContactNumber() + "\n" +
                " \tEmail Address: " + this.getEmailAddress() + "\n" +
                " \tIllness Category: " + this.getCategory().getPatientSymtom() + "\n" +
                "\tVisited status: " + this.getPatientVisitedHospital() + "\n" +
                "\tPrescription status: " + this.printPrescriptionStatus() + "\n" +
                "\tTest Name: " + this.printTestName() + "\n";
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
        logger.info("Patient Test Name: "+ this.printTestName());
    }
}
