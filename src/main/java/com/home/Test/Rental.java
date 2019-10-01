package com.home.Test;

class Rental {

    public Rental() {
    }

    public double getBasePrice() {
        // Calculation of Price.
        // . . .
        return 2.2d;
    }

    public double amountFor(int kind, int days) {
        double result;
        result = days * getBasePrice();
        switch (kind) {
            case 1:
                result = result * 1.5;
                break;
            case 2:
                result = result * 2;
                break;
            case 3:
                result = result * 2.5;
                break;
            default:
                break;
        }
        if (days > 7) {
            result = result * 3;
        }
        return result;
    }
    // Other methods.
}