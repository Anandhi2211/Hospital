package com.solvd.hospital.symptoms;

import com.solvd.hospital.department.HospitalDepartment;

public enum ListOfSymptoms {
    SKIN_INFECTION(HospitalDepartment.DERMATOLOGY),
    PIGMENTATION_REMOVAL(HospitalDepartment.DERMATOLOGY),
    SKIN_RASHES(HospitalDepartment.DERMATOLOGY),
    TAN_REMOVAL(HospitalDepartment.DERMATOLOGY),

    NECK_PAIN(HospitalDepartment.ORTHOPEDIC),
    BACK_PAIN(HospitalDepartment.ORTHOPEDIC),
    KNEE_PAIN(HospitalDepartment.ORTHOPEDIC),
    WRIST_PAIN(HospitalDepartment.ORTHOPEDIC),

    EAR_FLUID(HospitalDepartment.OTOLARYNGOLOGY),
    EAR_PAIN(HospitalDepartment.OTOLARYNGOLOGY),
    EAR_INFECTION(HospitalDepartment.OTOLARYNGOLOGY);
    ListOfSymptoms(HospitalDepartment dermatology) {
    }
}
