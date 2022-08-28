package ru.ibs.framework.managers;

import ru.ibs.framework.pages.ExtendedFiltersPage;
import ru.ibs.framework.pages.YaMarketPage;
import ru.ibs.framework.pages.YaPage;

public class PageManager {

    private static PageManager INSTANCE = null;

    private YaPage yaPage;
    private YaMarketPage yaMarketPage;
    private ExtendedFiltersPage extendedFiltersPage;

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public YaPage getYaPage() {
        if (yaPage == null) {
            yaPage = new YaPage();
        }
        return yaPage;
    }

    public YaMarketPage getYaMarketPage() {
        if (yaMarketPage == null) {
            yaMarketPage = new YaMarketPage();
        }
        return yaMarketPage;
    }

    public ExtendedFiltersPage getExtendedFiltersPage() {
        if (extendedFiltersPage == null) {
            extendedFiltersPage = new ExtendedFiltersPage();
        }
        return extendedFiltersPage;
    }

}
