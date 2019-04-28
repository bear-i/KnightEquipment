package com.epam.service;

import com.epam.ammunitionTypes.AmmunitionSpec;
import com.epam.entity.Ammunition;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class SortServiceImplTest {
    private SortService sortService;
    private Set<Ammunition> ammunitions;

    @Before
    public void setUp() throws Exception {
        sortService = new SortServiceImpl();
        ammunitions = new HashSet<>();
    }

    @Test
    public void sortedSetShouldNotBeNull() {
        assertNotNull("Should not be null", sortService.sortBy(ammunitions, AmmunitionSpec.id));
    }

    @Test
    public void sortedSetShouldNotBeNullUsingMatcher() {
        assertThat(sortService.sortBy(ammunitions, AmmunitionSpec.price), notNullValue());
    }
}
