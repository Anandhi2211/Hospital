package com.solvd.hospital;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger(Hospital.class);
    private static ConnectionPool connectionPool = null;
    private List<Connection> connectionsList = new ArrayList<>();

    public ConnectionPool() {
        IntStream.range(1, 5).forEach(i -> {
            Connection connection = new Connection();
            connection.setName("Connection Name " + i);
            connectionsList.add(connection);
        });
    }

    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public synchronized Connection getConnection() {
        Connection connection = connectionsList.get(0);
        connectionsList.remove(connection);
        releaseConnection(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        connectionsList.add(connection);
    }
}
