package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;

public class Ammunition {
    private int id;
    private double price;
    private int weigth;
    private AmmunitionMaterial material;
    private String name;

    public Ammunition() {
    }

    public Ammunition(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public Ammunition(int id, double price, int weigth, AmmunitionMaterial material, String name) {
        this.id = id;
        this.price = price;
        this.weigth = weigth;
        this.material = material;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public AmmunitionMaterial getMaterial() {
        return material;
    }

    public void setMaterial(AmmunitionMaterial material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ammunition that = (Ammunition) o;

        if (Double.compare(that.getPrice(), getPrice()) != 0) return false;
        if (getWeigth() != that.getWeigth()) return false;
        return getMaterial() == that.getMaterial();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getPrice());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getWeigth();
        return result;
    }

    @Override
    public String toString() {
        return "\nid:" + id + ", name: " + name + ", price: " + price +
                ", weigth: " + weigth + ", material: " + material;
    }
}
