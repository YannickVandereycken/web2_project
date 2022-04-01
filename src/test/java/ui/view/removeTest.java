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

public class removeTest {
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
    public void test_verwijderFilmConfirmation_inOrde() {
        String titel = "Inception";
        driver.findElement(By.id("remove" + 2)).click();
        assertEquals("Bevestiging", driver.getTitle());
        assertEquals("Verwijdering van deze film", driver.findElement(By.tagName("h2")).getText());
    }

    @Test
    public void test_verwijderFilmAnnulationToIndex_inOrde() {
        String titel = "Inception";
        driver.findElement(By.id("remove" + 2)).click();
        driver.findElement(By.id("cancel")).click();
        assertEquals("Filmbibliotheek", driver.getTitle());
        assertEquals("Mijn persoonlijke filmbibliotheek", driver.findElement(By.tagName("h2")).getText());
    }

    @Test
    public void test_verwijderFilmSuccesvol_juisteFilm() {
        removeFilm("Dune");
        assertEquals("Filmbibliotheek", driver.getTitle());
        assertEquals("Overzicht", driver.findElement(By.tagName("h2")).getText());
        assertFalse(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "Dune"));
    }

    private void removeFilm(String titel) {
        driver.findElement(By.id("remove" + 1)).click();
        driver.findElement(By.id("confirm")).click();
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
