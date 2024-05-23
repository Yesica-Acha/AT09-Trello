package trello.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.AbstractBasePage;

public class LoginPage extends AbstractBasePage {

    @FindBy(id="username")
    private WebElement userNameTxtBox;

    @FindBy(id="password")
    private WebElement passwordTxtBox;

    @FindBy(id="login-submit")
    private WebElement continueLoginBtn;

    public LoginPage() {
        super();
        driver.get("https://trello.com/login");
    }


    public BoardsPage loginSuccessful(final String userEmail, final String password) {
        setUserName(userEmail);
        clickLoginBtn();
        setPassword(password);
        clickLoginBtn();
        return new BoardsPage();
    }

    public LoginPage loginWithInvalidEmail(final String invalidUserEmail) {
        setUserName(invalidUserEmail);
        clickLoginBtn();
        return this;
    }

    public void loginWithInvalidPassword(final String userEmail, String invalidPassword) {
        setUserName(userEmail);
        clickLoginBtn();
        setPassword(invalidPassword);
        clickLoginBtn();
    }

    public LoginPage clickLoginBtn() {
        action.click(continueLoginBtn);
//        wait.until(ExpectedConditions.elementToBeClickable(continueLoginBtn));
//        continueLoginBtn.click();
        return this;
    }

    public LoginPage setPassword(String password) {
        action.setValue(passwordTxtBox, password);
//        passwordTxtBox.clear();
//        passwordTxtBox.sendKeys(password);
        return this;
    }

    public LoginPage setUserName(String userEmail) {
        action.setValue(userNameTxtBox, userEmail);
//        userNameTxtBox.clear();
//        userNameTxtBox.sendKeys(userEmail);
        return this;
    }
}
