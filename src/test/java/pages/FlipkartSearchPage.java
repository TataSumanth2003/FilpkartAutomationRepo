package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ResuabilityClass;

/**
 * Page Object Model class for Flipkart Search Page.
 */
public class FlipkartSearchPage {
    private WebDriver driver;
    private ResuabilityClass re;

    @FindBy(xpath = "//input[@name='q' and @type='text']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit' and @aria-label='Search for Products, Brands and More']")
    WebElement searchButton;

    @FindBy(className = "JFPqaw")
    WebElement closeLoginPopup;

    /**
     * Constructor initializes WebDriver and PageFactory elements.
     */
    public FlipkartSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        re = new ResuabilityClass(driver);
    }

    /**
     * Closes the Flipkart login popup if it appears.
     * @throws InterruptedException 
     */
    public void closePopupIfPresent()  {
        try {
            if (closeLoginPopup.isDisplayed()) {
                closeLoginPopup.click();
            }
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {
            System.out.println("Login popup not present or already closed.");
        }
    }

    /**
     * Enters the search text into the search box.
     * @param text The item to search (e.g., "Mobiles")
     * @throws InterruptedException 
     */
    public void search(String text) {
//        closePopupIfPresent();
    	System.out.println("*******************************************************************");
        re.enterText(searchBox, text);
    }

    /**
     * Clicks the search button.
     */
    public void clickSearch() {
        try {
            re.clickElement(searchButton);
        } catch (Exception e) {
            System.out.println("Search button not interactable.");
        }
    }
}
