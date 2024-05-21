package trello;

import org.testng.Assert;
import org.testng.annotations.Test;
import trello.ui.pages.AccountMenuPage;
import trello.ui.pages.BoardsPage;
import trello.ui.pages.LoginPage;

public class LoginTests extends AbstractBaseTests  {


    @Test
    public void loginSuccessfulTest() {

        // Tes data
        String userEmail = "autotester248@gmail.com";
        String userPassword = "password";
        String userName = "Automation Testing";

        LoginPage loginPage = new LoginPage();
        BoardsPage boardsPage = loginPage.loginSuccessful(userEmail, userPassword);

        Assert.assertEquals(boardsPage.getTopMenu().getUserName(), userName,
                "The User name displayed in the top menu was not the expected.");

        AccountMenuPage accountMenuPage = boardsPage.getTopMenu().openAccountMenu();

        Assert.assertTrue(accountMenuPage.isUserInfoDisplayed(userName), "The user name was not the expected.");
        Assert.assertTrue(accountMenuPage.isUserInfoDisplayed(userEmail), "The user email was not the expected.");
        System.out.println("test");
    }
}
