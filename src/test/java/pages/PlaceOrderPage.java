package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ResuabilityClass;

public class PlaceOrderPage {
	WebDriver driver;
    private ResuabilityClass re;
    
    public PlaceOrderPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
        re = new ResuabilityClass(driver);
    }
    
    @FindBy(xpath = "//button[@class='QqFHMw zA2EfJ _7Pd1Fp']")
    WebElement placeClick;
    
    public void placeOrder()
    {
    	try
    	{
    		re.clickElement(placeClick);
    	}catch(Exception e)
    	{
    		System.out.println("Cannot click add to cart button");
    	}
    }
}
