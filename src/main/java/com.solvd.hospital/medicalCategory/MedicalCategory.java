package com.solvd.hospital.medicalCategory;

import com.solvd.hospital.department.Department;

public  class MedicalCategory extends Department {



    public String getPatientSymtom() {
        return patientSymtom;
    }

    public void setPatientSymtom(String patientSymtom) {
        this.patientSymtom = patientSymtom;
    }

    private String patientSymtom;

    public String[] getSymtoms() {
        return symtoms;
    }

    public void setSymtoms(String[] symtoms) {
        this.symtoms = symtoms;
    }

    private String[] symtoms;





    @Override
    public void assignedDoctor() {

    }
}
