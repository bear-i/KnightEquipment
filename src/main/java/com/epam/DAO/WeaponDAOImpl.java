package com.epam.DAO;

import com.epam.entity.Weapon;
import com.epam.service.InputServiceImpl;
import java.util.HashSet;
import java.util.Set;

public class WeaponDAOImpl implements AmmunitionDAO {
    public Set<Weapon> getAll() {
        Set<Weapon>  weapon = new HashSet();
        weapon.addAll(new SpearDAOImpl().getAll());
        weapon.addAll(new SwordDAOImpl().getAll());
        weapon.addAll(new BowDAOImpl().getAll());
        weapon.addAll(new ShieldDAOImpl().getAll());
        return weapon;
    }

    public  Set<Weapon> getByPrice() {
        double[] priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public  Set<Weapon> getByPassedPrice(double [] priceRange){
        Set<Weapon> priceRangeWeapon = new HashSet<>();
        priceRangeWeapon.addAll(new BowDAOImpl().getByPassedPrice(priceRange));
        priceRangeWeapon.addAll(new SwordDAOImpl().getByPassedPrice(priceRange));
        priceRangeWeapon.addAll(new BowDAOImpl().getByPassedPrice(priceRange));
        priceRangeWeapon.addAll(new ShieldDAOImpl().getByPassedPrice(priceRange));
        return priceRangeWeapon;
    }
}
