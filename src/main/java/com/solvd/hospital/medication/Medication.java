package main.java.com.solvd.hospital.medication;

public class Medication {

    private String pharmacyName;
    private String pharmacyAddress;
    private String pharmacyZipcode;

    public String getMedicationStatus() {
        return medicationStatus;
    }

    private String medicationStatus;

    private String followUpStatus;

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public void setPharmacyZipcode(String pharmacyZipcode) {
        this.pharmacyZipcode = pharmacyZipcode;
    }

    public void setMedicationStatus(String medicationStatus) {
        this.medicationStatus = medicationStatus;
    }



    public void setFollowUpStatus(String followUpStatus) {
        this.followUpStatus = followUpStatus;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public String getPharmacyZipcode() {
        return pharmacyZipcode;
    }



    public String getFollowUpStatus() {
        return followUpStatus;
    }
}
