package com.epam.DAO;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class SwordDAOImplTest {
    private static AmmunitionDAO swordAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        swordAccessObj = SwordDAOSingletonImpl.getInstance();
    }

    @Test
    public void getAllMethodShouldNotReturnNull() {
        assertThat(swordAccessObj.getAll(), notNullValue());
    }

    @Test
    public void getAllMethodShouldReturnSet() {
        assertThat(swordAccessObj.getAll(), Matchers.instanceOf(Set.class));
    }
}