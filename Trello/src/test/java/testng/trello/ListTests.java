package testng.trello;

import core.Environment;
import org.testng.Assert;
import org.testng.annotations.Test;
import trello.ui.pages.BoardPage;
import trello.ui.pages.BoardsPage;
import trello.ui.pages.LoginPage;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ListTests extends AbstractBaseTests {

    @Test
    public void createListTest() {

        // Test data
        String boardTitle = "STATIC_BOARD";
        String listName= "Test List";

        LoginPage loginPage = new LoginPage();
        BoardsPage boardsPage = loginPage.loginSuccessful(Environment.getInstance().getValue("user_name"),
                Environment.getInstance().getValue("password"));

        // Open Board
        BoardPage boardPage = boardsPage.openBoard(boardTitle);

        // Create List
        boardPage.addList(listName);

        // Verify the list name
        List<String> lists = boardPage.getLists();
        Assert.assertTrue(lists.contains(listName),
                "The list was not created. The board has the following lists: " + lists);
    }
}
