package org.prog.web.pageobjects.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPage {

    private WebDriver driver;
    private String url;

    public final static String BLANK_PAGE = "about:blank";

    public AbstractPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public void loadPage() {
        driver.get(BLANK_PAGE);
        driver.get(url);
    }

    protected List<WebElement> getElements(By selector) {
        return driver.findElements(selector);
    }

    protected WebElement waitForElement(By selector) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    protected List<WebElement> waitForElements(By selector) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
    }

    protected void clickElement(By selector) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(selector))
                .click();
    }
}
