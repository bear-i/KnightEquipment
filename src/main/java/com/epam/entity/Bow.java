package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.BowForm;

public class Bow extends Weapon {
    private BowForm bowForm;

    public Bow() {
    }

    public Bow(String name, double price, double purchaseTax, BowForm bowForm) {
        super(name, price, purchaseTax);
        this.bowForm = bowForm;
    }

    public Bow(int id, double price, int weigth, AmmunitionMaterial material, String name, double purchaseTax, BowForm bowForm) {
        super(id, price, weigth, material, name, purchaseTax);
        this.bowForm = bowForm;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public BowForm getBowForm() {
        return bowForm;
    }

    public void setBowForm(BowForm bowForm) {
        this.bowForm = bowForm;
    }

    @Override
    public double getPurchaseTax() {
        return super.getPurchaseTax();
    }

    @Override
    public void setPurchaseTax(double purchaseTax) {
        super.setPurchaseTax(purchaseTax);
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
        return super.toString() +  ", form: " + bowForm;
    }
}
