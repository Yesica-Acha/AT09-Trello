package testng.trello;

import org.testng.annotations.Test;
import trello.ui.pages.*;

import static org.testng.Assert.assertEquals;

public class BoardTests extends AbstractBaseTests {

    @Test
    public void createBoardTest() {

        // Test data
        String userEmail = "autotester248@gmail.com";
        String userPassword = "password";
        String boardTitle = "Test Board";

        LoginPage loginPage = new LoginPage();
        BoardsPage boardsPage = loginPage.loginSuccessful(userEmail, userPassword);

        CreateBoardPage createBoardPage = boardsPage.getTopMenu().openCreateMenu()
                .openCreateBoardPage();

        BoardPage boardPage = createBoardPage.createBoard(boardTitle);

        assertEquals(boardPage.getBoardTitle(), boardTitle, "The board title was not the expected.");
    }
}
