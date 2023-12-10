package com.solvd.hospital.patient;

import com.solvd.hospital.Hospital;
import com.solvd.hospital.absctractclasses.FinancialBenefits;
import com.solvd.hospital.billing.Billing;
import com.solvd.hospital.billing.Payment;
import com.solvd.hospital.doctor.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PatientRecord {
    private static final Logger logger = LogManager.getLogger(Hospital.class);
    private Patient patient;
    private Billing billing;
    private Doctor assignedDoctor;
    private TreatmentDetails treatmentDetails;
    private FinancialBenefits financialBenefits;

    private Payment payment;
    private boolean patientAssignedDoctor;

    public PatientRecord() {
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getAssignedDoctor() {

        return this.assignedDoctor;
    }

    public void setAssignedDoctor(Doctor doctor) {

        this.assignedDoctor = doctor;
    }

    public boolean getPatientAssignedDoctor() {
        return this.patientAssignedDoctor;
    }

    public boolean isPatientAssignedDoctor() {
        return patientAssignedDoctor;
    }

    public void setPatientAssignedDoctor(boolean patientAssignedDoctor) {
        this.patientAssignedDoctor = patientAssignedDoctor;
    }

    public Billing getBilling() {
        return this.billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        if (payment == null) {
            this.payment = new Payment();
        } else
            this.payment = payment;
    }

    public FinancialBenefits getFinancialBenefits() {
        return this.financialBenefits;
    }

    public void setFinancialBenefits(FinancialBenefits financialBenefits) {
        this.financialBenefits = financialBenefits;
    }

    public TreatmentDetails getTreatmentDetails() {
        if (treatmentDetails == null) {
            this.treatmentDetails = new TreatmentDetails();
        }
        return this.treatmentDetails;
    }

    public void setTreatmentDetails(TreatmentDetails treatmentDetails) {
        if (treatmentDetails == null) {

            this.treatmentDetails = new TreatmentDetails();
        } else
            this.treatmentDetails = treatmentDetails;
    }

    //    public String printDoctorInfo()
//    {
////        return assignedDoctorList == null || assignedDoctorList.isEmpty() ?  "NO DOC is assigned " :
////                assignedDoctorList.stream().map(doctor -> doctor.getDoctorId()).findAny().get();
//////        String infoToPrint = "No Doctor is assigned";
//        String infoPrint = "No Doc Assigned";
//        if(assignedDoctor!=null)
//        {
//            d
//        }
//        return infoPrint;
////        if (assignedDoctorList != null) {
////            for (Doctor assignedDocctor : assignedDoctorList) {
////                infoToPrint = assignedDocctor.getDoctorId();
////            }
////        }
////        return infoToPrint;
////        return assignedDoctorList==null? "no doc":assignedDoctorList.stream().map(doctor -> doctor.getDoctorId());
//    }
    public String toString() {
        return "\tPatient Id: " + this.getPatient().getPatientId() + "\n" +
                "\tDoctor Id: " + this.getAssignedDoctor().getDoctorId() + "\n" +
                "\tFirst Name: " + this.getPatient().getPersonalInformation().getFirstName() + "\n" +
                "\tGender: " + this.getPatient().getPersonalInformation().getGender() + "\n" +
                "\tContact Number: " + this.getPatient().getPersonalInformation().getContactNumber() + "\n" +
                "\tEmail Address: " + this.getPatient().getPersonalInformation().getEmailAddress() + "\n" +
                "\tInsurance Name: " + this.getPatient().getInsurance().getInsuranceName() + "\n" +
                "\tInsurance Number: " + this.getPatient().getInsurance().getInsuranceNumber() + "\n" +
                "\tAnnual Income : " + this.getPatient().getAnnualIncome() + "\n" +
                "\tIllness Category: " + this.getPatient().getSymptoms().getPatientSymptom() + "\n" +
                "\tVisited status: " + this.getPatientAssignedDoctor() + "\n" +
                "\tPrescription Status: " + this.getTreatmentDetails().getPrescriptionStatus() + "\n" +
                "\tTest Name: " + this.getTreatmentDetails().getTestName() + "\n";
    }

    public void printInformation() {
        logger.info("\tPatient Id: " + this.getPatient().getPatientId());
        logger.info("\tPatient Name: " + this.getPatient().getPersonalInformation().getFirstName());
        logger.info("\tPatient Symptoms: " + this.getPatient().getSymptoms().getPatientSymptom());
    }

    public void printFinancialBenefits() {
        logger.info("Patient Name: " + this.getPatient().getPersonalInformation().getFirstName());
        logger.info("Patient Id: " + this.getPatient().getPatientId());
        logger.info("Benefits Eligible: " + this.getFinancialBenefits().getBenefitPercent() + "%");
    }
}
