package ui.view;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class addTest {
    private WebDriver driver;
    private String url = "http://localhost:8080/vandereycken_yannick_war_exploded/";
    private String url_cyclone = "http://cyclone3.uclllabs.be:8081/vandereycken-yannick/";

    @Before
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //WebDriverManager.safaridriver().setup();
        //driver = new SafariDriver();
        driver.get(url + "FilmServlet?page=add");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_voegFilmToe_NaarOverzichtEnToontNieuwFilm() {
        assertEquals("Voeg Toe", driver.getTitle());
        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText());
        voegItemToe("Us", 120, 2019, 8.5);

        assertEquals("Overzicht", driver.getTitle());
        assertEquals("Overzicht", driver.findElement(By.tagName("h2")).getText());

        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "Us"));
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "2u 0m"));
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "2019"));
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "8.5"));
    }

    @Test
    public void test_voegLegeFilmToe_TerugNaarFormulierMetFoutboodschappen() {
        assertEquals("Voeg Toe", driver.getTitle());
        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText());
        voegItemToe("", 0, 0, -1);

        assertEquals("Voeg Toe", driver.getTitle());
        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText());

        List<WebElement> errors = driver.findElements(By.className("error"));
        assertEquals("Titel mag niet leeg zijn", errors.get(0).getText());
        assertEquals("Speelduur moet positief zijn", errors.get(1).getText());
        assertEquals("Releasejaar moet na 1870 zijn", errors.get(2).getText());
        assertEquals("Rating moet tussen 0 en 10 zijn", errors.get(3).getText());
    }

    @Test
    public void test_EnkelSpeelduurOntbreekt_FormulierOpnieuwGetoondMetfoutboodschapSpeelduur() {
        assertEquals("Voeg Toe", driver.getTitle());
        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText());
        voegItemToe("Us", 0, 2000, 5);

        assertEquals("Voeg Toe", driver.getTitle());

        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText());
        assertEquals("Speelduur moet positief zijn", driver.findElement(By.className("error")).getText());
    }

    @Test
    public void test_SpeelduurEnJaarOntbreken_FormulierOpnieuwGetoondMetfoutboodschapSpeelduurEnJaar() {
        assertEquals("Voeg Toe", driver.getTitle());
        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText());
        voegItemToe("Us", 0, 0, 5);

        assertEquals("Voeg Toe", driver.getTitle());
        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText());

        List<WebElement> errors = driver.findElements(By.className("error"));
        assertEquals("Speelduur moet positief zijn", errors.get(0).getText());
        assertEquals("Releasejaar moet na 1870 zijn", errors.get(1).getText());
    }

    @Test
    public void test_voegFilmToeMetNegatieveWaarden_TerugNaarFormulierMetFoutboodschappen() {
        assertEquals("Voeg Toe", driver.getTitle());
        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText());
        voegItemToe("", -20, -20, -20);

        assertEquals("Voeg Toe", driver.getTitle());
        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText());

        List<WebElement> errors = driver.findElements(By.className("error"));
        assertEquals("Titel mag niet leeg zijn", errors.get(0).getText());
        assertEquals("Speelduur moet positief zijn", errors.get(1).getText());
        assertEquals("Releasejaar moet na 1870 zijn", errors.get(2).getText());
        assertEquals("Rating moet tussen 0 en 10 zijn", errors.get(3).getText());
    }

    @Test
    public void test_voegFilmToeMetTitelEnJaar_BlijvenDezeWaardesIngevuld() {
        assertEquals("Voeg Toe", driver.getTitle());
        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText());
        voegItemToe("Us", 0, 2019, -1);

        assertEquals("Voeg Toe", driver.getTitle());
        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText());

        assertEquals("Us", driver.findElement(By.id("titel")).getAttribute("value"));
        assertEquals("2019", driver.findElement(By.id("jaar")).getAttribute("value"));
    }

    private void voegItemToe(String titel, int speelduur, int jaar, double rating) {
        driver.findElement(By.id("titel")).sendKeys(titel);
        driver.findElement(By.id("tijd")).sendKeys(speelduur + "");
        driver.findElement(By.id("jaar")).sendKeys(jaar + "");
        driver.findElement(By.id("rating")).sendKeys(rating + "");
        driver.findElement(By.id("verstuur")).click();
    }

    private boolean paginaBevatItemMetText(List<WebElement> items, String tekst) {
        for (WebElement item : items) {
            if (item.getText().equals(tekst)) {
                return true;
            }
        }
        return false;
    }
}
