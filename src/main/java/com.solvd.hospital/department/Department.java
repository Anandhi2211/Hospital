package com.solvd.hospital.department;

public abstract class Department  {
    private String departmentName;
    private String departmentCode;
   // private String[] symptoms;


    public abstract void assignedDoctor();



    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

}
