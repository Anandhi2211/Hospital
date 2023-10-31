import main.java.com.solvd.hospital.appointment.Appointment;
import main.java.com.solvd.hospital.doctor.Doctor;
import main.java.com.solvd.hospital.medication.Medication;
import main.java.com.solvd.hospital.patient.Patient;
import main.java.com.solvd.hospital.personalInformation.PersonalInformation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Hospital {
    int option = 0;
    String patientName;
    //ArrayList<Appointment> appointments = new ArrayList<Appointment>() ;
    ArrayList<Patient> patientList = new ArrayList<>();

    public void welcomePage() {
        do {
            System.out.println("Welcome to Hospital Portal!");
            System.out.println("Please choose the options");
            System.out.println("New Patient -- option 1");
            System.out.println("Doctor to Prescribe Medicine -- option 2");
            System.out.println("Patient to View all the Records -- option 3"); 
            System.out.println("Existing Patient to view the Records -- option 4");
            System.out.println("Exit Portal -- option 5");
            System.out.println("Please Enter your option");
            System.out.println();
            Scanner in = new Scanner(System.in);
            option = in.nextInt();
            switch (option) {
                case 1:
                    Patient patient = new Patient(UUID.randomUUID().toString());
                    System.out.println("Enter your first name:");

                    PersonalInformation personalInfo = new PersonalInformation();
                    personalInfo.setFistName(in.next());
                    patient.setPersonalInfo(personalInfo);

                    System.out.println("Choose the Medical Category");
                    System.out.println("1.Ophthalmologist");
                    System.out.println("2.Dentistry");
                    System.out.println("3.General physician");

                    int doctorOption = in.nextInt();
                    if (doctorOption == 1) {
                        System.out.println("Ophthalmologist is Assigned");
                        Doctor doc = new Doctor();
                        doc.setDepartmentCode("100");
                        patient.setDoctorList(doc);

                        Appointment app = new Appointment();
                        app.setAppointmentStatus("Confirmed");
                        patient.setAppointmentInfo(app);

                    } else if (doctorOption == 2) {
                        System.out.println("Dentistry is Assigned");
                        Doctor doc = new Doctor();
                        doc.setDepartmentCode("101");
                        patient.setDoctorList(doc);

                        Appointment app = new Appointment();
                        app.setAppointmentStatus("Confirmed");
                        patient.setAppointmentInfo(app);

                    } else if (doctorOption == 3) {
                        System.out.println("General Physician is Assigned");
                        Doctor doc = new Doctor();
                        doc.setDepartmentCode("102");
                        patient.setDoctorList(doc);

                        Appointment app = new Appointment();
                        app.setAppointmentStatus("Confirmed");
                        patient.setAppointmentInfo(app);

                    }
                    System.out.println("****************************************************************************************************");
                    System.out.println("Patient Registered and your ID is " + patient.getPatientId());
                    System.out.println("****************************************************************************************************");
                    patientList.add(patient);

                    break;

                case 2:

                    System.out.println("Enter the Patient Name: ");
                    patientName = in.next();
                    for (Patient p : patientList) {
                        if (p.getPersonalInfo().getFistName().equals(patientName)) {
                            Medication medication = new Medication();
                            medication.setMedicationStatus("Medicine Prescribed for Patient ");
                            p.setMedicationInfoList(medication);
                            System.out.println("****************************************************************************************************");
                            System.out.println("Patient Id " + p.getPatientId());
                            System.out.println("Medicine is prescribed for Patient " + p.getPersonalInfo().getFistName());

                        }
                    }

                    System.out.println("****************************************************************************************************");
                    // patientList.add();
                    break;

                case 3:

                    System.out.println("Enter Patient Name: ");
                    patientName = in.next();


                    for (Patient p : patientList) {

                        if (p.getPersonalInfo().getFistName().equals(patientName)) {
                            System.out.println("****************************************************************************************************");
                            System.out.println("First Name " + p.getPersonalInfo().getFistName());
                            System.out.println("Patients ID " + p.getPatientId());
                            //Yet to modify
                            System.out.println("Hospital DepartmentCode " + p.getDoctorList().get(0).getDepartmentCode());
                            System.out.println("Appointment Status of the Patient " + p.getAppointmentInfo().get(0).getAppointmentStatus());
                            System.out.println("Medicine Status of the patient " + p.getMedicationInfo().get(0).getMedicationStatus());
                            System.out.println("****************************************************************************************************");

                        }


                    }


                    break;

                case 4:
                    System.out.println("Thanks for Checking with us");
                    System.out.println("****************************************************************************************************");

                    break;
            }
        } while (option < 4);
    }

    public static void main(String[] args) {

        Hospital hospital = new Hospital();
        hospital.welcomePage();

    }
}