package ru.ibs.framework.managers;

import ru.ibs.framework.pages.LoginPage;
import ru.ibs.framework.pages.MainPage;
import ru.ibs.framework.pages.TripCreatingPage;

public class PageManager {

    private static PageManager INSTANCE = null;

    private LoginPage loginPage;
    private MainPage mainPage;
    private TripCreatingPage tripCreatingPage;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public TripCreatingPage getTripCreatingPage() {
        if (tripCreatingPage == null) {
            tripCreatingPage = new TripCreatingPage();
        }
        return tripCreatingPage;
    }

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }
}
