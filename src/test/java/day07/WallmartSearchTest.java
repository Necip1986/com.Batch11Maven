package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WallmartSearchTest {
    /*
    1-Test01 isimli bir class olusturun
    2- https://www.walmart.com/ adresine gidin
    3- Browseri tam sayfa yapin
    4-Sayfayi “refresh” yapin
    5- Sayfa basliginin “Save” ifadesi icerdigini control edin
    6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
    7- URL in walmart.com icerdigini control edin
    8-”Nutella” icin arama yapiniz
    9- Kac sonuc bulundugunu yaziniz
    10-Sayfayi kapatin
     */

   static WebDriver driver;

    @BeforeClass
    public static void setUp(){ //ilk ayarlari yaptik
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.walmart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void titleSaveArama(){
        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        String actualTitle=driver.getTitle();
        String expectedTitleIceriyormu="Save";
        if(actualTitle.contains(expectedTitleIceriyormu)){
            System.out.println("Sayfa basligi Save iceriyor mu testi PASS");
        }else{
            System.out.println("Sayfa basligi Save iceriyor mu testi FAILED");
        }
    }
    @Test
    public void titleEsitMi(){
        // 6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        String actualTitle=driver.getTitle();
        String expectedTitle="Walmart.com | Save Money.Live Better";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Sayfa basligi Walmart.com | Save Money.Live Better'a esit mi testi PASS ");
        }else{
            System.out.println("Sayfa basligi Walmart.com | Save Money.Live Better'a esit mi testi FAILED ");
            System.out.println("Actuel Title: "+actualTitle);
            System.out.println("Expected Title: "+expectedTitle);
        }
    }
    @Test
    public void urlTesti(){
        //7-URL'in walmart.com icerdigini control edin

        String actualUrl=driver.getCurrentUrl();
        if(actualUrl.contains("walmart.com")){
            System.out.println("Sayfa URL'si 'walmart.com' iceriyor mu testi PASS");
        }else{
            System.out.println("Sayfa URL'si 'walmart.com' iceriyor mu testi FAILED");
        }
    }
    @Test
    public void nutellaTesti(){
        //8-”Nutella” icin arama yapiniz

        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='global-search-input']"));
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        //9- Kac sonuc bulundugunu yaziniz
        WebElement aramaSonuc= driver.findElement(By.xpath("//div[@class='result-summary-container']"));
        System.out.println(aramaSonuc.getText());
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
