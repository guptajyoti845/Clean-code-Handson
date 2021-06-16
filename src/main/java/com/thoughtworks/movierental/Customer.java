package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;


// TODO 1. convert Switch to Runtime Polymorphism (similar to strategy pattern)
// TODO 2. Fix of Law of demeter  (eg: line 35)
// TODO 3. Breaking Tell Don't Ask and breaking encapsulation (eg : line 39)

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            double thisAmount = 0;
            thisAmount += each.amount();
            frequentRenterPoints++;

            if (each.isMovieRelease() && each.isDaysRentedGreaterThanOne()) {
              frequentRenterPoints++;
            }

            result += each.findResult(thisAmount);
            totalAmount += thisAmount;
        }

        //add footer lines result
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }


}

