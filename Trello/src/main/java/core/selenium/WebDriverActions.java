package core.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverActions {

    private final WebDriver driver;

    private final WebDriverWait wait;

    public WebDriverActions(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(final WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void click(final By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    public String getText(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public String getText(final By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void setValue(final WebElement webElement, final String value) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void selectCheckBox(final WebElement checkbox) {
        if (!checkbox.isSelected()) {
            click(checkbox);
        }
    }

    public void selectDropDown(final WebElement webElement, final String option) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Select selectField = new Select(webElement);
        selectField.selectByVisibleText(option);
    }

    public boolean isElementPresent(final By locator, final int defaultImplicitTime) {
        try {
            // Changing timeout
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            // Restore timeout
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(defaultImplicitTime));
        }
    }

    public void jsClick(final WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }

    public void scrollTo(final WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }
}
