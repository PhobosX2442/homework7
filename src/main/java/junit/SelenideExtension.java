package junit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SelenideExtension implements BeforeAllCallback, AfterEachCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://cinescope.t-qa.ru";
        Configuration.timeout = 60000;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        Selenide.closeWebDriver();
    }
}
