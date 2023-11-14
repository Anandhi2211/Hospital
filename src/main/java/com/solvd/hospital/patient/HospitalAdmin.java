package com.solvd.hospital.patient;

import com.solvd.hospital.medicalrecords.IMedicalRecords;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HospitalAdmin implements IHospitalAdmin , IMedicalRecords {
    private static final Logger logger = LogManager.getLogger(HospitalAdmin.class);
    Scanner in = new Scanner(System.in);
    @Override
    public void welcomePage() {
        logger.info("Welcome to Hospital Portal!");
        logger.info("Please choose the options");
        logger.info("Patient and Doctor Details using HashMap-- option 1");
        logger.info("Assign Doctor for each Patient -HashMap- option 2");
        logger.info("Look up particular patient -- option 3");
        logger.info("Generate Bill for each patient: -- option 4 ");
        logger.info("Doctor treats Patient -- option 5");
        logger.info("View all the patient Details  using HASHMAP-- option 6");
        logger.info("Department in the hospital using SET -- option 7");
        logger.info("List of the all the Bill using HASHMAP-- option 8");
        logger.info("Exit Portal -- option 9");
        logger.info("Please Enter your option");
    }

    public String getPatientId() throws ExceptionHospitalAdmin {

        logger.info("Enter the Patient Id: (1000,1001,1002,1003,1004)");
        String patientId = in.next();
        String regex = "[0-9]+";
        if (!Pattern.matches(regex, patientId)) {
            throw new ExceptionHospitalAdmin("Not Valid Id");
        } else {
            return patientId;
        }
    }
    @Override
    public void printPatientMedicalRecords() {
    }
}
