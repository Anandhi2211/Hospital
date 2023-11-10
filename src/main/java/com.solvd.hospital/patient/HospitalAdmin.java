package com.solvd.hospital.patient;

import com.solvd.hospital.PatientRecord.PatientRecord;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.medicalrecords.IMedicalRecords;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HospitalAdmin implements IHospitalAdmin , IMedicalRecords {
    private static final Logger logger = LogManager.getLogger(HospitalAdmin.class);

    Scanner in = new Scanner(System.in);
    public static ArrayList<PatientRecord> patientRecords =new ArrayList<PatientRecord>();
    public static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();

    @Override
    public void welcomePage() {
        logger.info("Welcome to Hospital Portal!");
        logger.info("Please choose the options");
        logger.info("List Patients Name -- option 1");
        logger.info("List Doctors Name --- option 2");
        logger.info("Assign Doctor for each Patient -- option 3");
        logger.info("Look up particular patient -- option 4");
        logger.info("Generate Bill for each patient: -- option 5 ");
        logger.info("View all the patient Details  -- option 6");
        logger.info("Doctor treats Patient -- option 7");
        logger.info("Exit Portal -- option 8");
        logger.info("Please Enter your option");
    }

    public String getPatientName() throws ExceptionHospitalAdmin {

        logger.info("Enter the Patient Name: ");
        String patientName = in.next();
        String regex = "[A-Za-z]+";
        if (!Pattern.matches(regex, patientName)) {
            throw new ExceptionHospitalAdmin("Not Valid Name");
        } else {
            return patientName;
        }
    }

    public void printPatientDetails(ArrayList<PatientRecord> patientList) {

        if(this.patientRecords == null)
        {
            this.patientRecords = new ArrayList<PatientRecord>();
        }
        logger.info("Printing Patient Details");
        for (PatientRecord p : patientRecords) {
            p.printInformation(); // displays only patient records abstract method overloading
        }
    }

    @Override
    public void printPatientMedicalRecords() {

    }
}
