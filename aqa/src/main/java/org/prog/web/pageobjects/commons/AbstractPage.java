package org.prog.web.pageobjects.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.util.WebDriverFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPage {

    @Autowired
    protected WebDriverFacade webDriverFacade;
    private final String url;

    public final static String BLANK_PAGE = "about:blank";

    public AbstractPage(String url) {
        this.url = url;
    }

    public void loadPage() {
        webDriverFacade.getUrl(BLANK_PAGE);
        webDriverFacade.getUrl(url);
    }
}
