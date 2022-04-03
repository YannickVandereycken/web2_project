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

import static org.junit.Assert.*;

public class updateTest {
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
        driver.get(url + "FilmServlet?page=overview");
        driver.navigate();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_WijzigFilmGaNaarJuistePagina_inOrde() {
        assertEquals("Overzicht", driver.getTitle());
        assertEquals("Overzicht", driver.findElement(By.tagName("h2")).getText());

        String titel = "Inception";
        driver.findElement(By.id("update" + 2)).click();

        assertEquals("Wijzig", driver.getTitle());
        assertEquals("Wijzig de volgende film", driver.findElement(By.tagName("h2")).getText());
    }

    @Test
    public void test_WijzigFilm_ZijnDezeWaardesVoorafIngevuld() {
        String titel = "Inception";
        driver.findElement(By.id("update" + 2)).click();

        assertEquals("Wijzig", driver.getTitle());
        assertEquals("Wijzig de volgende film", driver.findElement(By.tagName("h2")).getText());

        assertEquals("Inception", driver.findElement(By.id("titel")).getAttribute("value"));
        assertEquals("148", driver.findElement(By.id("tijd")).getAttribute("value"));
        assertEquals("2010", driver.findElement(By.id("jaar")).getAttribute("value"));
        assertEquals("9.5", driver.findElement(By.id("rating")).getAttribute("value"));
    }

    @Test
    public void test_WijzigFilmMetFouteJaar_TerugNaarFormulierMetFoutboodschap() {
        String titel = "Inception";
        driver.findElement(By.id("update" + 2)).click();

        assertEquals("Wijzig", driver.getTitle());
        assertEquals("Wijzig de volgende film", driver.findElement(By.tagName("h2")).getText());

        driver.findElement(By.id("jaar")).clear();
        driver.findElement(By.id("jaar")).sendKeys(1000 + "");
        driver.findElement(By.id("verstuur")).click();

        assertEquals("Wijzig", driver.getTitle());
        assertEquals("Wijzig de volgende film", driver.findElement(By.tagName("h2")).getText());

        assertEquals("Releasejaar moet na 1870 zijn", driver.findElement(By.className("error")).getText());
    }

    @Test
    public void test_WijzigFilmCorrect_FilmAangepastInOverzicht() {
        String titel = "Dune";
        driver.findElement(By.id("update" + 1)).click();

        assertEquals("Wijzig", driver.getTitle());
        assertEquals("Wijzig de volgende film", driver.findElement(By.tagName("h2")).getText());

        driver.findElement(By.id("jaar")).clear();
        driver.findElement(By.id("jaar")).sendKeys(3000 + "");
        driver.findElement(By.id("rating")).clear();
        driver.findElement(By.id("rating")).sendKeys(10 + "");
        driver.findElement(By.id("verstuur")).click();

        assertEquals("Overzicht", driver.getTitle());
        assertEquals("Overzicht", driver.findElement(By.tagName("h2")).getText());
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "Dune"));
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "2u 35m"));
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "3000"));
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "10.0"));
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
