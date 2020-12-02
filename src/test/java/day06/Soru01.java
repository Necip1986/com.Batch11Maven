package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Soru01 {
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

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

       // 2- https://www.walmart.com/ adresine gidin
        driver.navigate().to("https://www.walmart.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        // 4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        String actualTitle=driver.getTitle();
        String expectedTitleIceriyormu="Save";
        if(actualTitle.contains(expectedTitleIceriyormu)){
            System.out.println("Sayfa basligi Save iceriyor mu testi PASS");
        }else{
            System.out.println("Sayfa basligi Save iceriyor mu testi FAILED");
        }

        // 6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        String expectedTitle="Walmart.com | Save Money.Live Better";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Sayfa basligi Walmart.com | Save Money.Live Better'a esit mi testi PASS ");
        }else{
            System.out.println("Sayfa basligi Walmart.com | Save Money.Live Better'a esit mi testi FAILED ");
            System.out.println("Actuel Title: "+actualTitle);
            System.out.println("Expected Title: "+expectedTitle);
        }

        //7-URL'in walmart.com icerdigini control edin

        String actualUrl=driver.getCurrentUrl();
        if(actualUrl.contains("walmart.com")){
            System.out.println("Sayfa URL'si 'walmart.com' iceriyor mu testi PASS");
        }else{
            System.out.println("Sayfa URL'si 'walmart.com' iceriyor mu testi FAILED");
        }

        //8-”Nutella” icin arama yapiniz
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='global-search-input']"));
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        //9- Kac sonuc bulundugunu yaziniz
        WebElement aramaSonuc= driver.findElement(By.xpath("//div[@class='result-summary-container']"));
        System.out.println(aramaSonuc.getText());

        // 10-Sayfayi kapatin
        driver.close();


    }
}
