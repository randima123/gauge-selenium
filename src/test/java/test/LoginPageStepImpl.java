package test;

import com.thoughtworks.gauge.Step;
import util.driver.Driver;
import page.LoginPage;

public class LoginPageStepImpl {

    private LoginPage loginPage = new LoginPage(Driver.webDriver);

    @Step("Input email <email>")
    public void enterEmail(String email) {
        loginPage.setEmail(email);
    }

    @Step("Input password <password>")
    public void enterPassword(String password) {
        loginPage.setPassword(password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        loginPage.clickSignIn();
    }
}
