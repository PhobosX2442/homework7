package junit;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import pages.LoginPage;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext) {

        new LoginPage()
                .openLoginPage()
                .setEmail("quicksilverx@yandex.ru")
                .setPassword("Qwer1234")
                .clickLogin();
    }
}
