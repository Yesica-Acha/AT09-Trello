package trello.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import trello.ui.AbstractBasePage;
import trello.ui.components.TopMenu;

public class BoardsPage extends AbstractBasePage {

    private TopMenu topMenu;

    public BoardsPage() {
        super();
        this.topMenu = new TopMenu();
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }

    public BoardPage openBoard(final String boardTitle) {
        driver.findElement(By.cssSelector("[title='" + boardTitle + "']")).click();
        return new BoardPage();
    }
}
