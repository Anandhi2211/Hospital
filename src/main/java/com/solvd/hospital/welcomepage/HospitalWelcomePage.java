package com.solvd.hospital.welcomepage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HospitalWelcomePage implements IHospitalAdmin {
    private static final Logger logger = LogManager.getLogger(HospitalWelcomePage.class);
    @Override
    public void welcomePage() {
        logger.info("Welcome to Hospital Portal!");
        logger.info("Please choose the options");
        logger.info("Patient, Doctor and Department Details--option 1");
        logger.info("Assign Doctor for each Patient--option 2");
        logger.info("Doctor treats each Patient--option 3");
        logger.info("Generate Bill for each patient--option 4 ");
        logger.info("Calculate the amount to pay for each patient--option 5");
        logger.info("Add New Patient to the Portal--option 6");
        logger.info("Display particular patient--option 7");
        logger.info("View all the patient Details in the Hospital-- option 8");
        logger.info("Exit Portal -- option 9");
        logger.info("Please Enter your option");
    }
    public String getPatientId(Scanner in) throws ExceptionHospitalAdmin {
        logger.info("Enter the Patient Id: (1000,1001,1002,1003,1004)");
        String patientId = in.next();
        String regex = "[0-9]+";
        if (!Pattern.matches(regex, patientId)) {
            throw new ExceptionHospitalAdmin("Not Valid Id");
        } else {
            return patientId;
        }
    }
}
