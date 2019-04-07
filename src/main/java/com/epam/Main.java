package com.epam;

import com.epam.service.AppServiceImpl;
import com.epam.service.MenuServiceImpl;

public class Main {
    public static void main(String[] args) {
        AppServiceImpl app = new AppServiceImpl();
        MenuServiceImpl menu = new MenuServiceImpl();
        app.setKnightBalance();
        app.chooseOptionFromStartingMenu();
        System.out.println("Bye-bye!");
    }
}
