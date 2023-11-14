package com.solvd.hospital.generatingData;

import com.solvd.hospital.PatientRecord.PatientRecord;
import com.solvd.hospital.department.Department;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.medicalCategory.MedicalCategory;
import com.solvd.hospital.personalInformation.ExceptionPersonalInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class GeneratingData {

    public void addPatientDetails(ArrayList<PatientRecord> patientList, HashMap<String, PatientRecord> patientRecordHashMap) throws ExceptionPersonalInformation {

        PatientRecord p = new PatientRecord();
        MedicalCategory category = new MedicalCategory();
        p.setFirstName("Ashok");
        p.setGender("M");
        p.setAge(20);
        p.setContactNumber("2222222222");
        p.setEmailAddress("ashokkumar@gmail.com");
        p.setPatientId("1000");
        category.setPatientSymtom("Skin Infection");
        p.setCategory(category);
        patientList.add(p);
        patientRecordHashMap.put(p.getPatientId(), p);


        p = new PatientRecord();
        category = new MedicalCategory();
        p.setFirstName("Anand");
        p.setGender("M");
        p.setAge(25);
        p.setContactNumber("3333333333");
        p.setEmailAddress("anandlakshman@gmail.com");
        p.setPatientId("1001");
        category.setPatientSymtom("Neck pain");
        p.setCategory(category);
        patientList.add(p);
        patientRecordHashMap.put(p.getPatientId(), p);

        p = new PatientRecord();
        category = new MedicalCategory();
        p.setFirstName("Abi");
        p.setGender("F");
        p.setAge(28);
        p.setContactNumber("4444444444");
        p.setEmailAddress("abishekar@gmail.com");
        p.setPatientId("1002");
        category.setPatientSymtom("Ear Fluid");
        p.setCategory(category);
        patientList.add(p);
        patientRecordHashMap.put(p.getPatientId(), p);

        p = new PatientRecord();
        category = new MedicalCategory();
        p.setFirstName("Ranjith");
        p.setGender("M");
        p.setAge(30);
        p.setContactNumber("8888888888");
        p.setEmailAddress("ranjith@gmail.com");
        p.setPatientId("1003");
        category.setPatientSymtom("Ear Pain");
        p.setCategory(category);
        patientList.add(p);
        patientRecordHashMap.put(p.getPatientId(), p);


        p = new PatientRecord();
        category = new MedicalCategory();
        p.setFirstName("Anil");
        p.setGender("M");
        p.setAge(30);
        p.setContactNumber("7898653221");
        p.setEmailAddress("anilkumar@gmail.com");
        p.setPatientId("1004");
        category.setPatientSymtom("Ear Infection");
        p.setCategory(category);
        patientList.add(p);
        patientRecordHashMap.put(p.getPatientId(), p);


        p = new PatientRecord();
        category = new MedicalCategory();
        p.setFirstName("arav");
        p.setGender("M");
        p.setAge(30);
        p.setContactNumber("8979898989");
        p.setEmailAddress("anilkumar@gmail.com");
        p.setPatientId("1004");
        category.setPatientSymtom("stomach Infection");
        p.setCategory(category);
        patientList.add(p);
        patientRecordHashMap.put(p.getPatientId(), p);

    }

    public void addDoctorDetails(ArrayList<Doctor> doctorList, Set<String> departmentNameList) throws ExceptionPersonalInformation {

        Doctor doctor = new Doctor();
        Department dep = new Department();
        doctor.setContactNumber("7898653212");
        doctor.setDoctorId("20000");
        doctor.setFirstName("Ram");
        dep.setDepartmentCode("100");
        dep.setDepartmentName("Dermatology");
        departmentNameList.add(dep.getDepartmentName());


        doctor.setTreatableSymptom("Skin Infection");
        doctor.setTreatableSymptom("Skin Rashes");
        doctor.setTreatableSymptom("Tan Removal");
        doctor.setTreatableSymptom("Skin pigmentation");

        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20001");
        doctor.setFirstName("Kiran");
        dep.setDepartmentCode("101");
        dep.setDepartmentName("Otolaryngology");
        departmentNameList.add(dep.getDepartmentName());

        doctor.setTreatableSymptom("Ear Infection");
        doctor.setTreatableSymptom("Ear blocked");
        doctor.setContactNumber("7887877845");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20002");
        doctor.setFirstName("Selva");
        dep.setDepartmentCode("102");
        dep.setDepartmentName("Orthopedic");
        departmentNameList.add(dep.getDepartmentName());

        doctor.setTreatableSymptom("Knee Pain");
        doctor.setTreatableSymptom("Neck pain");
        doctor.setTreatableSymptom("Back Pain");
        doctor.setContactNumber("8998653265");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20003");
        doctor.setFirstName("Tony");
        dep.setDepartmentCode("100");
        dep.setDepartmentName("Dermatology");
        departmentNameList.add(dep.getDepartmentName());

        doctor.setTreatableSymptom("Skin Rashes");
        doctor.setTreatableSymptom("Tan Removal");
        doctor.setContactNumber("5432659887");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20004");
        doctor.setFirstName("Som");
        dep.setDepartmentCode("101");
        dep.setDepartmentName("Otolaryngology");
        departmentNameList.add(dep.getDepartmentName());

        doctor.setTreatableSymptom("Ear Infection");
        doctor.setTreatableSymptom("Ear Fluid");
        doctor.setContactNumber("6532655487");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20005");
        doctor.setFirstName("Jothi");
        dep.setDepartmentCode("102");
        dep.setDepartmentName("Orthopedic");
        departmentNameList.add(dep.getDepartmentName());

        doctor.setContactNumber("326598875421");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20006");
        doctor.setFirstName("Poonam");
        dep.setDepartmentCode("100");
        dep.setDepartmentName("Dermatology");
        departmentNameList.add(dep.getDepartmentName());

        doctor.setDepartmentInfo(dep);
        doctor.setTreatableSymptom("Skin Infection");
        doctor.setTreatableSymptom("Skin Rashes");
        doctor.setTreatableSymptom("Tan Removal");
        doctor.setTreatableSymptom("Skin pigmentation");
        doctor.setContactNumber("6598875421");
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20007");
        doctor.setFirstName("Geetha");
        dep.setDepartmentCode("101");
        dep.setDepartmentName("Otolaryngology");
        departmentNameList.add(dep.getDepartmentName());

        doctor.setTreatableSymptom("Ear Infection");
        doctor.setTreatableSymptom("Ear Pain");
        doctor.setContactNumber("9887656598");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20008");
        doctor.setFirstName("Raju");
        dep.setDepartmentCode("102");
        dep.setDepartmentName("Orthopedic");
        departmentNameList.add(dep.getDepartmentName());

        doctor.setTreatableSymptom("Knee Pain");
        doctor.setTreatableSymptom("wrist Pain");
        doctor.setContactNumber("989898659887");
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

    }
}
