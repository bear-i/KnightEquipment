package com.epam.service;

public class MenuServiceImpl implements MenuService {

    @Override
    public void showStartingMenu() {
        System.out.println("\nMain menu.\n1.Show all ammunition.\n2.Show armors.\n3.Show weapons.\n4.Show bought ammunition.\n0.Exit\n");
    }

    @Override
    public void showSort() {
        System.out.println("Choose you option: \n1.Sort by id.\n2.Sort by price.\n3.Sort by weigth\n4.To main menu.\n0.Exit.\n");
    }

    @Override
    public void showAmmunitionUnitMenu() {
        System.out.println("Choose your option:\n1.Buy.\n2.Show within the price range.\n3.Sort by...\n4.To main menu\n0.Exit.\n");
    }
}
