package org.prog.web.pageobjects.hotline.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.prog.web.pageobjects.commons.AbstractModule;
import org.springframework.stereotype.Component;

@Component
public class CategoriesModule extends AbstractModule {

    private By HOTLINE_FINANCE = By.xpath("//a[@data-eventlabel='HOTLINE.FINANCE']");
    private By AUTO_MOTO = By.xpath("//a[@data-eventlabel='Авто і Мото']");
    private By TECH = By.xpath("//a[@data-eventlabel='Побутова техніка']");


    public WebElement getHotlineFinance() {
        return webDriverFacade.waitForElement(HOTLINE_FINANCE);
    }

    public WebElement getAutoMoto() {
        return webDriverFacade.waitForElement(AUTO_MOTO);
    }

    public WebElement getTech() {
        return webDriverFacade.waitForElement(TECH);
    }
}
