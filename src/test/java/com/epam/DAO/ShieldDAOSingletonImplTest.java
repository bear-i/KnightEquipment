package com.epam.DAO;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ShieldDAOSingletonImplTest {
    private static AmmunitionDAO shieldAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        shieldAccessObj = ShieldDAOSingletonImpl.getInstance();
    }

    @Test
    public void get_All_Method_Should_Not_Return_Null() {
        assertThat(shieldAccessObj.getAll(), notNullValue());
    }

    @Test
    public void getAllMethodShouldReturnSet() {
        assertThat(shieldAccessObj.getAll(), Matchers.instanceOf(Set.class));
    }
}