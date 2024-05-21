package trello.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import trello.ui.AbstractBasePage;

public class AccountMenuPage extends AbstractBasePage {

    By userNameBy = By.cssSelector("[data-testid='account-menu-account-section']");

    final String USER_INFO_XPATH = ".//div[text()='$s']";

    public boolean isUserInfoDisplayed(String userInfo) {
        return driver.findElement(userNameBy).findElement(By.xpath(".//div[text()='" + userInfo + "']")).isDisplayed();
    }
}
