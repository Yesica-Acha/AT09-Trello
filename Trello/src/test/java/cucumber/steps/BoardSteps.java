package cucumber.steps;

import core.selenium.SharedDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import trello.ui.pages.BoardPage;
import trello.ui.pages.BoardsPage;
import trello.ui.pages.CreateBoardPage;
import trello.ui.pages.CreateMenuPage;

import static org.testng.Assert.assertEquals;

public class BoardSteps {
    BoardsPage boardsPage;
    CreateBoardPage createBoardPage;
    BoardPage boardPage;

    public BoardSteps(final SharedDriver sharedDriver) {

    }

    @When("I open Board Creation form from the top menu")
    public void openBoardCreationFormFromTheTopMenu() {
        boardsPage = new BoardsPage();
        createBoardPage = boardsPage.getTopMenu().openCreateMenu()
                .openCreateBoardPage();
    }

    @And("I create a board with title {string}")
    public void createBoardWithTitle(String boardTitle) {
        boardPage = createBoardPage.createBoard(boardTitle);
    }

    @Then("the board title {string} should be displayed in the board page")
    public void verifyBoardTitleIsDisplayedInTheBoardPage(String boardTitle) {
        assertEquals(boardPage.getBoardTitle(), boardTitle, "The board title was not the expected.");
    }

    @When("I open Board Creation form from the context")
    public void openBoardCreationFormFromTheContext() {
    }
}
