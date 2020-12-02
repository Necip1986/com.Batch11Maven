package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Homework {
    /*
     1) Bir class oluşturun: YoutubeAssertions
     2) https://www.youtube.com adresine gidin
     3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri 	yapin
	    titleTest => Sayfa başlığının “YouTube” oldugunu test edin
	    imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
	    Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        wrongTitleTest=> Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");

    }
    @Test
    public void titleTest(){
        String actualTitle=driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void imageTest(){
        WebElement uyari1= driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope yt-button-renderer style-text size-small']"));
        uyari1.click();

        WebElement uyari2= driver.findElement(By.xpath("(//div[@class='ZFr60d CeoRYc'])[3]"));
        uyari2.click();

        WebElement image= driver.findElement(By.xpath("(//div[@id='logo-icon-container'])[1]"));
        Assert.assertTrue(image.isDisplayed());
    }
    @Test
    public void searchBox(){
        WebElement searchBox= driver.findElement(By.xpath("//div[@id='search-container']"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        String actualTitle= driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertFalse(actualTitle.equals(expectedTitle));

    }

    @AfterClass
    public static void tearDown(){
       driver.quit();

    }

}
