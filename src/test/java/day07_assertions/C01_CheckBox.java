package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
// burada test yok gorev var
public class C01_CheckBox {
    static WebElement checkbox1, checkbox2;
    static WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() throws InterruptedException {
//    a. Verilen web sayfasına gidin.
//    https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
//    b. Checkbox1 ve checkbox2 elementlerini locate edin.
        checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
//    c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(5000);
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
//    d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        Thread.sleep(5000);
    }
    //checkbox 2 secilioldugu icin secmedi checkbox 1 i secti
    @After
    public void tearDown() {
        driver.close();
    }
}