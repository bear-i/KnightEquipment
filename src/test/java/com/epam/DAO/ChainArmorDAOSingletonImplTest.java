package com.epam.DAO;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ChainArmorDAOSingletonImplTest {
    private static AmmunitionDAO chainArmorAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        chainArmorAccessObj = ChainArmorDAOSingletonImpl.getInstance();
    }

    @Test
    public void getAllMethodShouldNotReturnNull() {
        assertThat(chainArmorAccessObj.getAll(), notNullValue());
    }

    @Test
    public void getAllMethodShouldReturnSet() {
        assertThat(chainArmorAccessObj.getAll(), Matchers.instanceOf(Set.class));
    }
}