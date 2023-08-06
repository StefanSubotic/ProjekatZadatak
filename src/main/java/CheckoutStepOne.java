import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOne extends BasePage{
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(className = "complete-header")
    WebElement getText;
    @FindBy(id = "finish")
    WebElement finish;
    public CheckoutStepOne(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void inputForm(String name, String last, String zipCode)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(last);
        postalCode.sendKeys(zipCode);
        continueButton.click();
    }
    public void clickFinish(){
        finish.click();
    }
    public String getMessage()
    {
        return getText.getText();
    }
}
