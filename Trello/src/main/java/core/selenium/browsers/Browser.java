package core.selenium.browsers;

import org.openqa.selenium.WebDriver;

@FunctionalInterface
public interface Browser {

    WebDriver init();
}
