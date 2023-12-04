package com.solvd.hospital.doctor;

import com.solvd.hospital.department.Department;
import com.solvd.hospital.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Doctor extends Person {
    private static final Logger logger = LogManager.getLogger(Doctor.class);
    private String doctorId;
    private Department departmentInfo;
    private boolean doctorAssigned;
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
            return this.departmentInfo;
        } else
            return this.departmentInfo;
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
        logger.info("Name: Dr." + this.getPersonalInformation().getFirstName());
        logger.info("Id: " + this.getDoctorId());
        logger.info("Dept Code: " + this.getDepartmentInfo().getDepartmentCode());
        logger.info("Department Name: " + this.getDepartmentInfo().getDepartmentName());
    }
//    public void symptomsDoctorTreat(String doctorId) {
//        if (this.treatableSymptomList == null) {
//            this.treatableSymptomList = new ArrayList<String>();
//        } else {
//            if (this.doctorId.equals(doctorId)) {
//                for (String sym : this.treatableSymptomList) {
//                    logger.info("List of symptoms: " + sym);
//                }
//            }
//        }
//    }
    public boolean getDoctorAssigned() {
        return this.doctorAssigned;
    }

    public void setDoctorAssigned(boolean doctorAssigned) {
        this.doctorAssigned = doctorAssigned;
    }
}
