package com.epam.factory;

import com.epam.ammunitionTypes.AmmunitionSpec;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ComparatorFactoryTest {
    private static ComparatorFactory comparatorFactory;

    @BeforeClass
    public static void onlyOnce() {
        comparatorFactory = new ComparatorFactory();
    }

    @Test
    public void id_Comparator_Should_Not_Be_Null() {
        assertThat(comparatorFactory.getComparator(AmmunitionSpec.id), notNullValue());
    }

    @Test
    public void price_Comparator_Should_Not_Be_Null() {
        assertThat(comparatorFactory.getComparator(AmmunitionSpec.price), notNullValue());
    }

    @Test
    public void weigth_Comparator_Should_Not_Be_Null() {
        assertThat(comparatorFactory.getComparator(AmmunitionSpec.weigth), notNullValue());
    }
}