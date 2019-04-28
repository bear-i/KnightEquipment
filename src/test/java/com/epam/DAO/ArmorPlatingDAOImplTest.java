package com.epam.DAO;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ArmorPlatingDAOImplTest {
    private static AmmunitionDAO armorPlatingAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        armorPlatingAccessObj = ArmorPlatingDAOSingletonImpl.getInstance();
    }

    @Test
    public void getAllMethodShouldNotReturnNull() {
        assertThat(armorPlatingAccessObj.getAll(), notNullValue());
    }

    @Test
    public void getAllMethodShouldReturnSet() {
        assertThat(armorPlatingAccessObj.getAll(), Matchers.instanceOf(Set.class));
    }
}