package deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Deneme1 {
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
        WebDriver driver=new ChromeDriver();

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi= driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucSayisi.getText());

        //5- Ilk urunu tiklayalim
        WebElement ilkUrun= driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        ilkUrun.click();
        driver.navigate().back();

        //6- Sayfadaki tum basliklari yazdiralim
        List<WebElement>basliklar= driver.findElements(By.tagName("//h1"));
        System.out.println("Sayfadaki Basliklar:");
        for(WebElement w:basliklar){
            System.out.println(w.getText());
        }



    }
}
