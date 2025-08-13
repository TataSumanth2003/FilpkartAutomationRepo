package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ResuabilityClass;

public class FlipkartResultPage {
	WebDriver driver;
    private ResuabilityClass re;
    
    public FlipkartResultPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
        re = new ResuabilityClass(driver);
    }


    String firstClickXPath="//div[@class='DOjaWF gdgoEp']/div[2]";
    
    public void firstResult()
    {
    	try {
            re.windowHandling(firstClickXPath);
        } catch (Exception e) {
            System.out.println("First search not interactable.");
        }
    }
}
