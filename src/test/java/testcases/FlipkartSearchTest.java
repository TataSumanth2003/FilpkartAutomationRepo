//package testcases;
//
//import java.io.IOException;
//
//
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import baseclass.LibraryClass;
//import pages.AddToCartPage;
//import pages.FlipkartFilters;
//import pages.FlipkartResultPage;
//import pages.FlipkartSearchPage;
//import pages.PlaceOrderPage;
//import utilities.ResuabilityClass;
//
///**
// * TestNG test class for Flipkart search functionality.
// */
//public class FlipkartSearchTest extends LibraryClass {
//
//    ResuabilityClass re;
//    FlipkartSearchPage srh;
//    FlipkartResultPage frp;
//    FlipkartFilters ff;
//    AddToCartPage atc;
//    PlaceOrderPage pop;
//
//    /**
//     * Initializes browser and application before tests.
//     */
//    @BeforeTest
//    public void openApp() {
//        initializeBrowser();
//        openApplication();
//        re = new ResuabilityClass(driver);
//        srh = new FlipkartSearchPage(driver);
//        frp= new FlipkartResultPage(driver);
//        ff= new FlipkartFilters(driver);
//        atc= new AddToCartPage(driver);
//        pop= new PlaceOrderPage(driver);
//    }
//
//    /**
//     * Test case: Search for "Mobiles" on Flipkart.
//     * @throws IOException 
//     * @throws InterruptedException 
//     */
//    @Test(priority=1)
//    public void searchMobile() throws IOException {
//        srh.search("Mobiles");
//        srh.clickSearch();
//        re.takescreenshot("src/test/resources/screenshot/flipkartsearch.png");
//        
//    }
//    
//    @Test(priority=2)
//    public void filterClick()
//    {
//    	ff.brandFilter();
//    	ff.ratingFilter();
//    }
//    @Test(priority=3)
//    public void resultClick() throws IOException
//    {
//    	frp.firstResult();
//    	re.takescreenshot("src/test/resources/screenshot/firstResult.png");
//    }
//    
//    @Test(priority=4)
//    public void addToCartClick()
//    {
//    	atc.addToCart();
//    }
//    
//    @Test(priority=5)
//    public void placeOrderClick()
//    {
//    	pop.placeOrder();
//    }
//
//    /**
//     * Takes a screenshot and closes the browser after tests.
//     */
//    @AfterTest
//    public void closeApp() throws IOException {
//        System.out.println("Page Title: " + re.getTitleName());
////        closeBrowser();
//    }
//}
