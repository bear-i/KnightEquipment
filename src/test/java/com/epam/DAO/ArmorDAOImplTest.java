package com.epam.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ArmorDAOImplTest {
    private static AmmunitionDAO armorAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        armorAccessObj = new ArmorDAOImpl();
    }

    @Test
    public void get_All_Method_Should_Not_Return_Null() {
        assertThat(armorAccessObj.getAll(), notNullValue());
    }
}