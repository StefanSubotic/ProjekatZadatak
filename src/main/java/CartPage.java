import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

@FindBy(className = "inventory_item_name")
    WebElement productNameOnCart;

public CartPage (ChromeDriver driver)
{
    this.driver = driver;
    PageFactory.initElements(driver,this);
}

public String getProductName()
{
    return productNameOnCart.getText();
}

}
