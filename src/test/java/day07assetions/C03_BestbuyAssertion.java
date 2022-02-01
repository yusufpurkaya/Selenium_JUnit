package day07assetions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestbuyAssertion {
    //1) Bir class oluşturun: BestBuyAssertions

    WebDriver driver;
@Test
    public void test01(){
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com");
        //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    Assert.assertEquals("https://www.bestbuy.com/",driver.getCurrentUrl());
    //Assert.assertEquals("Lutfen test degerlerini gozden gecirin ",driver.getCurrentUrl(),"https://www.bestbuy.com/");
     // istesek basina not ta yazabiliridk be testFAILED olunca bu mesaj gorunur

    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    String actuelTitle=driver.getTitle();
    String expectedTitle="Rest";
    Assert.assertFalse(actuelTitle.contains(expectedTitle));// neden false kullandik cunku zaten icermesin istiyoz

        //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    WebElement logo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
    Assert.assertTrue("logo gorun medi",logo.isDisplayed());
        //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
WebElement francais=driver.findElement(By.xpath("//button[text()='Français']"));
Assert.assertTrue("fransizca secenegi gorunmuyor",francais.isDisplayed());
    }




    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().window().maximize();
    }
@After
    public void teardown(){
        driver.close();
}

}
