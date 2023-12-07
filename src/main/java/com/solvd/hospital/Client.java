package com.solvd.hospital;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {
    private static final Logger logger = LogManager.getLogger(Hospital.class);

    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection;
        int timer = 0;
        while (timer < 5000) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            connection = connectionPool.getConnection();
            logger.info(connection.getName());
            connection.start();
            timer = timer + 1000;
        }
    }
}
