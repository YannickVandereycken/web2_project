package domain;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class formulierTest {
    private WebDriver driver;
    //pas url aan indien nodig
    private String url = "http://localhost:8080/vandereycken_yannick_war_exploded/";

    @Before
    public void setUp() throws Exception {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //WebDriverManager.safaridriver().setup();
        //driver = new SafariDriver();
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    /**
     * Test valid case
     */
    @Test
    public void test_formulier_alles_invullen_gaat_naar_overzicht_en_toont_nieuw_item_in_tabel() {
        // navigeer naar formulier - Pas url hieronder aan indien nodig
        driver.get(url + "add.jsp"); //PAS URL AAN NAAR DAT VAN JOUW FORMULIER
        // vul velden geldig in
        voegItemToe("Us", 120, 2019, 8.5); //valide String en int values invullen
        // controleer <title> van pagina die browser toont
        assertEquals("Overzicht", driver.getTitle()); //PAS AAN NAAR JOUW TITELTEXT OP DE OVERZICHTSPAGINA
        // controleer <h2>
        assertEquals("Overzicht", driver.findElement(By.tagName("h2")).getText()); //PAS AAN NAAR JOUW TITELTEXT OP DE OVERZICHTSPAGINA
        // controleer of overzicht nieuw ingevoegd item bevat
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "Us"));
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "2u 0m"));
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "2019")); //input4 (integer value in dit geval)
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "8.5"));
    }

    /**
     * Invalid case
     */
    @Test
    public void test_als_Lege_Item_Toegevoegd_Dan_Wordt_Formulier_Opnieuw_Getoond_met_foutboodschap() {
        // navigeer naar formulier
        driver.get(url + "add.jsp"); //PAS URL AAN NAAR DAT VAN JOUW FORMULIER
        // vul velden geldig in
        voegItemToe("", 0, 0, 0.0); //voor lege inputvelden "" en voor integer waarden 0
        // controleer <title> van pagina die browser toont
        assertEquals("Voeg Toe", driver.getTitle()); //PAS AAN NAAR JOUW TITLETEKST
        // controleer <h2>
        assertEquals("Voeg je favoriete films toe", driver.findElement(By.tagName("h2")).getText()); //PAS AAN NAAR JOUW TITLETEKST
        // controleer of foutboodschap aanwezig is
        assertEquals("U vulde niet alle velden in",driver.findElement(By.className("error")).getText()); //PAS AAN NAAR FOUTMELDING (indien nodig)
    }

    /**
     * Methode die velden van formulier invult en op submit knop duwt
     * @param input1, input2, input3, input4: velden die ingevuld worden
     */
    //PAS ONDERSTAANDE INPUTVELDEN (EN BUTTON) AAN NAAR DIE VAN JOUW PROJECT (Met behulp van de id's)
    private void voegItemToe(String input1, int input2, int input3, double input4) {
        //Pas url hieronder aan indien nodig
        driver.findElement(By.id("titel")).sendKeys(input1);
        driver.findElement(By.id("time")).sendKeys(input2 + "");
        driver.findElement(By.id("jaar")).sendKeys(input3 + ""); //BIJ integer values input best eindigen met + "" !!!
        driver.findElement(By.id("rating")).sendKeys(input4 + "");
        driver.findElement(By.id("verstuur")).click();
    }

    /**
     * Returnt true indien lijst webelements de gezochte tekst bevat
     * @param items: op overzichtspagina's zijn alle items vervat in een container, bijv <td>
     * @param tekst die opgezocht moet worden
     */
    private boolean paginaBevatItemMetText(List<WebElement> items, String tekst) {
        for (WebElement item : items) {
            if (item.getText().equals(tekst)) {
                return true;
            }
        }
        return false;
    }
}