import com.solvd.hospital.PatientRecord.PatientRecord;
import com.solvd.hospital.billing.Billing;
import com.solvd.hospital.billing.IBilling;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.generatingData.GeneratingData;
import com.solvd.hospital.patient.HospitalAdmin;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {

    public static ArrayList<PatientRecord> patientRecords = new ArrayList<PatientRecord>();
    public static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();

    public static void main(String[] args) {
        int option;
        HospitalAdmin admin = new HospitalAdmin();
        GeneratingData data = new GeneratingData();
        data.addPatientDetails(patientRecords);
        data.addDoctorDetails(doctorList); // add doctor details
        {
            do {
                admin.welcomePage();
                Scanner in = new Scanner(System.in);
                option = in.nextInt();
                switch (option) {
                    case 1:
                        for (PatientRecord p : patientRecords) {
                            p.printInformation(); // displays only patient records abstract method overloading
                        }
                        break;
                    case 2:
                        for (Doctor doc : doctorList) {
                            doc.printInformation(); // displays only Doctor Details name abstract method overloading
                        }
                        break;
                    case 3:
                        String patientName = admin.getPatientName();
                        for (int i = 0; i < patientRecords.size(); i++) {
                            PatientRecord p = patientRecords.get(i);
                            if (p.getFistName().equalsIgnoreCase(patientName)) {
                                String patientSymtom = p.getCategory().getPatientSymtom();
                                System.out.print("Patient Symptoms: " + patientSymtom);
                                System.out.print("Do you want to make appointment?  Y/N ");
                                String answer = in.next();
                                if (answer.equalsIgnoreCase("y")) {
                                    for (Doctor doctor : doctorList) {
                                        if (doctor.isTreatable(patientSymtom)) {
                                            System.out.print("This Doctor ID " + doctor.getDoctorId() + "is assigned for this Patient");
                                            p.setAssignedDoctor(doctor);
                                            p.setPatientVisitedHospital(true);
                                            patientRecords.set(i, p);
                                            break;
                                        }
                                    }
                                    System.out.println("");
                                } else if (answer.equalsIgnoreCase("N")) {
                                    System.out.println("Doctor is not assigned..!!");
                                    break;
                                } else {
                                    System.out.println("Enter the correct Value and Start from the beginning");
                                }
                            }
                        }
                        System.out.println("****************************************************************************************************");
                        break;

                    case 4:
                        patientName = admin.getPatientName();
                        for (PatientRecord p : patientRecords) {
                            if (p.getFistName().equalsIgnoreCase(patientName)) {
                                System.out.println(p);
                            }
                        }
                        System.out.println("****************************************************************************************************");
                        break;
                    case 5:
                        patientName = admin.getPatientName();
                        for (PatientRecord p : patientRecords) {
                            if (p.getFistName().equalsIgnoreCase(patientName)) {
                                if (p.getPatientVisitedHospital()) {
                                    IBilling billing = new Billing();
                                    for (Doctor assignedDoctor : p.getAssignedDoctorList()) {
                                        System.out.println(assignedDoctor.getDepartmentInfo().getDepartmentCode());
                                        billing.billNumberGenerated(assignedDoctor.getDepartmentInfo().getDepartmentCode());
                                    }
                                } else {
                                    System.out.println("Patient did not visit the hospital yet");
                                }
                            }
                        }
                        System.out.println("****************************************************************************************************");
                        break;
                    case 6:

                        for (PatientRecord patientRecord : patientRecords) // printing all the details for the patient
                        {
                            System.out.println(patientRecord);
                        }
                        break;

                    case 7:
                        System.out.println("Thanks for Checking with us");
                        System.out.println("****************************************************************************************************");
                        break;

                    default:
                        System.out.print("Enter the valid option between 1 and 7: ");
                }
            } while (option < 7);
        }
    }

}