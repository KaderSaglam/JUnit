package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeTesti {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
    //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //	 ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //	○ wrongTitleTest	=> Sayfa basliginin “youtube” olmadigini dogrulayin
static  WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTest(){
        //	○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle= driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertTrue(expectedTitle.contains(expectedTitle));

    }

    @Test
    public void imageTest(){
        //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
        Assert.assertTrue(image.isDisplayed());

    }

    @Test
    public void searchBoxTest(){
        //	 ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue("arama kutusuna erisilemiyor ",searchBox.isEnabled());

    }
    @Test
    public void wrongTitleTest(){
        //	○ wrongTitleTest	=> Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle= driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertEquals("sayfa basligi youtube degil",expectedTitle,actualTitle);

    }

    @AfterClass
    public static void teardown(){


    }
}

