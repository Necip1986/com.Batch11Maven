package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Soru03 {
    /*
      1. “https://www.saucedemo.com” Adresine gidin
      2. Username kutusuna “standard_user” yazdirin
      3. Password kutusuna “secret_sauce” yazdirin
      4. Login tusuna basin
      5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
      6. Add to Cart butonuna basin
      7. Alisveris sepetine tiklayin
      8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
      9. Sayfayi kapatin
     */

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //2. Username kutusuna “standard_user” yazdirin
        WebElement userNameKutusu= driver.findElement(By.id("user-name"));
        userNameKutusu.sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordKutusu= driver.findElement(By.cssSelector("input[id='password'"));
        passwordKutusu.sendKeys("secret_sauce");

        //4. Login tusuna basin
        WebElement loginKutusu= driver.findElement(By.id("login-button"));
        loginKutusu.click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun= driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrunIsmi=ilkUrun.getText();
        System.out.println("Ilk Urunun Ismi: "+ilkUrunIsmi);
        ilkUrun.click();

        //6. Add to Cart butonuna basin
        WebElement addToChart= driver.findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[1]"));
        addToChart.click();

        //7. Alisveris sepetine tiklayin
        WebElement chartBox= driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']"));
        chartBox.click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement secilenUrun= driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String sepettekiUrun=secilenUrun.getText();

        if(ilkUrunIsmi.equals(sepettekiUrun)){
            System.out.println("Secilen urun sepete eklendi mi Testi PASS");
            System.out.println("Sepetteki Urun: "+sepettekiUrun);
        }else{
            System.out.println("Secilen urun sepete eklendi mi Testi FAILED");
        }
        
        //9. Sayfayi kapatin
        driver.close();

    }
}
