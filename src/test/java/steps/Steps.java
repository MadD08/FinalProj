package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Steps {
    protected WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hedgehog\\IdeaProjects\\AutTrainingProject\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    private Map<String, String> dataForOrder;
    private Map<String, String> cardDetails;
    private By searchFieldLocator = By.xpath("//div[@class='ui-search-form-input']/input");
    private By searchButton = By.xpath("//div[@class='ui-search-form-input on-search-mode']/button");
    private By searchBookByTitle = By.xpath("//a[@title='Пришвидшений курс Python. Практичний, проєктно-орієнтований вступ до програмування']");
    private By searchCartButton = By.xpath("//span[@class='ui-btn-shopping-cart__title']");
    private By searchByAddToCart = By.xpath("//div[@class='product-sidebar__ordering']//button[contains(text(),'До кошика')]");
    private By searchCloseButton = By.xpath("//button[@class='ui-btn-close product-layout__close']");
    private By searchGoToCheckOut = By.xpath("//div[@class='microcart-summary']//button");
    private By firstNameInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@name='first name']");
    private By secondNameInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@name='last name']");
    private By phoneInputLocator = By.xpath("//div[@class='input-tel']//input[@class='ui-base-input']");
    private By emailInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@name='email']");
    private By countryInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@placeholder='Введіть назву країни...']");
    private By desiredCountryLocator = By.xpath("//div[@class='body is-open']//div[contains(text(),'Україна')]");
    private By cityInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@placeholder='Введіть назву міста...']");
    private By desiredCityLocator = By.xpath("//ul[@class='item-with-list__options']//li[contains(text(),'Київ')]");
    private By deliveryMethodLocator = By.xpath("//span[contains(text(),'Поштомат Нова Пошта')]");
    private By addressInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@placeholder='Адреса поштомата']");
    private By desiredAddressLocator = By.xpath("//div[@class='body is-open']//div[contains(text(),'Поштомат \"Нова Пошта\" №22220')]");
    private By paymentMethodLocator = By.xpath("//div[contains(text(),'Оплата карткою On-line')]");
    private By checkoutButtonLocator = By.xpath("//section[@class='order-submit sidebar']//div[@class='order-submit__submit']");
    private By cardNumberLocator = By.xpath("//input[@title='Номер картки']");
    private By dueMonthLocator = By.xpath("//input[@title='мм']");
    private By dueYearLocator = By.xpath("//input[@title='рр']");
    private By cvvLocator = By.xpath("//input[@title='CVV']");
    private By payButtonLocator = By.xpath("//button[@type='submit']");

    @Given("I am a new customer and I open the \"Home page\"")
    public void i_open_the() {
        driver.get("https://www.yakaboo.ua");
    }


    @And("I search for {string}")
    public void i_search_for(String bookName) {
        driver.findElement(searchFieldLocator).sendKeys(bookName);
        driver.findElement(searchButton).click();
    }


    @And("I select the product with title {string}")
    public void i_select_the_product_with_title(String bookName) {
        driver.findElement(searchBookByTitle).click();
    }

    @And("I click \"Add to basket\" button for the given needed product and close the book info page")
    public void i_click_button_for_the_given_needed_product_and_close_the_book_info_page() {
        driver.findElement(searchByAddToCart).click();
        driver.findElement(searchCloseButton).click();
    }

    @And("I click on the basket icon on \"Search Results Page\"")
    public void i_click_on_the_basket_icon_on() {
        driver.findElement(searchCartButton).click();
        driver.findElement(searchGoToCheckOut).click();
    }

    @And("I am filling the details:")
    public void i_am_filling_the_details(DataTable dataForOrderTable) {
        dataForOrder = dataForOrderTable.asMap(String.class, String.class);
        driver.findElement(firstNameInputLocator).sendKeys(dataForOrder.get("name"));
        driver.findElement(secondNameInputLocator).sendKeys(dataForOrder.get("secondName"));
        driver.findElement(phoneInputLocator).sendKeys(dataForOrder.get("phone"));
        driver.findElement(emailInputLocator).sendKeys(dataForOrder.get("email"));
        driver.findElement(countryInputLocator).sendKeys(dataForOrder.get("country"));
        driver.findElement(desiredCountryLocator).click();
        driver.findElement(cityInputLocator).sendKeys(dataForOrder.get("city"));
        driver.findElement(desiredCityLocator).click();
        driver.findElement(deliveryMethodLocator).click();
        driver.findElement(addressInputLocator).sendKeys(dataForOrder.get("address"));
        driver.findElement(desiredAddressLocator).click();
    }


    @And("I press the \"Continue to payment\" button")
    public void i_press_the_button() {
        Assert.assertTrue(driver.findElement(checkoutButtonLocator).isEnabled());
        driver.findElement(checkoutButtonLocator).click();
    }

    @Then("I feel my card details and press pay button")
    public void i_feel_my_card_details_and_press_pay_button(DataTable cardDetailsTable) {
        cardDetails = cardDetailsTable.asMap(String.class, String.class);
        driver.findElement(cardNumberLocator).sendKeys(cardDetails.get("cardNumber"));
        driver.findElement(dueMonthLocator).sendKeys(cardDetails.get("mm"));
        driver.findElement(dueYearLocator).sendKeys(cardDetails.get("yy"));
        driver.findElement(cvvLocator).sendKeys(cardDetails.get("cvv"));
        driver.findElement(payButtonLocator).click();
    }

}
