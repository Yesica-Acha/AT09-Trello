package trello.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import trello.ui.AbstractBasePage;

import java.util.List;

public class BoardPage extends AbstractBasePage {

    By boardTitleBy = By.cssSelector("[data-testid='board-name-display']");

    public String getBoardTitle() {
        return driver.findElement(boardTitleBy).getText();
    }

    public void addList(String listName) {

    }

    public List<String> getLists() {
        return null;
    }
}
