package com.epam.DAO;

import com.epam.entity.Ammunition;

import java.util.Set;

public interface AmmunitionDAO {
    Set<? extends Ammunition> getAll();

    Set<? extends Ammunition> getByPrice();
}
