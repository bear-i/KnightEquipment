package com.epam;

import com.epam.service.AppServiceImpl;

public class Main {
    public static void main(String[] args) {
        AppServiceImpl app = new AppServiceImpl();
        app.setKnightBalance();
        app.chooseOptionFromStartingMenu();
        System.out.println("Bye-bye!");
    }
}
