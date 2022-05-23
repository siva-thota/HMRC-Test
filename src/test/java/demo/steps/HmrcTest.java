package demo.steps;

import io.cucumber.java8.En;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import demo.pages.LandingPage;
import demo.utils.Config;

public class HmrcTest implements En {

    private Logger log = LoggerFactory.getLogger(HmrcTest.class);

    LandingPage landingPage = new LandingPage();
    Config config = new Config();

    public HmrcTest() {

        Given("I open the demo site", () -> {
            landingPage.openUrl(config.getProperty("host"));
        });

        Then("I validate the page title {string}", (String string) -> {
            Assert.assertTrue(landingPage.validatePage(string));
        });

        When("I click on the {string} menu", (String menu) -> {
            landingPage.clickOnMenu(menu);
        });

        Then("I add costly dress to cart", () -> {
            landingPage.addCostlyItemToCart();
        });

    }

}
