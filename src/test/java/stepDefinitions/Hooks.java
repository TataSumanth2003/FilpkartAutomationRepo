package stepDefinitions;

import baseclass.LibraryClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends LibraryClass{
	@Before
	 public void setUp() throws Exception {
	    initializeBrowser();
    	System.out.println("*******************************************************************Initialized browser");
        openApplication();
    	System.out.println("*******************************************************************Application opened");
	    }


  @After
  public void tearDown() {
	   closeBrowser();
   	   System.out.println("*******************************************************************Application closed");
  }
}
