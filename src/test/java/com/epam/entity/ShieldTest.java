package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.ShieldForm;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

public class ShieldTest {
    private static Ammunition shield;

    @BeforeClass
    public static void setUp() throws Exception {
        shield = new Shield();
    }

    @Test
    public void correct_If_Has_Material() {
        assertThat(shield, hasProperty("shieldForm"));
    }

    @Test
    public void if_Equals_Than_Correct() {
        Ammunition shield1 = new Shield(506, 1550.0, 9, AmmunitionMaterial.Bronze,
                "Shield", 0.25, ShieldForm.Almondshaped);
        Ammunition shield2 = new Shield(506, 1550.0, 9, AmmunitionMaterial.Bronze,
                "Shield", 0.25, ShieldForm.Almondshaped);
        assertEquals(shield1, shield2);
    }

    @Test
    public void if_Not_Same_Than_Correct() {
        Ammunition shield1 = new Shield(506, 1550.0, 9, AmmunitionMaterial.Bronze,
                "Shield", 0.25, ShieldForm.Almondshaped);
        Ammunition shield2 = new Shield(506, 1550.0, 9, AmmunitionMaterial.Bronze,
                "Shield", 0.25, ShieldForm.Almondshaped);
        assertNotSame(shield1, shield2);
    }
}