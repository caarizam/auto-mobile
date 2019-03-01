package org.auto.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin = { "pretty", "json:target/cucumber-json-report", "html:target/cucumber-html" },
        format = { "pretty", "html:target/html-report" },
        features = {"src/test/resources/features/" },
        glue = { "classpath:org.auto.steps.definition" },
        tags = { "@add-remove-note" }
        )
public class TestRunner {

}
