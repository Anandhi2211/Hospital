package com.solvd.hospital.department;

import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.patientrecord.PatientRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Department extends Doctor {
    private static final Logger logger = LogManager.getLogger(PatientRecord.class);
    private String departmentName;
    private String departmentCode;
    public String getDepartmentName() {
        return this.departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentCode() {
        return this.departmentCode;
    }
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    @Override
    public String toString() {
        return "\tDepartmentName= " + this.getDepartmentName()+" DepartmentCode= " + this.getDepartmentCode() + "\n";
    }
    public void printDepartmentDetails()
    {
        logger.info("\tDepartment Name: "+this.getDepartmentName());
        logger.info("\tDepartment Code: "+this.getDepartmentCode());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        return (this.departmentCode.equals(((Department) obj).getDepartmentCode()) &&
                this.departmentName.equals(((Department) obj).getDepartmentName()));
    }
    @Override
    public int hashCode() {
        return departmentName.hashCode() ^ departmentCode.hashCode();
    }
}
