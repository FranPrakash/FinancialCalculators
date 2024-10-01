package com.pluralsight;

import java.util.Scanner;

public class financialCalculator {


    public static void main(String[] args) {

        // Create a scanner object to receive user input.
        Scanner myScanner = new Scanner(System.in);

        System.out.println( " Welcome to Mortgage Calculator!");

        System.out.println(" Please enter the principal amount: ");
        float principal = myScanner.nextFloat();
        System.out.println( "Please enter the interest rate :");
        float interestRate = myScanner.nextFloat();
        System.out.println("Please enter the loan length in years : ");
        int loanLength = myScanner.nextInt();

        // Calculations formula

        double annualInterestRate = interestRate / 100; // example: converting 7.625% to 0.07625 (percentage to decimal)
        double monthlyInterestRate = annualInterestRate / 12;  // example: convert 0.07625 to monthly rate

        int numberOfPayments = loanLength * 12; //

        // Formula M  = P monthlyInterestRate (1 + monthlyInterestRate)^n / (1 + monthlyInterestRate)^n - 1
        double monthlyPayment = principal * (monthlyInterestRate * Math.pow((1+monthlyInterestRate), numberOfPayments))
                /(Math.pow((1+monthlyInterestRate), numberOfPayments)-1);

        // total amount paid = number of payments * monthly payment
        // total amount paid = principal + total interest paid
        // total interest paid = total amount paid - principal
        // total interest paid = number of payments * monthly payments - principal
        double totalInterestPaid = numberOfPayments * monthlyPayment - principal;

        System.out.println("Your expected monthly payment is: $"+monthlyPayment);
        System.out.println("Total interest paid is: $"+totalInterestPaid);

        myScanner.close(); // close the scanner
    }
}
