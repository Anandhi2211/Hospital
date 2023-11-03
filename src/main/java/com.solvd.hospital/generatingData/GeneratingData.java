package com.solvd.hospital.generatingData;

import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.medicalCategory.MedicalCategory;
import com.solvd.hospital.patient.Patient;

import java.util.ArrayList;

public class GeneratingData {

    public void addPatientDetails(ArrayList<Patient> patientList) {
        Patient p = new Patient();
        MedicalCategory category = new MedicalCategory();
        p.setFistName("Ashok");
        p.setLastName("kumar");
        p.setGender("M");
        p.setAge(20);
        p.setContactNumber("2222222222");
        p.setEmailAddress("ashokkumar@gmail.com");
        p.setPatientId("1000");
        category.setPatientSymtom("Eye infection");
        p.setCategory(category);
        p.setPersonalInfo(p);

        patientList.add(p);




        p=new Patient();
        category = new MedicalCategory();
        p.setFistName("Anand");
        p.setLastName("Lakshman");
        p.setGender("M");
        p.setAge(25);
        p.setContactNumber("3333333333");
        p.setEmailAddress("anandlakshman@gmail.com");
        p.setPatientId("1001");
        category.setPatientSymtom("Eye Infection");
        p.setCategory(category);

        p.setPersonalInfo(p);

        patientList.add(p);

        p=new Patient();
        category = new MedicalCategory();
        p.setFistName("Abi");
        p.setLastName("Shekar");
        p.setGender("F");
        p.setAge(28);
        p.setContactNumber("4444444444");
        p.setEmailAddress("abishekar@gmail.com");
        p.setPatientId("1002");
        category.setPatientSymtom("Eye Infection");
        p.setCategory(category);

        p.setPersonalInfo(p);
        patientList.add(p);

        p=new Patient();
        category = new MedicalCategory();
        p.setFistName("Ranjith");
        p.setLastName("kumar");
        p.setGender("M");
        p.setAge(30);
        p.setContactNumber("8888888888");
        p.setEmailAddress("ranjith@gmail.com");
        p.setPatientId("1003");
        category.setPatientSymtom("Ear Pain");
        p.setCategory(category);

        p.setPersonalInfo(p);
        patientList.add(p);

        p=new Patient();
        category = new MedicalCategory();
        p.setFistName("Anil");
        p.setLastName("kumar");
        p.setGender("M");
        p.setAge(30);
        p.setContactNumber("7898653221");
        p.setEmailAddress("anilkumar@gmail.com");
        p.setPatientId("1004");
        category.setPatientSymtom("Ear Infection");
        p.setCategory(category);

        p.setPersonalInfo(p);
        patientList.add(p);
        for(Patient list : patientList)
        {
            System.out.println(list);

        }
/*
        p=new Patient();
        p.setFistName("Shika");
        p.setLastName("kumar");
        p.setGender("F");
        p.setAge(33);
        p.setContactNumber("9865325478");
        p.setEmailAddress("shikakumar@gmail.com");
        p.setPatientId("1005");
        p.setSymptoms("Ear Infection");
        p.setPersonalInfo(p);
        patientList.add(p);

        p=new Patient();
        p.setFistName("Divya");
        p.setLastName("kumar");
        p.setGender("F");
        p.setAge(30);
        p.setContactNumber("7898655412");
        p.setEmailAddress("divyakumar@gmail.com");
        p.setPatientId("1006");
        p.setSymptoms("Knee pain");
        p.setPersonalInfo(p);
        patientList.add(p);

        p=new Patient();
        p.setFistName("Deva");
        p.setLastName("raj");
        p.setGender("M");
        p.setAge(23);
        p.setContactNumber("7898653212");
        p.setEmailAddress("devaraj@gmail.com");
        p.setPatientId("1007");
        p.setSymptoms("Knee pain");
        p.setPersonalInfo(p);
        patientList.add(p);

        p=new Patient();
        p.setFistName("Sathi");
        p.setLastName("kumar");
        p.setGender("M");
        p.setAge(30);
        p.setContactNumber("7855444455");
        p.setEmailAddress("sathikumar@gmail.com");
        p.setPatientId("1008");
        p.setSymptoms("Knee pain");
        p.setPersonalInfo(p);
        patientList.add(p);

        p=new Patient();
        p.setFistName("Raji");
        p.setLastName("kumar");
        p.setGender("F");
        p.setAge(55);
        p.setContactNumber("8644696455");
        p.setEmailAddress("rajikumar@gmail.com");
        p.setPatientId("1009");
        p.setSymptoms("Knee pain");
        p.setPersonalInfo(p);
        patientList.add(p);

*/

    }

    public void addDoctorDetails(ArrayList<Doctor> doctorList) {

        Doctor d = new Doctor();
       // Department d = new Department();
        d.setDoctorId("20000");
        d.setDepartmentCode("100");
        d.setDepartmentName("Dermatology");

        d.setDepartmentInfo(d);
        doctorList.add(d);

        d = new Doctor();
      //  d = new Department();
        d.setDoctorId("20001");
        d.setDepartmentCode("101");
        d.setDepartmentName("Otolaryngology");
        d.setDepartmentInfo(d);
        doctorList.add(d);

        d = new Doctor();
        //d = new Department();

        d.setDoctorId("20002");
        d.setDepartmentCode("102");
        d.setDepartmentName("Orthopedic");
        d.setDepartmentInfo(d);
        doctorList.add(d);

        d = new Doctor();
        //d = new Department();

        d.setDoctorId("20003");
        d.setDepartmentCode("100");
        d.setDepartmentName("Dermatology");
        d.setDepartmentInfo(d);
        doctorList.add(d);

        d = new Doctor();
       // d = new Department();

        d.setDoctorId("20004");
        d.setDepartmentCode("101");
        d.setDepartmentName("Otolaryngology");
        d.setDepartmentInfo(d);
        doctorList.add(d);

        d = new Doctor();
       // d = new Department();

        d.setDoctorId("20005");
        d.setDepartmentCode("102");
        d.setDepartmentName("Orthopedic");
        d.setDepartmentInfo(d);
        doctorList.add(d);

        d = new Doctor();
       // d = new Department();

        d.setDoctorId("20006");
        d.setDepartmentCode("100");
        d.setDepartmentName("Dermatology");
        d.setDepartmentInfo(d);
        doctorList.add(d);

        d = new Doctor();
       // d = new Department();

        d.setDoctorId("20007");
        d.setDepartmentCode("101");
        d.setDepartmentName("Otolaryngology");
        d.setDepartmentInfo(d);
        doctorList.add(d);

        d = new Doctor();
      //  d = new Department();

        d.setDoctorId("20008");
        d.setDepartmentCode("102");
        d.setDepartmentName("Orthopedic");
        d.setDepartmentInfo(d);
        doctorList.add(d);


    }

    public void addSymtomDetails() {


        MedicalCategory category = new MedicalCategory();
        String [] symtoms = {"Knee Pain","Leg Sprain","Neck Pain","Bone Fracture","Wrist pain","Skin infection","Skin allergy","Skin lightening","Tan Removal"};

       // String [] dermoSymtoms = {"Skin infection","Skin allergy","Skin lightening","Tan Removal"};

        category.setSymtoms(symtoms);
        for(String c : symtoms)
        {
         System.out.println(c);
        }
       // doctor.setSymptoms(dermoSymtoms);
        //doctorList.add(doctor);






    }
}
