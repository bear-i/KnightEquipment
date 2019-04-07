package com.epam.service;

import com.epam.ammunitionTypes.AmmunitionSpec;
import com.epam.entity.Ammunition;

import java.util.Set;

public interface SortService {
    Set<Ammunition> sortBy(Set<? extends Ammunition> ammunitions, AmmunitionSpec spec);
}
