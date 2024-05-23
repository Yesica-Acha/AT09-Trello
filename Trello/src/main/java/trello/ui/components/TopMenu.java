package trello.ui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import trello.ui.AbstractBasePage;
import trello.ui.pages.AccountMenuPage;
import trello.ui.pages.CreateMenuPage;

public class TopMenu extends AbstractBasePage {

    By accountMenuBtnBy = By.cssSelector("[data-testid = 'header-member-menu-avatar']");

    By creteBtnBy = By.cssSelector("[data-testid*='create-menu']");

    public AccountMenuPage openAccountMenu() {
        action.click(accountMenuBtnBy);
        return new AccountMenuPage();
    }

    public String getUserName() {
        WebElement accountMenuBtn = driver.findElement(accountMenuBtnBy);
        String userName = accountMenuBtn.findElement(By.cssSelector("span")).getAttribute("aria-label");
        return userName.substring(0, userName.indexOf("(") -1 );
    }

    public CreateMenuPage openCreateMenu() {
        action.click(creteBtnBy);
        return new CreateMenuPage();
    }
}
