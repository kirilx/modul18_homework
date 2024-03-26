import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptLogIn {
    @Test
    public void javaScripLogInButton () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameBox = driver.findElement(By.cssSelector("#username"));
        usernameBox.sendKeys("tomsmith");
        WebElement passwordBox = driver.findElement(By.cssSelector("#password"));
        passwordBox.sendKeys("SuperSecretPassword!");
        WebElement logiInButton = driver.findElement(By.cssSelector(".radius"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logiInButton);


        WebElement successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        String successText = successMessage.getText();
        Assert.assertTrue(successText.contains("You logged into a secure area!"), "Login was not successful");


    }
}
