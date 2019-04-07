package com.epam.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class SpearDAOImplTest {
    private static AmmunitionDAO spearAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        spearAccessObj = new SpearDAOImpl();
    }

    @Test
    public void get_All_Method_Should_Not_Return_Null() {
        assertThat(spearAccessObj.getAll(), notNullValue());
    }
}