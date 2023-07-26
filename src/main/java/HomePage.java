import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage extends BasePage{

    private By searchFieldLocator = By.xpath("//div[@class='ui-search-form-input']/input");
    private By searchButton = By.xpath("//div[@class='ui-search-form-input']/button");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForBook(String bookName){
        driver.findElement(searchFieldLocator).sendKeys(bookName);
        driver.findElement(searchButton).click();
    }

    public SearchResultsPage goToSearchResultsPage(){
        searchForBook("Head First. Java");
        return new SearchResultsPage(driver);
    }
}
