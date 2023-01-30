import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import modules.AdminLogin;
import modules.NavigateTo;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SampleProject {
    public static void main(String[] args) throws InterruptedException {

        // Debugging statement for Selenium Start-up
        System.out.println("Selenium starting up!");

        // Setting Chrome Driver OS Path
        System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver_win32/chromedriver.exe");
        // Creating a new object for the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximising the browser window
        driver.manage().window().maximize();

        // Pinging the Target V4-FP
        driver.get("https://neverland.freshprints.com/");


        //Created AdminLogin class for Better Management
        AdminLogin.loginEmail(driver).sendKeys("interns2022@freshprints.com");
        AdminLogin.loginPassword(driver).sendKeys("interns2022");
        AdminLogin.loginButton(driver).click();

        // Creating NavigateTo class for Navigations in FP V4
        NavigateTo.User(driver).click();

        //Added Wait for UI to fully load
        Thread.sleep(5000);

        // Test Case #1

        // Getting the title of the browser tab
        String titleBarName=driver.getTitle();

        // Verifying the title of the browser tab
        if(titleBarName.equals("Users || OMS || Fresh Prints"))
            System.out.println("Test Case 1 : Passed ✅");
        else
            System.out.println("Test Case 1 : Failed ❌");


        // Test Case #2

        // Creating a List Data Structure to hold all elements of particular class
        List<WebElement> elements = driver.findElements(By.className("tabs__tab"));

        // Getting size of the list DS
        int elementsCount = elements.size();

        //Checking all 8 pills appearance
        if(elementsCount == 8)
            System.out.println("Test Case 2 : Passed ✅");
        else
            System.out.println("Test Case 2 : Failed ❌");


        // Test Case #3

        // Creating a List Data Structure to hold all elements of a particular class
        List<WebElement> countPills = driver.findElements(By.className("tabs__count"));

        // Getting size of the list DS
        int numbersCount = countPills.size();

        // Checking 7 counts appearing on Pills
        if(numbersCount == 7)
            System.out.println("Test Case 3 : Passed ✅");
        else
            System.out.println("Test Case 3 : Failed ❌");


        // Test Case #4

        // Getting the UserName text on NavBar
        String userName=driver.findElement(By.xpath("//span[@id='userdropdown-info']")).getAttribute("innerHTML");

        // Verifying if it matches with what expected
        if("Fp Interns".equals(userName))
            System.out.println("Test Case 4 : Passed ✅");
        else
            System.out.println("Test Case 4 : Failed ❌");


        // Test Case #5

        // Navigating to Client Pill by NavigateTo Class
        NavigateTo.ClientPill(driver).click();

        // Added Wait for Changes to take place
        Thread.sleep(5000);

        // Getting the text for Active Pill
        String pillActive=driver.findElement(By.xpath("//*[@id=\"tabs-wrapper\"]/div[2]/div")).getText();

        //Verifying if Client pill got active
        if(pillActive.contains("Client"))
            System.out.println("Test Case 5 : Passed ✅");
        else
            System.out.println("Test Case 5 : Failed ❌");


        // Test Case #6

        // Navigating to Create User Button (+)
        driver.findElement(By.xpath("//*[@id=\"sticky-search-filter\"]/div[2]/app-button/button/img")).click();

        // Selecting Admin for New User Creation
        driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/app-wizard-create-select/div/div[1]")).click();

        // Filling Required Details for the Form Corner Case Checks
        driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/div[1]/app-admin/div/div/aw-wizard/div/aw-wizard-step[1]/div/div[3]/app-contact-info/div/div[1]/div[2]/app-input/div/input")).sendKeys("Aayush");
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. +1(917)720-7465\"]")).sendKeys("9999999999");
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. abram@gmail.com\"]")).sendKeys("aayush@qa.com");

            // Verifying if Full Name Warning is displayed
            try {
                driver.findElement(By.xpath("//*[contains(text(),' What’s your full name? ')]"));
                System.out.println("Test Case 6 : Passed ✅");
            } catch (Exception e) {
                System.out.println("Test Case 6 : Failed ❌");
            }

        // Test Case #7

            // Exiting New User Pop-Up
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[1]/i")).click();
            driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")).click();

            // Navigating to New User Pop-Up
            driver.findElement(By.xpath("//*[@id=\"sticky-search-filter\"]/div[2]/app-button/button/img")).click();
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/app-wizard-create-select/div/div[1]")).click();

            // Filling Required Details for the Form Corner Case Checks
            driver.findElement(By.xpath("//*[@id=\"null\"]")).sendKeys("Aayush Varshney");
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. +1(917)720-7465\"]")).sendKeys("999999");
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. abram@gmail.com\"]")).sendKeys("aayush@qa.com");

            // Verifying if Mobile Number length warning is displaying
            try {
                driver.findElement(By.xpath("//*[contains(text(),'spam calls')]"));
                System.out.println("Test Case 7 : Passed ✅");
            } catch (Exception e) {
                System.out.println("Test Case 7 : Failed ❌");
            }


        // Test Case #8

            // Exiting New User Pop-Up
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[1]/i")).click();
            driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")).click();
            // Navigating to New User Pop-Up
            driver.findElement(By.xpath("//*[@id=\"sticky-search-filter\"]/div[2]/app-button/button/img")).click();
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/app-wizard-create-select/div/div[1]")).click();

            // Filling Required Details for the Form Corner Case Checks
            driver.findElement(By.xpath("//*[@id=\"null\"]")).sendKeys("Aayush Varshney");
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. abram@gmail.com\"]")).sendKeys("invalidEmail/qa.com");
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. +1(917)720-7465\"]")).sendKeys("9999999999");

            // Verifying if invalid e-mail warnings are getting displayed
            try {
                driver.findElement(By.xpath("//*[contains(text(),'valid email')]"));
                System.out.println("Test Case 8 : Passed ✅");
            } catch (Exception e) {
                System.out.println("Test Case 8 : Failed ❌");
            }


        // Test Case #9

            // Exiting New User Pop-Up
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[1]/i")).click();
            driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")).click();

            // Navigating to New User Pop-Up
            driver.findElement(By.xpath("//*[@id=\"sticky-search-filter\"]/div[2]/app-button/button/img")).click();
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/app-wizard-create-select/div/div[1]")).click();

            // Filling Required Details for the Form Corner Case Checks
            driver.findElement(By.xpath("//*[@id=\"null\"]")).sendKeys("Number in Full Name 123");
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. +1(917)720-7465\"]")).sendKeys("9999999999");
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. abram@gmail.com\"]")).sendKeys("aayush@qa.com");

            // Verifying if Invalid Full Name warning is displayed
            try {
                driver.findElement(By.xpath("//*[contains(text(),' What’s your full name? ')]"));
                System.out.println("Test Case 9 : Passed ✅");
            } catch (Exception e) {
                System.out.println("Test Case 9 : Failed ❌");
            }


        // Test Case #10

            // Exiting New User Pop-Up
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[1]/i")).click();
            driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")).click();

            // Navigating to New User Pop-Up
            driver.findElement(By.xpath("//*[@id=\"sticky-search-filter\"]/div[2]/app-button/button/img")).click();
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/app-wizard-create-select/div/div[1]")).click();

            // Filling Required Details for the Form Corner Case Checks
            driver.findElement(By.xpath("//*[@id=\"null\"]")).sendKeys("Aayush Varshney");
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. +1(917)720-7465\"]")).sendKeys("trying text in mobile number");
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. abram@gmail.com\"]")).sendKeys("aayush@fp.com");

            // Verifying if Mobile number is not containing any text
            try {
                driver.findElement(By.xpath("//*[contains(text(),'spam calls')]"));
                System.out.println("Test Case 10 : Passed ✅");
            } catch (Exception e) {
                System.out.println("Test Case 10 : Failed ❌");
            }


        // Test Case #11

            // Exiting New User Pop-Up
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[1]/i")).click();
            driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")).click();

            // Navigating to New User Pop-Up
            driver.findElement(By.xpath("//*[@id=\"sticky-search-filter\"]/div[2]/app-button/button/img")).click();
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/app-wizard-create-select/div/div[1]")).click();

            // Filling Required Details for the Form Corner Case Checks
            driver.findElement(By.xpath("//*[@id=\"null\"]")).sendKeys("Duplicate e-mail testing");
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. +1(917)720-7465\"]")).sendKeys("9999999999");

            // Already Used e-mail entered
            driver.findElement(By.xpath("//input[@placeholder=\"e.g. abram@gmail.com\"]")).sendKeys("aayush@fp.com");
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/div[1]/app-admin/div/div/aw-wizard/div/aw-wizard-step[1]/div/div[3]/app-button/button")).click();

            // Entering Dummy Password
            driver.findElement(By.xpath("//input[@placeholder=\"Enter password\"]")).sendKeys("qwerty");
            driver.findElement(By.xpath("//input[@placeholder=\"Confirm password\"]")).sendKeys("qwerty");

            // Pressing Submit Button
            driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/div[1]/app-admin/div/div/aw-wizard/div/aw-wizard-step[2]/div/div[2]/div/div[3]/app-button/button")).click();

            // Warning issue wait time fur duplicate e-mail
            Thread.sleep(5000);

            // Verifying if warning got displayed on entering duplicate e-mail
            try {
                driver.findElement(By.xpath("//*[contains(text(),'exists')]"));
                System.out.println("Test Case 11 : Passed ✅");
            } catch (Exception e) {
                System.out.println("Test Case 11 : Failed ❌");
            }


        // quitting driver and closing connection
//        driver.quit();
    }
}