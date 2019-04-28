package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.HelmetForm;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

public class HelmetTest {
    private static Ammunition helmet;

    @BeforeClass
    public static void setUp() throws Exception {
        helmet = new Helmet();
    }

    @Test
    public void correctIfHasMaterial() {
        assertThat(helmet, hasProperty("helmetForm"));
    }

    @Test
    public void ifEqualsThanCorrect() {
        Ammunition helmet1 = new Helmet(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Helmet", HelmetForm.Conical);
        Ammunition helmet2 = new Helmet(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Helmet", HelmetForm.Conical);
        assertEquals(helmet1, helmet2);
    }

    @Test
    public void ifNotSameThanCorrect() {
        Ammunition helmet1 = new Helmet(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Helmet", HelmetForm.Conical);
        Ammunition helmet2 = new Helmet(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Helmet", HelmetForm.Conical);
        assertNotSame(helmet1, helmet2);
    }
}
