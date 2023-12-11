package com.solvd.hospital;

import com.solvd.hospital.billing.Billing;
import com.solvd.hospital.billing.Payment;
import com.solvd.hospital.department.Department;
import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.enums.*;
import com.solvd.hospital.exceptions.ExceptionHospitalAdmin;
import com.solvd.hospital.generatingdata.GeneratingData;
import com.solvd.hospital.generatingdata.PatientIdGenerator;
import com.solvd.hospital.interfaces.IBilling;
import com.solvd.hospital.patient.Patient;
import com.solvd.hospital.patient.PatientRecord;
import com.solvd.hospital.patient.Symptoms;
import com.solvd.hospital.patient.TreatmentDetails;
import com.solvd.hospital.welcomepage.HospitalWelcomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.*;

public class Hospital {
    private static final Logger logger = LogManager.getLogger(Hospital.class);
    public static ArrayList<PatientRecord> patientRecordList = new ArrayList<>();
    public static HashMap<String, PatientRecord> patientRecordHashMap = new HashMap<>();
    public static ArrayList<Doctor> doctorList = new ArrayList<>();
    public static HashSet<Department> departmentList = new HashSet<>();
    public static HashMap<String, Billing> billNumbers = new HashMap<>();
    public static HashSet<Patient> newPatientList = new HashSet<>();

    public static void main(String[] args) {
        int option;
        Scanner in = new Scanner(System.in);
        HospitalWelcomePage admin = new HospitalWelcomePage();
        Hospital hospital = new Hospital();
        GeneratingData data = new GeneratingData();
        try {
            patientRecordList = data.addPatientDetails(patientRecordList); // add Patient Details
            patientRecordHashMap = data.addToHashMap(patientRecordHashMap, patientRecordList);
            doctorList = data.addDoctorDetails(doctorList); // add Doctor details
            departmentList = data.addDepartmentDetails(doctorList, departmentList);
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
                            logger.info("*****************");
                            hospital.printDoctorDetails();
                            logger.info("*****************");
                            hospital.printDepartmentInfo();
                            logger.info("*****************");
                            break;
                        case 2:
                            logger.info("ASSIGNS DOCTOR TO THE PATIENT");
                            hospital.assignDoctorToPatient(in);
                            break;
                        case 3:
                            logger.info("DOCTOR TREATS THE PATIENT");
                            hospital.doctorTreatingPatient(in);
                            logger.info("*****************");
                            break;
                        case 4:
                            logger.info("ADMIN GENERATES BILL FOR ALL THE PATIENT");
                            hospital.generateBillForPatient(in);
                            break;
                        case 5:
                            logger.info("ENTER THE PATIENT ID TO DO PAYMENT");
                            hospital.patientPayingBill(in);
//                            hospital.financialBenefitsForEachPatient(in);
                            break;
                        case 6:
                            logger.info("ADD NEW PATIENTS TO THE RECORD");
                            newPatientList = data.addNewPatientList(newPatientList);
                            hospital.newPatientList(newPatientList, in);
                            break;
                        case 7:
                            logger.info("ENTER PATIENT ID TO VIEW THE DETAILS");
                            hospital.viewPatientRecord(in);
                            break;
                        case 8:
                            logger.info("CHANGE DOCTOR ASSIGNED STATUS USING REFLECTION");
                            hospital.changeDoctorAssignedStatus(in);
                            break;
                        case 9:
                            logger.info("ENTER ALL THE PATIENT DETAILS");
                            hospital.printAllPatientRecords();
                            break;
                        case 0:
                            logger.info("Thanks for Checking with us");
                            logger.info("*************************************************");
                            break;
                        default:
                            logger.info("Enter the valid option between 1 and 9: ");
                    }
                } while (option < 10);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
            logger.info("Finally No Exception found");
        }
    }

    private void patientPayingBill(Scanner in) {
        HospitalWelcomePage admin = new HospitalWelcomePage();
        String patientId = admin.getPatientId(in);
        PatientRecord patientRecord = patientRecordHashMap.get(patientId);
        if (patientRecordHashMap.containsKey(patientId)) {

            if (patientRecord.getBilling().isBillingGeneratedStatus() && patientRecord.getBilling()!=null) {
                logger.info("Patient Id: " + patientRecord.getPatient().getPatientId());
                logger.info("Bill Number: " + patientRecord.getBilling().getBillingNumber());
                logger.info("Bill Amount: " + patientRecord.getBilling().getBillingAmount());
                logger.info("Enter Card Number:");
                String cardNumber = in.next();
                Payment payment = new Payment();
                payment.setCardNumber(cardNumber);
                logger.info("Enter The card Name: ");
                String cardName = in.next();
                payment.setCardName(cardName);
                logger.info("Enter CVV: ");
                String cvv = in.next();
                payment.setCvvNumber(cvv);
                payment.setPaymentPaidStatus(true);
                patientRecord.setPayment(payment);
                patientRecordHashMap.put(patientId, patientRecord);
            }

            else {
                logger.info("Billing Not Generated");
            }
        } else {
            logger.info("Patient Id Not Found");
        }


    }

//    private void financialAssistanceCheck(HashMap<String, PatientRecord> patientRecordHashMap) {
//        logger.info("Prints every Patient and their Financial Benefits Percentage : ");
//        Billing billing = new Billing();
//        patientRecordHashMap.keySet()
//                .stream().sorted().map(x -> patientRecordHashMap.get(x))
//                .forEach(y -> billing.checkFinancialBenefits(y).printFinancialBenefits());
//    }

    private void changeDoctorAssignedStatus(Scanner in) throws Exception {
        logger.info("Using Reflections Changing Doctor Assigned Status:");
        Doctor doctor = new Doctor();
        Field[] doctorFields = doctor.getClass().getDeclaredFields();
        logger.info("Enter Doctor Id to change the Doctor Details");
        String answer = in.next();
        Doctor reflectionDoctor = doctorList.stream()
                .filter(doctor1 -> doctor1.getDoctorId()
                        .equalsIgnoreCase(answer)).findAny().get();
        System.out.println("Before Changing Doctor Status: " + reflectionDoctor.getDoctorAssigned());
        Field fil = Arrays.stream(doctorFields)
                .filter(y -> y.getName()
                        .equalsIgnoreCase("doctorAssigned"))
                .findAny().get();
        fil.setAccessible(true);
        fil.set(reflectionDoctor, true);
        System.out.println("After Changing Doctor Status: " + reflectionDoctor.getDoctorAssigned());
    }

    private void generateBillForPatient(Scanner in) throws ExceptionHospitalAdmin { // Generate bill
        for (String patientId : patientRecordHashMap.keySet()) {
            PatientRecord patientRecord = patientRecordHashMap.get(patientId);
            if (patientRecord.getBilling()!=null) {
                if (patientRecord.getPatientAssignedDoctor()) {
                    if (patientRecord.getTreatmentDetails() != null) {
                        Treatment treatment = Arrays.stream(Treatment.values())
                                .filter(t -> t.name()
                                        .equalsIgnoreCase(patientRecord.getTreatmentDetails().getTestName())).findAny().orElse(null);
                        Billing billing = new Billing();
                        billing.setBillingNumber(UUID.randomUUID().toString());
                        billing.setBillingGeneratedStatus(true);
                        CoPay coPay = Arrays.stream(CoPay.values())
                                .filter(coPay1 -> patientRecord.getAssignedDoctor().getDepartmentInfo().getDepartmentCode()
                                        .equals(coPay1.getDepCode())).findFirst().get();
                        if (treatment == null) {
                            billing.setBillingAmount(coPay.getCoPayAmt());
                            patientRecord.setBilling(billing);
                        } else {
                            billing.setBillingAmount(coPay.getCoPayAmt() + treatment.getPriceAmt());
                            patientRecord.setBilling(billing);
                        }
                        HospitalInsurance hp = Arrays.stream(HospitalInsurance.values())
                                .filter(hospitalInsurance1 -> hospitalInsurance1.name()
                                        .equalsIgnoreCase(patientRecord.getPatient().getInsurance().getInsuranceName())).findAny().get();
                        IBilling iBilling = (patientRecordLamda) -> {
                            Billing billingLamda = patientRecordLamda.getBilling();
                            patientRecordLamda = billingLamda.checkFinancialBenefits(patientRecordLamda);
                            int financialBenefitsAmt = billingLamda.getBillingAmount() * (patientRecordLamda.getBilling().getBenefitPercent()) / 100;
                            int insuranceBenefitsAmt = billingLamda.getBillingAmount() * (hp.getPercentageConcession()) / 100;
                            logger.info("Patient Id: " + patientRecordLamda.getPatient().getPatientId());
                            logger.info("Total Amount Before Financial Benefits: " + patientRecordLamda.getBilling().getBillingAmount());
                            logger.info("Deductible amount as per the insurance: " + insuranceBenefitsAmt);
                            logger.info("Deductible amount as per the Financial benefits: " + financialBenefitsAmt);
                            logger.info("Patient final amount to pay: " + (billingLamda.getBillingAmount() - insuranceBenefitsAmt - financialBenefitsAmt));
                            billingLamda.setBillingAmount((billingLamda.getBillingAmount() - insuranceBenefitsAmt - financialBenefitsAmt));
                            patientRecordLamda.setBilling(billingLamda);
                            patientRecordHashMap.put(patientId, patientRecordLamda);
                        };
                        iBilling.billCalculation(patientRecord);
                        logger.info("Bill Number: " + billing.getBillingNumber());
                        logger.info("Bill Amount: " + billing.getBillingAmount());
                        logger.info("**********");
                        billing.setBillingGeneratedStatus(true);
                        patientRecord.setBilling(billing);
                        patientRecordHashMap.put(patientId, patientRecord);
                        billNumbers.put(billing.getBillingNumber(), billing);
                    } else {
                        logger.info("Doctor didn't Treat the Patient ");
                    }
                } else {
                    logger.info(patientRecord.getPatient().getPatientId() + " No Billing Record");
                }
            } else {
                logger.info("Patient Id: " + patientRecord.getPatient().getPatientId());
                logger.info("Bill Number: " + patientRecord.getBilling().getBillingNumber());
                logger.info("Bill Amount: " + patientRecord.getBilling().getBillingAmount());
                logger.info("*****************");
            }
        }
    }

    private void newPatientList(HashSet<Patient> newPatientList, Scanner in) {
        logger.info("Adding New Patients to Hash Map and adding their Symptoms");
        logger.info("Do you want add to the patient List  Y/N ");
        Iterator<Patient> iterator = newPatientList.iterator();
        while (iterator.hasNext()) {
            Patient patient;
            patient = iterator.next();
            logger.info("Add this new Patient " + patient.getPersonalInformation().getFirstName() + "?:  Y/N");
            String answer = in.next();
            if (answer.equalsIgnoreCase("y")) {
                logger.info("Enter the symptoms value: ");
                Arrays.stream(ListOfSymptoms.values())
                        .forEach(listOfSymptoms -> System.out.println(listOfSymptoms.name() + "---" + listOfSymptoms.getValue()));
                int value = in.nextInt();
                ListOfSymptoms listOfSymptoms = Arrays.stream(ListOfSymptoms.values())
                        .filter(l -> l.getValue() == value).findAny().get();
                Symptoms symptoms = new Symptoms();
                PatientIdGenerator patientIdGenerator = new PatientIdGenerator();
                logger.info(listOfSymptoms.name() + " is assigned to the Patient " + patient.getPersonalInformation().getFirstName());
                symptoms.setPatientSymptom(listOfSymptoms.name());
                patient.setSymptoms(symptoms);
                patient.setPatientId(patientIdGenerator.getPatientIdGenerator());
                logger.info("Im herer " + patient.getPatientId());
                PatientRecord patientRecord = new PatientRecord();
                patientRecord.setPatient(patient);
                patientRecordList.add(patientRecord);

                GeneratingData data = new GeneratingData();

                patientRecordHashMap = data.addToHashMap(patientRecordHashMap, patientRecordList);
//                patientRecordHashMap.put(patient.getPatientId(), patientRecord);


            } else if (answer.equalsIgnoreCase("N")) {
                logger.info("Look into next Patient");
            } else {
                logger.info("Enter either Y/N");
            }
        }
    }

    private void printAllPatientRecords() {
        patientRecordHashMap.keySet().stream().sorted().forEach(x->logger.info(patientRecordHashMap.get(x)));
    }

    private void doctorTreatingPatient(Scanner in) throws ExceptionHospitalAdmin { //Doctor Prescribes Test for the patient
        HospitalWelcomePage admin = new HospitalWelcomePage();
        String patientId = admin.getPatientId(in);
        PatientRecord p = patientRecordHashMap.get(patientId);
        if (patientRecordHashMap.containsKey(patientId)) {
            if (p.getTreatmentDetails() != null) {
                if (p.getPatientAssignedDoctor()) {
                    p.printInformation();
                    logger.info("Enter the Prescriptions : y/n");
                    String answer = in.next();
                    if (answer.equalsIgnoreCase("y")) {
                        TreatmentDetails medicalRecord = new TreatmentDetails();
                        medicalRecord.setPrescriptionStatus(true);
                        p.setTreatmentDetails(medicalRecord);
                        patientRecordHashMap.put(patientId, p);
                        Doctor doctor = p.getAssignedDoctor();
                        if (doctor.getDepartmentInfo().getDepartmentCode().equals(HospitalDepartment.DERMATOLOGY.getDeptCode())) {
                            logger.info("1." + Treatment.BLOOD_TEST);
                            logger.info("2." + Treatment.LASER_TEST);
                            int option = in.nextInt();
                            switch (option) {
                                case 1:
                                    medicalRecord.setTestName(String.valueOf(Treatment.BLOOD_TEST));
                                    p.setTreatmentDetails(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                                case 2:
                                    medicalRecord.setTestName(String.valueOf(Treatment.LASER_TEST));
                                    p.setTreatmentDetails(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                            }
                        } else if (doctor.getDepartmentInfo().getDepartmentCode().equals(HospitalDepartment.OTOLARYNGOLOGY.getDeptCode())) {
                            logger.info("1." + Treatment.ANTIBIOTICS);
                            logger.info("2." + Treatment.PAIN_KILLERS);
                            int option = in.nextInt();
                            switch (option) {
                                case 1:
                                    medicalRecord.setTestName(String.valueOf(Treatment.ANTIBIOTICS));
                                    p.setTreatmentDetails(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                                case 2:
                                    medicalRecord.setTestName(String.valueOf(Treatment.PAIN_KILLERS));
                                    p.setTreatmentDetails(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                            }
                        } else if (doctor.getDepartmentInfo().getDepartmentCode().equals(HospitalDepartment.ORTHOPEDIC.getDeptCode())) {
                            logger.info("1." + Treatment.X_RAY);
                            logger.info("2." + Treatment.PHYSIOTHERAPY);
                            int option = in.nextInt();
                            switch (option) {
                                case 1:
                                    medicalRecord.setTestName(String.valueOf(Treatment.X_RAY));
                                    p.setTreatmentDetails(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                                case 2:
                                    medicalRecord.setTestName(String.valueOf(Treatment.PHYSIOTHERAPY));
                                    p.setTreatmentDetails(medicalRecord);
                                    patientRecordHashMap.put(patientId, p);
                                    break;
                            }
                        }
                        p.printInformation();
                        medicalRecord.printPatientMedicalRecords();
                    } else if (answer.equalsIgnoreCase("n")) {
                        logger.info("Do not want to prescribe medication,  Enter the details again.");
                    }
                } else {
                    logger.info("Doctor was not assigned to the patient");
                }
            } else {
                logger.info("Already Doctor prescribed Medication");
            }
        } else {
            logger.info("Patient Id Not found");
        }
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
                logger.info("Do you want to assign Doctor ?  Y/N");
                String answer = in.next();
                if (!answer.equals("Y") && (!answer.equals("y") && (!answer.equals("N")) && (!answer.equals("n")))) {
                    throw new ExceptionHospitalAdmin("Inside Exception Enter either y/n");
                } else {
                    if (answer.equalsIgnoreCase("y")) {
                        boolean doctorIdentified = false;
                        Doctor filteredDoc = doctorList.stream()
                                .filter(doctor -> doctor.isTreatable(patientSymptom))
                                .filter(doctor -> !(doctor.getDoctorAssigned())).findAny().get();
                        filteredDoc.setDoctorAssigned(true);
                        logger.info("Dr." + filteredDoc.getPersonalInformation().getFirstName() + " is assigned for the patient");
                        filteredDoc.setDoctorAssigned(true);
                        p.setAssignedDoctor(filteredDoc);
                        p.setPatientAssignedDoctor(true);
                        doctorIdentified = true;
                        if (!doctorIdentified) {
                            logger.info("Doctor is not available");
                        }
                    }
                    if (answer.equalsIgnoreCase("N")) {
                        logger.info("Doctor is not assigned");
                    }
                }
            } else {
                logger.info("Already Doctor Assigned for the Patient");
            }
        } else {
            logger.info("Patient Not Found");
        }
        logger.info("*************************************************");
    }

    private void printDoctorDetails() { //Prints all the Doctor Details
        logger.info("Printing Doctor Details");
        doctorList.stream().forEach(doctor -> doctor.printInformation());
    }

    private void printPatientDetails() {
        logger.info("Printing Patient Details");
        patientRecordHashMap.keySet().stream().sorted().forEach(x -> patientRecordHashMap.get(x).printInformation());
    }

    private void printDepartmentInfo() {
        logger.info("Departments in the Hospital");
        departmentList.stream().forEach(department -> department.printDepartmentDetails());
    }
}