package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtonTest {

    /*
    1.Bir class oluşturun : RadioButtonTest
    2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    - https://www.facebook.com adresine gidin
    - “Create an Account” button’una basin
    - “radio buttons” elementlerini locate edin
    - Secili degilse cinsiyet butonundan size uygun olani secin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void createAccountButonu(){
        WebElement cerez= driver.findElement(By.xpath("//button[@id='u_0_h']"));
        cerez.click();
        WebElement createAcc= driver.findElement(By.id("u_0_2"));
        createAcc.click();
        WebElement man= driver.findElement(By.xpath("//input[@id='u_2_3']"));
        WebElement female= driver.findElement(By.xpath("//input[@id='u_2_2']"));
        WebElement custom= driver.findElement(By.xpath("//input[@id='u_2_4']"));

        if(!man.isSelected()){
            man.click();
        }
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }
}
