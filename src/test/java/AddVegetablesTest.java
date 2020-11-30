
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Browser;

public class AddVegetablesTest {
    @DataProvider
    public Object[][] testData() {
        String[][] veggiesToBuy = {
                { "Brocolli", "Cucumber", "Beetroot"},
                {"Carrot", "Tomato", "Beans"}

        };
        return veggiesToBuy;

    }

    @BeforeMethod
    public void setUp() {
        Browser.open("chrome");
        GreenKartHomePage.goTo();
    }


    @Test(dataProvider = "testData")
    public void testCart(String veg1, String veg2, String veg3){
        GreenKartHomePage.addVeggiesToCart(veg1, veg2, veg3);
        GreenKartHomePage.isTrue("3");

    }

    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }


}
