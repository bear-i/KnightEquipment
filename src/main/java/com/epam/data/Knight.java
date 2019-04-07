package com.epam.data;

import com.epam.entity.Ammunition;

import java.util.ArrayList;
import java.util.List;

public class Knight {
    private double balance;
    private List<Ammunition> boughtAmmunition = new ArrayList<>();

    public Knight(){

    }

    Knight(double balance){
        this.balance = balance;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Knight knight = (Knight) o;

        if (Double.compare(knight.getBalance(), getBalance()) != 0) return false;
        return getBoughtAmmunition().equals(knight.getBoughtAmmunition());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getBalance());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getBoughtAmmunition().hashCode();
        return result;
    }
}
