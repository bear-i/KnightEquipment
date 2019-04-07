package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;

public class Weapon extends Ammunition {
    private double purchaseTax;


    public Weapon() {
    }

    public Weapon(String name, double price, double purchaseTax) {
        super(name, price);
        this.purchaseTax = purchaseTax;
    }

    public Weapon(int id, double price, int weigth, AmmunitionMaterial material, String name, double purchaseTax) {
        super(id, price, weigth, material, name);
        this.purchaseTax = purchaseTax;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public double getPurchaseTax() {
        return purchaseTax;
    }

    public void setPurchaseTax(double purchaseTax) {
        this.purchaseTax = purchaseTax;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public int getWeigth() {
        return super.getWeigth();
    }

    @Override
    public void setWeigth(int weigth) {
        super.setWeigth(weigth);
    }

    @Override
    public AmmunitionMaterial getMaterial() {
        return super.getMaterial();
    }

    @Override
    public void setMaterial(AmmunitionMaterial material) {
        super.setMaterial(material);
    }

    @Override
    public String toString() {
        return super.toString() + ", tax: " + purchaseTax;
    }
}
