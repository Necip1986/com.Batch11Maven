package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Soru02 {

    /*
      1. http://zero.webappsecurity.com sayfasina gidin
      2. Signin buttonuna tiklayin
      3. Login alanine  “username” yazdirin
      4. Password alanine “password” yazdirin
      5. Sign in buttonuna tiklayin
      6. Pay Bills sayfasina gidin
      7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
      8. tarih kismina “2020-09-10”
      9. Pay buttonuna tiklayin
      10. “The payment was successfully submitted.” mesajinin ciktigini control edin
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.navigate().to("http://zero.webappsecurity.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //2. Signin buttonuna tiklayin
        WebElement signInButonu= driver.findElement(By.xpath("//button[@id='signin_button']"));
        signInButonu.click();

        //3. Login alanine  “username” yazdirin
        WebElement loginKutusu= driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutusu.sendKeys("username");

        //4. Password alanine “password” yazdirin
        WebElement passwordKutusu= driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordKutusu.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        WebElement signInTikla= driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        signInTikla.click();

        //6. Pay Bills sayfasina gidin
        WebElement payBillsLinki= driver.findElement(By.linkText("Pay Bills"));
        payBillsLinki.click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountKutusu= driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amountKutusu.sendKeys("2000");

        // 8. tarih kismina “2020-09-10”
        WebElement tarihKutusu= driver.findElement(By.xpath("//input[@id='sp_date']"));
        tarihKutusu.sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        WebElement payButonu= driver.findElement(By.id("pay_saved_payees"));
        payButonu.click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesaj= driver.findElement(By.xpath("//span[@title='$ 2000 payed to payee sprint']"));
        String actualMesaj=mesaj.getText();
        String expextedMesaj="The payment was successfully submitted.";

        if(actualMesaj.equals(expextedMesaj)){
            System.out.println("'The payment was successfully submitted.' mesaji gorunuyor mu Testi PASS");
        }else{
            System.out.println("'The payment was successfully submitted.' mesaji gorunuyor mu Testi FAILED");
        }

        driver.close();

    }
}
