package com.epam.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class BowDAOImplTest {
    private static AmmunitionDAO bowAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        bowAccessObj = new BowDAOImpl();
    }

    @Test
    public void get_All_Method_Should_Not_Return_Null() {
        assertThat(bowAccessObj.getAll(), notNullValue());
    }
}