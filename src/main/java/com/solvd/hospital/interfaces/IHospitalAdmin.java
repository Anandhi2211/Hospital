package com.solvd.hospital.interfaces;

import com.solvd.hospital.exceptions.ExceptionHospitalAdmin;

import java.util.Scanner;

public interface IHospitalAdmin {
    void welcomePage();

    String getPatientId(Scanner in) throws ExceptionHospitalAdmin;
}
