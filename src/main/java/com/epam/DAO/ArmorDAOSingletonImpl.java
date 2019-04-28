package com.epam.DAO;

import com.epam.entity.Armor;
import com.epam.service.InputServiceImpl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArmorDAOSingletonImpl implements AmmunitionDAO {
    private static ArmorDAOSingletonImpl INSTANCE = null;

    private ArmorDAOSingletonImpl() {

    }

    public Set<Armor> getAll() {
        Set<Armor> armor = new HashSet<>();
        armor.addAll(ArmorPlatingDAOSingletonImpl.getInstance().getAll());
        armor.addAll(ChainArmorDAOSingletonImpl.getInstance().getAll());
        armor.addAll(HelmetDAOSingletonImpl.getInstance().getAll());
        return armor;
    }

    public Set<Armor> getByPrice() {
        Map<String, Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Armor> getByPassedPrice(Map<String, Double> priceRange) {
        Set<Armor> priceRangeArmor = new HashSet<>();
        priceRangeArmor.addAll(ArmorPlatingDAOSingletonImpl.getInstance().getByPassedPrice(priceRange));
        priceRangeArmor.addAll(ChainArmorDAOSingletonImpl.getInstance().getByPassedPrice(priceRange));
        priceRangeArmor.addAll(HelmetDAOSingletonImpl.getInstance().getByPassedPrice(priceRange));
        return priceRangeArmor;
    }

    public static ArmorDAOSingletonImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ArmorPlatingDAOSingletonImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ArmorDAOSingletonImpl();
                }
            }
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
