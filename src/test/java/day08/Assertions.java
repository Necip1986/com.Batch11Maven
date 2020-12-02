package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertions {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }

    @Test
    public void pozitifTest(){
        String accTitle=driver.getTitle();
        String expTitle="Amazonx";
        /*
        if(accTitle.equals(expTitle)){
            System.out.println("Title Testi PASS");
        }else{
            System.out.println("Title Testi FAILED");
        }
        */

        //Sayfa basliginin "Amazonx" icerdigini dogrulayin
        //2.yol
        Assert.assertTrue(accTitle.contains(expTitle));
        System.out.println("Bu yazi yazilacak mi"); //assert hata verince bu calismadi. Herhangi bir assertion
                                                    //failed olursa bulunulan testin calismasi biter. Siradaki teste gecer
                                                   //bu satir calismaz
    }
    @Test
    public void negatifTest(){
        //Sayfa basliginin "Mehmet icermedigini dogrulayin
        String accTitle=driver.getTitle();
        String expeTitle="Mehmet";
        Assert.assertFalse(accTitle.contains("Mehmet"));
    }
    @Test
    public void equalsTest(){
        //Sayfa basliginin "" oldugunu dogrulayiniz
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        String expecTitle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        Assert.assertEquals(actualTitle,expecTitle);
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
