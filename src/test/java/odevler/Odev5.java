package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class Odev5 {

   static WebDriver driver;
    static WebElement aramaKutusu;



    @Test
    public void test1(){
        //            - Test 1
//    Arama kutusunun yanindaki kategori menusundeki kategori
//    sayisinin 45 oldugunu test edin
        List<WebElement> kategoriler=driver.findElements(By.xpath("//option"));
        int actuelkategoriSayisi=kategoriler.size();
        int expectedategoriSayisi=45;
        if (actuelkategoriSayisi==expectedategoriSayisi){
            System.out.println("Kategori Sayisi Testi PASSED");
        }else System.out.println("Kategori Sayisi Testi FAILED kategori sayisi" +actuelkategoriSayisi);

    }@Test
    public void test2(){
                     //-Test 2
             //   1. Kategori menusunden Books secenegini secin
        WebElement kategori= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        kategori.click();
        WebElement books=driver.findElement(By.xpath("//option[text()='Books']"));
        books.click();
           //2. Arama kutusuna Java yazin ve aratin
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);

           //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi= driver.findElement(By.xpath("//span[text()='1-16 of over 30,000 results for']"));
        System.out.println(sonucYazisi.getText());
          //4. Sonucun Java kelimesini icerdigini test edin
        String sonucYazisiString=sonucYazisi.getText();
        String sonucSayisiArr[]=sonucYazisiString.split(" ");
        System.out.println(sonucSayisiArr[3]+" adet sonuc vardir");
     String arananSonuc="Java";
        if (sonucYazisiString.contains(arananSonuc)){
            System.out.println("aranan Sonuc Testi PASS");
        }else {
            System.out.println("aranan Sonuc Testi FAILED");
        }

    }@BeforeClass
    public static void beforeClass(){
        // https://www.amazon.com/ adresine gidin.
        WebDriverManager.chromedriver().setup();
      driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");





    }@AfterClass
    public static void afterClass(){
driver.close();

    }

   }
