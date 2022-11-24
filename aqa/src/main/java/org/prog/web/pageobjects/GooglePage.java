package org.prog.web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.prog.web.pageobjects.commons.AbstractPage;

import java.util.List;
import java.util.stream.Collectors;

public class GooglePage extends AbstractPage {

    private final static String COOKIES_WRAPPER = "CXQnmb";
    private final static String GOOGLE_SEARCH_BAR_NAME = "q";
    private final static String GOOGLE_SEARCH_RESULTS = "//div[@id='rso']/div//a/h3";

    private final static String URL = "https://google.com/";

    public GooglePage(WebDriver driver) {
        super(driver, URL);
    }

    public void acceptCookies() {
        List<WebElement> cookiesWrapper = getElements(By.id(COOKIES_WRAPPER));
        if (!cookiesWrapper.isEmpty() && cookiesWrapper.get(0).isDisplayed()) {
            List<WebElement> buttons = waitForElements(By.tagName("button"));
            buttons.get(3).click();
        }
    }

    public void setSearchValue(String searchValue) {
        waitForElement(By.name(GOOGLE_SEARCH_BAR_NAME)).clear();
        waitForElement(By.name(GOOGLE_SEARCH_BAR_NAME)).sendKeys(searchValue);
    }

    public void performSearch(boolean usingMouse) {
        if (usingMouse) {
            clickElement(By.name(GOOGLE_SEARCH_BAR_NAME));
        } else {
            waitForElement(By.name(GOOGLE_SEARCH_BAR_NAME)).sendKeys(Keys.RETURN);
        }
    }

    public List<String> getSearchResults() {
        return waitForElements(By.xpath(GOOGLE_SEARCH_RESULTS))
                .stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }

    public String getHeaderText() {
        return waitForElement(By.xpath("//span[@role='heading']")).getText();
    }

    public void openGoogleApps() {

    }

    public void selectGoogleApp() {

    }
}
