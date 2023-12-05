package com.solvd.hospital.patientrecord;

import com.solvd.hospital.billing.Billing;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.financialbenefits.FinancialBenefits;
import com.solvd.hospital.medicalrecords.MedicalRecord;
import com.solvd.hospital.patient.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PatientRecord  {
    private static final Logger logger = LogManager.getLogger(PatientRecord.class);
    private Patient patient;
    private Billing billing;
    private ArrayList<Doctor> assignedDoctorList;
    private MedicalRecord medicalRecord;
    private FinancialBenefits financialBenefits = new FinancialBenefits();
    private boolean patientAssignedDoctor;
    public PatientRecord() {
    }
    public Patient getPatient() {
        return this.patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
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
    public boolean getPatientAssignedDoctor() {
        return this.patientAssignedDoctor;
    }
    public void setPatientAssignedDoctor(boolean patientAssignedDoctor) {
        this.patientAssignedDoctor = patientAssignedDoctor;
    }
    public boolean isPatientAssignedDoctor() {
        return patientAssignedDoctor;
    }
    public void setAssignedDoctorList(ArrayList<Doctor> assignedDoctorList) {
        this.assignedDoctorList = assignedDoctorList;
    }
    public void setBilling(Billing billing) {
        this.billing = billing;
    }
    public Billing getBilling() {
        return this.billing;
    }
    public FinancialBenefits getFinancialBenefits() {
        return this.financialBenefits;
    }
    public void setFinancialBenefits(FinancialBenefits financialBenefits) {
        this.financialBenefits = financialBenefits;
    }
    public MedicalRecord getMedicalRecord() {
        if (this.medicalRecord == null) {
            this.medicalRecord = new MedicalRecord();
        }
        return this.medicalRecord;
    }
    public void setMedicalRecord(MedicalRecord medicalRecord) {
        if (medicalRecord == null) {
            this.medicalRecord = new MedicalRecord();
        }
        this.medicalRecord = medicalRecord;
    }
    public String printDoctorInfo()
    {
        return assignedDoctorList == null || assignedDoctorList.isEmpty() ?  "NO DOC is assigned " :
                assignedDoctorList.stream().map(doctor -> doctor.getDoctorId()).findAny().get();
//        String infoToPrint = "No Doctor is assigned";
//        if (assignedDoctorList != null) {
//            for (Doctor assignedDocctor : assignedDoctorList) {
//                infoToPrint = assignedDocctor.getDoctorId();
//            }
//        }
//        return infoToPrint;
//        return assignedDoctorList==null? "no doc":assignedDoctorList.stream().map(doctor -> doctor.getDoctorId());
    }
    public String toString() {
        return "\tPatient Id: " + this.getPatient().getPatientId() + "\n" +
                "\tDoctor Id: " + this.printDoctorInfo() + "\n" +
                "\tFirst Name: " + this.getPatient().getPersonalInformation().getFirstName() + "\n" +
                "\tGender: " + this.getPatient().getPersonalInformation().getGender() + "\n" +
                "\tContact Number: " + this.getPatient().getPersonalInformation().getContactNumber() + "\n" +
                "\tEmail Address: " + this.getPatient().getPersonalInformation().getEmailAddress() + "\n" +
                "\tInsurance Name: " + this.getPatient().getInsurance().getInsuranceName() + "\n" +
                "\tInsurance Number: " + this.getPatient().getInsurance().getInsuranceNumber() + "\n" +
                "\tAnnual Income : " + this.getPatient().getAnnualIncome() + "\n" +
                "\tIllness Category: " + this.getPatient().getSymptoms().getPatientSymptom() + "\n" +
                "\tVisited status: " + this.getPatientAssignedDoctor() + "\n" +
                "\tPrescription Status: " + this.getMedicalRecord().getPrescriptionStatus() + "\n" +
                "\tTest Name: " + this.getMedicalRecord().getTestName() + "\n";
    }
    public void printInformation() {
        logger.info("\tPatient Id: " + this.getPatient().getPatientId());
        logger.info("\tPatient Name: " + this.getPatient().getPersonalInformation().getFirstName());
        logger.info("\tPatient Symptoms: " + this.getPatient().getSymptoms().getPatientSymptom());
    }
    public void printFinancialBenefits() {
        logger.info("Patient Name: " + this.getPatient().getPersonalInformation().getFirstName());
        logger.info("Patient Id: " + this.getPatient().getPatientId());
        logger.info("Benefits Eligible: " + this.getFinancialBenefits().getBenefitPercent()+"%");
    }
}
