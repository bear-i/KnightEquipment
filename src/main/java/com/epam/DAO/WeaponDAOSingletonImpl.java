package com.epam.DAO;

import com.epam.entity.Weapon;
import com.epam.service.InputServiceImpl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeaponDAOSingletonImpl implements AmmunitionDAO {
    private static WeaponDAOSingletonImpl INSTANCE = null;

    private WeaponDAOSingletonImpl() {

    }

    public Set<Weapon> getAll() {
        Set<Weapon> weapon = new HashSet();
        weapon.addAll(SpearDAOSingletonImpl.getInstance().getAll());
        weapon.addAll(SwordDAOSingletonImpl.getInstance().getAll());
        weapon.addAll(BowDAOSingletonImpl.getInstance().getAll());
        weapon.addAll(ShieldDAOSingletonImpl.getInstance().getAll());
        return weapon;
    }

    public Set<Weapon> getByPrice() {
        Map<String, Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Weapon> getByPassedPrice(Map<String, Double> priceRange) {
        Set<Weapon> priceRangeWeapon = new HashSet<>();
        priceRangeWeapon.addAll(SpearDAOSingletonImpl.getInstance().getByPassedPrice(priceRange));
        priceRangeWeapon.addAll(SwordDAOSingletonImpl.getInstance().getByPassedPrice(priceRange));
        priceRangeWeapon.addAll(BowDAOSingletonImpl.getInstance().getByPassedPrice(priceRange));
        priceRangeWeapon.addAll(ShieldDAOSingletonImpl.getInstance().getByPassedPrice(priceRange));
        return priceRangeWeapon;
    }

    public static WeaponDAOSingletonImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ArmorPlatingDAOSingletonImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WeaponDAOSingletonImpl();
                }
            }
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
