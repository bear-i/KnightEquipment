package com.epam.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class HelmetDAOImplTest {
    private static AmmunitionDAO HelmetAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        HelmetAccessObj = new HelmetDAOImpl();
    }

    @Test
    public void get_All_Method_Should_Not_Return_Null() {
        assertThat(HelmetAccessObj.getAll(), notNullValue());
    }
}