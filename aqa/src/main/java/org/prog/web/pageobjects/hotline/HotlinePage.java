package org.prog.web.pageobjects.hotline;

import org.prog.web.pageobjects.commons.AbstractPage;
import org.prog.web.pageobjects.hotline.modules.AdvertismentModule;
import org.prog.web.pageobjects.hotline.modules.CategoriesModule;
import org.prog.web.pageobjects.hotline.modules.HeaderModule;

public class HotlinePage extends AbstractPage {
    private static final String URL = "https://hotline.ua/";

    private final AdvertismentModule advertismentModule;
    private final HeaderModule headerModule;
    private final CategoriesModule categoriesModule;

    public HotlinePage() {
        super(URL);
        advertismentModule = new AdvertismentModule();
        headerModule = new HeaderModule();
        categoriesModule = new CategoriesModule();
    }

    public AdvertismentModule onAds() {
        return advertismentModule;
    }

    public HeaderModule onHeader() {
        return headerModule;
    }

    public CategoriesModule onCats() {
        return categoriesModule;
    }
}
