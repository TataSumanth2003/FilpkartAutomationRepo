package stepDefinitions;

import baseclass.LibraryClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends LibraryClass{
	@Before
	 public void setUp() throws Exception {
	    initializeBrowser();
        openApplication();
	    }


  @After
  public void tearDown() {
	   closeBrowser();
  }
}
