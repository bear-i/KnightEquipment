package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;

public class Armor extends Ammunition {

    public Armor() {
    }

    public Armor(String name, double price) {
        super(name, price);
    }

    public Armor(int id, double price, int weigth, AmmunitionMaterial material, String name) {
        super(id, price, weigth, material, name);
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
        return super.toString();
    }
}
