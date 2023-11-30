package com.solvd.hospital.welcomepage;

import java.util.Scanner;

public interface IHospitalAdmin {
    void welcomePage();
    String getPatientId(Scanner in) throws ExceptionHospitalAdmin;
}
