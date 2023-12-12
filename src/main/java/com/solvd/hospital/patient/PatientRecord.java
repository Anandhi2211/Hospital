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
        return this.billing == null ? this.billing = new Billing() : this.billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public Payment getPayment() {
        return this.payment == null ? this.payment = new Payment() : this.payment;
    }

    public void setPayment(Payment payment) {
        if (payment == null) {
            this.payment = new Payment();
        } else
            this.payment = payment;
    }

    public void setFinancialBenefits(FinancialBenefits financialBenefits) {
        this.financialBenefits = financialBenefits;
    }

    public TreatmentDetails getTreatmentDetails() {
        return this.treatmentDetails == null ? this.treatmentDetails = new TreatmentDetails() : this.treatmentDetails;
    }

    public void setTreatmentDetails(TreatmentDetails treatmentDetails) {
        if (this.treatmentDetails == null) {

            this.treatmentDetails = new TreatmentDetails();
        } else
            this.treatmentDetails = treatmentDetails;
    }

    public String printDoctorName() {
        return this.getAssignedDoctor() != null ? "Dr." + this.getAssignedDoctor().getPersonalInformation().getFirstName() : "No Doc Assigned";
    }

    public String printPrescriptionTestName() {
        return this.getTreatmentDetails().getTestName() != null ? this.getTreatmentDetails().getTestName() : "No Prescription Assigned";
    }

    public String toString() {
        return "\n" +
                "\tPatient Id: " + this.getPatient().getPatientId() + "\n" +
                "\tFirst Name: " + this.getPatient().getPersonalInformation().getFirstName() + "\n" +
                "\tGender: " + this.getPatient().getPersonalInformation().getGender() + "\n" +
                "\tContact Number: " + this.getPatient().getPersonalInformation().getContactNumber() + "\n" +
                "\tEmail Address: " + this.getPatient().getPersonalInformation().getEmailAddress() + "\n" +
                "\tInsurance Name: " + this.getPatient().getInsurance().getInsuranceName() + "\n" +
                "\tInsurance Number: " + this.getPatient().getInsurance().getInsuranceNumber() + "\n" +
                "\tAnnual Income : " + this.getPatient().getAnnualIncome() + "\n" +
                "\tIllness Category: " + this.getPatient().getSymptoms().getPatientSymptom() + "\n" +
                "\tDoctor Name: " + this.printDoctorName() + "\n" +
                "\tVisited status: " + this.getPatientAssignedDoctor() + "\n" +
                "\tPrescription Status: " + this.getTreatmentDetails().getPrescriptionStatus() + "\n" +
                "\tTest Name: " + this.printPrescriptionTestName() + "\n" +
                "\tBill Number: " + this.printBillNumber() + "\n" +
                "\tBill Amount: " + this.printBillAmount() + "\n" +
                "\tPayment Paid Status:" + this.getPayment().isPaymentPaidStatus() + "\n";
    }

    public String printBillAmount() {
        return this.getBilling().getBillingAmount() != 0 ? String.valueOf(this.getBilling().getBillingAmount()) : "Bill Amount Not Generated";
    }

    public String printBillNumber() {
        return this.getBilling().getBillingNumber() != null ? this.getBilling().getBillingNumber() : "Bill Number Not Generated";
    }

    public void printInformation() {
        logger.info("\tPatient Id: " + this.getPatient().getPatientId());
        logger.info("\tPatient Name: " + this.getPatient().getPersonalInformation().getFirstName());
        logger.info("\tPatient Symptoms: " + this.getPatient().getSymptoms().getPatientSymptom() + "\n");
    }
}
