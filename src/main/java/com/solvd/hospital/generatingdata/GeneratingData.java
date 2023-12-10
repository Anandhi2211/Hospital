package com.solvd.hospital.generatingdata;

import com.solvd.hospital.billing.Insurance;
import com.solvd.hospital.department.Department;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.enums.HospitalDepartment;
import com.solvd.hospital.enums.HospitalInsurance;
import com.solvd.hospital.enums.ListOfSymptoms;
import com.solvd.hospital.exceptions.ExceptionPersonalInformation;
import com.solvd.hospital.patient.Patient;
import com.solvd.hospital.patient.PatientRecord;
import com.solvd.hospital.patient.Symptoms;
import com.solvd.hospital.patient.personalinformation.PersonalInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GeneratingData {
    public HashMap<String, PatientRecord> addToHashMap(HashMap<String, PatientRecord> patientRecordHashMap, ArrayList<PatientRecord> patientRecordList) {
        patientRecordList.stream().forEach(x -> patientRecordHashMap.put(x.getPatient().getPatientId(), x));
        return patientRecordHashMap;
    }

    public ArrayList<PatientRecord> addPatientDetails(ArrayList<PatientRecord> patientRecordList) throws ExceptionPersonalInformation {
        PatientRecord patientRecord = new PatientRecord();
        Symptoms symptoms = new Symptoms();
        Patient patient = new Patient();
        PatientIdGenerator patientIdGenerator = new PatientIdGenerator();
        Insurance insurance = new Insurance();
        PersonalInformation<String> personalInformation = new PersonalInformation<>();
        personalInformation.setFirstName("Ashok");
        personalInformation.setGender("M");
        personalInformation.setContactNumber("2222222222");
        personalInformation.setEmailAddress("ashokkumar@gmail.com");
        patient.setAnnualIncome(40000);
        insurance.setInsuranceName(HospitalInsurance.CIGNA.name());
        insurance.setInsuranceNumber("459878");
        patient.setInsurance(insurance);
        patient.setPersonalInformation(personalInformation);
        symptoms.setPatientSymptom(ListOfSymptoms.SKIN_INFECTION.name());
        patient.setPatientId(patientIdGenerator.getPatientIdGenerator());
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        patientRecordList.add(patientRecord);

        patientRecord = new PatientRecord();
        symptoms = new Symptoms();
        patient = new Patient();
        patientIdGenerator = new PatientIdGenerator();
        insurance = new Insurance();
        personalInformation = new PersonalInformation<>();
        personalInformation.setFirstName("Anand");
        personalInformation.setGender("M");
        personalInformation.setContactNumber("33333333");
        personalInformation.setEmailAddress("anand@gmail.com");
        patient.setAnnualIncome(50000);
        insurance.setInsuranceName(HospitalInsurance.ANTHEM.name());
        insurance.setInsuranceNumber("658975");
        patient.setInsurance(insurance);
        patient.setPersonalInformation(personalInformation);
        symptoms.setPatientSymptom(ListOfSymptoms.NECK_PAIN.name());
        patient.setPatientId(patientIdGenerator.getPatientIdGenerator());
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        patientRecordList.add(patientRecord);

        patientRecord = new PatientRecord();
        symptoms = new Symptoms();
        patient = new Patient();
        patientIdGenerator = new PatientIdGenerator();
        insurance = new Insurance();
        personalInformation = new PersonalInformation<>();
        personalInformation.setFirstName("Abi");
        personalInformation.setGender("F");
        personalInformation.setContactNumber("4444444444");
        personalInformation.setEmailAddress("abi@gmail.com");
        patient.setAnnualIncome(120000);
        insurance.setInsuranceName(HospitalInsurance.MEDICAID.name());
        insurance.setInsuranceNumber("659894");
        patient.setInsurance(insurance);
        patient.setPersonalInformation(personalInformation);
        symptoms.setPatientSymptom(ListOfSymptoms.SKIN_RASHES.name());
        patient.setPatientId(patientIdGenerator.getPatientIdGenerator());
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        patientRecordList.add(patientRecord);

        patientRecord = new PatientRecord();
        symptoms = new Symptoms();
        patient = new Patient();
        patientIdGenerator = new PatientIdGenerator();
        insurance = new Insurance();
        personalInformation = new PersonalInformation<>();
        personalInformation.setFirstName("Ranjith");
        personalInformation.setGender("M");
        personalInformation.setContactNumber("33333333");
        personalInformation.setEmailAddress("ranjith@gmail.com");
        patient.setAnnualIncome(100000);
        insurance.setInsuranceName(HospitalInsurance.CAREPLUS.name());
        insurance.setInsuranceNumber("658975");
        patient.setInsurance(insurance);
        patient.setPersonalInformation(personalInformation);
        symptoms.setPatientSymptom(ListOfSymptoms.EAR_PAIN.name());
        patient.setPatientId(patientIdGenerator.getPatientIdGenerator());
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        patientRecordList.add(patientRecord);

        patientRecord = new PatientRecord();
        symptoms = new Symptoms();
        patient = new Patient();
        patientIdGenerator = new PatientIdGenerator();
        insurance = new Insurance();
        personalInformation = new PersonalInformation<>();
        personalInformation.setFirstName("Anil");
        personalInformation.setGender("M");
        personalInformation.setContactNumber("33333333");
        personalInformation.setEmailAddress("anil@gmail.com");
        patient.setAnnualIncome(90000);
        insurance.setInsuranceName(HospitalInsurance.CIGNA.name());
        insurance.setInsuranceNumber("989865");
        patient.setInsurance(insurance);
        patient.setPersonalInformation(personalInformation);
        symptoms.setPatientSymptom(ListOfSymptoms.PIGMENTATION_REMOVAL.name());
        patient.setPatientId(patientIdGenerator.getPatientIdGenerator());
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        patientRecordList.add(patientRecord);

        patientRecord = new PatientRecord();
        symptoms = new Symptoms();
        patient = new Patient();
        patientIdGenerator = new PatientIdGenerator();
        insurance = new Insurance();
        personalInformation = new PersonalInformation<>();
        personalInformation.setFirstName("Arav");
        personalInformation.setGender("M");
        personalInformation.setContactNumber("9999998888");
        personalInformation.setEmailAddress("arav@gmail.com");
        patient.setAnnualIncome(150000);
        insurance.setInsuranceName(HospitalInsurance.ANTHEM.name());
        insurance.setInsuranceNumber("989877");
        patient.setInsurance(insurance);
        patient.setPersonalInformation(personalInformation);
        symptoms.setPatientSymptom(ListOfSymptoms.BACK_PAIN.name());
        patient.setPatientId(patientIdGenerator.getPatientIdGenerator());
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        patientRecordList.add(patientRecord);

        return patientRecordList;
    }

    public HashSet<Patient> addNewPatientList(HashSet<Patient> newPatientList) {

        PersonalInformation<String> personalInformation = new PersonalInformation<>();
        Patient patient = new Patient();
        Insurance insurance = new Insurance();
        personalInformation.setFirstName("Lakshmi");
        personalInformation.setGender("F");
        personalInformation.setContactNumber("9897786545");
        personalInformation.setEmailAddress("laksmi@gmail.com");
        patient.setPersonalInformation(personalInformation);
        patient.setAnnualIncome(80000);
        insurance.setInsuranceNumber("879865");
        insurance.setInsuranceName(HospitalInsurance.CIGNA.name());
        patient.setInsurance(insurance);
        newPatientList.add(patient);

        patient = new Patient();
        insurance = new Insurance();
        personalInformation = new PersonalInformation<>();
        personalInformation.setFirstName("Nithya");
        personalInformation.setGender("F");
        personalInformation.setContactNumber("9897786545");
        personalInformation.setEmailAddress("Nithya@gmail.com");
        patient.setPersonalInformation(personalInformation);
        patient.setAnnualIncome(80000);
        insurance.setInsuranceNumber("879865");
        insurance.setInsuranceName(HospitalInsurance.CAREPLUS.name());
        patient.setInsurance(insurance);
        newPatientList.add(patient);

        patient = new Patient();
        insurance = new Insurance();
        personalInformation = new PersonalInformation<>();
        personalInformation.setFirstName("Hema");
        personalInformation.setGender("F");
        personalInformation.setContactNumber("9897786545");
        personalInformation.setEmailAddress("hema@gmail.com");
        patient.setPersonalInformation(personalInformation);
        patient.setAnnualIncome(80000);
        insurance.setInsuranceNumber("879865");
        insurance.setInsuranceName(HospitalInsurance.ANTHEM.name());
        patient.setInsurance(insurance);
        newPatientList.add(patient);

        patient = new Patient();
        insurance = new Insurance();
        personalInformation = new PersonalInformation<>();
        personalInformation.setFirstName("Chandru");
        personalInformation.setGender("F");
        personalInformation.setContactNumber("9897786545");
        personalInformation.setEmailAddress("chan@gmail.com");
        patient.setPersonalInformation(personalInformation);
        patient.setAnnualIncome(80000);
        insurance.setInsuranceNumber("879865");
        insurance.setInsuranceName(HospitalInsurance.MEDICAID.name());
        patient.setInsurance(insurance);
        newPatientList.add(patient);

        return newPatientList;
    }

    public HashSet<Department> addDepartmentDetails(ArrayList<Doctor> doctorList, HashSet<Department> departmentList) {
        doctorList.stream().forEach(x -> departmentList.add(x.getDepartmentInfo()));
        return departmentList;
    }

    public ArrayList<Doctor> addDoctorDetails(ArrayList<Doctor> doctorList) throws ExceptionPersonalInformation {
        Doctor doctor = new Doctor();
        Department dep = new Department();
        PersonalInformation<String> personalInformation = new PersonalInformation<>();
        personalInformation.setContactNumber("7898653212");
        doctor.setDoctorId("20000");
        personalInformation.setFirstName("Ram");
        dep.setDepartmentCode((HospitalDepartment.DERMATOLOGY.getDeptCode()));
        dep.setDepartmentName(String.valueOf(HospitalDepartment.DERMATOLOGY));
        doctor.setPersonalInformation(personalInformation);
        doctor.setTreatableSymptom(ListOfSymptoms.SKIN_INFECTION.name());
        doctor.setTreatableSymptom(ListOfSymptoms.SKIN_RASHES.name());
        doctor.setTreatableSymptom(ListOfSymptoms.TAN_REMOVAL.name());
        doctor.setTreatableSymptom(ListOfSymptoms.PIGMENTATION_REMOVAL.name());
        doctor.setDepartmentInfo(dep);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        personalInformation = new PersonalInformation<>();
        doctor.setDoctorId("20001");
        personalInformation.setFirstName("Kiran");
        dep.setDepartmentCode((HospitalDepartment.OTOLARYNGOLOGY.getDeptCode()));
        dep.setDepartmentName(String.valueOf(HospitalDepartment.OTOLARYNGOLOGY));
        doctor.setTreatableSymptom(ListOfSymptoms.EAR_INFECTION.name());
        doctor.setTreatableSymptom(ListOfSymptoms.EAR_FLUID.name());
        doctor.setTreatableSymptom(ListOfSymptoms.EAR_PAIN.name());
        personalInformation.setContactNumber("7887877845");
        doctor.setDepartmentInfo(dep);
        doctor.setPersonalInformation(personalInformation);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        personalInformation = new PersonalInformation<>();
        doctor.setDoctorId("20002");
        personalInformation.setFirstName("Selva");
        dep.setDepartmentCode((HospitalDepartment.ORTHOPEDIC.getDeptCode()));
        dep.setDepartmentName(String.valueOf(HospitalDepartment.ORTHOPEDIC));
        doctor.setTreatableSymptom(ListOfSymptoms.KNEE_PAIN.name());
        doctor.setTreatableSymptom(ListOfSymptoms.NECK_PAIN.name());
        doctor.setTreatableSymptom(ListOfSymptoms.BACK_PAIN.name());
        personalInformation.setContactNumber("8998653265");
        doctor.setDepartmentInfo(dep);
        doctor.setPersonalInformation(personalInformation);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        personalInformation = new PersonalInformation<>();
        doctor.setDoctorId("20003");
        personalInformation.setFirstName("Tony");
        dep.setDepartmentCode((HospitalDepartment.DERMATOLOGY.getDeptCode()));
        dep.setDepartmentName(String.valueOf(HospitalDepartment.DERMATOLOGY));
        doctor.setTreatableSymptom(ListOfSymptoms.SKIN_INFECTION.name());
        doctor.setTreatableSymptom(ListOfSymptoms.SKIN_RASHES.name());
        doctor.setTreatableSymptom(ListOfSymptoms.TAN_REMOVAL.name());
        doctor.setTreatableSymptom(ListOfSymptoms.PIGMENTATION_REMOVAL.name());
        personalInformation.setContactNumber("5432659887");
        doctor.setDepartmentInfo(dep);
        doctor.setPersonalInformation(personalInformation);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        personalInformation = new PersonalInformation<>();
        doctor.setDoctorId("20004");
        personalInformation.setFirstName("Som");
        dep.setDepartmentCode((HospitalDepartment.OTOLARYNGOLOGY.getDeptCode()));
        dep.setDepartmentName(String.valueOf(HospitalDepartment.OTOLARYNGOLOGY));
        doctor.setTreatableSymptom(ListOfSymptoms.EAR_INFECTION.name());
        doctor.setTreatableSymptom(ListOfSymptoms.EAR_FLUID.name());
        doctor.setTreatableSymptom(ListOfSymptoms.EAR_PAIN.name());
        personalInformation.setContactNumber("6532655487");
        doctor.setDepartmentInfo(dep);
        doctor.setPersonalInformation(personalInformation);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        personalInformation = new PersonalInformation<>();
        doctor.setDoctorId("20005");
        personalInformation.setFirstName("Jothi");
        dep.setDepartmentCode((HospitalDepartment.ORTHOPEDIC.getDeptCode()));
        dep.setDepartmentName(String.valueOf(HospitalDepartment.ORTHOPEDIC));
        doctor.setTreatableSymptom(ListOfSymptoms.KNEE_PAIN.name());
        doctor.setTreatableSymptom(ListOfSymptoms.NECK_PAIN.name());
        doctor.setTreatableSymptom(ListOfSymptoms.BACK_PAIN.name());
        personalInformation.setContactNumber("326598875421");
        doctor.setDepartmentInfo(dep);
        doctor.setPersonalInformation(personalInformation);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        personalInformation = new PersonalInformation<>();
        doctor.setDoctorId("20006");
        personalInformation.setFirstName("Poonam");
        dep.setDepartmentCode((HospitalDepartment.DERMATOLOGY.getDeptCode()));
        dep.setDepartmentName(String.valueOf(HospitalDepartment.DERMATOLOGY));
        doctor.setDepartmentInfo(dep);
        doctor.setTreatableSymptom(ListOfSymptoms.SKIN_INFECTION.name());
        doctor.setTreatableSymptom(ListOfSymptoms.SKIN_RASHES.name());
        doctor.setTreatableSymptom(ListOfSymptoms.TAN_REMOVAL.name());
        doctor.setTreatableSymptom(ListOfSymptoms.PIGMENTATION_REMOVAL.name());
        personalInformation.setContactNumber("6598875421");
        doctor.setPersonalInformation(personalInformation);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        personalInformation = new PersonalInformation<>();
        doctor.setDoctorId("20007");
        personalInformation.setFirstName("Geetha");
        dep.setDepartmentCode((HospitalDepartment.OTOLARYNGOLOGY.getDeptCode()));
        dep.setDepartmentName(String.valueOf(HospitalDepartment.OTOLARYNGOLOGY));
        doctor.setTreatableSymptom(ListOfSymptoms.EAR_INFECTION.name());
        doctor.setTreatableSymptom(ListOfSymptoms.EAR_FLUID.name());
        doctor.setTreatableSymptom(ListOfSymptoms.EAR_PAIN.name());
        personalInformation.setContactNumber("9887656598");
        doctor.setDepartmentInfo(dep);
        doctor.setPersonalInformation(personalInformation);
        doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        personalInformation = new PersonalInformation<>();
        doctor.setDoctorId("20008");
        personalInformation.setFirstName("Raju");
        dep.setDepartmentCode(HospitalDepartment.ORTHOPEDIC.getDeptCode());
        dep.setDepartmentName(String.valueOf(HospitalDepartment.ORTHOPEDIC));
        doctor.setTreatableSymptom(ListOfSymptoms.KNEE_PAIN.name());
        doctor.setTreatableSymptom(ListOfSymptoms.NECK_PAIN.name());
        doctor.setTreatableSymptom(ListOfSymptoms.BACK_PAIN.name());
        personalInformation.setContactNumber("989898659887");
        doctor.setDepartmentInfo(dep);
        doctor.setPersonalInformation(personalInformation);
        doctorList.add(doctor);

        return doctorList;
    }
}
