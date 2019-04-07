package com.epam.data;

import org.hamcrest.Matchers;
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
    public void correct_If_Has_Balance() {
        assertThat(knight, hasProperty("balance"));
    }

    @Test
    public void should_Have_List_Of_Bought_Ammunition() {
        assertThat(knight, hasProperty("boughtAmmunition"));
    }

    @Test
    public void bought_Ammunition_Should_Not_Be_null() {
        assertThat(knight.getBoughtAmmunition(), notNullValue());
    }

    @Test
    public void if_toString_Correct() {
        knight.setBalance(1000);
        assertThat(knight, hasToString("Balance: 1000.0, bought ammunition: []"));
    }

    @Test
    public void if_Equals_Than_Correct() {
        assertEquals(new Knight(2000.0), new Knight(2000.0));
    }

    @Test
    public void if_Not_Same_Than_Correct() {
        assertNotSame(new Knight(2000.0), new Knight(2000.0));
    }
}