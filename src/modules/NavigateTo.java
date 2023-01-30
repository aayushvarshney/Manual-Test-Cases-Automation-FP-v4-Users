package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigateTo {

    public static WebElement User(WebDriver driver) {

        WebElement element1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/ul/li[3]/a"));
        return element1;

    }

    public static WebElement ClientPill(WebDriver driver) {

        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"tabs-wrapper\"]/div[2]"));
        return element2;

    }
}
