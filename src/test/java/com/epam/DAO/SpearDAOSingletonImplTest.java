package com.epam.DAO;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class SpearDAOSingletonImplTest {
    private static AmmunitionDAO spearAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        spearAccessObj = SpearDAOSingletonImpl.getInstance();
    }

    @Test
    public void getAllMethodShouldNotReturnNull() {
        assertThat(spearAccessObj.getAll(), notNullValue());
    }

    @Test
    public void getAllMethodShouldReturnSet() {
        assertThat(spearAccessObj.getAll(), Matchers.instanceOf(Set.class));
    }
}