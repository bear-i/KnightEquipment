package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.BowForm;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

public class BowTest {
    private static Ammunition bow;

    @BeforeClass
    public static void setUp() throws Exception {
        bow = new Bow();
    }

    @Test
    public void correct_If_Has_Material() {
        assertThat(bow, hasProperty("bowForm"));
    }

    @Test
    public void if_Equals_Than_Correct() {
        Ammunition bow1 = new Bow(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Bow", 0.05, BowForm.Flat);
        Ammunition bow2 = new Bow(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Bow", 0.05, BowForm.Flat);
        assertEquals(bow1, bow2);
    }

    @Test
    public void if_Not_Same_Than_Correct() {
        Ammunition bow1 = new Bow(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Bow", 0.05, BowForm.Flat);
        Ammunition bow2 = new Bow(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Bow", 0.05, BowForm.Flat);
        assertNotSame(bow1, bow2);
    }
}