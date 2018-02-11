
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeGTest {
    private WebDriver driver;
    private String url;
    private String searchWord;

    @Before
    public void beforeMethod() {
        driver = new ChromeDriver();
        url = "http://google.com";
        searchWord = "maserati";
    }

    @Test
    public void mainTest() {
        driver.get(url);
        driver.findElement(By.cssSelector("input#lst-ib")).sendKeys(searchWord);
        driver.findElement(By.cssSelector("input#lst-ib")).sendKeys(Keys.ENTER);

        List<WebElement> allElements;
        allElements = driver.findElements(By.cssSelector("div.rc"));
        allElements.addAll(driver.findElements(By.cssSelector("li.ads-ad")));
        allElements.addAll(driver.findElements(By.cssSelector("div.dbsr")));

        for (WebElement element: allElements) {
            System.out.println(element.getText().contains(searchWord));

            assertTrue("Incorrect", element.getText().toLowerCase().contains(searchWord.toLowerCase()));

        }

    }

    @After
    public void finish(){
        driver.quit();
    }

}




