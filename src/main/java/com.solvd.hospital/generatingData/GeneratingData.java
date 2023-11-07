package com.solvd.hospital.generatingData;

import com.solvd.hospital.PatientRecord.PatientRecord;
import com.solvd.hospital.department.Department;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.medicalCategory.MedicalCategory;

import java.util.ArrayList;

public class GeneratingData {

    public void addPatientDetails(ArrayList<PatientRecord> patientList) {
        PatientRecord p = new PatientRecord();
        MedicalCategory category = new MedicalCategory();
        p.setFistName("Ashok");
        p.setGender("M");
        p.setAge(20);
        p.setContactNumber("2222222222");
        p.setEmailAddress("ashokkumar@gmail.com");
        p.setPatientId("1000");
        category.setPatientSymtom("Skin Infection");
        p.setCategory(category);
        patientList.add(p);

        p = new PatientRecord();
        category = new MedicalCategory();
        p.setFistName("Anand");
        p.setGender("M");
        p.setAge(25);
        p.setContactNumber("3333333333");
        p.setEmailAddress("anandlakshman@gmail.com");
        p.setPatientId("1001");
        category.setPatientSymtom("Eye Infection");
        p.setCategory(category);
        patientList.add(p);

        p = new PatientRecord();
        category = new MedicalCategory();
        p.setFistName("Abi");
        p.setGender("F");
        p.setAge(28);
        p.setContactNumber("4444444444");
        p.setEmailAddress("abishekar@gmail.com");
        p.setPatientId("1002");
        category.setPatientSymtom("Red Eyes");
        p.setCategory(category);
        patientList.add(p);

        p = new PatientRecord();
        category = new MedicalCategory();
        p.setFistName("Ranjith");
        p.setGender("M");
        p.setAge(30);
        p.setContactNumber("8888888888");
        p.setEmailAddress("ranjith@gmail.com");
        p.setPatientId("1003");
        category.setPatientSymtom("Ear Pain");
        p.setCategory(category);
        patientList.add(p);

        p = new PatientRecord();
        category = new MedicalCategory();
        p.setFistName("Anil");
        p.setGender("M");
        p.setAge(30);
        p.setContactNumber("7898653221");
        p.setEmailAddress("anilkumar@gmail.com");
        p.setPatientId("1004");
        category.setPatientSymtom("Ear Infection");
        p.setCategory(category);
        patientList.add(p);
    }

    public void addDoctorDetails(ArrayList<Doctor> doctorList) {

        Doctor doctor = new Doctor();
        Department dep = new Department();
        doctor.setContactNumber("7898653212");
        doctor.setDoctorId("20000");
        doctor.setFistName("Ram");
        dep.setDepartmentCode("100");
        dep.setDepartmentName("Dermatology");
        doctor.setTreatableSymtom("Skin Infection");
        doctor.setTreatableSymtom("Skin Rashes");
        doctor.setTreatableSymtom("Tan Removal");
        doctor.setTreatableSymtom("Skin pigmentation");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20001");
        doctor.setFistName("Kiran");
        dep.setDepartmentCode("101");
        dep.setDepartmentName("Otolaryngology");
        doctor.setTreatableSymtom("Ear Infection");
        doctor.setTreatableSymtom("Ear blocked");
        doctor.setContactNumber("7887877845");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20002");
        doctor.setFistName("Selva");
        dep.setDepartmentCode("102");
        dep.setDepartmentName("Orthopedic");
        doctor.setTreatableSymtom("Knee Pain");
        doctor.setContactNumber("8998653265");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20003");
        doctor.setFistName("Tony");
        dep.setDepartmentCode("100");
        dep.setDepartmentName("Dermatology");
        doctor.setContactNumber("5432659887");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20004");
        doctor.setFistName("Som");
        dep.setDepartmentCode("101");
        dep.setDepartmentName("Otolaryngology");
        doctor.setTreatableSymtom("Ear Infection");
        doctor.setTreatableSymtom("Ear Pain");
        doctor.setContactNumber("6532655487");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20005");
        doctor.setFistName("Jothi");
        dep.setDepartmentCode("102");
        dep.setDepartmentName("Orthopedic");
        doctor.setContactNumber("326598875421");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20006");
        doctor.setFistName("Poonam");
        dep.setDepartmentCode("100");
        dep.setDepartmentName("Dermatology");
        doctor.setDepartmentInfo(dep);
        doctor.setTreatableSymtom("Skin Infection");
        doctor.setTreatableSymtom("Skin Rashes");
        doctor.setTreatableSymtom("Tan Removal");
        doctor.setTreatableSymtom("Skin pigmentation");
        doctor.setContactNumber("6598875421");
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20007");
        doctor.setFistName("Geetha");
        dep.setDepartmentCode("101");
        dep.setDepartmentName("Otolaryngology");
        doctor.setTreatableSymtom("Ear Infection");
        doctor.setTreatableSymtom("Ear Pain");
        doctor.setContactNumber("9887656598");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20008");
        doctor.setFistName("Raju");
        dep.setDepartmentCode("102");
        dep.setDepartmentName("Orthopedic");
        doctor.setContactNumber("989898659887");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

    }
}
