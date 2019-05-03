package com.epam.service;

import com.epam.DAO.AmmunitionDAO;
import com.epam.entity.Ammunition;

import java.util.Set;

public interface AppService {
    void setKnightBalance();

    void chooseOptionFromStartingMenu();

    void chooseUnitOption(AmmunitionDAO accessObj);

    void sortBy(AmmunitionDAO accessObj);

    void showWithinPriceRange(AmmunitionDAO accessObj);

    void buyUnit(Set<? extends Ammunition> ammunitionSet);

    void showBoughtAmmunition();
}
