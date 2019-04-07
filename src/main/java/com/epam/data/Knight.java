package com.epam.data;

import com.epam.entity.Ammunition;

import java.util.ArrayList;
import java.util.List;

public class Knight {
    private double balance;
    private List<Ammunition> boughtAmmunition = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Ammunition> getBoughtAmmunition() {
        return boughtAmmunition;
    }

    @Override
    public String toString() {
        return "Balance: " + balance +
                ", bought ammunition: " + boughtAmmunition;
    }
}
