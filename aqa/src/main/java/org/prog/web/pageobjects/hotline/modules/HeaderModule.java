package org.prog.web.pageobjects.hotline.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.prog.web.pageobjects.commons.AbstractModule;
import org.springframework.stereotype.Component;

@Component
public class HeaderModule extends AbstractModule {
    private final By MENU_BTN = By.className("button-menu-main");
    private final By CITY = By.className("location__city");
    private final By LANG_SELECTOR = By.className("lang-button");
    private final By LANG_ITEM = By.className("lang-item");


    public void openMenu() {
        webDriverFacade.waitForElement(MENU_BTN).click();
    }

    public String getCurrentCity() {
        return webDriverFacade.waitForElement(CITY).getText();
    }

    public void openLangSelection() {
        webDriverFacade.waitForElement(LANG_SELECTOR).click();
    }

    public void selectLang(String value) {
        webDriverFacade.getElements(LANG_ITEM).stream()
                .filter(webElement -> webElement.getText().contains(value))
                .findAny()
                .ifPresent(WebElement::click);
    }

}
