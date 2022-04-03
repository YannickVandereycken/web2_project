package ui.view;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.Assert.assertEquals;

public class htmlTest {
    private WebDriver driver;
    private String url_cyclone = "http://cyclone3.uclllabs.be:8081/vandereycken-yannick/";

    @Before
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //WebDriverManager.safaridriver().setup();
        //driver = new SafariDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void html_index() {
        isValidHtml(url_cyclone + "FilmServlet");
    }

    @Test
    public void html_overview() {
        isValidHtml(url_cyclone + "FilmServlet?page=overview");
    }

    @Test
    public void html_add() {
        isValidHtml(url_cyclone + "FilmServlet?page=add");
    }

    @Test
    public void html_search() {
        isValidHtml(url_cyclone + "FilmServlet?page=search");
    }

    @Test
    public void html_confirmation() {
        isValidHtml(url_cyclone + "FilmServlet?page=confirmation&id=0");
    }

    @Test
    public void html_update() {
        isValidHtml(url_cyclone + "FilmServlet?page=update&id=0");
    }

    public void isValidHtml(String url) {
        driver.get("https://html5.validator.nu");
        driver.findElement(By.id("doc")).sendKeys(url);

        driver.findElement(By.id("submit")).click();
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        WebElement pass = driver.findElement(By.className("success"));
        assertEquals("The document is valid HTML5 + ARIA + SVG 1.1 + MathML 2.0 (subject to the utter previewness of this service).", pass.getText());
    }
}
