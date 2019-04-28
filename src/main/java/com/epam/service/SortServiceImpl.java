package com.epam.service;

import com.epam.ammunitionTypes.AmmunitionSpec;
import com.epam.entity.Ammunition;
import com.epam.factory.ComparatorFactory;

import java.util.Set;
import java.util.TreeSet;

public class SortServiceImpl implements SortService {
    @Override
    public Set<Ammunition> sortBy(Set<? extends Ammunition> ammunitions, AmmunitionSpec spec) {
        Set<Ammunition> sortedAmmunition = new TreeSet<>(ComparatorFactory.getComparator(spec));
        sortedAmmunition.addAll(ammunitions);
        return sortedAmmunition;
    }
}
