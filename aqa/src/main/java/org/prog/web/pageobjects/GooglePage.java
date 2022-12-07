package org.prog.web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.prog.web.pageobjects.commons.AbstractPage;

import java.util.List;
import java.util.stream.Collectors;

public class GooglePage extends AbstractPage {

    private final static String COOKIES_WRAPPER = "CXQnmb";
    private final static String GOOGLE_SEARCH_BAR_NAME = "q";
    private final static String GOOGLE_SEARCH_RESULTS = "//div[@id='rso']/div//a/h3";

    private final static String URL = "https://google.com/";

    public GooglePage() {
        super(URL);
    }

    public void acceptCookies() {
        List<WebElement> cookiesWrapper = webDriverFacade.getElements(By.id(COOKIES_WRAPPER));
        if (!cookiesWrapper.isEmpty() && cookiesWrapper.get(0).isDisplayed()) {
            List<WebElement> buttons = webDriverFacade.waitForElements(By.tagName("button"));
            buttons.get(3).click();
        }
    }

    public void setSearchValue(String searchValue) {
        webDriverFacade.waitForElement(By.name(GOOGLE_SEARCH_BAR_NAME)).clear();
        webDriverFacade.waitForElement(By.name(GOOGLE_SEARCH_BAR_NAME)).sendKeys(searchValue);
    }

    public void performSearch() {
        webDriverFacade.waitForElement(By.name(GOOGLE_SEARCH_BAR_NAME)).sendKeys(Keys.RETURN);
    }

    public List<String> getSearchResults() {
        return webDriverFacade.waitForElements(By.xpath(GOOGLE_SEARCH_RESULTS))
                .stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }

    public String getHeaderText() {
        return webDriverFacade
                .waitForElement(By.xpath("//span[@role='heading']")).getText();
    }
}
