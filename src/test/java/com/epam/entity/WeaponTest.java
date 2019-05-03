package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

public class WeaponTest {
    private Weapon weapon;

    @Before
    public void setUp() throws Exception {
        weapon = new Weapon();
    }

    @Test
    public void correctIfHasId() {
        assertThat(weapon, hasProperty("purchaseTax"));
    }

    @Test
    public void ifEqualsThanCorrect() {
        Ammunition weapon1 = new Weapon(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet", 0.15);
        Ammunition weapon2 = new Weapon(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet", 0.15);
        assertEquals(weapon1, weapon2);
    }

    @Test
    public void ifNotSameThanCorrect() {
        Ammunition weapon1 = new Weapon(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet", 0.15);
        Ammunition weapon2 = new Weapon(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet", 0.15);
        assertNotSame(weapon1, weapon2);
    }
}
