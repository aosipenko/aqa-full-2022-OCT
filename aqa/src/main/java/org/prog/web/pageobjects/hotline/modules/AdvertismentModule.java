package org.prog.web.pageobjects.hotline.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.prog.web.pageobjects.commons.AbstractModule;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdvertismentModule extends AbstractModule {
    private final By AD_BUTTONS = By.xpath("//nav/button");


    public List<String> getAdTopics() {
        return webDriverFacade.getElements(AD_BUTTONS).stream()
                .map(webElement -> webElement.getAttribute("data-eventlabel"))
                .collect(Collectors.toList());
    }
}
