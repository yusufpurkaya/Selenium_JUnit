package day06JUnit;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class C05 {

static WebDriver driver;
static WebElement searchBox;

    //● https://www.amazon.com/ adresine gidin.

    //            - Test 1
//    Arama kutusunun yanindaki kategori menusundeki kategori
//    sayisinin 45 oldugunu test edin
@Test
public  void test01(){
List<WebElement> kategori=driver.findElements(By.xpath("//select[@id='searchDropdownBox']"));
int actuelKategoriSayısı= kategori.size();
int istenen=45;
    System.out.println(actuelKategoriSayısı==istenen?"Kategori Sayisi Testi PASSED":"Kategori Sayisi Testi FAILED");
}

//-Test 2
//            1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin
@Test
    public void test02(){
 WebElement books=   driver.findElement(By.xpath("//option[text()='Books']"));
books.click();
searchBox=driver.findElement(By.id("twotabsearchtextbox"));
searchBox.sendKeys("Java"+ Keys.ENTER);

WebElement sonucYazisi=driver.findElement(By.xpath("//span[text()='1-16 of over 30,000 results for']"));
    String sonuc=sonucYazisi.getText();
    String sonucArr[]=sonuc.split(" ");
    System.out.println(sonucArr[3]);
    System.out.println(sonuc.contains("Java")?"sonucda Java arama testi PASS":"sonucda Java arama testi FAILED");
}
@BeforeClass
public static void ilk(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.navigate().to("https://www.amazon.com");
}
@AfterClass
    public static void afterClass(){
        driver.close();
    }
}





