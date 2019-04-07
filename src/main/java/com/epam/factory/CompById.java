package com.epam.factory;

import com.epam.entity.Ammunition;

import java.util.Comparator;

public class CompById implements Comparator<Ammunition> {

    @Override
    public int compare(Ammunition o1, Ammunition o2) {
        return ((o1.getId() - o2.getId()) > 0) ? 1 : ((o1.getId() - o2.getId()) == 0) ? 0 : -1;
    }
}
