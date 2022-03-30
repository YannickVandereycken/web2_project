package ui.view;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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

    @Test // Voer deze test uit als je je project opgeladen hebt
    public void html_index() {
        isValidHtml("http://cyclone3.uclllabs.be:8081/vandereycken-yannick/index.jsp");
        //isValidHtml(url_cyclone + "FilmServlet");
    }

    @Test // Voer deze test uit als je je project opgeladen hebt
    public void html_overview() {
        isValidHtml("http://cyclone3.uclllabs.be:8081/vandereycken-yannick/FilmServlet");
        //isValidHtml(url_cyclone + "FilmServlet?page=overview");
    }

    @Test // Voer deze test uit als je je project opgeladen hebt
    public void html_add() {
        isValidHtml("http://cyclone3.uclllabs.be:8081/vandereycken-yannick/add.jsp");
        //isValidHtml(url_cyclone + "FilmServlet?page=add");
    }

    //@Test // Voer deze test uit als je je project opgeladen hebt
    //public void html_search() {
    //    isValidHtml(url_cyclone + "FilmServlet?page=search");
    //}

    public void isValidHtml(String url) {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        driver.findElement(By.id("uri")).sendKeys(url);

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        driver.findElement(By.cssSelector(".submit_button")).click();

//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        WebElement pass = driver.findElement(By.className("succes"));
        //WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }
}
