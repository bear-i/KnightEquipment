package com.epam.DAO;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class HelmetDAOImplTest {
    private static AmmunitionDAO helmetAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        helmetAccessObj = HelmetDAOSingletonImpl.getInstance();
    }

    @Test
    public void getAllMethodShouldNotReturnNull() {
        assertThat(helmetAccessObj.getAll(), notNullValue());
    }

    @Test
    public void getAllMethodShouldReturnSet() {
        assertThat(helmetAccessObj.getAll(), Matchers.instanceOf(Set.class));
    }
}
