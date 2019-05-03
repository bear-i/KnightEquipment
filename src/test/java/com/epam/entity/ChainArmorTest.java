package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.RingsSize;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

public class ChainArmorTest {
    private static Ammunition chainArmor;

    @BeforeClass
    public static void setUp() throws Exception {
        chainArmor = new ChainArmor();
    }

    @Test
    public void correctIfHasMaterial() {
        assertThat(chainArmor, hasProperty("ringsSize"));
    }

    @Test
    public void ifEqualsThanCorrect() {
        Ammunition chain1 = new ChainArmor(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Chain", RingsSize.Large);
        Ammunition chain2 = new ChainArmor(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Chain", RingsSize.Large);
        assertEquals(chain1, chain2);
    }

    @Test
    public void ifNotSameThanCorrect() {
        Ammunition chain1 = new ChainArmor(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Chain", RingsSize.Large);
        Ammunition chain2 = new ChainArmor(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Chain", RingsSize.Large);
        assertNotSame(chain1, chain2);
    }
}
