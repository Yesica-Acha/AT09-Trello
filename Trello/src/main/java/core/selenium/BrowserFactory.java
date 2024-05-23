package core.selenium;

import core.selenium.browsers.Browser;
import core.selenium.browsers.Chrome;
import core.selenium.browsers.Firefox;
import core.selenium.browsers.Headless;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BrowserFactory {
    private static final Map<String, Supplier<Browser>> BROWSERS = new HashMap<>();
    static {
        BROWSERS.put("chrome", Chrome::new);
        BROWSERS.put("firefox", Firefox::new);
        BROWSERS.put("headless", Headless::new);
    }

    private BrowserFactory() {
    }

    public static WebDriver getBrowser(final String browser) {
        return BROWSERS.getOrDefault(browser, Chrome::new).get().init();
    }
}
