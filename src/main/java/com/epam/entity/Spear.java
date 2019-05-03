package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.SpearType;

public class Spear extends Weapon {
    private SpearType spearType;

    public Spear() {
    }

    public Spear(String name, double price, double purchaseTax, SpearType spearType) {
        super(name, price, purchaseTax);
        this.spearType = spearType;
    }

    public Spear(int id, double price, int weigth, AmmunitionMaterial material, String name, double purchaseTax, SpearType spearType) {
        super(id, price, weigth, material, name, purchaseTax);
        this.spearType = spearType;
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

    public SpearType getSpearType() {
        return spearType;
    }

    public void setSpearType(SpearType spearType) {
        this.spearType = spearType;
    }

    @Override
    public String toString() {
        return super.toString() + ", type: " + spearType;
    }
}
