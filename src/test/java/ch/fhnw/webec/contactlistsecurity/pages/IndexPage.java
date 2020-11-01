package ch.fhnw.webec.contactlistsecurity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class IndexPage {

    private static final String URL = "http://localhost:%d";

    public static IndexPage to(WebDriver driver, int port) {
        driver.get(String.format(URL, port));
        return PageFactory.initElements(driver, IndexPage.class);
    }

    private final WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "contact-details")
    private List<WebElement> contactDetails;

    @FindBy(id = "no-contact-message")
    private List<WebElement> noContactMessage;

    @FindBy(className = "contact-link")
    private List<WebElement> contactLinks;

    @FindBy(id = "first-name-value")
    private List<WebElement> firstNameValue;

    @FindBy(id = "last-name-value")
    private List<WebElement> lastNameValue;

    @FindBy(id = "email-value")
    private List<WebElement> emailValue;

    @FindBy(id = "phone-value")
    private List<WebElement> phoneValue;

    @FindBy(id = "job-title-value")
    private List<WebElement> jobTitleValue;

    @FindBy(id = "company-value")
    private List<WebElement> companyValue;

    public List<WebElement> getContactDetails() {
        return contactDetails;
    }

    public List<WebElement> getNoContactMessage() {
        return noContactMessage;
    }

    public List<WebElement> getContactLinks() {
        return contactLinks;
    }

    private static Optional<String> extractText(List<WebElement> element) {
        return element.stream()
                .map(WebElement::getText)
                .findAny();
    }

    public Optional<String> getSelectedFirstName() {
        return extractText(firstNameValue);
    }

    public Optional<String> getSelectedLastame() {
        return extractText(lastNameValue);
    }

    public Optional<String> getSelectedEmails() {
        return extractText(emailValue);
    }

    public Optional<String> getSelectedPhones() {
        return extractText(phoneValue);
    }

    public Optional<String> getSelectedJobTitle() {
        return extractText(jobTitleValue);
    }

    public Optional<String> getSelectedCompany() {
        return extractText(companyValue);
    }
}
