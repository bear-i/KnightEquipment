package com.epam.DAO;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ArmorDAOSingletonImplTest {
    private static AmmunitionDAO armorAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        armorAccessObj = ArmorDAOSingletonImpl.getInstance();
    }

    @Test
    public void getAllMethodShouldNotReturnNull() {
        assertThat(armorAccessObj.getAll(), notNullValue());
    }

    @Test
    public void getAllMethodShouldReturnSet() {
        assertThat(armorAccessObj.getAll(), Matchers.instanceOf(Set.class));
    }
}