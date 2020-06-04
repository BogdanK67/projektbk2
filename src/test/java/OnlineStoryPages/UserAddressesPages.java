package OnlineStoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAddressesPages {
    public UserAddressesPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div[4]/a/span")
    private WebElement createAddressButton;

    public void clickCreateAddressButton() {
        createAddressButton.click();
    }
}

