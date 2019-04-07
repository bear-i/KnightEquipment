package com.epam.DAO;

import com.epam.entity.Ammunition;
import com.epam.service.InputServiceImpl;

import java.util.*;

public class AmmunitionDAOImpl implements AmmunitionDAO {

    public Set<Ammunition> getAll() {
        Set<Ammunition> ammun = new HashSet<Ammunition>();
        ammun.addAll(new WeaponDAOImpl().getAll());
        ammun.addAll(new ArmorDAOImpl().getAll());
        return ammun;
    }

    public Set<Ammunition> getByPrice() {
        double[] priceRange = new InputServiceImpl().getPriceRange();
        Set<Ammunition> ammun = new HashSet<>();
        ammun.addAll(new WeaponDAOImpl().getByPassedPrice(priceRange));
        ammun.addAll(new ArmorDAOImpl().getByPassedPrice(priceRange));
        return ammun;
    }
}
