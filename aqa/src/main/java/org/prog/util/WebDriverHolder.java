package org.prog.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHolder {
  private final WebDriver driver;
  private final static WebDriverHolder instance = new WebDriverHolder();

  private WebDriverHolder() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  public static WebDriverHolder getInstance() {
    return instance;
  }

  public WebDriver getDriver() {
    return driver;
  }
}
