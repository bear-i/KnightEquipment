package com.epam.entity;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

public class AmmunitionTest {
    static Ammunition ammunition;

    @BeforeClass
    public static void setUp() throws Exception {
        ammunition = new Ammunition();
    }

    @Test
    public void correctIfHasId() {
        assertThat(ammunition, hasProperty("id"));
    }

    @Test
    public void correctIfHasPrice() {
        assertThat(ammunition, hasProperty("price"));
    }

    @Test
    public void correctIfHasWeigth() {
        assertThat(ammunition, hasProperty("weigth"));
    }

    @Test
    public void correctIfHasName() {
        assertThat(ammunition, hasProperty("name"));
    }

    @Test
    public void correctIfHasMaterial() {
        assertThat(ammunition, hasProperty("material"));
    }

    @Test
    public void ifEqualsThanCorrect() {
        Ammunition ammun1 = new Ammunition(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet");
        Ammunition ammun2 = new Ammunition(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet");
        assertEquals(ammun1, ammun2);
    }

    @Test
    public void ifNotSameThanCorrect() {
        Ammunition ammun1 = new Ammunition(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet");
        Ammunition ammun2 = new Ammunition(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet");
        assertNotSame(ammun1, ammun2);
    }
}
