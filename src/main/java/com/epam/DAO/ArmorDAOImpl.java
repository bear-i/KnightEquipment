package com.epam.DAO;

import com.epam.entity.Armor;
import com.epam.service.InputServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArmorDAOImpl implements AmmunitionDAO {

    public Set<Armor> getAll() {
        Set<Armor> armor = new HashSet<>();
        armor.addAll(new ArmorPlatingDAOImpl().getAll());
        armor.addAll(new ChainArmorDAOImpl().getAll());
        armor.addAll(new HelmetDAOImpl().getAll());
        return armor;
    }

    public Set<Armor> getByPrice() {
        ArrayList<Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Armor> getByPassedPrice(ArrayList<Double> priceRange) {
        Set<Armor> priceRangeArmor = new HashSet<>();
        priceRangeArmor.addAll(new ArmorPlatingDAOImpl().getByPassedPrice(priceRange));
        priceRangeArmor.addAll(new ChainArmorDAOImpl().getByPassedPrice(priceRange));
        priceRangeArmor.addAll(new HelmetDAOImpl().getByPassedPrice(priceRange));
        return priceRangeArmor;
    }
}
