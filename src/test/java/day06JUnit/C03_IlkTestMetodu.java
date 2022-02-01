package day06JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IlkTestMetodu {
    WebDriver driver;

    @Test
    public void test01(){
      //amazon.com a gidelim ve title in amazon icerdigini test edelim
        driver.get("https:www.amazon.com");
       // System.out.println(driver.getTitle().contains("amazon")?"amazon testi PASS":"amazon testi FAILED");


        // JUnit ile yapsaydik
       // Assert.assertTrue(driver.getTitle().contains("amazon"));
    }
    @Test
    public void test02(){
       // google a gidelim ve basligin google icerdigini test edelim
        driver.get("https://www.google.com");
//Assert.assertTrue(driver.getTitle().contains("google"));
    }
@Before
public void ayarlariduzenle(){
    WebDriverManager.chromedriver().setup();

     driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();
}
@After
public void ortaligitopla(){
   driver.quit();
}
}
