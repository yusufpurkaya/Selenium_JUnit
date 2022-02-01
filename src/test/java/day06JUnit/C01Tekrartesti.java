package day06JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01Tekrartesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1-C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
       driver.navigate().to("https://www.google.com");

        //3- cookies uyarisini kabul ederek kapatin
        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        System.out.println(driver.getTitle().contains("Google")?"google icerme testi PASS":"google icerme testi FAILED");
        //5- Arama cubuguna “Nutella” yazip aratin
WebElement aramaKutusu=driver.findElement(By.xpath("//input[@name='q']"));
      aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //6-Bulunan sonuc sayisini yazdirin
     WebElement sonucSayisi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       String sonucString=sonucSayisi.getText();
       String sonucKelimeleri[]=sonucString.split(" ");
        System.out.println(Arrays.toString(sonucKelimeleri));
       String nutellaSayisi=sonucKelimeleri[1];  //1.410.000.000
        nutellaSayisi= nutellaSayisi.replace(".","");
        int nutellasayi=Integer.parseInt(nutellaSayisi);
        System.out.println(nutellasayi>10000000?"10milyondan fazla sonuc testi PASS":"10milyondan fazla sonuc testi FAILED");
        //8-Sayfayi kapatin
driver.quit();

    }
}
