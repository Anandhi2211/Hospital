package com.solvd.hospital.doctor;

import com.solvd.hospital.department.Department;
import com.solvd.hospital.personalInformation.PersonalInformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Doctor extends PersonalInformation {
    private static final Logger logger = LogManager.getLogger(Doctor.class);

    private String doctorId;
    public Department departmentInfo;
    private ArrayList<String> treatableSymptomList;

    public Doctor() {

    }

    public String getDoctorId() {

        return this.doctorId;
    }

    public void setDoctorId(String doctorId) {

        this.doctorId = doctorId;
    }

    public Department getDepartmentInfo() {

        if (this.departmentInfo == null) {
            this.departmentInfo = new Department();
            return departmentInfo;
        } else
            return departmentInfo;
    }

    public void setDepartmentInfo(Department departmentInfo) {

        this.departmentInfo = departmentInfo;
    }

    public ArrayList<String> getTreatableSymptomList() {

        return this.treatableSymptomList;
    }

    public void setTreatableSymptom(String symptom) {

        if (this.treatableSymptomList == null) {
            this.treatableSymptomList = new ArrayList<String>();
            this.treatableSymptomList.add(symptom);
        } else
            this.treatableSymptomList.add(symptom);
    }

    public boolean isTreatable(String symptom) {

        if (this.treatableSymptomList == null) {
            this.treatableSymptomList = new ArrayList<String>();
            return this.treatableSymptomList.contains(symptom);
        }
        return this.treatableSymptomList.contains(symptom);
    }

    public String toString() {

        return this.doctorId;
    }

    @Override
    public void printInformation() {
        logger.info("Name: " + this.getFirstName());
        logger.info("Id: " + this.getDoctorId());
        logger.info("Department Name: " + this.getDepartmentInfo().getDepartmentName());
    }

    public void symptomsDoctorTreat(String doctorId) {
        if (this.treatableSymptomList == null) {
            this.treatableSymptomList = new ArrayList<String>();
        } else {
            if (this.doctorId.equals(doctorId)) {
                for (String sym : this.treatableSymptomList) {
                    logger.info("List of symptoms: " + sym);
                }
            }
        }
    }
}
