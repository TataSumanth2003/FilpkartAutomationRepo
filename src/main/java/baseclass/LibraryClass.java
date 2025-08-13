package baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryClass {

    protected static WebDriver driver;
    protected static Properties config = new Properties();
    private static final Logger logger = LogManager.getLogger(LibraryClass.class);

    // Load config.properties
    public static void loadConfig() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/Configuration.Properties/Config.properties")) {
            config.load(fis);
            logger.info("Config loaded successfully");
        } catch (IOException e) {
            logger.error("Failed to load configuration: " + e.getMessage());
        }
    }

    // Initialize browser based on config
    public static void initializeBrowser() {
        loadConfig();
        String executionType = config.getProperty("executionType"); // local or sauce
        String browser = config.getProperty("browser", "chrome");
        int implicitWait = Integer.parseInt(config.getProperty("implicitWait", "10"));

        // Sauce Labs credentials from environment variables
        String sauceUser = "oauth-tatasumanth2003-fa806";
        String sauceKey = "4c88c651-41a9-4270-80c4-55a48a8d2579";
        boolean canRunSauce = sauceUser != null && sauceKey != null;

        if (executionType.equalsIgnoreCase("sauce") && canRunSauce) {
            runOnSauce(browser, sauceUser, sauceKey);
        } else {
            if (executionType.equalsIgnoreCase("sauce") && !canRunSauce) {
                logger.warn("Sauce Labs credentials not found. Falling back to local execution.");
            }
            runLocally(browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
    }

    // Run browser locally
    private static void runLocally(String browser) {
        String os = System.getProperty("os.name").toLowerCase();
        logger.info("Running locally on OS: " + os);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Local Chrome driver setup successful");
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logger.info("Local Firefox driver setup successful");
        } else {
            logger.error("Unsupported browser: " + browser);
            throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

    // Run browser on Sauce Labs
    private static void runOnSauce(String browser, String sauceUser, String sauceKey) {
        try {
            // Sauce Labs EU-Central-1 URL
            String sauceURL = "https://" + sauceUser + ":" + sauceKey +
                    "@ondemand.eu-central-1.saucelabs.com/wd/hub";

            // Desired capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", browser);
            caps.setCapability("platformName", config.getProperty("platformName", "Windows 11"));
            caps.setCapability("browserVersion", config.getProperty("browserVersion", "latest"));

            // Sauce-specific options
            java.util.HashMap<String, Object> sauceOptions = new java.util.HashMap<>();
            sauceOptions.put("name", config.getProperty("testName"));
            sauceOptions.put("build", config.getProperty("buildName"));
            caps.setCapability("sauce:options", sauceOptions);

            // Start remote driver
            driver = new RemoteWebDriver(new URL(sauceURL), caps);
            logger.info("Remote WebDriver initiated for Sauce Labs EU-Central-1");

            // Log Sauce Labs session link
            String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
            logger.info("Sauce Labs Session ID: " + sessionId);
            logger.info("Watch the test video here: https://app.eu-central-1.saucelabs.com/tests/" + sessionId);

        } catch (Exception e) {
            logger.error("Failed to start Sauce Labs RemoteWebDriver", e);
            logger.warn("Falling back to local execution.");
            runLocally(browser);
        }
    }

    // Open application URL from config
    public static void openApplication() {
        String url = config.getProperty("url");
        driver.get(url);
        logger.info("Navigated to URL: " + url);
    }

    // Close browser
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver closed successfully");
        }
    }
}
