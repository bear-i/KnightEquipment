package com.epam.factory;

import com.epam.entity.Ammunition;

import java.util.Comparator;

public class CompByWeigth implements Comparator<Ammunition> {

    @Override
    public int compare(Ammunition o1, Ammunition o2) {
        return ((o1.getWeigth()-o2.getWeigth())>0) ? 1 : ((o1.getWeigth()-o2.getWeigth())==0) ? 0 : -1;
    }
}
