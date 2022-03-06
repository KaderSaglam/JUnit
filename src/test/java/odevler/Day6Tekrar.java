package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class Day6Tekrar {
    public static void main(String[] args) {
        //1-C01_TekrarTesti isimli bir class olusturun

WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin

        // trde cookes cıkmıyor. bu bir tane yazi sadece otomosyanda cıkıyor
        //herkes kendi cookesini yapmasi lazim ulkeden ulkeye farkeder

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle= driver.getTitle();
        String expectedArananKelime="Google";
        if (actualTitle.contains(expectedArananKelime))
            System.out.println("title testi PASSED");
        else System.out.println("title testi FAİLED");

        //5- Arama cubuguna “Nutella” yazip aratin
WebElement aramaCubugu= driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
aramaCubugu.sendKeys("nutella"+ Keys.ENTER);
        //6-Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucYazisiElementi.getText());

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String  sonucYazisiString=sonucYazisiElementi.getText();
        String sonucKelimeleri[]=sonucYazisiString.split(" ");
        System.out.println(Arrays.toString(sonucKelimeleri));
        String sonucNutellaYazisiString=sonucKelimeleri[1];// bu bize 83.200.000 bunu verir
        sonucNutellaYazisiString= sonucNutellaYazisiString.replaceAll(".","");
        System.out.println(sonucNutellaYazisiString);
       int sonucYazisi=Integer.parseInt(sonucNutellaYazisiString);
        if (sonucYazisi>10000000) {
            System.out.println("Nutella arama testi PASSED");

        }else System.out.println("Nutella arama testi FAILED");
        //8- sayfayi kapatin
        driver.close();
    }
}
