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

import java.util.*;

public class Hospital {
    private static final Logger logger = LogManager.getLogger(Hospital.class);
    public static ArrayList<PatientRecord> patientRecords = new ArrayList<>();
    public static HashMap<String, PatientRecord> patientRecordHashMap = new HashMap<>();
    public static ArrayList<Doctor> doctorList = new ArrayList<>();

    public static Set<String> departmentNameList = new HashSet<>();
    public static HashSet<String> billNumber = new HashSet<>();

    public static void main(String[] args) {
        int option ;
        Scanner in = new Scanner(System.in);
        HospitalAdmin admin = new HospitalAdmin();
        Hospital hospital = new Hospital();
        GeneratingData data = new GeneratingData();
        try {
            data.addPatientDetails(patientRecords, patientRecordHashMap); // add Patient Details
            data.addDoctorDetails(doctorList,departmentNameList); // add Doctor details
            {
                do {
                    admin.welcomePage();
                    option = in.nextInt();
                    if (!(option >= 1) && !(option <= 9)) {
                        throw new ExceptionHospitalAdmin("Invalid Input");
                    }
                    switch (option) {
                        case 1:
                            hospital.printPatientDetails();
                            hospital.printDoctorDetails();
                            break;
                        case 2:
                            hospital.assignDoctorToPatient();
                            break;
                        case 3:
                            hospital.viewPatientRecord();
                            break;
                        case 4:
                            hospital.generateBillForEachPatient();
                            break;
                        case 5:
                            hospital.doctorPrescribingPatient();
                            break;
                        case 6:
                            hospital.printAllPatientRecords();
                            break;
                        case 7:
                            hospital.printDepartmentName();
                            break;
                        case 8:
                            hospital.printAllBillNumber();
                            break;
                        case 9:
                            logger.info("Thanks for Checking with us");
                            logger.info("*************************************************");
                            break;
                        default:
                            logger.info("Enter the valid option between 1 and 9: ");
                    }
                } while (option < 9);
            }
        } catch (ExceptionHospitalAdmin e) {
            logger.error(e.getMessage());
        } catch (ExceptionPersonalInformation e) {
            logger.error(e.getMessage());
        }
    }

    private void printAllPatientRecords() {
        logger.info(patientRecordHashMap);
    }

    private void doctorPrescribingPatient() throws ExceptionHospitalAdmin { //Doctor Prescribes Test for the patient
        HospitalAdmin admin = new HospitalAdmin();
        String patientId = admin.getPatientId();
        PatientRecord p = patientRecordHashMap.get(patientId);
        if (patientRecordHashMap.containsKey(patientId)) {
            System.out.println(p.getPatientAssignedDoctor());
            if (p.getPatientAssignedDoctor()) {
                p.printInformation();
                logger.info("Enter the Prescriptions : y/n");
                Scanner in = new Scanner(System.in);
                String answer = in.next();
                if (answer.equalsIgnoreCase("y")) {
                    MedicalRecords medicalRecord = new MedicalRecords();
                    medicalRecord.setPrescriptionStatus(true);
                    p.setMedicalRecords(medicalRecord);
                    patientRecordHashMap.put(patientId, p);
                    for (int doctorIndex = 0; doctorIndex < p.getAssignedDoctorList().size(); doctorIndex++) {
                        Doctor doctor = p.getAssignedDoctorList().get(doctorIndex);
                        if (doctor.getDepartmentInfo().getDepartmentCode().equals("100")) {
                            logger.info("1.Blood Test");
                            logger.info("2.Laser Test");
                            int option = in.nextInt();
                            switch (option) {
                                case 1:
                                    medicalRecord.setTestName("Blood Test");
                                    p.setMedicalRecords(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                                case 2:
                                    medicalRecord.setTestName("Laser Test");
                                    p.setMedicalRecords(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
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
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                                case 2:
                                    medicalRecord.setTestName("CT Scan");
                                    p.setMedicalRecords(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
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
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                                case 2:
                                    medicalRecord.setTestName("MRI");
                                    p.setMedicalRecords(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                            }
                        }
                    }
                    p.printPatientMedicalRecords();
                    logger.info(p);
                } else if (answer.equalsIgnoreCase("n")) {
                    logger.info("Do not want to prescribe medication,  Enter the details again.");
                }
            } else {
                logger.info("Doctor was not assigned to the patient");
            }
        } else {
            logger.info("Patient Not Found");
        }
    }

    private void generateBillForEachPatient() throws ExceptionHospitalAdmin { // Generate bill once only after assigning doctor to a patient
        HospitalAdmin admin = new HospitalAdmin();
        String patientId = admin.getPatientId();
        if (patientRecordHashMap.containsKey(patientId)) {
            PatientRecord p = patientRecordHashMap.get(patientId);
            if (p.getPatientAssignedDoctor()) {
                IBilling billing = new Billing();
                for (Doctor assignedDoctor : p.getAssignedDoctorList()) {
                    billing.billNumberGenerated(patientId, patientRecordHashMap, assignedDoctor.getDepartmentInfo().getDepartmentCode(),billNumber);
                }
            } else {
                logger.info("Patient did not visit the hospital yet");
            }
        } else {
            logger.info("Patient Not Found");
        }
        logger.info("*************************************************");
    }

    private void viewPatientRecord() throws ExceptionHospitalAdmin { // View particular patient Record
        HospitalAdmin admin = new HospitalAdmin();
        String patientId = admin.getPatientId();
        if (patientRecordHashMap.containsKey(patientId)) {
            logger.info(patientRecordHashMap.get(patientId));
        } else {
            logger.info("Patient Not Found");
        }
        logger.info("*************************************************");
    }

    private void assignDoctorToPatient() throws ExceptionHospitalAdmin { // Checks the symptoms and assign doctor to a patient
        Scanner in = new Scanner(System.in);
        HospitalAdmin admin = new HospitalAdmin();
        String patientId = admin.getPatientId();
        if (patientRecordHashMap.containsKey(patientId)) {
            PatientRecord p = patientRecordHashMap.get(patientId);
            if(!p.getPatientAssignedDoctor())
            {
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
                                    p.setPatientAssignedDoctor(true);
                                    patientRecordHashMap.put(patientId, p);
                                    doctorIdentified = true;
                                    break;
                                }
                            }
                            if (!doctorIdentified) {
                                logger.info("Doctor is not available");
                            }
                    }  if (answer.equalsIgnoreCase("N")) {
                        logger.info("Doctor is not assigned");
                    }
                }
            }
             if (p.getPatientAssignedDoctor())
            {
                logger.info("Already Doctor Assigned for the Patient");
            }
        } else {
            logger.info("Patient Not Found");
        }
        logger.info("*************************************************");
    }

    private void printDoctorDetails() { //Prints all the Doctor Details
        logger.info("Printing Doctor Details");
        for (Doctor doc : doctorList) {
            doc.printInformation(); // displays only Doctor Details name abstract method overloading
        }
    }

    private void printPatientDetails() { // Prints the Patient Details(Name, ID and Symptoms
        logger.info("Printing Patient Details");
        for (String patientId : patientRecordHashMap.keySet()) {
            patientRecordHashMap.get(patientId).printInformation();
//            p.printInformation(); // displays only patient records abstract method overloading
        }




    }

    private void printAllBillNumber()
    {
        logger.info("Entire Bill List");
        logger.info(billNumber);
    }

    private void printDepartmentName()
    {
        logger.info("Department in the Hospital");
        logger.info(departmentNameList);
    }



}