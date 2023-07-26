import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage{

    private By searchBookByTitle = By.xpath("//a[@title='Head First. Java']");
    private By searchCartButton = By.xpath("//span[@class='ui-btn-shopping-cart__title']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public BookInfoPage goToBookInfoPage(){
        driver.findElement(searchBookByTitle).click();
        return new BookInfoPage(driver);
    }

    public CartPage goToCartPage(){
        driver.findElement(searchCartButton).click();
        return new CartPage(driver);
    }
}
