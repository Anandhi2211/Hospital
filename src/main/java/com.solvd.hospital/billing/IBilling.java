package com.solvd.hospital.billing;

public interface IBilling {

    final static String dermatologyCoPay = "$50";
    final static String OtolaryngologyCoPay = "$70";
    final static String OrthopedicCoPay = "$100";

    void billNumberGenerated(String departmentCode);

}
