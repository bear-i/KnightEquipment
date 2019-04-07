package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.RingsSize;

public class ChainArmor extends Armor {
    private RingsSize ringsSize;

    public ChainArmor() {
    }

    public ChainArmor(String name, double price, RingsSize ringsSize) {
        super(name, price);
        this.ringsSize = ringsSize;
    }

    public ChainArmor(int id, double price, int weigth, AmmunitionMaterial material, String name, RingsSize ringsSize) {
        super(id, price, weigth, material, name);
        this.ringsSize = ringsSize;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public RingsSize getRingsSize() {
        return ringsSize;
    }

    public void setRingsSize(RingsSize ringsSize) {
        this.ringsSize = ringsSize;
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
        return super.toString() + ", rings size: " + ringsSize;
    }
}
