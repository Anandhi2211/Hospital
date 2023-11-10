import com.solvd.hospital.PatientRecord.PatientRecord;
import com.solvd.hospital.billing.Billing;
import com.solvd.hospital.billing.IBilling;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.generatingData.GeneratingData;
import com.solvd.hospital.medicalrecords.MedicalRecords;
import com.solvd.hospital.patient.ExceptionHospitalAdmin;
import com.solvd.hospital.patient.HospitalAdmin;
import com.solvd.hospital.personalInformation.ExceptionPersonalInformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    private static final Logger logger = LogManager.getLogger(Hospital.class);
    public static ArrayList<PatientRecord> patientRecords = new ArrayList<>();
    public static ArrayList<Doctor> doctorList = new ArrayList<>();

    public static void main(String[] args) {
        int option = 0;
        Scanner in = new Scanner(System.in);
        HospitalAdmin admin = new HospitalAdmin();
        Hospital hospital = new Hospital();
        GeneratingData data = new GeneratingData();
        try {
            data.addPatientDetails(patientRecords); // add Patient Details
            data.addDoctorDetails(doctorList); // add Doctor details
            {
                do {
                    admin.welcomePage();
                    option = in.nextInt();
                    if (!(option >= 1) && !(option <= 8)) {
                        throw new ExceptionHospitalAdmin("Invalid Input");
                    }
                    switch (option) {
                        case 1:
                            hospital.printPatientDetails();
                            break;
                        case 2:
                            hospital.printDoctorDetails();
                            break;
                        case 3:
                            hospital.assignDoctorToPatient();
                            break;
                        case 4:
                            hospital.viewPatientRecord();
                            break;
                        case 5:
                            hospital.generateBillForEachPatient();
                            break;
                        case 6:
                            hospital.printAllPatientRecords();
                            break;
                        case 7:
                            hospital.doctorPrescribingPatient();
                            break;
                        case 8:
                            logger.info("Thanks for Checking with us");
                            logger.info("*************************************************");
                            break;
                        default:
                            logger.info("Enter the valid option between 1 and 7: ");
                    }
                } while (option < 8);
            }
        } catch (ExceptionHospitalAdmin e) {
            logger.error(e.getMessage());
        } catch (ExceptionPersonalInformation e) {
            logger.error(e.getMessage());
        }
    }

    private void printAllPatientRecords() {
        for (PatientRecord patientRecord : patientRecords) // printing all the details for the patient
        {
            logger.info(patientRecord);
        }
    }

    private void doctorPrescribingPatient() throws ExceptionHospitalAdmin {
        HospitalAdmin admin = new HospitalAdmin();
        String patientName = admin.getPatientName();
        Boolean patientFound = false;
        for (int i = 0; i < patientRecords.size(); i++) {
            PatientRecord p = patientRecords.get(i);
            if (p.getFirstName().equalsIgnoreCase(patientName)) {
                patientFound = true;
                if (p.getPatientVisitedHospital()) {
                    p.printInformation();
                    logger.info("Enter the Prescriptions : y/n");
                    Scanner in = new Scanner(System.in);
                    String answer = in.next();
                    if (answer.equalsIgnoreCase("y")) {
                        MedicalRecords medicalRecord = new MedicalRecords();
                        medicalRecord.setPrescriptionStatus(true);
                        p.setMedicalRecords(medicalRecord);
                        patientRecords.set(i, p);
                        for (int docterIndex = 0; docterIndex < p.getAssignedDoctorList().size(); docterIndex++) {
                            Doctor doctor = p.getAssignedDoctorList().get(docterIndex);
                            if (doctor.getDepartmentInfo().getDepartmentCode().equals("100")) {
                                logger.info("1.Blood Test");
                                logger.info("2.Laser Test");
                                int option = in.nextInt();
                                switch (option) {
                                    case 1:
                                        medicalRecord.setTestName("Blood Test");
                                        p.setMedicalRecords(medicalRecord);
                                        patientRecords.set(i, p);

                                        break;
                                    case 2:
                                        medicalRecord.setTestName("Laser Test");
                                        p.setMedicalRecords(medicalRecord);
                                        patientRecords.set(i, p);
                                        break;
                                }
                            } else if (doctor.getDepartmentInfo().getDepartmentCode().equals("101")) {
                                logger.info("1.MRI Test");
                                logger.info("2.CT Scan");
                                int option = in.nextInt();
                                switch (option) {
                                    case 1:
                                        medicalRecord.setTestName("MRI Test");
                                        p.setMedicalRecords(medicalRecord);
                                        patientRecords.set(i, p);

                                        break;
                                    case 2:
                                        medicalRecord.setTestName("CT Scan");
                                        p.setMedicalRecords(medicalRecord);
                                        patientRecords.set(i, p);
                                        break;
                                }
                            } else if (doctor.getDepartmentInfo().getDepartmentCode().equals("102")) {
                                logger.info("1.X-Ray");
                                logger.info("2.MRI");
                                int option = in.nextInt();
                                switch (option) {
                                    case 1:
                                        medicalRecord.setTestName("X-Ray");
                                        p.setMedicalRecords(medicalRecord);
                                        patientRecords.set(i, p);

                                        break;
                                    case 2:
                                        medicalRecord.setTestName("MRI");
                                        p.setMedicalRecords(medicalRecord);
                                        patientRecords.set(i, p);
                                        break;
                                }
                            }
                        }
                        p.printPatientMedicalRecords();
                        logger.info(p);
                    }
                } else {
                    logger.info("Doctor can prescribe medication only after visiting the hospital");
                }
            }
        }
        if (!patientFound) {
            logger.info("Patient Not Found");
        }
    }

    private void generateBillForEachPatient() throws ExceptionHospitalAdmin {
        HospitalAdmin admin = new HospitalAdmin();
        String patientName = admin.getPatientName();
        Boolean patientFound = false;
        for (PatientRecord p : patientRecords) {
            if (p.getFirstName().equalsIgnoreCase(patientName)) {
                patientFound = true;
                if (p.getPatientVisitedHospital()) {
                    IBilling billing = new Billing();
                    for (Doctor assignedDoctor : p.getAssignedDoctorList()) {
//                        logger.info(assignedDoctor.getDepartmentInfo().getDepartmentCode());
                        billing.billNumberGenerated(assignedDoctor.getDepartmentInfo().getDepartmentCode());
                    }
                } else {
                    logger.info("Patient did not visit the hospital yet");
                }
            }
        }
        if (!patientFound) {
            logger.info("Patient Not Found");
        }
        logger.info("*************************************************");
    }

    private void viewPatientRecord() throws ExceptionHospitalAdmin {
        HospitalAdmin admin = new HospitalAdmin();
        String patientName = admin.getPatientName();
        Boolean patientFound = false;
        for (PatientRecord p : patientRecords) {
            if (p.getFirstName().equalsIgnoreCase(patientName)) {
                patientFound = true;
                logger.info(p);
            }
        }
        if (!patientFound) {
            logger.info("Patient Not Found");
        }
        logger.info("*************************************************");
    }

    private void assignDoctorToPatient() throws ExceptionHospitalAdmin {
        Scanner in = new Scanner(System.in);
        HospitalAdmin admin = new HospitalAdmin();
        String patientName = admin.getPatientName();
        Boolean patientFound = false;
        for (int i = 0; i < patientRecords.size(); i++) {
            PatientRecord p = patientRecords.get(i);
            if (p.getFirstName().equalsIgnoreCase(patientName)) {
                patientFound = true;
                String patientSymptom = p.getCategory().getPatientSymtom();
                logger.info("Patient Symptoms: " + patientSymptom);
                logger.info("Do you want to make appointment?  Y/N ");
                String answer = in.next();
                if (!answer.equals("Y") && (!answer.equals("y") && (!answer.equals("N")) && (!answer.equals("n")))) {
                    throw new ExceptionHospitalAdmin("Inside Exception Enter either y/n");
                } else {
                    if (answer.equalsIgnoreCase("y")) {
                        boolean doctorIdentified = false;
                        for (Doctor doctor : doctorList) {
                            if (doctor.isTreatable(patientSymptom)) {
                                logger.info("This Doctor ID " + doctor.getDoctorId() + "is assigned for this Patient");
                                p.setAssignedDoctor(doctor);
                                p.setPatientVisitedHospital(true);
                                patientRecords.set(i, p);
                                doctorIdentified = true;
                                break;
                            }
                        }
                        if (!doctorIdentified) {
                            logger.info("Doctor is not available");
                        }
                        logger.info("");
                    } else if (answer.equalsIgnoreCase("N")) {
                        logger.info("Doctor is not assigned");
                    }
                    break;
                }
            }
        }
        if (!patientFound) {
            logger.info("Patient Not Found");
        }
        logger.info("*************************************************");
    }

    private void printDoctorDetails() {
        logger.info("Printing Doctor Details");
        for (Doctor doc : doctorList) {
            doc.printInformation(); // displays only Doctor Details name abstract method overloading
//            doc.symptomsDoctorTreat(doc.getDoctorId());
        }
    }

    private void printPatientDetails() {
        logger.info("Printing Patient Details");
        for (PatientRecord p : patientRecords) {
            p.printInformation(); // displays only patient records abstract method overloading
        }
    }
}