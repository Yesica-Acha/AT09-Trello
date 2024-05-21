package trello.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import trello.ui.AbstractBasePage;

public class CreateMenuPage extends AbstractBasePage {

    By createBoardBy = By.cssSelector("button[data-testid*='create-board-button']");

    public CreateBoardPage openCreateBoardPage() {
        driver.findElement(createBoardBy).click();
        return new CreateBoardPage();
    }

}
