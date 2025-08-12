package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ResuabilityClass;

public class FlipkartFilters {
	WebDriver driver;
    private ResuabilityClass re;
    
    public FlipkartFilters(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
        re = new ResuabilityClass(driver);
    }
    
    @FindBy(xpath = "//div[text()='Google']")
    WebElement brandClick;
    
//    @FindBy(xpath = "//div[text()='4★ & above']")
//    WebElement ratingClick;
    
    String ratingXpath= "//div[text()='4★ & above']";
    
    public void brandFilter()
    {
    	try {
            re.clickElement(brandClick);
        } catch (Exception e) {
            System.out.println("Brand Checkbox not interactable.");
        }    
    	
    }
    
    public void ratingFilter()
    {
    	try {
            re.scrollDown(ratingXpath);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Could not scroll");
        } 
    }
}
