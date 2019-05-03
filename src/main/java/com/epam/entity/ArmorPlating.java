package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.ArmorPlatingKind;

public class ArmorPlating extends Armor {
    private ArmorPlatingKind kind;

    public ArmorPlating() {
    }

    public ArmorPlating(String name, double price, ArmorPlatingKind kind) {
        super(name, price);
        this.kind = kind;
    }

    public ArmorPlating(int id, double price, int weigth, AmmunitionMaterial material, String name, ArmorPlatingKind kind) {
        super(id, price, weigth, material, name);
        this.kind = kind;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public ArmorPlatingKind getKind() {
        return kind;
    }

    public void setKind(ArmorPlatingKind kind) {
        this.kind = kind;
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
        return super.toString() + ", kind: " + kind;
    }
}
