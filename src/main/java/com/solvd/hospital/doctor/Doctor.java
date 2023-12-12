package com.solvd.hospital.doctor;

import com.solvd.hospital.Hospital;
import com.solvd.hospital.absctractclasses.Person;
import com.solvd.hospital.department.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Doctor extends Person {
    private static final Logger logger = LogManager.getLogger(Hospital.class);
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
        return this.departmentInfo == null ? this.departmentInfo = new Department() : this.departmentInfo;
    }

    public void setDepartmentInfo(Department departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

    public void setTreatableSymptom(String symptom) {

        if (this.treatableSymptomList == null) {
            this.treatableSymptomList = new ArrayList<>();
            this.treatableSymptomList.add(symptom);
        } else
            this.treatableSymptomList.add(symptom);
    }

    public boolean isTreatable(String symptom) {
        if (this.treatableSymptomList == null) {
            this.treatableSymptomList = new ArrayList<>();
            return this.treatableSymptomList.contains(symptom);
        }
        return this.treatableSymptomList.contains(symptom);
    }

    public String toString() {
        return this.doctorId;
    }

    @Override
    public void printInformation() {
        logger.info("\tName: Dr." + this.getPersonalInformation().getFirstName());
        logger.info("\tId: " + this.getDoctorId());
        logger.info("\tDept Code: " + this.getDepartmentInfo().getDepartmentCode());
        logger.info("\tDepartment Name: " + this.getDepartmentInfo().getDepartmentName() + "\n");
    }

    public boolean getDoctorAssigned() {
        return this.doctorAssigned;
    }

    public void setDoctorAssigned(boolean doctorAssigned) {
        this.doctorAssigned = doctorAssigned;
    }
}
