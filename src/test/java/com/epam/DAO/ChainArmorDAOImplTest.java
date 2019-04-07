package com.epam.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ChainArmorDAOImplTest {
    private static AmmunitionDAO chainArmorAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        chainArmorAccessObj = new ChainArmorDAOImpl();
    }

    @Test
    public void get_All_Method_Should_Not_Return_Null() {
        assertThat(chainArmorAccessObj.getAll(), notNullValue());
    }
}