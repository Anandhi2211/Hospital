package com.solvd.hospital.financialbenefits;

public class FinancialBenefits {
    private int benefitPercent;
    private boolean benefitStatus;
    public int getBenefitPercent() {
        return benefitPercent;
    }
    public void setBenefitPercent(int benefitPercent) {
        this.benefitPercent = benefitPercent;
    }
    public boolean isBenefitStatus() {
        return benefitStatus;
    }
    public void setBenefitStatus(boolean benefitStatus) {
        this.benefitStatus = benefitStatus;
    }
}
