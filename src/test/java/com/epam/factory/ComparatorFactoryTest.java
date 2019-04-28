package com.epam.factory;

import com.epam.ammunitionTypes.AmmunitionSpec;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ComparatorFactoryTest {

    @Test
    public void idComparatorShouldNotBeNull() {
        assertThat(ComparatorFactory.getComparator(AmmunitionSpec.id), notNullValue());
    }

    @Test
    public void priceComparatorShouldNotBeNull() {
        assertThat(ComparatorFactory.getComparator(AmmunitionSpec.price), notNullValue());
    }

    @Test
    public void weigthComparatorShouldNotBeNull() {
        assertThat(ComparatorFactory.getComparator(AmmunitionSpec.weigth), notNullValue());
    }
}
