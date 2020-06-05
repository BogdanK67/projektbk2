package junit;

import OnlineStoryPages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        
   //     public static List<String> productSize = Arrays.asList("S,", "M", "L", "XL");
  //      static int size =1;
        
        productProductPage.setProductSize("M");
        productProductPage.setProductQuantity("5");
        productProductPage.setAddtoBasket();
        
        //productProductPage("5");
    }

    //private void productProductPage(String s) {
    

    @After
    public void tearDown() {


    }
}

