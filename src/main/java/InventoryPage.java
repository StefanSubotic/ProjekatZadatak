import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement onesie;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement tShirt;

    @FindBy(className = "shopping_cart_badge")
    WebElement cart;

    @FindBy(className = "shopping_cart_link")
    WebElement cartNumber;

    @FindBy(className = "product_sort_container")
    WebElement sort;

    @FindBy(className = "inventory_item_price")
    WebElement totalPrice;

    @FindBy(className = "summary_subtotal_label")
    WebElement itemPrice;

    @FindBy(id = "checkout")
    WebElement checkout;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpack;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpack;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeBikeLight;

    @FindBy(id = "continue-shopping")
    WebElement continueShopping;

    public InventoryPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnesie()
    {
        onesie.click();
    }
    public void clickbikeLight()
    {
        bikeLight.click();
    }
    public void clickTshirt()
    {
        tShirt.click();
    }
    public void clickCheckout(){checkout.click();}
    public void clickBackpack(){backpack.click();}

    public void removeBackpack(){removeBackpack.click();}
    public void removeBikeLight(){removeBikeLight.click();}
    public void clickcOnContinueShopping(){continueShopping.click();}


    public String getCartNumber()
    {
        return cartNumber.getText();
    }
    public void sortProducts(String text)
    {
        Select select = new Select(sort);
        select.selectByVisibleText(text);
    }

    public void clickOnCart()
    {
        cart.click();
    }
    public String getTotalPrice()
    {
        return totalPrice.getText();
    }
    public String getItemPrice()
    {
        return  itemPrice.getText();
    }
}
