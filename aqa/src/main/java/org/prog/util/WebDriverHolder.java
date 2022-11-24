package org.prog.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHolder {
    private WebDriver driver;
    private final static WebDriverHolder instance = new WebDriverHolder();

    private WebDriverHolder() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } catch (Exception e) {
            driver = null;
            e.printStackTrace();
        }
    }

    public static WebDriverHolder getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
