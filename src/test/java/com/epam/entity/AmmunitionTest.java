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
    public void correct_If_Has_Id() {
        assertThat(ammunition, hasProperty("id"));
    }

    @Test
    public void correct_If_Has_Price() {
        assertThat(ammunition, hasProperty("price"));
    }

    @Test
    public void correct_If_Has_Weigth() {
        assertThat(ammunition, hasProperty("weigth"));
    }

    @Test
    public void correct_If_Has_Name() {
        assertThat(ammunition, hasProperty("name"));
    }

    @Test
    public void correct_If_Has_Material() {
        assertThat(ammunition, hasProperty("material"));
    }

    @Test
    public void if_Equals_Than_Correct() {
        Ammunition ammun1 = new Ammunition(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet");
        Ammunition ammun2 = new Ammunition(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet");
        assertEquals(ammun1, ammun2);
    }

    @Test
    public void if_Not_Same_Than_Correct() {
        Ammunition ammun1 = new Ammunition(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet");
        Ammunition ammun2 = new Ammunition(808, 2000.0, 50, AmmunitionMaterial.Cooper, "Helmet");
        assertNotSame(ammun1, ammun2);
    }
}