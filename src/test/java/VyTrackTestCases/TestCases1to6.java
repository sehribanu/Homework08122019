package VyTrackTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebBrowserFactory;

public class TestCases1to6 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        //browser setup as Firefox
        WebDriver driver= WebBrowserFactory.getDriver("firefox");
        driver.get("https://qa1.vytrack.com/");
        driver.manage().window().maximize();


        //locate username box and give the username input
        WebElement usernameBox=driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys("storemanager85");

        //locate password box and give the password input
        WebElement passwordBox=driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");

        //locate Log in button and click
        WebElement loginButton=driver.findElement(By.id("_submit"));
        loginButton.click();
    }
    @Test
    public void testCase01() throws InterruptedException {

        //Navigate to “Activities -> Calendar Events”
        WebElement activities=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span"));
        WebElement calendarEvents=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]/a/span"));
        calendarEvents.click();

        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(activities));



        Actions actions=new Actions(driver);
        actions.moveToElement(activities).clickAndHold().moveToElement(calendarEvents).release().build().perform();

       System.out.println("Hello from github")



    }





}
