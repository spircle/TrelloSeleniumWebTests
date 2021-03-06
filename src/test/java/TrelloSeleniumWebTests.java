import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TrelloSeleniumWebTests {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

    }
    @Test
    public void searchTest() throws InterruptedException {
        System.out.println("Trello opened");
        click(By.cssSelector("[href='/login']"));
        click(By.id("user"));
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("arturanisimov20031996@gmail.com");
        Thread.sleep(2000);
        click(By.className("atlassian-brand"));
        wd.findElement(By.id("name")).sendKeys("Artur Anisimov");
        click(By.id("password"));
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("pisikaka17153" + Keys.ENTER);
       click(By.id("login-button"));


        isAvatarPresent();

    }
    public void click(By locator){
        wd.findElement(locator).click();
    }
    public boolean isAvatarPresent() {
       return wd.findElements(By.xpath("//button[@data-test-id='header-member-menu-button']")).size() > 0;
             }

    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();
    }
}
