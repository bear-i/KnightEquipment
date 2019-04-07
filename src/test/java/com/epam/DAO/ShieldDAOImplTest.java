package com.epam.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ShieldDAOImplTest {
    private static AmmunitionDAO shieldAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        shieldAccessObj = new ShieldDAOImpl();
    }

    @Test
    public void get_All_Method_Should_Not_Return_Null() {
        assertThat(shieldAccessObj.getAll(), notNullValue());
    }
}