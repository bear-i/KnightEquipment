package com.epam.service;

import java.util.Scanner;

public class InputServiceImpl implements InputService {
    private static final String WRONG_NUMBER_FORMAT = "Wrong number format, try again:";
    private Scanner scanner = new Scanner(System.in);

    public double[] getPriceRange() {
        double[] priceRange = new double[2];
        try {
            System.out.println("Enter minimal price: ");
            priceRange[0] = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter maximal price: ");
            priceRange[1] = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(WRONG_NUMBER_FORMAT);
            return getPriceRange();
        }
        return priceRange;
    }

    public double getBalance() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(WRONG_NUMBER_FORMAT);
            return getBalance();
        }
    }

    public int getOption() {
        System.out.println("Enter number of option:");
        return readIntegerLineFromConsole();
    }

    public int getId() {
        System.out.println("Enter the id of unit: ");
        return readIntegerLineFromConsole();
    }

    private int readIntegerLineFromConsole() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(WRONG_NUMBER_FORMAT);
            return readIntegerLineFromConsole();
        }
    }
}
