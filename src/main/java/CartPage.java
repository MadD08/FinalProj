import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By searchBookByTitle = By.xpath("//button[@class='ui-btn-primary microcart-summary-button']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage goToCheckOutPage(){
        driver.findElement(searchBookByTitle).click();
        return new CheckOutPage(driver);
    }
}
