package com.epam.service;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MenuServiceImplTest {
    MenuService menuService;

    @Before
    public void setUp() throws Exception {
        menuService = new MenuServiceImpl();
    }

    @Test
    public void starting_Menu_Should_Be_Equal_To() {
        String expected = "\nMain menu.\n1.Show all ammunition.\n2.Show armors.\n3.Show weapons.\n4.Show bought ammunition.\n0.Exit\n";
        String real = menuService.getStartingMenu();
        assertThat(real, equalTo(expected));
    }

    @Test
    public void sort_Menu_Should_Be_Equal_To() {
        String expected = "Choose you option: \n1.Sort by id.\n2.Sort by price.\n3.Sort by weigth\n4.To main menu.\n0.Exit.\n";
        String real = menuService.getSortMenu();
        assertThat(real, equalTo(expected));
    }

    @Test
    public void unit_Menu_Should_Be_Equal_To() {
        String expected = "Choose your option:\n1.Buy.\n2.Show within the price range.\n3.Sort by...\n4.To main menu\n0.Exit.\n";
        String real = menuService.getAmmunitionUnitMenu();
        assertThat(real, equalTo(expected));
    }
}