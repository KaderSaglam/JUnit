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

import java.time.Duration;
import java.util.List;

public class Homework5 {

        static WebDriver driver;
        static WebElement aramaKutusu;
        @Test
        public void test01(){
//            - Test 1
//    Arama kutusunun yanindaki kategori menusundeki kategori
//    sayisinin 45 oldugunu test edin
            List<WebElement> kategoriler=driver.findElements(By.xpath("//option"));
            int actuelkategoriSayisi=kategoriler.size();
            int expectedategoriSayisi=45;
            if (actuelkategoriSayisi==expectedategoriSayisi){
                System.out.println("Kategori Sayisi Testi PASSED");
            }else {
                System.out.println("Kategori Sayisi Testi FAILED kategori sayisi" +actuelkategoriSayisi);
            }
        }
        @Test
        public void test02(){
            //-Test 2
//1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin
            driver.findElement(By.xpath("//option[text()='Books']")).click();
            aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.sendKeys("Java"+ Keys.ENTER);
            WebElement sonucSayisiElementi=driver.findElement(By.xpath("//span[text()='1-16 of over 30,000 results for']"));
            String sonucSayisiString=sonucSayisiElementi.getText();
            String sonucSayisiArr[]=sonucSayisiString.split(" ");
            System.out.println(sonucSayisiArr[3]+" adet sonuc vardir");
            WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
            String actualSonucYazisi=sonucYazisiElementi.getText();
            String arananSonuc="Java";
            if (actualSonucYazisi.contains(arananSonuc)){
                System.out.println("aranan Sonuc Testi PASS");
            }else {
                System.out.println("aranan Sonuc Testi FAILED");
            }
        }
        @BeforeClass
        public static void beforeClass(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            //https://www.amazon.com/ adresine gidin.
            driver.get("https://www.amazon.com");
        }
        @AfterClass
        public  static void afterClass(){
            driver.close();
        }
    }


