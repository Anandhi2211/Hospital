import com.solvd.hospital.billing.Billing;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.generatingData.GeneratingData;
import com.solvd.hospital.medicalCategory.MedicalCategory;
import com.solvd.hospital.medication.Medication;
import com.solvd.hospital.patient.Patient;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Hospital {
    int option = 0;
    String answer;
    String patientName;
    public static ArrayList<Patient> patientList = new ArrayList<Patient>();
    public static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();

    public void welcomePage() {
        do {
            System.out.println("Welcome to Hospital Portal!");
            System.out.println("Please choose the options");
            System.out.println("List Patients Name -- option 1");
            System.out.println("Assign Doctor for each Patient -- option 2");
            System.out.println("Look up particular patient -- option 3");
            System.out.println("View all the patient Details  -- option 4");
            System.out.println("Exit Portal -- option 5");
            System.out.println("Please Enter your option");
            System.out.println();
            Scanner in = new Scanner(System.in);
            option = in.nextInt();
            switch (option) {
                case 1:
                    for (Patient p : patientList) {
                        p.printInformation(p); // displays only patient name abstract method overloading
                    }
                   /* for(Doctor d : doctorList)
                    {
                        System.out.println(d);; // displays only patient name abstract method overloading
                    }*/
                    break;
                case 2:
                    System.out.println("Enter the Patient Name: ");
                    patientName = in.next();
                    Doctor doctor = new Doctor();
                    doctor.assignedDoctor(patientName, patientList, in, doctorList); // Abstract metthod

                    System.out.println("****************************************************************************************************");
                    break;
                case 3:
                    System.out.println("Enter Patient Name: ");
                    patientName = in.next();
                    for (Patient p : patientList) {

                        if (p.getPersonalInfo().getFistName().equalsIgnoreCase(patientName)) {
                            System.out.println("****************************************************************************************************");
                            p.printInformation();// abstract method to print Patient ID(Patient class extends personal) and firstname(abstract Personal Class)
                            System.out.println("****************************************************************************************************");
                        }
                    }
                    break;
                case 4:
                    for (Patient list : patientList) // printing all the details for the patient
                    {
                        System.out.println(list);
                    }
                    System.out.println("Thanks for Checking with us");
                    System.out.println("****************************************************************************************************");
                    break;
                default:
                    System.out.println("Enter the valid option between 1 and 4 ");
            }
        } while (option < 4);
    }

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        GeneratingData data = new GeneratingData();
        data.addPatientDetails(patientList);
        data.addDoctorDetails(doctorList); // add doctor details
        hospital.welcomePage();
    }
}