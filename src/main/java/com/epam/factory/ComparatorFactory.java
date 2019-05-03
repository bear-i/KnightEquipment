package com.epam.factory;

import com.epam.ammunitionTypes.AmmunitionSpec;
import com.epam.entity.Ammunition;
import java.util.Comparator;

public class ComparatorFactory {
    public static Comparator<Ammunition> getComparator(AmmunitionSpec spec) {
        switch(spec){
            case id:
                return new CompById();
            case price:
                return new CompByPrice();
            case weigth:
                return new CompByWeigth();
            default: return new CompById();
        }
    }
}
