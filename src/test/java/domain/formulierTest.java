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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class formulierTest {
    private WebDriver driver;
    //pas url aan indien nodig
    private String url = "http://localhost:8080/web_war_exploded/";

    @Before
    public void setUp() throws Exception {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
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
        driver.get(url + "formulier.jsp"); //PAS URL AAN NAAR DAT VAN JOUW FORMULIER
        // vul velden geldig in
        voegItemToe("input1", "input2", 10, "input4"); //valide String en int values invullen
        // controleer <title> van pagina die browser toont
        assertEquals("Overzicht Items", driver.getTitle()); //PAS AAN NAAR JOUW TITELTEXT OP DE OVERZICHTSPAGINA
        // controleer <h2>
        assertEquals("Overzicht Items", driver.findElement(By.tagName("h2")).getText()); //PAS AAN NAAR JOUW TITELTEXT OP DE OVERZICHTSPAGINA
        // controleer of overzicht nieuw ingevoegd item bevat
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "input1"));
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "input2"));
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "10")); //input4 (integer value in dit geval)
        assertTrue(paginaBevatItemMetText(driver.findElements(By.tagName("td")), "input4"));
    }

    /**
     * Invalid case
     */
    @Test
    public void test_als_Lege_Item_Toegevoegd_Dan_Wordt_Formulier_Opnieuw_Getoond_met_foutboodschap() {
        // navigeer naar formulier
        driver.get(url + "formulier.jsp"); //PAS URL AAN NAAR DAT VAN JOUW FORMULIER
        // vul velden geldig in
        voegItemToe("", "", 0, ""); //voor lege inputvelden "" en voor integer waarden 0
        // controleer <title> van pagina die browser toont
        assertEquals("Voeg een item toe", driver.getTitle()); //PAS AAN NAAR JOUW TITLETEKST
        // controleer <h2>
        assertEquals("Voeg een item toe", driver.findElement(By.tagName("h2")).getText()); //PAS AAN NAAR JOUW TITLETEKST
        // controleer of foutboodschap aanwezig is
        assertEquals("U vulde niet alle velden in",driver.findElement(By.id("message")).getText()); //PAS AAN NAAR FOUTMELDING (indien nodig)
    }

    /**
     * Methode die velden van formulier invult en op submit knop duwt
     * @param input1, input2, input3, input4: velden die ingevuld worden
     */
    //PAS ONDERSTAANDE INPUTVELDEN (EN BUTTON) AAN NAAR DIE VAN JOUW PROJECT (Met behulp van de id's)
    private void voegItemToe(String input1, String input2, int input3, String input4) {
        //Pas url hieronder aan indien nodig
        driver.findElement(By.id("input1")).sendKeys(input1);
        driver.findElement(By.id("input2")).sendKeys(input2);
        driver.findElement(By.id("input3")).sendKeys(input3 + ""); //BIJ integer values input best eindigen met + "" !!!
        driver.findElement(By.id("input4")).sendKeys(input4);
        driver.findElement(By.id("submut")).click();
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