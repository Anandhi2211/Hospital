package com.solvd.hospital;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Connection extends Thread {
    private static final Logger logger = LogManager.getLogger(Hospital.class);
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            logger.info("Thread " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
