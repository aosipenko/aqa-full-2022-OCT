package org.prog.plugin;

import ch.qos.logback.classic.Level;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import org.prog.util.WebDriverFacade;
import org.springframework.beans.factory.annotation.Autowired;

public class MyCucesPlugin implements EventListener {

    @Autowired
    private WebDriverFacade webDriverFacade;

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunFinished.class, this::tearDown);
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::setLoggingLevel);
    }

    private void tearDown(TestRunFinished event) {
        System.out.println("All tests finished, shutting down...");
        webDriverFacade.quit();
    }

    public void setLoggingLevel(TestRunStarted event) {
        ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory.getLogger(
                ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.INFO);
    }
}