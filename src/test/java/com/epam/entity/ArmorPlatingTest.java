package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.ArmorPlatingKind;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

public class ArmorPlatingTest {
    private static Ammunition armorplating;

    @BeforeClass
    public static void setUp() throws Exception {
        armorplating = new ArmorPlating();
    }

    @Test
    public void correctIfHasMaterial() {
        assertThat(armorplating, hasProperty("kind"));
    }

    @Test
    public void ifEqualsThanCorrect() {
        Ammunition armorplating1 = new ArmorPlating(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Armor", ArmorPlatingKind.Full);
        Ammunition armorplating2 = new ArmorPlating(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Armor", ArmorPlatingKind.Full);
        assertEquals(armorplating1, armorplating2);
    }

    @Test
    public void ifNotSameThanCorrect() {
        Ammunition armorplating1 = new ArmorPlating(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Armor", ArmorPlatingKind.Full);
        Ammunition armorplating2 = new ArmorPlating(905, 400.0, 9, AmmunitionMaterial.Cooper,
                "Armor", ArmorPlatingKind.Full);
        assertNotSame(armorplating1, armorplating2);
    }
}
