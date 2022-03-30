package ui.view;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class searchTest {
    private WebDriver driver;
    private String url = "http://localhost:8080/vandereycken_yannick_war_exploded/";
    private String url_cyclone = "http://cyclone3.uclllabs.be:8081/vandereycken-yannick/";

    @Before
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //WebDriverManager.safaridriver().setup();
        //driver = new SafariDriver();
        driver.get(url + "FilmServlet?page=search");
        driver.navigate();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test_zoekFilmSuccesvol_juisteFilm(){
        zoekItem("dune");
        assertEquals("Resultaat", driver.getTitle());
        assertEquals("De film die je zocht is:", driver.findElement(By.tagName("h3")).getText());
    }

    @Test
    public void test_zoekFilmNietInDatabase_geenFilmGevonden(){
        zoekItem("The power of the dog");
        assertEquals("Resultaat", driver.getTitle());
        assertEquals("Er is geen film de overeenkomt met je zoekopdracht.", driver.findElement(By.tagName("h3")).getText());
    }

    @Test
    public void test_zoekFilmLegeString_geenFilmGevonden(){
        zoekItem("");
        assertEquals("Zoek", driver.getTitle());
        assertEquals("Zoek in de filmbibliotheek", driver.findElement(By.tagName("h2")).getText());
    }

    private void zoekItem(String titel){
        driver.findElement(By.id("titel")).sendKeys(titel);
        driver.findElement(By.id("verstuur")).click();
    }
}
