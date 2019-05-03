package com.epam.DAO;

import com.epam.entity.Ammunition;
import com.epam.service.InputServiceImpl;

import java.util.*;

public class AmmunitionDAOSingletonImpl implements AmmunitionDAO {
    private static AmmunitionDAOSingletonImpl INSTANCE = null;

    private AmmunitionDAOSingletonImpl() {

    }

    public Set<Ammunition> getAll() {
        Set<Ammunition> ammun = new HashSet<Ammunition>();
        ammun.addAll(WeaponDAOSingletonImpl.getInstance().getAll());
        ammun.addAll(ArmorDAOSingletonImpl.getInstance().getAll());
        return ammun;
    }

    public Set<Ammunition> getByPrice() {
        Map<String, Double> priceRange = new InputServiceImpl().getPriceRange();
        Set<Ammunition> ammun = new HashSet<>();
        ammun.addAll(WeaponDAOSingletonImpl.getInstance().getByPassedPrice(priceRange));
        ammun.addAll(ArmorDAOSingletonImpl.getInstance().getByPassedPrice(priceRange));
        return ammun;
    }

    public static AmmunitionDAOSingletonImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ArmorPlatingDAOSingletonImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AmmunitionDAOSingletonImpl();
                }
            }
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
