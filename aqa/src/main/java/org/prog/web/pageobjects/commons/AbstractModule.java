package org.prog.web.pageobjects.commons;

import org.openqa.selenium.WebDriver;
import org.prog.util.WebDriverFacade;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractModule {

    @Autowired
    protected WebDriverFacade webDriverFacade;

}
