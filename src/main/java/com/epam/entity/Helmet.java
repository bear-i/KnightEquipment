package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.HelmetForm;

public class Helmet extends Armor {
    private HelmetForm helmetForm;

    public Helmet() {
    }

    public Helmet(String name, double price, HelmetForm helmetForm) {
        super(name, price);
        this.helmetForm = helmetForm;
    }

    public Helmet(int id, double price, int weigth, AmmunitionMaterial material, String name, HelmetForm helmetForm) {
        super(id, price, weigth, material, name);
        this.helmetForm = helmetForm;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public HelmetForm getHelmetForm() {
        return helmetForm;
    }

    public void setHelmetForm(HelmetForm helmetForm) {
        this.helmetForm = helmetForm;
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
        return super.toString() + ", form: " + helmetForm;
    }
}
