package org.prog.plugin;

import ch.qos.logback.classic.Level;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import org.prog.util.PageHolder;
import org.prog.util.Pages;
import org.prog.util.WebDriverHolder;
import org.prog.web.pageobjects.GooglePage;
import org.prog.web.pageobjects.hotline.HotlinePage;

public class MyCucesPlugin implements EventListener {

  @Override
  public void setEventPublisher(EventPublisher eventPublisher) {
    eventPublisher.registerHandlerFor(TestRunFinished.class, this::tearDown);
    eventPublisher.registerHandlerFor(TestRunStarted.class, this::iniPages);
    eventPublisher.registerHandlerFor(TestRunStarted.class, this::setLoggingLevel);
  }

  private void tearDown(TestRunFinished event) {
    System.out.println("All tests finished, shutting down...");
    WebDriverHolder.getInstance().getDriver().quit();
  }

  public void iniPages(TestRunStarted event) {
    PageHolder.getInstance().iniPage(Pages.GOOGLE,
        new GooglePage(WebDriverHolder.getInstance().getDriver()));
    PageHolder.getInstance().iniPage(Pages.HOTLINE,
        new HotlinePage(WebDriverHolder.getInstance().getDriver()));
  }

  public void setLoggingLevel(TestRunStarted event) {
    ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory.getLogger(
        ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
    root.setLevel(Level.INFO);
  }
}