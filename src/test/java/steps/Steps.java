package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class Steps {

    protected WebDriver driver = new ChromeDriver();
    private Map<String, String> dataForOrder;
    private Map<String, String> cardDetails;
    private By searchFieldLocator = By.xpath("//div[@class='ui-search-form-input']/input");
    private By searchButton = By.xpath("//div[@class='ui-search-form-input']/button");
    private By searchBookByTitle = By.xpath("//a[@title='Head First. Java']");
    private By searchCartButton = By.xpath("//span[@class='ui-btn-shopping-cart__title']");
    private By searchByAddToCart = By.xpath("//div[@class='product-sidebar__ordering']//button[contains(text(),'До кошика')]");
    private By searchCloseButton = By.xpath("//button[@class='ui-btn-close product-layout__close']");
    private By firstNameInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@name='first name']");
    private By secondNameInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@name='last name']");
    private By phoneInputLocator = By.xpath("//div[@class='input-tel']//input[@class='ui-base-input']");
    private By emailInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@name='email']");
    private By countryInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@placeholder='Введіть назву країни...']");
    private By desiredCountryLocator = By.xpath("//div[@class='body is-open']//div[contains(text(),'Україна')]");
    private By cityInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@placeholder='Введіть назву міста...']");
    private By desiredCityLocator = By.xpath("//div[@class='body is-open']//div[contains(text(),'Київ')]");
    private By deliveryMethodLocator = By.xpath("//span[contains(text(),'Поштомат Нова Пошта')]");
    private By addressInputLocator = By.xpath("//div[@class='ui-base-field__input']/input[@placeholder='Адреса поштомата']");
    private By desiredAddressLocator = By.xpath("//div[@class='body is-open']//div[contains(text(),'Поштомат \"Нова Пошта\" №22220')]");
    private By paymentMethodLocator = By.xpath("//span[contains(text(),'Оплата карткою On-line')]");
    private By checkoutButtonLocator = By.xpath("//section[@class='order-submit sidebar']//button[@class='ui-btn-secondary']");
    private By cardNumberLocator = By.xpath("//input[@title='Номер картки']");
    private By dueMonthLocator = By.xpath("//input[@title='мм']");
    private By dueYearLocator = By.xpath("//input[@title='рр']");
    private By cvvLocator = By.xpath("//input[@title='CVV']");
    private By payButtonLocator = By.xpath("//button[@type='submit']");

    @Given("I am a new customer and I open the \"Home page\"")
    public void i_open_the() throws Throwable {
        driver.get("https://www.yakaboo.ua");
        throw new PendingException();
    }


    @And("I search for \"Head First. Java\"")
    public void i_search_for(String bookName) throws Throwable {
        driver.findElement(searchFieldLocator).sendKeys(bookName);
        driver.findElement(searchButton).click();
        throw new PendingException();
    }


    @And("I select the product with title \"Head First. Java\"")
    public void i_select_the_product_with_title() throws Throwable {
        driver.findElement(searchBookByTitle).click();
        throw new PendingException();
    }

    @And("I click \"Add to basket\" button for the given needed product and close the book info page")
    public void i_click_button_for_the_given_needed_product_and_close_the_book_info_page() throws Throwable {
        driver.findElement(searchByAddToCart).click();
        driver.findElement(searchCloseButton).click();
        throw new PendingException();
    }

    @And("I click on the basket icon on \"Search Results Page\"")
    public void i_click_on_the_basket_icon_on() throws Throwable {
        driver.findElement(searchCartButton).click();
        throw new PendingException();
    }

    @And("I am filling the details:")
    public void i_am_filling_the_details(DataTable dataForOrderTable) throws Throwable {
        dataForOrder = new HashMap<String, String>();
        for (DataTableRow row : dataForOrderTable.getGherkinRows()) {
            dataForOrder.put(row.getCells().get(0), row.getCells().get(1));
        }
        dataForOrder = dataForOrderTable.asMap(String.class, String.class);
        driver.findElement(firstNameInputLocator).sendKeys(dataForOrder.get("name"));
        driver.findElement(secondNameInputLocator).sendKeys(dataForOrder.get("secondName"));
        driver.findElement(phoneInputLocator).sendKeys(dataForOrder.get("phone"));
        driver.findElement(emailInputLocator).sendKeys(dataForOrder.get("email"));
        driver.findElement(deliveryMethodLocator).click();
        driver.findElement(countryInputLocator).sendKeys(dataForOrder.get("country"));
        driver.findElement(desiredCountryLocator).click();
        driver.findElement(cityInputLocator).sendKeys(dataForOrder.get("city"));
        driver.findElement(desiredCityLocator).click();
        driver.findElement(addressInputLocator).sendKeys(dataForOrder.get("address"));
        driver.findElement(desiredAddressLocator).click();
        throw new PendingException();
    }

    @And("I select online payment option")
    public void i_select_online_payment_option() throws Throwable {
        driver.findElement(paymentMethodLocator).click();
        throw new PendingException();
    }

    @And("I press the \"Continue to payment\" button")
    public void i_press_the_button(String arg0) throws Throwable {
        driver.findElement(checkoutButtonLocator).click();
        throw new PendingException();
    }

    @Then("I feel my card details and press pay button")
    public void i_feel_my_card_details_and_press_pay_button(DataTable cardDetailsTable) throws Throwable {
        cardDetails = new HashMap<String, String>();
        for (DataTableRow row : cardDetailsTable.getGherkinRows()) {
            dataForOrder.put(row.getCells().get(0), row.getCells().get(1));
        }
        cardDetails = cardDetailsTable.asMap(String.class, String.class);
        driver.findElement(cardNumberLocator).sendKeys(cardDetails.get("cardNumber"));
        driver.findElement(dueMonthLocator).sendKeys(cardDetails.get("mm"));
        driver.findElement(dueYearLocator).sendKeys(cardDetails.get("yy"));
        driver.findElement(cvvLocator).sendKeys(cardDetails.get("cvv"));
        driver.findElement(payButtonLocator).click();
        throw new PendingException();
    }


}