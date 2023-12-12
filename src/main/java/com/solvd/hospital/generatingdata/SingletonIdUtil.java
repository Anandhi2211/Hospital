package com.solvd.hospital.generatingdata;

public class SingletonIdUtil {
    private static SingletonIdUtil singletonIdUtil = null;
    private static long patientId = 999;
    public SingletonIdUtil() {
    }
    public static SingletonIdUtil patientIdGenerator() {
        if (singletonIdUtil == null) {
            singletonIdUtil = new SingletonIdUtil();
        }
        return singletonIdUtil;
    }
    public String getPatientIdGenerator() {
        patientId++;
        return String.valueOf(this.patientId);
    }
}
