package Login;

import OnlineStoryPages.LoginPage;
import OnlineStoryPages.UserAddressesPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import OnlineStoryPages.AddressesPages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private AddressesPages addressesPage;
    private UserAddressesPages userAddressPage;

    @Given("^User is logged to online shop and user goes to his AccountPage$")
    public void userIsLoggedInToTheShop() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("bokro1967@wp.pl", "testek1");

        Assert.assertEquals("Testek Testowicz", loginPage.getLoggedUsername());
    }

    @When("^User goes to NewAddressPage$")
    public void userGoesToNewAddressPage() {
        UserAddressesPages yourAddressPage = new UserAddressesPages(driver);
        yourAddressPage.clickCreateAddressButton();
    }

    @And("^User entered <alias>, <address>, <city>, <postcode>, <country>, <phone> on your address page$")
    public void userEnteredAliasAddressCityPostcodeCountryPhoneOnYourAddressPage
            (String alias, String address, String city, String postcode, String country, String phone) {
        this.addressesPage = new AddressesPages(driver);
        addressesPage.setAlias(alias);
        Assert.assertEquals("YNWA", addressesPage.getAliasCheck());
        addressesPage.setAddress(address);
        Assert.assertEquals("Anfield Rd", addressesPage.getAddressCheck());
        addressesPage.setCityInput(city);
        Assert.assertEquals("Liverpool", addressesPage.getCityCheck());
        addressesPage.setPostCodeInput(postcode);
        Assert.assertEquals("L4 0TH", addressesPage.getPostCodeCheck());
        //addressesPage.roleDropCountry(country);
        //Assert.assertEquals("United Kingdom", addressesPage.getCountryCheck());
        addressesPage.setPhoneInput(phone);
        Assert.assertEquals("+441512642222", addressesPage.getPhoneCheck());
    }

    @Then("^User create new address page$")
    public void userCreateNewAddressPage() {
        addressesPage.clickSaveButton();
    }


    @And("^Close browser$")
    public void tearDown() {
        //driver.quit();
    }

}