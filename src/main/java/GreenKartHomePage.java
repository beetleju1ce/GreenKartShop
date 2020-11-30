import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Browser;
import java.util.Arrays;
import java.util.List;

/**
 * A class that represents GreenKart homepage
 */
public class GreenKartHomePage {

    private static final By LOC_BY_PRODUCTS_NAME = By.cssSelector("h4.product-name");
    private static final By LOC_BY_BUTTON = By.xpath("//div[@class='product-action']/button");
    private static final By LOC_BY_ITEMS_COUNT = By.xpath("//td[text() = 'Items']/following-sibling::td[2]");

    /**
     * Method that leads the user
     * to GreenKart homepage
     */
    public static void goTo() {
        Browser.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }


    /**
     * A method that selects certain vegetables and adds them
     * to the shopping cart
     * @param veg1 - vegetable to be added to the cart
     * @param veg2 - vegetable to be added to the cart
     * @param veg3 - vegetable to be added to the cart
     */
    public static void addVeggiesToCart(String veg1, String veg2, String veg3){
       String[] veggiesToBuy = {veg1, veg2, veg3 };
       List<WebElement> veggies = Browser.driver.findElements(LOC_BY_PRODUCTS_NAME);
        int j = 0;
        for(int i = 0; i < veggies.size(); i++){
             String[] name = veggies.get(i).getText().split("-");
             String formattedName = name[0].trim();
             List veggiesToByuAsList = Arrays.asList(veggiesToBuy);
             if(veggiesToByuAsList.contains(formattedName)){
                 j++;
                 Browser.driver.findElements(LOC_BY_BUTTON).get(i).click();
                 if(j == veggiesToBuy.length){
                     break;
                 }
             }
        }
    }

    /**
     * A method that checks if the correct count of vegetables
     * is added to the cart
     * @param expectedResult - the expected amount of vegetables
     */
    public static void isTrue(String expectedResult){
        String actualCount = Browser.driver.findElement(LOC_BY_ITEMS_COUNT).getText();
        Assert.assertTrue(actualCount.contains(expectedResult));
    }
}
