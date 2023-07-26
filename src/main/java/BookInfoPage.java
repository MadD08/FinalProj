import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookInfoPage extends BasePage{

    private By searchByAddToCart = By.xpath("//div[@class='product-sidebar__ordering']//button[contains(text(),'До кошика')]");
    private By searchCloseButton = By.xpath("//button[@class='ui-btn-close product-layout__close']");

    public BookInfoPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage goBackToSearchResultsPage(){
        driver.findElement(searchByAddToCart).click();
        driver.findElement(searchCloseButton).click();
        return new SearchResultsPage(driver);
    }
}
