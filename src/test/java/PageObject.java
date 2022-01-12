import org.openqa.selenium.By;

public class PageObject {
    public static final String baseUrl = "http://www.sberbank.ru/ru/person";
    public static final By buttonStrahovanie = By.xpath("//nav/div/ul/li[9]/a");
    public static final By buttonVseProgrammy = By.xpath("//a[contains(text(),\'Все страховые программы\')]");
    public static final By buttonStrahTourists = By.xpath("//h3[contains(.,\'Страхование путешественников\')]");
    public static final By zagolovokToCheck = By.xpath("//*[@id=\"page-main\"]/div[2]/div/div/div/div/div/div[1]/h1");
    public static final By buttonOformitOnline = By.xpath
            ("//*[@id=\"page-main\"]/div[2]/div/div/div/div/div/div[1]/div[2]/a/span");
    public static final By summaSZMinimum = By.xpath("//online-card-program/div");
    public static final By buttonOformit = By.xpath("//button[contains(.,\'Оформить\')]");
    public static final By fieldSurname = By.id("surname_vzr_ins_0");
    public static final By fieldName = By.id("name_vzr_ins_0");
    public static final By fieldBirthDate = By.id("birthDate_vzr_ins_0");
    public static final By fieldLastName = By.id("person_lastName");
    public static final By fieldFirstName = By.id("person_firstName");
    public static final By fieldMiddleName = By.id("person_middleName");
    public static final By fieldPersonBirthDate = By.id("person_birthDate");
    public static final By fieldPassportSeries = By.id("passportSeries");
    public static final By fieldPassportNumber = By.id("passportNumber");
    public static final By fieldDocumentDate = By.id("documentDate");
    public static final By fieldDocumentIssue = By.id("documentIssue");
    public static final By buttonSubmit = By.xpath("//button[@type=\'submit\']");
    public static final By alertMessage = By.xpath("//alert-form/div");
}