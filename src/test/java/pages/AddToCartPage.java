package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ResuabilityClass;

public class AddToCartPage {
	
	WebDriver driver;
    private ResuabilityClass re;
    
    public AddToCartPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
        re = new ResuabilityClass(driver);
    }
    
    @FindBy(xpath = "//button[@class='QqFHMw vslbG+ In9uk2']")
    WebElement cartClick;
    
    public void addToCart()
    {
    	try
    	{
    		re.clickElement(cartClick);
    	}catch(Exception e)
    	{
    		System.out.println("Cannot click add to cart button");
    	}
    }
}
