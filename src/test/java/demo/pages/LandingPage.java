package demo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import demo.driver.BasePage;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class LandingPage extends BasePage {

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    private WebElement menu_Women;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    private WebElement menu_Dresses;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    private WebElement menu_TShirts;

    @FindBy(css = "div.right-block")
    private List<WebElement> itemBlocks;

    @FindBy(css = "div.left-block")
    private List<WebElement> itemImageBlocks;

    @FindBy(css = "a.button.button.ajax_add_to_cart_button.btn.btn-default")
    WebElement addToCart;

    @FindBy(css = "div.shopping_cart")
    private WebElement cart;

    public void clickOnMenu(String menu) {
        switch (menu.toLowerCase()) {
            case "dresses":
                menu_Dresses.click();
                break;
            case "women":
                menu_Women.click();
                break;
            case "t-shirts":
                menu_TShirts.click();
                break;
            default:
                Assert.fail("Fail: Menu not present on the page.");
        }
    }

    public void addCostlyItemToCart() {
        System.out.println("Number of item in the page " + itemBlocks.size());

        int counter = 0;
        for (WebElement itemBlock : itemBlocks) {
            String temp = itemBlock.findElement(By.tagName("div")).getText().replace("$", "");
            if (temp.contains("%")) {
                temp = temp.split(" ")[0];
            }
            if (temp.equals(getHighestCost())) {
                break;
            }
            counter++;
        }
        Actions action = new Actions(driver);
        action.moveToElement(itemImageBlocks.get(counter));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addToCart);
    }

    private String getHighestCost() {
        List<Double> itemCosts = new ArrayList<>();
        for (WebElement block : itemBlocks) {
            String temp = block.findElement(By.tagName("div")).getText().replace("$", "");
            if (temp.contains("%")) {
                temp = temp.split(" ")[0];
            }
            itemCosts.add(Double.parseDouble(temp));
        }

        double highest = 0;
        for (double temp : itemCosts) {
            if (highest <= temp) {
                highest = temp;
            }
        }

        return String.valueOf(highest);
    }
}
