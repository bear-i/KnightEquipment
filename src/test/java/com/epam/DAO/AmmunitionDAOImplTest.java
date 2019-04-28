package com.epam.DAO;

import com.epam.entity.Ammunition;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class AmmunitionDAOImplTest {
    private static AmmunitionDAO ammunitionAccessObj;

    @BeforeClass
    public static void onlyOnce() {
        ammunitionAccessObj = AmmunitionDAOSingletonImpl.getInstance();
    }

    @Test
    public void getAllMethodShouldNotReturnNull() {
        assertThat(ammunitionAccessObj.getAll(), notNullValue());
    }

    @Test
    public void getAllMethodShouldReturnSet() {
        assertThat(ammunitionAccessObj.getAll(), Matchers.instanceOf(Set.class));
    }
}