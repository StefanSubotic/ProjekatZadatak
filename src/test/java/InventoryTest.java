import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest{

    LoginPage loginPage;

    InventoryPage inventoryPage;

    CheckoutStepOne checkoutStepOne;
    CartPage cartPage;


    @BeforeMethod
    public void SetUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOne = new CheckoutStepOne(driver);
    }

    @Test
    public void VerifyOnCartPageProduct()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.clickOnesie();
        inventoryPage.clickOnCart();

        Assert.assertEquals(cartPage.getProductName(),"Sauce Labs Onesie");
    }

   @Test
public void AddToCart3products()
    {
    loginPage.setUserName("standard_user");
    loginPage.setPassword("secret_sauce");
    loginPage.clickLogin();
    inventoryPage.sortProducts("Price (low to high)");
    inventoryPage.clickOnesie();
    inventoryPage.clickbikeLight();
    inventoryPage.clickTshirt();


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(inventoryPage.getCartNumber(), "3");
    }
    @Test
    public void removeProduct()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.clickBackpack();
        inventoryPage.clickbikeLight();
        inventoryPage.clickOnCart();
        inventoryPage.removeBackpack();
        inventoryPage.removeBikeLight();
        inventoryPage.clickcOnContinueShopping();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(inventoryPage.getCartNumber(),"");
    }



    @Test
    public void itemTotal()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.clickOnesie();
        inventoryPage.cart.click();
        inventoryPage.clickCheckout();
        checkoutStepOne.inputForm("Stefan", "Subotic", "11000");


        Assert.assertEquals(inventoryPage.getTotalPrice(),"$7.99");
    }

    @Test
    public void Total()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.clickOnesie();
        inventoryPage.clickbikeLight();
        inventoryPage.clickTshirt();
        inventoryPage.cart.click();
        inventoryPage.clickCheckout();
        checkoutStepOne.inputForm("Stefan", "Subotic", "11000");

        Assert.assertEquals(inventoryPage.getItemPrice(),"Item total: $33.97");
    }


    @Test
    public void buyProductsToTheEnd()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.sortProducts("Price (low to high)"); //Moze i bez ovoga?
        inventoryPage.clickOnesie();
        inventoryPage.clickbikeLight();
        inventoryPage.clickTshirt();
        inventoryPage.cart.click();
        inventoryPage.clickCheckout();
        checkoutStepOne.inputForm("Stefan", "Subotic", "11000");
        checkoutStepOne.clickFinish();

        Assert.assertEquals(checkoutStepOne.getMessage(), "Thank you for your order!");

    }



    @AfterMethod
    public void after ()
    {
        driver.quit();
    }

    }
