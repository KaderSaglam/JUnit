package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {
    /*
   ...Exercise5...
  @BeforeClass ın icerisinde driver i kuralim
  maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
  Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
  Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
  @AfterClass ta driver ı kapatalim

   */
   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }@Test
    public void googleTest(){
        driver.navigate().to("https://www.google.com");
        String sayfaBasligi="Google";
        Assert.assertTrue("Sayfa basligi google icermiyor ",driver.getTitle().contains(sayfaBasligi));



    }
    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        String amazonUrl="www.amazon.com";
        Assert.assertFalse("Url www.amazon.com icerİyor",driver.getCurrentUrl().contains(amazonUrl));

    }
    @AfterClass
    public static  void tearDown(){

        driver.quit();
    }

}
