package com.solvd.hospital.generatingData;

import com.solvd.hospital.Hospital;
import com.solvd.hospital.PatientRecord.PatientRecord;
import com.solvd.hospital.department.Department;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.insurance.Insurance;
import com.solvd.hospital.medicalrecords.Symptoms;
import com.solvd.hospital.patient.Patient;
import com.solvd.hospital.personalInformation.ExceptionPersonalInformation;

public class GeneratingData {

    public void addPatientDetails() throws ExceptionPersonalInformation {

        PatientRecord patientRecord = new PatientRecord();
        Symptoms symptoms = new Symptoms();
        Patient patient = new Patient();
        Insurance insurance = new Insurance();
        patient.setFirstName("Ashok");
        patient.setGender("M");
        patient.setContactNumber("2222222222");
        patient.setEmailAddress("ashokkumar@gmail.com");
        patient.setAnnualIncome("40000");
        insurance.setInsuranceName("cigna");
        insurance.setInsuranceNumber("459878");
        patient.setInsurance(insurance);
        symptoms.setPatientSymptom("Skin Infection");
        patient.setPatientId(String.valueOf(Hospital.patientId+1));
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        Hospital.patientRecordList.add(patientRecord);
        Hospital.patientRecordHashMap.put(patient.getPatientId(), patientRecord);

        patientRecord = new PatientRecord();
        symptoms = new Symptoms();
        patient = new Patient();
        insurance = new Insurance();
        patient.setFirstName("Anand");
        patient.setGender("M");
        patient.setContactNumber("3333333333");
        patient.setEmailAddress("anandlakshman@gmail.com");
        patient.setAnnualIncome("50000");
        insurance.setInsuranceName("Anthem");
        insurance.setInsuranceNumber("123265");
        patient.setInsurance(insurance);
        patient.setPatientId(String.valueOf(Hospital.patientId+1));
        symptoms.setPatientSymptom("Neck pain");
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        Hospital.patientRecordList.add(patientRecord);
        Hospital.patientRecordHashMap.put(patient.getPatientId(), patientRecord);

        patientRecord = new PatientRecord();
        patient = new Patient();
        symptoms = new Symptoms();
        insurance = new Insurance();
        patient.setFirstName("Abi");
        patient.setGender("F");
        patient.setContactNumber("4444444444");
        patient.setEmailAddress("abishekar@gmail.com");
        patient.setAnnualIncome("120000");
        insurance.setInsuranceName("medicaid");
        insurance.setInsuranceNumber("659865");
        patient.setInsurance(insurance);
        patient.setPatientId(String.valueOf(Hospital.patientId+1));
        symptoms.setPatientSymptom("Ear Fluid");
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        Hospital.patientRecordList.add(patientRecord);
        Hospital.patientRecordHashMap.put(patient.getPatientId(), patientRecord);

        patientRecord = new PatientRecord();
        symptoms = new Symptoms();
        patient = new Patient();
        insurance = new Insurance();
        patient.setFirstName("Ranjith");
        patient.setGender("M");
        patient.setContactNumber("8888888888");
        patient.setEmailAddress("ranjith@gmail.com");
        patient.setAnnualIncome("100000");
        insurance.setInsuranceName("carePlus");
        insurance.setInsuranceNumber("852541");
        patient.setInsurance(insurance);
        patient.setPatientId(String.valueOf(Hospital.patientId+1));
        symptoms.setPatientSymptom("Ear Pain");
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        Hospital.patientRecordList.add(patientRecord);
        Hospital.patientRecordHashMap.put(patient.getPatientId(), patientRecord);

        patientRecord = new PatientRecord();
        symptoms = new Symptoms();
        patient = new Patient();
        insurance = new Insurance();
        patient.setFirstName("Anil");
        patient.setGender("M");
        patient.setContactNumber("7898653221");
        patient.setEmailAddress("anilkumar@gmail.com");
        patient.setAnnualIncome("90000");
        insurance.setInsuranceName("cigna");
        insurance.setInsuranceNumber("986695");
        patient.setInsurance(insurance);
        patient.setPatientId(String.valueOf(Hospital.patientId+1));
        symptoms.setPatientSymptom("Ear Infection");
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        Hospital.patientRecordList.add(patientRecord);
        Hospital.patientRecordHashMap.put(patient.getPatientId(), patientRecord);

        patientRecord = new PatientRecord();
        symptoms = new Symptoms();
        patient = new Patient();
        insurance = new Insurance();
        patient.setFirstName("arav");
        patient.setGender("M");
        patient.setContactNumber("8979898989");
        patient.setEmailAddress("anilkumar@gmail.com");
        patient.setAnnualIncome("150000");
        insurance.setInsuranceName("Anthem");
        insurance.setInsuranceNumber("6598696");
        patient.setInsurance(insurance);
        patient.setPatientId(String.valueOf(Hospital.patientId+1));
        symptoms.setPatientSymptom("stomach Infection");
        patient.setSymptoms(symptoms);
        patientRecord.setPatient(patient);
        Hospital.patientRecordList.add(patientRecord);
        Hospital.patientRecordHashMap.put(patient.getPatientId(), patientRecord);
    }

    public void addNewPatientList() {

        Patient patient = new Patient();
        Insurance insurance = new Insurance();
        patient.setFirstName("Lakshmi");
        patient.setGender("F");
        patient.setContactNumber("9897786545");
        patient.setEmailAddress("laksmi@gmail.com");
        patient.setAnnualIncome("80000");
        insurance.setInsuranceNumber("879865");
        insurance.setInsuranceName("cigna");
        patient.setInsurance(insurance);
        Hospital.newPatientList.add(patient);

        patient = new Patient();
        insurance = new Insurance();
        patient.setFirstName("Nithya");
        patient.setGender("F");
        patient.setContactNumber("9897786545");
        patient.setEmailAddress("Nithya@gmail.com");
        patient.setAnnualIncome("80000");
        insurance.setInsuranceNumber("879865");
        insurance.setInsuranceName("cigna");
        patient.setInsurance(insurance);
        Hospital.newPatientList.add(patient);

        patient = new Patient();
        insurance = new Insurance();
        patient.setFirstName("Hema");
        patient.setGender("F");
        patient.setContactNumber("9897786545");
        patient.setEmailAddress("hema@gmail.com");
        patient.setAnnualIncome("80000");
        insurance.setInsuranceNumber("879865");
        insurance.setInsuranceName("cigna");
        patient.setInsurance(insurance);
        Hospital.newPatientList.add(patient);

        patient = new Patient();
        insurance = new Insurance();
        patient.setFirstName("Chandru");
        patient.setGender("F");
        patient.setContactNumber("9897786545");
        patient.setEmailAddress("chan@gmail.com");
        patient.setAnnualIncome("80000");
        insurance.setInsuranceNumber("879865");
        insurance.setInsuranceName("cigna");
        patient.setInsurance(insurance);
        Hospital.newPatientList.add(patient);



    }
    public void addDoctorDetails() throws ExceptionPersonalInformation {

        Doctor doctor = new Doctor();
        Department dep = new Department();
        doctor.setContactNumber("7898653212");
        doctor.setDoctorId("20000");
        doctor.setFirstName("Ram");
        dep.setDepartmentCode("100");
        dep.setDepartmentName("Dermatology");
        Hospital.departmentList.add(dep);
        doctor.setTreatableSymptom("Skin Infection");
        doctor.setTreatableSymptom("Skin Rashes");
        doctor.setTreatableSymptom("Tan Removal");
        doctor.setTreatableSymptom("Skin pigmentation");
        doctor.setDepartmentInfo(dep);
        Hospital.doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20001");
        doctor.setFirstName("Kiran");
        dep.setDepartmentCode("101");
        dep.setDepartmentName("Otolaryngology");
        Hospital.departmentList.add(dep);
        doctor.setTreatableSymptom("Ear Infection");
        doctor.setTreatableSymptom("Ear blocked");
        doctor.setContactNumber("7887877845");
        doctor.setDepartmentInfo(dep);
        Hospital.doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20002");
        doctor.setFirstName("Selva");
        dep.setDepartmentCode("102");
        dep.setDepartmentName("Orthopedic");
        Hospital.departmentList.add(dep);
        doctor.setTreatableSymptom("Knee Pain");
        doctor.setTreatableSymptom("Neck pain");
        doctor.setTreatableSymptom("Back Pain");
        doctor.setContactNumber("8998653265");
        doctor.setDepartmentInfo(dep);
        Hospital.doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20003");
        doctor.setFirstName("Tony");
        dep.setDepartmentCode("100");
        dep.setDepartmentName("Dermatology");
        Hospital.departmentList.add(dep);
        doctor.setTreatableSymptom("Skin Rashes");
        doctor.setTreatableSymptom("Tan Removal");
        doctor.setContactNumber("5432659887");
        doctor.setDepartmentInfo(dep);
        Hospital.doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20004");
        doctor.setFirstName("Som");
        dep.setDepartmentCode("101");
        dep.setDepartmentName("Otolaryngology");
        Hospital.departmentList.add(dep);
        doctor.setTreatableSymptom("Ear Infection");
        doctor.setTreatableSymptom("Ear Fluid");
        doctor.setContactNumber("6532655487");
        doctor.setDepartmentInfo(dep);
        Hospital.doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20005");
        doctor.setFirstName("Jothi");
        dep.setDepartmentCode("102");
        dep.setDepartmentName("Orthopedic");
        Hospital.departmentList.add(dep);
        doctor.setContactNumber("326598875421");
        doctor.setDepartmentInfo(dep);
        Hospital.doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20006");
        doctor.setFirstName("Poonam");
        dep.setDepartmentCode("100");
        dep.setDepartmentName("Dermatology");
        Hospital.departmentList.add(dep);
        doctor.setDepartmentInfo(dep);
        doctor.setTreatableSymptom("Skin Infection");
        doctor.setTreatableSymptom("Skin Rashes");
        doctor.setTreatableSymptom("Tan Removal");
        doctor.setTreatableSymptom("Skin pigmentation");
        doctor.setContactNumber("6598875421");
        Hospital.doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20007");
        doctor.setFirstName("Geetha");
        dep.setDepartmentCode("101");
        dep.setDepartmentName("Otolaryngology");
        Hospital.departmentList.add(dep);
        doctor.setTreatableSymptom("Ear Infection");
        doctor.setTreatableSymptom("Ear Pain");
        doctor.setContactNumber("9887656598");
        doctor.setDepartmentInfo(dep);
        Hospital.doctorList.add(doctor);

        doctor = new Doctor();
        dep = new Department();
        doctor.setDoctorId("20008");
        doctor.setFirstName("Raju");
        dep.setDepartmentCode("102");
        dep.setDepartmentName("Orthopedic");
        Hospital.departmentList.add(dep);
        doctor.setTreatableSymptom("Knee Pain");
        doctor.setTreatableSymptom("wrist Pain");
        doctor.setContactNumber("989898659887");
        doctor.setDepartmentInfo(dep);
        Hospital.doctorList.add(doctor);
    }
}
