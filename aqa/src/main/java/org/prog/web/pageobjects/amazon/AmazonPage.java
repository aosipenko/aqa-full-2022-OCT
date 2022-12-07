package org.prog.web.pageobjects.amazon;

import org.openqa.selenium.WebDriver;
import org.prog.web.pageobjects.amazon.modules.SearchBarModule;
import org.prog.web.pageobjects.commons.AbstractPage;

public class AmazonPage extends AbstractPage {

    private SearchBarModule searchBarModule;

    public AmazonPage(String url) {
        super(url);
    }
}
