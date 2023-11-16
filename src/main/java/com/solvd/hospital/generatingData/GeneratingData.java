package com.solvd.hospital.generatingData;

import com.solvd.hospital.Hospital;
import com.solvd.hospital.PatientRecord.PatientRecord;
import com.solvd.hospital.department.Department;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.medicalrecords.Symptoms;
import com.solvd.hospital.patient.Patient;
import com.solvd.hospital.person.Person;
import com.solvd.hospital.personalInformation.ExceptionPersonalInformation;
import com.solvd.hospital.personalInformation.Parameter;
import com.solvd.hospital.personalInformation.PersonalInformation;

import java.util.ArrayList;
import java.util.Set;

public class GeneratingData {

    public void addPatientDetails() throws ExceptionPersonalInformation {

        Parameter<PersonalInformation> parameter = new Parameter<>();
        PatientRecord patientRecord = new PatientRecord();
        Person person = new Person();
        Symptoms symptoms = new Symptoms();
        Patient patient = new Patient();
        person.setFirstName("Ashok");
        person.setGender("M");
        person.setContactNumber("2222222222");
        person.setEmailAddress("ashokkumar@gmail.com");
        parameter.setObj(person);
        symptoms.setPatientSymptom("Skin Infection");
        patient.setPatientId("1000");
        patient.setSymptoms(symptoms);
        patient.setPerson(person);
        patientRecord.setPatient(patient);
        Hospital.patientRecordList.add(patientRecord);
        Hospital.patientRecordHashMap.put(patient.getPatientId(), patientRecord);


//        PatientRecord patientRecord = new PatientRecord();
//        Person person = new Person();
//        Symptoms symptoms = new Symptoms();
//        Patient patient = new Patient();
//        person.setFirstName("Ashok");
//        person.setGender("M");
////        person.setAge(20);
//        person.setContactNumber("2222222222");
//        person.setEmailAddress("ashokkumar@gmail.com");
//        symptoms.setPatientSymptom("Skin Infection");
//        patient.setPatientId("1000");
//        patient.setSymptoms(symptoms);
//        patient.setPerson(person);
//        patientRecord.setPatient(patient);
//        Hospital.patientRecordList.add(patientRecord);
//        Hospital.patientRecordHashMap.put(patient.getPatientId(), patientRecord);
//
//
//        patientRecord = new PatientRecord();
//        person = new Person();
//        symptoms = new Symptoms();
//        patient = new Patient();
//        person.setFirstName("Anand");
//        person.setGender("M");
////        person.setAge(25);
//        person.setContactNumber("3333333333");
//        person.setEmailAddress("anandlakshman@gmail.com");
//        patient.setPatientId("1001");
//        symptoms.setPatientSymptom("Neck pain");
//        patient.setSymptoms(symptoms);
//        patient.setPerson(person);
//        patientRecord.setPatient(patient);
//        Hospital.patientRecordList.add(patientRecord);
//        Hospital.patientRecordHashMap.put(patient.getPatientId(), patientRecord);
//
//        patientRecord = new PatientRecord();
//        person = new Person();
//        symptoms = new Symptoms();
//        person.setFirstName("Abi");
//        person.setGender("F");
////        p.setAge(28);
//        person.setContactNumber("4444444444");
//        person.setEmailAddress("abishekar@gmail.com");
//        patient.setPatientId("1002");
//        symptoms.setPatientSymptom("Ear Fluid");
//        patient.setSymptoms(symptoms);
//        patient.setPerson(person);
//        patientRecord.setPatient(patient);
//        Hospital.patientRecordList.add(patientRecord);
//        Hospital.patientRecordHashMap.put(patient.getPatientId(), patientRecord);
//
//
//        patientRecord = new PatientRecord();
//        symptoms = new Symptoms();
//        person = new Person();
//        person.setFirstName("Ranjith");
//        person.setGender("M");
////        person.setAge(30);
//        person.setContactNumber("8888888888");
//        person.setEmailAddress("ranjith@gmail.com");
//        patient.setPatientId("1003");
//        symptoms.setPatientSymptom("Ear Pain");
//        patient.setSymptoms(symptoms);
//        patient.setPerson(person);
//        patientRecord.setPatient(patient);
//        Hospital.patientRecordList.add(patientRecord);
//        Hospital.patientRecordHashMap.put(patient.getPatientId(), patientRecord);
//
//
//        p = new PatientRecord();
//        symptoms = new MedicalCategory();
//        p.setFirstName("Anil");
//        p.setGender("M");
//        p.setAge(30);
//        p.setContactNumber("7898653221");
//        p.setEmailAddress("anilkumar@gmail.com");
//        p.setPatientId("1004");
//        symptoms.setPatientSymtom("Ear Infection");
//        p.setCategory(symptoms);
//        patientRecordList.add(p);
//        patientRecordHashMap.put(p.getPatientId(), p);
//
//
//        p = new PatientRecord();
//        symptoms = new MedicalCategory();
//        p.setFirstName("arav");
//        p.setGender("M");
//        p.setAge(30);
//        p.setContactNumber("8979898989");
//        p.setEmailAddress("anilkumar@gmail.com");
//        p.setPatientId("1004");
//        symptoms.setPatientSymtom("stomach Infection");
//        p.setCategory(symptoms);
//        patientRecordList.add(p);
//        patientRecordHashMap.put(p.getPatientId(), p);

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
