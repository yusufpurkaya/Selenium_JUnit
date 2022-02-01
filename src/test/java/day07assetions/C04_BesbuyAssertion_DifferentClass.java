package day07assetions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BesbuyAssertion_DifferentClass {






    //1) Bir class oluşturun: BestBuyAssertions

   static WebDriver driver;
    @Test
    public void urltesti(){

        //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        Assert.assertEquals("https://www.bestbuy.com/",driver.getCurrentUrl());
        //Assert.assertEquals("Lutfen test degerlerini gozden gecirin ",driver.getCurrentUrl(),"https://www.bestbuy.com/");
        // istesek basina not ta yazabiliridk be testFAILED olunca bu mesaj gorunur



    }
    @Test
    public void titletesti(){

        //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actuelTitle=driver.getTitle();
        String expectedTitle="Rest";
        Assert.assertFalse(actuelTitle.contains(expectedTitle));// neden false kullandik cunku zaten icermesin istiyoz

    }
    @Test
    public void logotesti(){
        //		○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue("logo gorun medi",logo.isDisplayed());
    }

    @Test
    public void linktesti(){
        //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francais=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue("fransizca secenegi gorunmuyor",francais.isDisplayed());
    }




    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }


}
