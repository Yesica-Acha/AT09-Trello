package cucumber.steps;

import core.Environment;
import core.selenium.DriverManager;
import core.selenium.SharedDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import trello.config.UserConfig;
import trello.ui.entities.User;
import trello.ui.pages.AccountMenuPage;
import trello.ui.pages.BoardsPage;
import trello.ui.pages.LoginPage;

import java.util.Map;

public class LoginSteps {

    LoginPage loginPage;
    BoardsPage boardsPage;

    public LoginSteps(final SharedDriver sharedDriver) {

    }

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        loginPage = new LoginPage();
    }

    @When("I login with username {string} and password {string}")
    public void login(String userEmail, final String userPassword) {
        boardsPage = loginPage.loginSuccessful(userEmail, userPassword);
    }

    // Example with Data Table
    @When("I log in with the following information:")
    public void loginWithValidCredentials(DataTable userInfo) {
        Map<String, String> userInfoMap = userInfo.asMap(String.class, String.class);
        login(userInfoMap.get("User Email"), userInfoMap.get("User Password"));
    }

    @DataTableType
    public User getUser(Map<String, String> userInfo){
        return new User(userInfo.get("User Email"), userInfo.get("User Password"));
    }

    @When("I login with the following information:")
    public void loginWithValidCredentials(User user) {
        login(user.getEmail(), user.getPassword());
    }

//    @Given("I am logged in with valid user credentials")
    @Given("^I am logged in with (.*?) user credentials$")
    public void loginWithValidCredentials(final String userAlias) {
        navigateToLoginPage();

//        String userEmail = Environment.getInstance().getValue("user_name");
//        String userPassword = Environment.getInstance().getValue("password");

        User user = UserConfig.getUserByAlias(userAlias);
        login(user.getEmail(), user.getPassword());
    }

    @Then("I should see {string} in the top menu")
    public void verifyUserNameInTopMenu(String userName) {
        Assert.assertEquals(boardsPage.getTopMenu().getUserName(), userName,
                "The User name displayed in the top menu was not the expected.");
    }
    @Then("I should see {string} and {string} in the account menu")
    public void verifyUserInformationInAccountMenu(String userEmail, String userName) {
        AccountMenuPage accountMenuPage = boardsPage.getTopMenu().openAccountMenu();

        Assert.assertTrue(accountMenuPage.isUserInfoDisplayed(userName), "The user name was not the expected.");
        Assert.assertTrue(accountMenuPage.isUserInfoDisplayed(userEmail), "The user email was not the expected.");
    }

}
