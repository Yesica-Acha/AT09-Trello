package trello.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import trello.ui.AbstractBasePage;

public class CreateBoardPage extends AbstractBasePage {

    By boardTitleTxtBoxBy = By.cssSelector("input[data-testid*='board-title']");
    By createBoardTitleBy = By.cssSelector("button[data-testid='create-board-submit-button']");

    private void setBoardTitle(final String boardTitle) {
        WebElement boardTitleTxtBox = driver.findElement(boardTitleTxtBoxBy);
        boardTitleTxtBox.clear();
        boardTitleTxtBox.sendKeys(boardTitle);
    }

    public BoardPage createBoard(final String boardTitle) {
        setBoardTitle(boardTitle);
        driver.findElement(createBoardTitleBy).click();
        return new BoardPage();
    }
}
