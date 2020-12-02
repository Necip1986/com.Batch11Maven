package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstMavenClass {

    /*
       Class Work Amazon Search Test
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement searchKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchKutusu.sendKeys("Samsung headphones");
        searchKutusu.submit();

        WebElement bulunanSonuc=driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(bulunanSonuc.getText());

        WebElement ilkUrun= driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        ilkUrun.click();



    }

}
