package junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "group_1")
    private WebElement sizeofProduct;

    @FindBy(id = "quantity_wanted")
    private WebElement productQuantity;

    @FindBy(css = "#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button")
    private WebElement AddToBasket;

    @FindBy(css = "#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a")
    private WebElement ProceedToCheckout;

    @FindBy(css = "#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.card-block > div > a")
    private WebElement ProceedToCheckout2;

    @FindBy(name = "confirm-addresses")
    private WebElement ContinueButton;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement ConfirmDelivery;

    @FindBy(id = "payment-option-1")
    private WebElement PaymentMethod;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement ConditionsToApprove;

    @FindBy(css = "#payment-confirmation > div.ps-shown-by-js > button")
    private WebElement OrderButton;

    @FindBy(xpath = "//div[@class='current-price']/span")
    private WebElement currentPriceElement;

    @FindBy(xpath = "//span[@class='regular-price']")
    private WebElement regularPriceElement;


    @FindBy(xpath = "//span[contains(@class, 'discount-percentage')]")
    private WebElement discountPercentageElement;


    public void setProductSize(String size) {
        sizeofProduct.click();
        sizeofProduct.sendKeys(size);
    }


    public void setProductQuantity(String quantity) {
        productQuantity.clear();
        productQuantity.sendKeys(quantity);


    }

    public void setAddtoBasket() {
        AddToBasket.click();


    }

    public void setProceedToCheckout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ProceedToCheckout.click();
    }

    public void setProceedToCheckout2() {
        ProceedToCheckout2.click();
    }

    public void setContinueButton() {
        ContinueButton.click();
    }

    public void setConfirmDelivery() {
        ConfirmDelivery.click();
    }

    public void setPaymentMethod() {
        PaymentMethod.click();
    }

    public void setConditionsToApprove() {
        ConditionsToApprove.click();
    }

    public void setOrderButton() {
        OrderButton.click();
    }

    public double getCurrentPrice() {
        String stringCurrentPrice = currentPriceElement.getAttribute("content");
        return Double.parseDouble(stringCurrentPrice);

    }


    public double getRegularPrice() {
        String stringRegularPrice = regularPriceElement.getText().substring(1);
        return Double.parseDouble(stringRegularPrice);

    }


    public double getDiscountValue() {
        String discountValue = discountPercentageElement.getText();

        // split dzieli nam napis "SAVE 20%" na tablicę ["SAVE", "20%"]
        String percentage = discountValue.split(" ")[1];

        // odetnij ostatni znak (%) ze stringa
        percentage = percentage.substring(0, percentage.length() - 1);
        return Double.parseDouble(percentage) / 100;

    }

}
