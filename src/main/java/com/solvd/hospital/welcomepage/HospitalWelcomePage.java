package com.solvd.hospital.welcomepage;

import com.solvd.hospital.Hospital;
import com.solvd.hospital.exceptions.ExceptionHospitalAdmin;
import com.solvd.hospital.interfaces.IHospitalAdmin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HospitalWelcomePage implements IHospitalAdmin {
    private static final Logger logger = LogManager.getLogger(Hospital.class);

    @Override
    public void welcomePage() {
        logger.info("\tWelcome to Hospital Portal!");
        logger.info("\tChoose from the below options");
        logger.info("1  -  Patient, Doctor and Department Details");
        logger.info("2  -  Assign Doctor to each Patient");
        logger.info("3  -  Doctor treats each Patient");
        logger.info("4  -  Generating Billing Details for all the patients using Lambda Expression");
        logger.info("5  -  Patient Pays Bill");
        logger.info("6  -  Add a New Patient to the Portal");
        logger.info("7  -  Display particular patient");
        logger.info("8  -  Change Doctor Assigned Status By Reflection");
        logger.info("9  -  View all the patient Details in the Hospital");
        logger.info("0  -  Exit Portal");
        logger.info("\tEnter your option");
    }

    public String getPatientId(Scanner in) throws ExceptionHospitalAdmin {
        logger.info("Enter any of the Patient Id: ");
        Hospital.patientRecordHashMap.keySet().stream().sorted().forEach(x -> logger.info(x));
        String patientId = in.next();
        String regex = "[0-9]+";
        if (!Pattern.matches(regex, patientId)) {
            throw new ExceptionHospitalAdmin("Not Valid Id");
        } else {
            return patientId;
        }
    }
}
