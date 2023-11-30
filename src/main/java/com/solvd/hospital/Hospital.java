package com.solvd.hospital;

import com.solvd.hospital.department.HospitalDepartment;
import com.solvd.hospital.medicalrecords.Treatment;
import com.solvd.hospital.welcomepage.ExceptionHospitalAdmin;
import com.solvd.hospital.welcomepage.HospitalWelcomePage;
import com.solvd.hospital.billing.Billing;
import com.solvd.hospital.department.Department;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.generatingdata.GeneratingData;
import com.solvd.hospital.medicalrecords.MedicalRecord;
import com.solvd.hospital.patient.Patient;
import com.solvd.hospital.patientrecord.PatientRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class Hospital {
//    public static Integer patientId = 1000;
    private static final Logger logger = LogManager.getLogger(Hospital.class);
    public static ArrayList<PatientRecord> patientRecordList = new ArrayList<>();
    public static HashMap<String, PatientRecord> patientRecordHashMap = new HashMap<>();
    public static ArrayList<Doctor> doctorList = new ArrayList<>();
    public static HashSet<Department> departmentList = new HashSet<>();
    public static HashSet<Billing> billNumbers = new HashSet<>();
    public static HashSet<Patient> newPatientList = new HashSet<>();
    public static void main(String[] args) {
        int option;
        Scanner in = new Scanner(System.in);
        HospitalWelcomePage admin = new HospitalWelcomePage();
        Hospital hospital = new Hospital();
        GeneratingData data = new GeneratingData();
        try {
            patientRecordList = data.addPatientDetails(patientRecordList); // add Patient Details
            patientRecordHashMap = data.addToHashMap(patientRecordHashMap,patientRecordList);
            doctorList = data.addDoctorDetails(doctorList); // add Doctor details
            departmentList = data.addDepartmentDetails(doctorList,departmentList);
            {
                do {
                    admin.welcomePage();
                    option = in.nextInt();
                    if (!(option >= 1) || !(option <= 9)) {
                        throw new ExceptionHospitalAdmin("Invalid Input");
                    }
                    switch (option) {
                        case 1:
                            hospital.printPatientDetails();
                            hospital.printDoctorDetails();
                            hospital.printDepartmentInfo();
                            break;
                        case 2:
                            hospital.assignDoctorToPatient(in);
                            break;
                        case 3:
                            hospital.viewPatientRecord(in);
                            break;
                        case 4:
                            hospital.generateBillForEachPatient(in);
                            break;
                        case 5:
                            hospital.doctorPrescribingPatient(in);
                            break;
                        case 6:
                            hospital.printAllPatientRecords();
                            break;
                        case 7:
//                            data.addNewPatientList();
//                            hospital.newPatientList(in);
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
        } finally {
            in.close();
            logger.info("Finally No Exception found");
        }
    }
//    private void newPatientList(Scanner in)  {
//        logger.info("Do you want add to the patient List  Y/N ");
//        Iterator iterator = newPatientList.iterator();
//        while (iterator.hasNext()) {
//            Patient patient;
//            patient = (Patient) iterator.next();
//            logger.info("Add this new Patient " + patient.getFirstName() + "?:  Y/N");
//            String answer = in.next();
//            if (answer.equalsIgnoreCase("y")) {
//                logger.info("Enter the symptoms");
//                String patientSymptom = in.next();
//                Symptoms symptoms = new Symptoms();
//                symptoms.setPatientSymptom(patientSymptom);
//                patient.setSymptoms(symptoms);
//                patient.setPatientId(String.valueOf(patientId + 1));
//                PatientRecord patientRecord = new PatientRecord();
//                patientRecord.setPatient(patient);
//                patientRecordList.add(patientRecord);
//                patientRecordHashMap.put(patient.getPatientId(), patientRecord);
//            } else if (answer.equalsIgnoreCase("N")) {
//                logger.info("Look into next Patient");
//            } else {
//                logger.info("Enter either Y/N");
//            }
//        }
//    }
    private void printAllPatientRecords() {
        logger.info(patientRecordHashMap);
    }
    private void doctorPrescribingPatient(Scanner in) throws ExceptionHospitalAdmin { //Doctor Prescribes Test for the patient
        HospitalWelcomePage admin = new HospitalWelcomePage();
        String patientId = admin.getPatientId(in);
        PatientRecord p = patientRecordHashMap.get(patientId);
        if (patientRecordHashMap.containsKey(patientId)) {
            if (p.getPatientAssignedDoctor()) {
                p.printInformation();
                logger.info("Enter the Prescriptions : y/n");
                String answer = in.next();
                if (answer.equalsIgnoreCase("y")) {
                    MedicalRecord medicalRecord = new MedicalRecord();
                    medicalRecord.setPrescriptionStatus(true);
                    p.setMedicalRecords(medicalRecord);
                    patientRecordHashMap.put(patientId, p);
                    for (int doctorIndex = 0; doctorIndex < p.getAssignedDoctorList().size(); doctorIndex++) {
                        Doctor doctor = p.getAssignedDoctorList().get(doctorIndex);
                        if (doctor.getDepartmentInfo().getDepartmentCode().equals(HospitalDepartment.DERMATOLOGY.getDeptCode())) {
                            logger.info("1."+Treatment.bloodTest);
                            logger.info("2."+Treatment.laserTest);
                            int option = in.nextInt();
                            switch (option) {
                                case 1:
                                    medicalRecord.setTestName(String.valueOf(Treatment.bloodTest));
                                    p.setMedicalRecords(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                                case 2:
                                    medicalRecord.setTestName(String.valueOf(Treatment.laserTest));
                                    p.setMedicalRecords(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                            }
                        } else if (doctor.getDepartmentInfo().getDepartmentCode().equals(HospitalDepartment.OTOLARYNGOLOGY.getDeptCode())) {
                            logger.info("1."+Treatment.antibiotics);
                            logger.info("2."+Treatment.painKillers);
                            int option = in.nextInt();
                            switch (option) {
                                case 1:
                                    medicalRecord.setTestName(String.valueOf(Treatment.antibiotics));
                                    p.setMedicalRecords(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                                case 2:
                                    medicalRecord.setTestName(String.valueOf(Treatment.painKillers));
                                    p.setMedicalRecords(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                            }
                        } else if (doctor.getDepartmentInfo().getDepartmentCode().equals(HospitalDepartment.ORTHOPEDIC.getDeptCode())) {
                            logger.info("1."+Treatment.xRay);
                            logger.info("2."+Treatment.physiotherapy);
                            int option = in.nextInt();
                            switch (option) {
                                case 1:
                                    medicalRecord.setTestName(String.valueOf(Treatment.xRay));
                                    p.setMedicalRecords(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                                case 2:
                                    medicalRecord.setTestName(String.valueOf(Treatment.physiotherapy));
                                    p.setMedicalRecords(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                            }
                        }
                    }
                    p.printPatientMedicalRecords();
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

    private void generateBillForEachPatient(Scanner in) throws ExceptionHospitalAdmin { // Generate bill once only after assigning doctor to a patient
        HospitalWelcomePage admin = new HospitalWelcomePage();
        String patientId = admin.getPatientId(in);
        if (patientRecordHashMap.containsKey(patientId)) {
            PatientRecord p = patientRecordHashMap.get(patientId);
            if (p.getPatientAssignedDoctor()) {
                for (Doctor assignedDoctor : p.getAssignedDoctorList()) {
                    if (assignedDoctor.getDepartmentInfo().getDepartmentCode().equals("100")) {
                        Billing billing = new Billing();
                        billing.setBillingNumber(UUID.randomUUID().toString());
                        logger.info("Bill Generated for the Patient : " + billing.getBillingNumber());
                        p.setBillingsList(billing);
                        patientRecordHashMap.put(patientId, p);
                        billNumbers.add(billing);
                        logger.info("Co-pay amount for Dermatology visit: $" + Billing.DERMATOLOGY_CO_PAY );
                    } else if (assignedDoctor.getDepartmentInfo().getDepartmentCode().equals("101")) {
                        Billing billing = new Billing();
                        billing.setBillingNumber(UUID.randomUUID().toString());
                        logger.info("Bill Generated for the Patient : " + billing.getBillingNumber());
                        p.setBillingsList(billing);
                        patientRecordHashMap.put(patientId, p);
                        billNumbers.add(billing);
                        logger.info("Co-pay amount for Otolaryngology visit: $" + Billing.OTOLARYNGOLOGY_CO_PAY);
                    } else if (assignedDoctor.getDepartmentInfo().getDepartmentCode().equals("102")) {
                        Billing billing = new Billing();
                        billing.setBillingNumber(UUID.randomUUID().toString());
                        logger.info("Bill Generated for the Patient : " + billing.getBillingNumber());
                        p.setBillingsList(billing);
                        patientRecordHashMap.put(patientId, p);
                        billNumbers.add(billing);
                        logger.info("Co-pay amount for Orthopedic visit: $" + Billing.ORTHOPEDIC_CO_PAY);
                    }
                }
            } else {
                logger.info("Patient did not visit the hospital yet");
            }
        } else {
            logger.info("Patient Not Found");
        }
        logger.info("*************************************************");
    }

    private void viewPatientRecord(Scanner in) throws ExceptionHospitalAdmin { // View particular patient Record
        HospitalWelcomePage admin = new HospitalWelcomePage();
        String patientId = admin.getPatientId(in);
        if (patientRecordHashMap.containsKey(patientId)) {
            logger.info(patientRecordHashMap.get(patientId));
        } else {
            logger.info("Patient Not Found");
        }
        logger.info("*************************************************");
    }

    private void assignDoctorToPatient(Scanner in) throws ExceptionHospitalAdmin { // Checks the symptoms and assign doctor to a patient
        HospitalWelcomePage admin = new HospitalWelcomePage();
        String patientId = admin.getPatientId(in);
        if (patientRecordHashMap.containsKey(patientId)) {
            PatientRecord p = patientRecordHashMap.get(patientId);
            if (!p.getPatientAssignedDoctor()) {
                String patientSymptom = p.getPatient().getSymptoms().getPatientSymptom();
                logger.info("Patient Symptoms: " + patientSymptom);
                logger.info("Do you want to make appointment?  Y/N");
                String answer =in.next();
                if (!answer.equals("Y") && (!answer.equals("y") && (!answer.equals("N")) && (!answer.equals("n")))) {
                    throw new ExceptionHospitalAdmin("Inside Exception Enter either y/n");
                } else {
                    if (answer.equalsIgnoreCase("y")) {
                        boolean doctorIdentified = false;
                        for (Doctor doctor : doctorList) {
                            if (doctor.isTreatable(patientSymptom) && !(doctor.isDoctorAssigned())) {
                               doctor.setDoctorAssigned(true);
//                               logger.info(doctor.isDoctorAssigned());
                                p.setAssignedDoctor(doctor);
                                p.setPatientAssignedDoctor(true);
                                patientRecordHashMap.put(patientId, p);
                                doctorIdentified = true;
                                logger.info("This Doctor ID " + doctor.getDoctorId() + "is assigned for this Patient " );
                                break;
                            }
                        }
                        if (!doctorIdentified) {
                            logger.info("Doctor is not available");
                        }
                    }
                    if (answer.equalsIgnoreCase("N")) {
                        logger.info("Doctor is not assigned");
                    }
                }
            }
            else if (p.getPatientAssignedDoctor()) {
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
        }
    }
    private void printAllBillNumber() throws ExceptionHospitalAdmin {
        logger.info("Entire Bill List");
        for (Billing billNumber : billNumbers) {
            logger.info(billNumber);
        }
    }
    private void printDepartmentInfo() {
        logger.info("Departments in the Hospital");
        logger.info(departmentList);
    }
}