package com.solvd.hospital.personalInformation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionPersonalInformation extends Exception {

    private static final Logger logger = LogManager.getLogger(ExceptionPersonalInformation.class);

    public ExceptionPersonalInformation(String message) {

        logger.error(message);
//        super(message);
    }
}
