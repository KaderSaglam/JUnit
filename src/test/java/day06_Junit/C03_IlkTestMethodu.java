package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C03_IlkTestMethodu {

    WebDriver driver;
    @Test
    public void test01(){
        //amazon.coma  gidelim ve Title 'in "amazon" ierdiğini test edelim
        driver.get("https://www.amazon.com");
        String actualTitle=  driver.getTitle();// gercek baslik
        System.out.println(actualTitle);// basligi yazdirdik
        String expectedTitle="amazon";// beklenen baslik
        if (actualTitle.equals(expectedTitle)) { // gercek baslik ile beklenen basligi karsilastirdik
            System.out.println("Amozan Testi PASSED");
        }else {
            System.out.println("Amozon testi FAİLED");
        }


    }
    @Test
    public void test02(){
//google.coma  gidelim ve Title 'in "google" ierdiğini test edelim
        driver.get("https://www.google.com");
        String actualTitle=  driver.getTitle();// gercek baslik
        System.out.println(actualTitle);// basligi yazdirdik
        String expectedTitle="google";// beklenen baslik
        if (actualTitle.equals(expectedTitle)) { // gercek baslik ile beklenen basligi karsilastirdik
            System.out.println("correct title");
        }else {
            System.out.println("incorrect title");
        }
    }
    // her test methodundan once calisir
    @Before
    public void ayarlarDuzenle(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    // en son bu calisr her zaman
    @After
    public  void ortaligiTopla(){
        driver.close();
    }
}
