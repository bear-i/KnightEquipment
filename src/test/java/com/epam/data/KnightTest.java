package com.epam.data;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class KnightTest {
    Knight knight;

    @Before
    public void setUp() throws Exception {
        knight = new Knight();
    }

    @Test
    public void correctIfHasBalance() {
        assertThat(knight, hasProperty("balance"));
    }

    @Test
    public void shouldHaveListOfBoughtAmmunition() {
        assertThat(knight, hasProperty("boughtAmmunition"));
    }

    @Test
    public void boughtAmmunitionShouldNotBeNull() {
        assertThat(knight.getBoughtAmmunition(), notNullValue());
    }

    @Test
    public void ifToStringCorrect() {
        knight.setBalance(1000);
        assertThat(knight, hasToString("Balance: 1000.0, bought ammunition: []"));
    }

    @Test
    public void ifEqualsThanCorrect() {
        assertEquals(new Knight(2000.0), new Knight(2000.0));
    }

    @Test
    public void ifNotSameThanCorrect() {
        assertNotSame(new Knight(2000.0), new Knight(2000.0));
    }
}
