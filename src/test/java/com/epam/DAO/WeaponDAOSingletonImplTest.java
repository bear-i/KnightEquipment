package com.epam.DAO;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class WeaponDAOSingletonImplTest {
    private static AmmunitionDAO weaponAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        weaponAccessObj = WeaponDAOSingletonImpl.getInstance();
    }

    @Test
    public void getAllMethodShouldNotReturnNull() {
        assertThat(weaponAccessObj.getAll(), notNullValue());
    }

    @Test
    public void getAllMethodShouldReturnSet() {
        assertThat(weaponAccessObj.getAll(), Matchers.instanceOf(Set.class));
    }
}