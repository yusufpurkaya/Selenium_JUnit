package day07assetions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02RadioButtons {
//https://www.facebook.com adresine gidin
//Cookies’i kabul edin





static WebDriver driver;
@Test
public void test01(){
    driver.get("https://www.facebook.com");
    //“Create an Account” button’una basin
    driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
//“radio buttons” elementlerini locate edin


WebElement radioButton=driver.findElement(By.xpath("//input[@value='2']"));
radioButton.click();
    //Secili degilse cinsiyet butonundan size uygun olani secin
    if (!radioButton.isSelected()){
        radioButton.click();
    }
}

 @Before
 public void setup(){
     WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 }
@After
    public void teardown(){
   driver.close();
}



}
