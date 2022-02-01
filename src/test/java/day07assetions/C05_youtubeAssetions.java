package day07assetions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class C05_youtubeAssetions {
    //1) Bir class oluşturun: YoutubeAssertions
 static WebDriver driver;

    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin

    @Test
    public void titleTest(){
        //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertEquals("YouTube",driver.getTitle());
    }

    @Test
    public void imagetest(){
        //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin

    }

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
@AfterClass
    public static void teardown(){

    }



}
