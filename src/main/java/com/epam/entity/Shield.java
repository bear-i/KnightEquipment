package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.ShieldForm;

public class Shield extends Weapon {
    private ShieldForm shieldForm;

    public Shield() {
    }

    public Shield(String name, double price, double purchaseTax, ShieldForm shieldForm) {
        super(name, price, purchaseTax);
        this.shieldForm = shieldForm;
    }

    public Shield(int id, double price, int weigth, AmmunitionMaterial material, String name, double purchaseTax, ShieldForm shieldForm) {
        super(id, price, weigth, material, name, purchaseTax);
        this.shieldForm = shieldForm;
    }

    public Shield(String name, double price, double purchaseTax) {
        super(name, price, purchaseTax);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public ShieldForm getShieldForm() {
        return shieldForm;
    }

    public void setShieldForm(ShieldForm shieldForm) {
        this.shieldForm = shieldForm;
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
        return super.toString() + ", form: " + shieldForm;
    }
}
