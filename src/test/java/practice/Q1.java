package practice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Q1 {
    /*
    ...Exercise1...
    BeforeClass ile driver ı olusturun ve class icinde static yapin
    Maximize edin, 15 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatın
 */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Before
    public void testtenOnce(){
        driver.get("http://www.google.com");
    }
    @After
    public void testtenSonra(){
        System.out.println( "sonuc yazisi :" + (driver.findElement(By.xpath("//div[@id ='result-stats']")).getText()));
    }
    @Test
    public void test1(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Green Mile" + Keys.ENTER);
    }
    @Test
    public void test2(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Premonition" + Keys.ENTER);
    }
    @Test
    public void test3(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
    }
}



