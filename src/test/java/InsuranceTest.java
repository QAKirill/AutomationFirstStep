import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class InsuranceTest
{
    private WebDriver driver;
    private String baseUrl = PageObject.baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Automation/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testInsurance() throws NoSuchElementException, InterruptedException {
        driver.get(baseUrl + "/");

        click(PageObject.buttonStrahovanie);
        click(PageObject.buttonVseProgrammy);
        click(PageObject.buttonStrahTourists);

        assertEquals("Страхование путешественников",
                driver.findElement(PageObject.zagolovokToCheck).getText());

        click(PageObject.buttonOformitOnline);
        click(PageObject.summaSZMinimum);
        click(PageObject.buttonOformit);

        fillField(PageObject.fieldSurname,"Surname");
        fillField(PageObject.fieldName,"Name");
        fillField(PageObject.fieldBirthDate,"01.01.2000");

        click(PageObject.fieldLastName); //без этого клика поле не заполняется
        fillField(PageObject.fieldLastName,"Фамилия");
        fillField(PageObject.fieldFirstName,"Имя");
        fillField(PageObject.fieldMiddleName,"Отчество");
        fillField(PageObject.fieldPersonBirthDate,"02.02.2002");

        click(PageObject.fieldPassportSeries);//без этого клика поле не заполняется
        fillField(PageObject.fieldPassportSeries,"1234");
        fillField(PageObject.fieldPassportNumber,"012345");
        fillField(PageObject.fieldDocumentDate,"05.05.2005");
        click(PageObject.fieldDocumentIssue);//без этого клика поле не заполняется
        fillField(PageObject.fieldDocumentIssue,"Кем-то выдан");

        assertEquals("Surname", driver.findElement(PageObject.fieldSurname).getAttribute("value"));
        assertEquals("Name", driver.findElement(PageObject.fieldName).getAttribute("value"));
        assertEquals("01.01.2000", driver.findElement(PageObject.fieldBirthDate).getAttribute("value"));
        assertEquals("Фамилия", driver.findElement(PageObject.fieldLastName).getAttribute("value"));
        assertEquals("Имя", driver.findElement(PageObject.fieldFirstName).getAttribute("value"));
        assertEquals("Отчество", driver.findElement(PageObject.fieldMiddleName).getAttribute("value"));
        assertEquals("1234", driver.findElement(PageObject.fieldPassportSeries).getAttribute("value"));
        assertEquals("012345", driver.findElement(PageObject.fieldPassportNumber).getAttribute("value"));
        assertEquals("05.05.2005", driver.findElement(PageObject.fieldDocumentDate).getAttribute("value"));
        assertEquals("Кем-то выдан", driver.findElement(PageObject.fieldDocumentIssue).getAttribute("value"));

        click(PageObject.buttonSubmit);

        assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(PageObject.alertMessage).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    private void click(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(locator));
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public boolean IsElementExists(By locator)
    {
        try
        {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException ex)
        {
            return false;
        }
    }
}
