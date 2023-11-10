package com.solvd.hospital.patient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionHospitalAdmin extends Exception {
    private static final Logger logger = LogManager.getLogger(ExceptionHospitalAdmin.class);

    public ExceptionHospitalAdmin(String message) {

        logger.error(message);
//        super(message);
    }
}
