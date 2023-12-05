package com.solvd.hospital.symptoms;

public enum ListOfSymptoms {
    SKIN_INFECTION(1),
    PIGMENTATION_REMOVAL(2),
    SKIN_RASHES(3),
    TAN_REMOVAL(4),

    NECK_PAIN(5),
    BACK_PAIN(6),
    KNEE_PAIN(7),

    EAR_FLUID(8),
    EAR_PAIN(9),
    EAR_INFECTION(10);

    public int getValue() {
        return value;
    }
    final int value;
    ListOfSymptoms(int value) {
        this.value = value;
    }
}
