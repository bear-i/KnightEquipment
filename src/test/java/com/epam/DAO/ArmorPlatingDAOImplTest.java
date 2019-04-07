package com.epam.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ArmorPlatingDAOImplTest {
    private static AmmunitionDAO armorPLatingAccessOnj;

    @BeforeClass
    public static void onlyOnce() {
        armorPLatingAccessOnj = new ArmorPlatingDAOImpl();
    }

    @Test
    public void get_All_Method_Should_Not_Return_Null() {
        assertThat(armorPLatingAccessOnj.getAll(), notNullValue());
    }

}