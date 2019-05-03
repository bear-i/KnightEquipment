package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class ArmorTest {
    private static Armor armor;

    @BeforeClass
    public static void setUp() throws Exception {
        armor = new Armor();
    }

    @Test
    public void ifEqualsThanCorrect() {
        Ammunition armor1 = new Armor(905, 400.0, 9, AmmunitionMaterial.Cooper, "Armor");
        Ammunition armor2 = new Armor(905, 400.0, 9, AmmunitionMaterial.Cooper, "Armor");
        assertEquals(armor1, armor2);
    }

    @Test
    public void ifNotSameThanCorrect() {
        Ammunition armor1 = new Armor(905, 400.0, 9, AmmunitionMaterial.Cooper, "Armor");
        Ammunition armor2 = new Armor(905, 400.0, 9, AmmunitionMaterial.Cooper, "Armor");
        assertNotSame(armor1, armor2);
    }
}
