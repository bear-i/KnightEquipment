package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.SwordLength;

public class Sword extends Weapon {
    private SwordLength swordLength;

    public Sword() {
    }

    public Sword(String name, double price, double purchaseTax, SwordLength swordLength) {
        super(name, price, purchaseTax);
        this.swordLength = swordLength;
    }

    public Sword(int id, double price, int weigth, AmmunitionMaterial material, String name, double purchaseTax, SwordLength swordLength) {
        super(id, price, weigth, material, name, purchaseTax);
        this.swordLength = swordLength;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
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

    public SwordLength getSwordLength() {
        return swordLength;
    }

    public void setSwordLength(SwordLength swordLength) {
        this.swordLength = swordLength;
    }

    @Override
    public String toString() {
        return super.toString() + ", length: " + swordLength;
    }
}
