package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLogin {

    public static WebElement loginEmail(WebDriver driver) {

        WebElement element=driver.findElement(By.id("form-email"));
        return element;

    }
    public static WebElement loginPassword(WebDriver driver) {

        WebElement element=driver.findElement(By.id("form-password"));
        return element;

    }

    public static WebElement loginButton(WebDriver driver) {

        WebElement element = driver.findElement(By.xpath("/html/body/div[4]/div/div/form/div/div[5]/div/button"));
        return element;

    }

}
