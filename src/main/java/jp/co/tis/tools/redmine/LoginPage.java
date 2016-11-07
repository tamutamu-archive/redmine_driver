package jp.co.tis.tools.redmine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(name = "username")
    @CacheLookup
    private WebElement username;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement password;

    @FindBy(name = "login")
    @CacheLookup
    private WebElement login;

    public LoginPage(WebDriver _driver) {
        this.driver = _driver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String username, String password) {

        this.driver.get(AppConst.REDMINE_URL);

        this.username.sendKeys(username);
        this.password.sendKeys(password);

        this.login.click();
    }
}
