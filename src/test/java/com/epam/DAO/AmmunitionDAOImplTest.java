package com.epam.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class AmmunitionDAOImplTest {
    private static AmmunitionDAO ammunitionAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        ammunitionAccessObj = new AmmunitionDAOImpl();
    }

    @Test
    public void get_All_Method_Should_Not_Return_Null() {
        assertThat(ammunitionAccessObj.getAll(), notNullValue());
    }
}