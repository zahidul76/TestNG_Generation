package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFunctionality {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        System.out.println("Opens Browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }
  @Test(priority = 1,dependsOnGroups = {"sanity","regression"})
    public void logInTest()
    {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
        System.out.println("Login Success");
        Assert.assertEquals(3,3);
    }
    @Test(priority = 2 , dependsOnMethods = {"logInTest"})
    public void logOut(){
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
        System.out.println("LogOut Success");
        Assert.assertEquals(9,9);

    }

    @Test(priority = 3)
    public void titleTest(){
        System.out.println("The Title is:");
    }



    @AfterTest
    public void tearDown(){
        driver.quit();
        System.out.println("Closes Browser");
    }

}
