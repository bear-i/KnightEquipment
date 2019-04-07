package com.epam.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class WeaponDAOImplTest {
    private static AmmunitionDAO weaponAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        weaponAccessObj = new WeaponDAOImpl();
    }

    @Test
    public void get_All_Method_Should_Not_Return_Null() {
        assertThat(weaponAccessObj.getAll(), notNullValue());
    }
}