package com.epam.service;

import com.epam.DAO.AmmunitionDAO;
import com.epam.DAO.AmmunitionDAOImpl;
import com.epam.DAO.ArmorDAOImpl;
import com.epam.DAO.WeaponDAOImpl;
import com.epam.ammunitionTypes.AmmunitionSpec;
import com.epam.data.Knight;
import com.epam.entity.Ammunition;

import java.util.Collection;
import java.util.Set;

public class AppServiceImpl implements AppService {
    private Knight knight = new Knight();
    private boolean quit = false;
    private AmmunitionDAO ammunitionDAO = new AmmunitionDAOImpl();
    private AmmunitionDAO weaponDAO = new WeaponDAOImpl();
    private AmmunitionDAO armorDAO = new ArmorDAOImpl();
    private InputService inputService = new InputServiceImpl();
    private MenuService menuService = new MenuServiceImpl();
    private SortService sortService = new SortServiceImpl();

    @Override
    public void setKnightBalance() {
        System.out.println("Welcome!\nEnter your balance: ");
        knight.setBalance(new InputServiceImpl().getBalance());
    }

    @Override
    public void chooseOptionFromStartingMenu() {
        do {
            System.out.println(menuService.getStartingMenu());
            switch (inputService.getOption()) {
                case 1:
                    show(ammunitionDAO.getAll());
                    chooseUnitOption(ammunitionDAO);
                    break;
                case 2:
                    show(armorDAO.getAll());
                    chooseUnitOption(armorDAO);
                    break;
                case 3:
                    show(weaponDAO.getAll());
                    chooseUnitOption(weaponDAO);
                    break;
                case 4:
                    showBoughtAmmunition();
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Enter option from menu.\n");
            }
        } while (!quit);
    }

    @Override
    public void chooseUnitOption(AmmunitionDAO accessObj) {
        System.out.println(menuService.getAmmunitionUnitMenu());
        switch (inputService.getOption()) {
            case 1:
                buyUnit(accessObj.getAll());
                break;
            case 2:
                showWithinPriceRange(accessObj);
                chooseUnitOption(accessObj);
                break;
            case 3:
                sortBy(accessObj);
                chooseUnitOption(accessObj);
                break;
            case 4:
                return;
            case 0:
                System.exit(0);
            default:
                System.out.println("Enter option from menu\n");
        }
    }

    @Override
    public void buyUnit(Set<? extends Ammunition> ammunitionSet) {
        int id = inputService.getId();
        for (Ammunition unit : ammunitionSet) {
            if (unit.getId() == id) {
                if (checkBalance(unit.getPrice())) {
                    knight.getBoughtAmmunition().add(unit);
                    knight.setBalance(knight.getBalance() - unit.getPrice());
                    System.out.println("You bought " + unit.getName());
                } else {
                    System.out.println("You haven't enough money for this unit\n");
                }
            }
        }
    }

    @Override
    public void showWithinPriceRange(AmmunitionDAO accessObj) {
        show(accessObj.getByPrice());
    }

    @Override
    public void sortBy(AmmunitionDAO accessObj) {
        Set<? extends Ammunition> unitsOfAmmunition = accessObj.getAll();
        System.out.println(menuService.getSortMenu());
        switch (inputService.getOption()) {
            case 1:
                show(sortService.sortBy(unitsOfAmmunition, AmmunitionSpec.id));
                break;
            case 2:
                show(sortService.sortBy(unitsOfAmmunition, AmmunitionSpec.price));
                break;
            case 3:
                show(sortService.sortBy(unitsOfAmmunition, AmmunitionSpec.weigth));
                break;
            case 4:
                return;
            case 0:
                System.exit(0);
            default:
                System.out.println("Enter option from menu\n");
        }
    }

    @Override
    public void showBoughtAmmunition() {
        Collection<Ammunition> boughtAmmunition = knight.getBoughtAmmunition();
        if (!boughtAmmunition.isEmpty()) {
            System.out.println("\nYou bought: ");
            show(boughtAmmunition);
        } else {
            System.out.println("You haven't bought anything yet\n");
        }
    }

    private boolean checkBalance(double price) {
        return (knight.getBalance() >= price);
    }

    private void show(Collection<? extends Ammunition> ammunSet) {
        System.out.println(ammunSet);
    }
}
