package com.solvd.hospital.admin;

import java.util.Scanner;

public interface IHospitalAdmin {
    void welcomePage();
    String getPatientId(Scanner in) throws ExceptionHospitalAdmin;
}
