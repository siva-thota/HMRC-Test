package demo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import demo.driver.Hooks;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"demo.steps"},
        plugin = {"pretty", "html:target/html/reports", "json:target/json/cucumber.json"},
        tags = "@demo")

public class Runner {

    @AfterClass
    public static void after() {
        Hooks hooks = new Hooks();
        hooks.cleanUp();
    }

}
