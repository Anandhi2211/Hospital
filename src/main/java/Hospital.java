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

    //public static ArrayList<>

    public void welcomePage() {
        do {
            System.out.println("Welcome to Hospital Portal!");
            System.out.println("Please choose the options");
            System.out.println("List Patients Name -- option 1");
            System.out.println("Prescribe Medicine for Each Patient -- option 2");
            System.out.println("View all the Records of all the patient  -- option 4");
            System.out.println("Exit Portal -- option 5");
            System.out.println("Please Enter your option");
            System.out.println();
            Scanner in = new Scanner(System.in);
            option = in.nextInt();
            switch (option) {
                case 1:
                    for(Patient p : patientList)
                    {
                        p.printInformation(p); // displays only patient name abstract method overloading
                    }
                    for(Doctor d : doctorList)
                    {
                        System.out.println(d);; // displays only patient name abstract method overloading
                    }
                    break;

                case 2:
                    System.out.println("Enter the Patient Name: ");
                    patientName = in.next();
                    for (Patient p : patientList) {
                        if (p.getPersonalInfo().getFistName().equalsIgnoreCase(patientName) ) {
                            System.out.println("Patient Symtoms: "+p.getCategory().getPatientSymtom());

                            System.out.println("Do you want to make appointment?  Y/N ");
                            answer = in.next();
                           if( answer.equals("Y"))
                            {
                                MedicalCategory symtoms = new MedicalCategory();
                                Doctor doctor = new Doctor();

                            }
                            else if(answer.equals("N"))
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("Enter the correct Value and Start from the beginning");
                            }


                            option = in.nextInt();
                            switch (option)
                            {
                                case 1:
                                    Medication medication = new Medication();
                                    medication.setMedicationStatus("Eye Drops Recommended");
                                    p.setMedicationInfoList(medication);
                                    Billing billing = new Billing();
                                    billing.setBillingNumber(UUID.randomUUID().toString());
                                    p.setBillingInfoList(billing);
                                    System.out.println("BillNumber: "+billing.getBillingNumber());
                                    p.printInformation();
                                    System.out.println("****************************************************************************************************");

                                    break;
                                case 2:
                                    medication = new Medication();
                                    medication.setMedicationStatus("Xrays Recommended");
                                    p.setMedicationInfoList(medication);
                                    billing = new Billing();
                                    billing.setBillingNumber(UUID.randomUUID().toString());
                                    p.setBillingInfoList(billing);
                                    System.out.println("BillNumber: "+billing.getBillingNumber());
                                    p.printInformation();
                                    System.out.println("****************************************************************************************************");


                                    break;
                                case 3:
                                    medication = new Medication();
                                    medication.setMedicationStatus("Antibiotics Recommended");
                                    p.setMedicationInfoList(medication);
                                    billing = new Billing();
                                    billing.setBillingNumber(UUID.randomUUID().toString());
                                    p.setBillingInfoList(billing);
                                    System.out.println("BillNumber: "+billing.getBillingNumber());
                                    p.printInformation();
                                    System.out.println("****************************************************************************************************");
                                    break;
                            }
                        }
                    }

                    System.out.println("****************************************************************************************************");

                    break;
                case 3:
                    System.out.println("Enter Patient Name: ");
                    patientName = in.next();
                    for (Patient p : patientList) {

                        if (p.getPersonalInfo().getFistName().equalsIgnoreCase(patientName)) {
                            System.out.println("****************************************************************************************************");
                            p.printInformation();   // abstract method to print Patient ID(Patient class extends personal) and firstname(abstract Personal Class)
                            System.out.println("****************************************************************************************************");
                        }
                    }
                    break;

                case 4:
                    for( Patient list : patientList ) // printing all the details for the patient
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
        GeneratingData data =new GeneratingData();
        data.addPatientDetails(patientList);
        data.addDoctorDetails(doctorList); // add doctor details
        data.addSymtomDetails(); // adds symtoms
        hospital.welcomePage();


    }


}