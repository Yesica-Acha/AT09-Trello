package core.selenium;

import core.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class DriverManager {

    private static DriverManager instance = null;

    private WebDriver driver;
    private WebDriverWait wait;
    private DriverManager() {
        initDriver();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private void initDriver() {
        String browser = Environment.getInstance().getValue("browser");
        int implicitTime = Integer.parseInt(Environment.getInstance().getValue("implicit_time"));
        int explicitTime = Integer.parseInt(Environment.getInstance().getValue("explicit_time"));

        if (browser.equalsIgnoreCase("chrome")) {

            // Initialize Chrome driver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            // Initialize Firefox driver
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        // Set implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTime));

        // Maximize the window
        driver.manage().window().setPosition(new Point(1529, -400));
        driver.manage().window().maximize();

        // Set explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitTime));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void quitDriver() {
        instance = null;
        driver.quit();
    }
}
