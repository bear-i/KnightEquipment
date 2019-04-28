package com.epam.DAO;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class BowDAOImplTest {
    private static AmmunitionDAO bowAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        bowAccessObj = BowDAOSingletonImpl.getInstance();
    }

    @Test
    public void getAllMethodShouldNotReturnNull() {
        assertThat(bowAccessObj.getAll(), notNullValue());
    }

    @Test
    public void getAllMethodShouldReturnSet() {
        assertThat(bowAccessObj.getAll(), Matchers.instanceOf(Set.class));
    }
}