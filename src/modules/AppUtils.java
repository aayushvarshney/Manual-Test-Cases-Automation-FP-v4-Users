import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppUtils {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver_win32/chromedriver.exe");
//        WebDriver driver=new ChromeDriver();

        WebDriver driver = new ChromeDriver();
        driver.get("https://neverland.freshprints.com/");

        List<WebElement> elements = driver.findElements(By.className("center-inner-div"));
        int elementsCount = elements.size();
        System.out.println("Total Number of Elements : " + elementsCount);

//        driver.quit();
    }
}