import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptLogIn {
    @Test
    public void javaScripLogInButton() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameBox = driver.findElement(By.cssSelector("#username"));
        WebElement passwordBox = driver.findElement(By.cssSelector("#password"));

        usernameBox.sendKeys("tomsmith");
        passwordBox.sendKeys("SuperSecretPassword!");

        WebElement logiInButton = driver.findElement(By.cssSelector(".radius"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logiInButton);


        WebElement successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        String successText = successMessage.getText();
        Assert.assertTrue(successText.contains("You logged into a secure area!"), "Login was not successful");


    }

    @Test
    public void javaScroll() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

       // JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement usernameField = driver.findElement(By.cssSelector("[type=text]"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type=password]"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[type=submit]"));
        loginButton.click();

        driver.manage().window().setSize(new Dimension(800,720));

        WebElement redShirt = driver.findElement(By.linkText("Test.allTheThings() T-Shirt (Red)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",redShirt);


        Assert.assertEquals(redShirt.getText(),"Test.allTheThings() T-Shirt (Red)");
    }
}