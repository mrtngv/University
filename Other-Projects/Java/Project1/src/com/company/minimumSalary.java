package com.company;

public enum minimumSalary {
    MINIMUM_SALARY(1000.0),MINIMUM_PERCENT(0.0);
    private double minimum;

    private minimumSalary(double minimum){
        this.minimum = minimum;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }
}
