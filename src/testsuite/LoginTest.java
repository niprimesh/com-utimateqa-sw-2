/**
 * write following test in to 'LoginTest' class
 * create login in diffrent method to login successfully
 * verify the test 'welcome back!'
 * create method named 'verifyTheErrorMessage'
 * create another method for invalid credentials and
 * VERIFY CAPTCHA MANUALLY
 * verify error message' Invalid email or password'
 */


package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/"; //set baseUrl

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        String expected = "Welcome Back!";
        String actual = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]")).getText();
        Assert.assertEquals(expected, actual);
        Thread.sleep(2000);
    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {
        WebElement signInLink = driver.findElement(By.partialLinkText("Sign"));
        Thread.sleep(2000);
        signInLink.click();
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("Prime123@gmail.com");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Prime123");
        Thread.sleep(2000);

        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]"));
        signInButton.click();
        Thread.sleep(2000);

        String expectedText = "Invalid email or password";
        WebElement actualText = driver.findElement(By.className("form-error__list-item"));
        String actualResult = actualText.getText();

        Assert.assertEquals(expectedText, actualResult);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}