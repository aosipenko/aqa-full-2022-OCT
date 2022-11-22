package org.prog;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/test/resources/feature",
    glue = "org.prog",
    plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-report.html", "org.prog.plugin.MyCucesPlugin"})
public class CucumberRunner {
}
