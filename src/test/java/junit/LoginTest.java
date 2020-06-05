package junit;

import OnlineStoryPages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

    }

    @Test
    public void testLoginWithPropoerCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productProductPage = new ProductPage(this.driver);
        loginPage.loginAs("bokro1967@wp.pl", "testek1");
        Assert.assertEquals("Testek Testowicz", loginPage.getLoggedUsername());

        driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/article[2]/div/div[1]/h3/a")).click();

        productProductPage.setProductSize("M");
        productProductPage.setProductQuantity("5");
        productProductPage.setAddtoBasket();
        productProductPage.setProceedToCheckout();
        productProductPage.setProceedToCheckout2();
        productProductPage.setContinueButton();
        productProductPage.setConfirmDelivery();
        productProductPage.setPaymentMethod();
        productProductPage.setConditionsToApprove();
        productProductPage.setOrderButton();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("/home/bogdan/Pictures/screen.png"));
        } catch (Exception e) {
            System.out.println("Nie udało się zapisać");
        }

    }

    @After
    public void tearDown() {


    }
}

