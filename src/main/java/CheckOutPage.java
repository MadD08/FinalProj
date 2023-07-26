import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage{

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


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
}
