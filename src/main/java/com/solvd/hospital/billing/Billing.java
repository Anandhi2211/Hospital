package main.java.com.solvd.hospital.billing;

public class Billing {

    //private String billingNumber;
    private String patientInsuranceName;
    private String patientInsuranceNumber;
    private String patientCreditCardNumber;

    public void setPatientInsuranceName(String patientInsuranceName) {
        this.patientInsuranceName = patientInsuranceName;
    }

    public void setPatientInsuranceNumber(String patientInsuranceNumber) {
        this.patientInsuranceNumber = patientInsuranceNumber;
    }

    public void setPatientCreditCardNumber(String patientCreditCardNumber) {
        this.patientCreditCardNumber = patientCreditCardNumber;
    }

    public String getPatientInsuranceName() {
        return patientInsuranceName;
    }

    public String getPatientInsuranceNumber() {
        return patientInsuranceNumber;
    }

    public String getPatientCreditCardNumber() {
        return patientCreditCardNumber;
    }
}
