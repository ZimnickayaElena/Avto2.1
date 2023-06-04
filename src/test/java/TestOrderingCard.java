import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderingCard {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");}

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldReqestDebetCard() {
        driver.get("http://localhost:9999");
        driver.findElements(By.tagName("input")).get(0).sendKeys("Зимницкая Елена");
        driver.findElements(By.tagName("input")).get(1).sendKeys("+79376566931");
        driver.findElement(By.tagName("label")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.tagName("p")).getText().trim();
        assertEquals(expected, actual);
    }
}
