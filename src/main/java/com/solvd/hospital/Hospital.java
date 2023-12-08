package com.solvd.hospital;

import com.solvd.hospital.billing.CoPay;
import com.solvd.hospital.billing.IBilling;
import com.solvd.hospital.department.HospitalDepartment;
import com.solvd.hospital.insurance.HospitalInsurance;
import com.solvd.hospital.medicalrecords.Treatment;
import com.solvd.hospital.patient.PatientIdGenerator;
import com.solvd.hospital.symptoms.ListOfSymptoms;
import com.solvd.hospital.symptoms.Symptoms;
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
                            hospital.printDoctorDetails();
                            hospital.printDepartmentInfo();
                            break;
                        case 2:
                            hospital.assignDoctorToPatient(in);
                            break;
                        case 3:
                            hospital.doctorPrescribingPatient(in);
                            break;
                        case 4:
                            hospital.generateBillForEachPatient(in);
                            break;
                        case 5:
                            hospital.paymentCalculationForEachPatient(in);
                            break;
                        case 6:
                            newPatientList = data.addNewPatientList(newPatientList);
                            hospital.newPatientList(newPatientList, in);
                            break;
                        case 7:
                            hospital.viewPatientRecord(in);
                            break;
                        case 8:
                            hospital.changeDoctorAssignedStatus(in);
                            hospital.financialAssistanceCheck(patientRecordHashMap);
                            break;
                        case 9:
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
    private void financialAssistanceCheck(HashMap<String, PatientRecord> patientRecordHashMap) {
        logger.info("Prints every Patient and their Financial Benefits Percentage : ");
        Billing billing = new Billing();
//        for (String patientId : patientRecordHashMap.keySet())
//        {
        patientRecordHashMap.keySet()
                .stream().map(x -> patientRecordHashMap.get(x))
                .forEach(y -> billing.checkFinancialBenefits(y).printFinancialBenefits());
//            PatientRecord patientRecord = billing.checkFinancialBenefits(patientRecordHashMap.get(patientId));
//            logger.info("Patient Name: " + patientRecord.getPatient().getPersonalInformation().getFirstName());
//            logger.info("Patient Id: " + patientRecord.getPatient().getPatientId());
//            logger.info("Benefits Eligible: " + patientRecord.getFinancialBenefits().getBenefitPercent()+"%");
//        }
    }
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
//        for(Doctor doc : doctorList)
//        {
//            if(doc.getDoctorId().equalsIgnoreCase(answer))
//            {
//                logger.info("Before Reflection Doctor Assigned Status "+ doc.getDoctorAssigned());
//                for(Field field : doctorFields)
//                {
//                    if(field.getName().equalsIgnoreCase("doctorAssigned"))
//                    {
//                        field.setAccessible(true);
//                        field.set(doc,true);
//                        logger.info("After Reflection Doctor Assigned Status "+ doc.getDoctorAssigned());
//                    }
//                }
//            }
//        }
    }
    private void paymentCalculationForEachPatient(Scanner in) {
        logger.info("Using Lambda expression Calculating Total amount to be paid by the Patient:");
        HospitalWelcomePage admin = new HospitalWelcomePage();
        String patientId = admin.getPatientId(in);
        PatientRecord patientRecord = patientRecordHashMap.get(patientId);
        if (patientRecord.getAssignedDoctorList() != null) {
            if (patientRecord.getBilling() != null) {
//                    for (HospitalInsurance hospitalInsurance : HospitalInsurance.values()) {
//                        if (patientRecord.getPatient().getInsurance().getInsuranceName().equalsIgnoreCase(hospitalInsurance.name())) {
                HospitalInsurance hp = Arrays.stream(HospitalInsurance.values())
                        .filter(hospitalInsurance1 -> hospitalInsurance1.name()
                                .equalsIgnoreCase(patientRecord.getPatient().getInsurance().getInsuranceName())).findAny().get();
                IBilling iBilling = () -> {
                    PatientRecord p;
                    Billing billing = patientRecord.getBilling();
                    logger.info("Total Billing Amount: " + billing.getBillingAmount());
                    p = billing.checkFinancialBenefits(patientRecord);
                    int financialBenefitsAmt = billing.getBillingAmount() * (p.getFinancialBenefits().getBenefitPercent()) / 100;
                    int insuranceBenefitsAmt = billing.getBillingAmount() * (hp.getPercentageConcession()) / 100;
                    logger.info("Deductible amount as per the insurance: " + insuranceBenefitsAmt);
                    logger.info("Deductible amount as per the Financial benefits: " + financialBenefitsAmt);
                    logger.info("Patient final amount to pay: " + (billing.getBillingAmount() - insuranceBenefitsAmt - financialBenefitsAmt));
                    billing.setBillingAmount((billing.getBillingAmount() - insuranceBenefitsAmt - financialBenefitsAmt));
                    p.setBilling(billing);
                    patientRecordHashMap.put(patientId, p);
                };
                iBilling.billCalculation();
//                        }
//                    }
            } else {
                logger.info("Bill already generated");
            }
        } else {
            logger.info("Doctor not yet assigned");
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
//                for(ListOfSymptoms listOfSymptoms : ListOfSymptoms.values())
//                {
//                    logger.info(listOfSymptoms.name() +"---"+ listOfSymptoms.getValue());
//                }
                int value = in.nextInt();
                ListOfSymptoms listOfSymptoms = Arrays.stream(ListOfSymptoms.values())
                        .filter(l -> l.getValue() == value).findAny().get();
//                for(ListOfSymptoms listOfSymptoms : ListOfSymptoms.values()) {
//                    if (value == listOfSymptoms.getValue()) {
                Symptoms symptoms = new Symptoms();
                PatientIdGenerator patientIdGenerator = new PatientIdGenerator();
                logger.info(listOfSymptoms.name() + " is assigned to the Patient " + patient.getPersonalInformation().getFirstName());
                symptoms.setPatientSymptom(listOfSymptoms.name());
                patient.setSymptoms(symptoms);
                patient.setPatientId(patientIdGenerator.getPatientIdGenerator());
//                    }
//                }
                PatientRecord patientRecord = new PatientRecord();
                patientRecord.setPatient(patient);
                patientRecordList.add(patientRecord);
                patientRecordHashMap.put(patient.getPatientId(), patientRecord);
            } else if (answer.equalsIgnoreCase("N")) {
                logger.info("Look into next Patient");
            } else {
                logger.info("Enter either Y/N");
            }
        }
    }
    private void printAllPatientRecords() {
        logger.info(patientRecordHashMap);
    }
    private void doctorPrescribingPatient(Scanner in) throws ExceptionHospitalAdmin { //Doctor Prescribes Test for the patient
        HospitalWelcomePage admin = new HospitalWelcomePage();
        String patientId = admin.getPatientId(in);
        PatientRecord p = patientRecordHashMap.get(patientId);
        if (patientRecordHashMap.containsKey(patientId)) {
            if (p.getMedicalRecord() != null) {
                if (p.getPatientAssignedDoctor()) {
                    p.printInformation();
                    logger.info("Enter the Prescriptions : y/n");
                    String answer = in.next();
                    if (answer.equalsIgnoreCase("y")) {
                        MedicalRecord medicalRecord = new MedicalRecord();
                        medicalRecord.setPrescriptionStatus(true);
                        p.setMedicalRecord(medicalRecord);
                        patientRecordHashMap.put(patientId, p);
                        for (int doctorIndex = 0; doctorIndex < p.getAssignedDoctorList().size(); doctorIndex++) {
                            Doctor doctor = p.getAssignedDoctorList().get(doctorIndex);
                            if (doctor.getDepartmentInfo().getDepartmentCode().equals(HospitalDepartment.DERMATOLOGY.getDeptCode())) {
                                logger.info("1." + Treatment.BLOOD_TEST);
                                logger.info("2." + Treatment.LASER_TEST);
                                int option = in.nextInt();
                                switch (option) {
                                    case 1:
                                        medicalRecord.setTestName(String.valueOf(Treatment.BLOOD_TEST));
                                        p.setMedicalRecord(medicalRecord);
                                        patientRecordHashMap.put(patientId, p);
                                        break;
                                    case 2:
                                        medicalRecord.setTestName(String.valueOf(Treatment.LASER_TEST));
                                        p.setMedicalRecord(medicalRecord);
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
                                        p.setMedicalRecord(medicalRecord);
                                        patientRecordHashMap.put(patientId, p);
                                        break;
                                    case 2:
                                        medicalRecord.setTestName(String.valueOf(Treatment.PAIN_KILLERS));
                                        p.setMedicalRecord(medicalRecord);
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
                                        p.setMedicalRecord(medicalRecord);
                                        patientRecordHashMap.put(patientId, p);
                                        break;
                                    case 2:
                                        medicalRecord.setTestName(String.valueOf(Treatment.PHYSIOTHERAPY));
                                        p.setMedicalRecord(medicalRecord);
                                        patientRecordHashMap.put(patientId, p);
                                        break;
                                }
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
    private void generateBillForEachPatient(Scanner in) throws ExceptionHospitalAdmin { // Generate bill once only after assigning doctor to a patient
        HospitalWelcomePage admin = new HospitalWelcomePage();
        String patientId = admin.getPatientId(in);
        if (patientRecordHashMap.containsKey(patientId)) {
            PatientRecord p = patientRecordHashMap.get(patientId);
            if (p.getBilling() == null) {
                if (p.getPatientAssignedDoctor()) {
                    Billing billing = new Billing();
                    for (Doctor assignedDoctor : p.getAssignedDoctorList()) {
                        for (CoPay coPay : CoPay.values()) {
                            if (assignedDoctor.getDepartmentInfo().getDepartmentCode().equalsIgnoreCase(String.valueOf(coPay.getDepCode()))) {
                                billing.setBillingNumber(UUID.randomUUID().toString());
                                billing.setBillingStatus(true);
                                billing.setBillingAmount(coPay.getCoPayAmt());
                                logger.info("Bill Number Generated for the Patient : " + billing.getBillingNumber());
                                logger.info("Co-pay amount for visit: $" + billing.getBillingAmount());
                                if (p.getMedicalRecord() != null) {
//                                    for (MedicalRecord m : p.getMedicalRecords()) {
                                    Treatment t = Arrays.stream(Treatment.values())
                                            .filter(treatment -> treatment.name()
                                                    .equalsIgnoreCase(p.getMedicalRecord().getTestName())).findAny().get();
//                                    for (Treatment treatment : Treatment.values()) {
//                                        if (treatment.name().equalsIgnoreCase(p.getMedicalRecord().getTestName())) {
                                    logger.info("Treatment: " + t.name());
                                    logger.info("Treatment Price amount: " + t.getPriceAmt());
                                    billing.setBillingAmount(t.getPriceAmt());
                                    logger.info("Total Bill Amount " + billing.getBillingAmount());
//                                        }
//                                    }
//                                }
                                    billing.setBillingStatus(true);
                                    p.setBilling(billing);
                                    patientRecordHashMap.put(patientId, p);
                                    billNumbers.put(billing.getBillingNumber(), billing);
                                } else {
                                    logger.info("NO Other Bills for Treatment");
                                }
                            }
                        }
                    }
                } else {
                    logger.info("Patient did not visit the hospital yet/ Doc has not been assigned");
                }
            } else {
                logger.info("Already bill Generated");
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
//                        logger.info("Status before :" + filteredDoc.getDoctorAssigned());
                        filteredDoc.setDoctorAssigned(true);
                        logger.info("Dr." + filteredDoc.getPersonalInformation().getFirstName() + " is assigned for the patient");
                        filteredDoc.setDoctorAssigned(true);
                        p.setAssignedDoctor(filteredDoc);
                        p.setPatientAssignedDoctor(true);
//                        logger.info("Status after :" + filteredDoc.getDoctorAssigned());
                        doctorIdentified = true;
//                        for (Doctor doctor : doctorList) {
//                            if (doctor.isTreatable(patientSymptom) && !(doctor.getDoctorAssigned())) {
//                                doctor.setDoctorAssigned(true);
//                                p.setAssignedDoctor(doctor);
//                                p.setPatientAssignedDoctor(true);
//                                patientRecordHashMap.put(patientId, p);
//                                doctorIdentified = true;
//                                logger.info("Dr." + doctor.getPersonalInformation().getFirstName() + " is assigned for this Patient ");
//                                break;
//                            }
//                        }
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
        doctorList.stream()
                .forEach(doctor -> doctor.printInformation());
//        for (Doctor doc : doctorList)
//        {
//            doc.printInformation(); // displays only Doctor Details name abstract method overloading
//        }
    }
    private void printPatientDetails() {
        logger.info("Printing Patient Details");
        patientRecordHashMap.keySet().stream()
                .forEach(x -> patientRecordHashMap.get(x).printInformation());
//        for (String patientId : patientRecordHashMap.keySet())
//        {
//            patientRecordHashMap.get(patientId).printInformation();
//        }
    }
    private void printDepartmentInfo() {
        logger.info("Departments in the Hospital");
        departmentList.stream().forEach(department -> department.printDepartmentDetails());
    }
}