package OnlineStoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressesPages {
    private WebDriver driver;

    public AddressesPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "alias")
    private WebElement aliasInput;
    @FindBy(name = "address1")
    private WebElement addressInput;
    @FindBy(name = "city")
    private WebElement cityInput;
    @FindBy(name = "postcode")
    private WebElement postCodeInput;
    @FindBy(name = "phone")
    private WebElement phoneInput;
    @FindBy(name = "id_country")
    private WebElement roleDropCountry;
    @FindBy(css = ".btn.btn-primary.float-xs-right")
    private WebElement saveButton;

    public void setAlias(String alias) {
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    public void setAddress(String address) {
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void setPostCodeInput(String postCode) {
        postCodeInput.click();
        postCodeInput.clear();
        postCodeInput.sendKeys(postCode);
    }

    public void setCityInput(String city) {
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void roleDropCountry(String country) {
        Select drop = new Select(roleDropCountry);
        drop.selectByVisibleText(country);
    }

    public void setPhoneInput(String phone) {
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public String getAliasCheck() {
        return aliasInput.getAttribute("value");
    }

    public String getAddressCheck() {
        return addressInput.getAttribute("value");
    }

    public String getCityCheck() {
        return cityInput.getAttribute("value");
    }

    public String getPostCodeCheck() {
        return postCodeInput.getAttribute("value");
    }

   // public String getCountryCheck() {
  //     Select drop = new Select(roleDropCountry);
  //     return drop.getFirstSelectedOption().getText();
  //  }

    public String getPhoneCheck() {
        return phoneInput.getAttribute("value");
    }
}
