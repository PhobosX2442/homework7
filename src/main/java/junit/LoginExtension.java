package junit;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import pages.LoginPage;


public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext) {


        LoginPage loginPage = new LoginPage();

        loginPage.openBrowser("/login");
        loginPage.setEmail("quicksilverx@yandex.ru");
        loginPage.setPassword("Qwer1234");
        loginPage.clickLogin();
    }
}
