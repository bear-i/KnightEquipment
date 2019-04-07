package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.SwordLength;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

public class SwordTest {
    private static Ammunition sword;

    @BeforeClass
    public static void setUp() throws Exception {
        sword = new Sword();
    }

    @Test
    public void correct_If_Has_Material() {
        assertThat(sword, hasProperty("swordLength"));
    }

    @Test
    public void if_Equals_Than_Correct() {
        Ammunition sword1 = new Sword(755, 900.0, 5, AmmunitionMaterial.Cooper,
                "Sword", 0.05, SwordLength.Long);
        Ammunition sword2 = new Sword(755, 900.0, 5, AmmunitionMaterial.Cooper,
                "Sword", 0.05, SwordLength.Long);
        assertEquals(sword1, sword2);
    }

    @Test
    public void if_Not_Same_Than_Correct() {
        Ammunition sword1 = new Sword(755, 900.0, 5, AmmunitionMaterial.Cooper,
                "Sword", 0.05, SwordLength.Long);
        Ammunition sword2 = new Sword(755, 900.0, 5, AmmunitionMaterial.Cooper,
                "Sword", 0.05, SwordLength.Long);
        assertNotSame(sword1, sword1);
    }
}