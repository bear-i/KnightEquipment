package com.epam.factory;

import com.epam.entity.Ammunition;

import java.util.Comparator;

public class CompByPrice implements Comparator<Ammunition> {

    @Override
    public int compare(Ammunition o1, Ammunition o2) {
        return ((o1.getPrice() - o2.getPrice()) > 0) ? 1 : ((o1.getPrice() - o2.getPrice()) == 0) ? 0 : -1;
    }
}
