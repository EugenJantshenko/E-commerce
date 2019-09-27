package com.home.Test;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double showRent(){
        Rental rental=new Rental();
        return rental.amountFor(2,13);
    }

// Other methods.
}
