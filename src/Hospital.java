import main.java.com.solvd.hospital.appointment.Appointment;
import main.java.com.solvd.hospital.medication.Medication;
import main.java.com.solvd.hospital.patient.Patient;
import main.java.com.solvd.hospital.personalInformation.PersonalInformation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Hospital {
    int option = 0;
    PersonalInformation personalInfo = new PersonalInformation();
    //ArrayList<Appointment> appointments = new ArrayList<Appointment>() ;
    ArrayList<Patient> patientList = new ArrayList<Patient>() ;
    public void welcomePage()
    {
        do {
            System.out.println("Welcome to Hospital Portal!");
            System.out.println("New Patient -- option 1");
            System.out.println("Existing Patient -- option 2");
            System.out.println("Home Page -- option 3");
            System.out.println("Exit Portal -- option 4");
            System.out.println("Please Enter your option");

            Scanner in = new Scanner(System.in);
            option = in.nextInt();
            switch (option)
            {
                case 1:
                    System.out.println("Inside option 1");
                    Patient patient = new Patient(UUID.randomUUID().toString());
                    System.out.println("Enter your first name:");
                    personalInfo.setFistName(in.next());
                    patient.setPersonalInfo(personalInfo);
                    patientList.add(patient);
                    System.out.println("Enter the Medical Category Options");
                    System.out.println("1.Ophthalmologist");
                    System.out.println("2.Dentistry");
                    System.out.println("3.General physician");
                    int doctorOption = in.nextInt();
                    if (doctorOption == 1) {
                        System.out.println("Ophthalmologist is Assigned");
                        Appointment app = new Appointment();
                        app.setAppointmentStatus("Confirmed");
                       // patientList.add(patient);
                        patient.setAppointmentInfo(app);
                        Medication medication = new Medication();
                        medication.setMedicationStatus("Medicine Prescribed");
                        patient.setMedicationInfoList(medication);

                        // appointments.add();
                    } else if (doctorOption == 2) {
                        System.out.println("Dentistry is Assigned");
                    } else if (doctorOption == 3) {
                        System.out.println("General Physician is Assigned");
                    }
                    System.out.println("***********************************************************");
                    patientList.add(patient);


                    break;
                case 2:
                    for(Patient p :patientList)

                {
                    System.out.println("First Name " + p.getPersonalInfo().getFistName());
                    System.out.println("Patients ID "+p.getPatientId());
                  //  System.out.println("Appointment Status " + p.);
                   // System.out.println("Medicine Status " + p.getMedicationInfo().get(0).getMedicationStatus());
                    System.out.println("***********************************************************");

                }


                break;
                case 3:

                    break;
                case 4:
                    System.out.println("Thanks for Checking with us");
                    System.out.println("***********************************************************");

                    break;
            }
        }while (option<4);
    }
    public static void main(String[] args) {

        Hospital hospital = new Hospital();
        hospital.welcomePage();

    }
}