package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.SpearType;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

public class SpearTest {
    private static Ammunition spear;

    @BeforeClass
    public static void setUp() throws Exception {
        spear = new Spear();
    }

    @Test
    public void correctIfHasMaterial() {
        assertThat(spear, hasProperty("spearType"));
    }

    @Test
    public void ifEqualsThanCorrect() {
        Ammunition spear1 = new Spear(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Spear", 0.03, SpearType.Throwing);
        Ammunition spear2 = new Spear(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Spear", 0.03, SpearType.Throwing);
        assertEquals(spear1, spear2);
    }

    @Test
    public void ifNotSameThanCorrect() {
        Ammunition spear1 = new Spear(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Spear", 0.03, SpearType.Throwing);
        Ammunition spear2 = new Spear(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Spear", 0.03, SpearType.Throwing);
        assertNotSame(spear1, spear2);
    }
}
