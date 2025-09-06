package junit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

import static javax.swing.UIManager.put;

public class SelenideExtension implements BeforeAllCallback, AfterEachCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        // Базовые настройки Selenide
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://cinescope.t-qa.ru";
        Configuration.timeout = 60000;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;

        // Настройки для Selenoid
        Configuration.remote = "http://host.docker.internal:4444/wd/hub";
        Configuration.browserVersion = "128.0";

        // Capabilities для Selenoid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVNC", true);
            put("enableVideo", false);
            put("enableLog", true);
        }});

        // Chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--window-size=1920,1080");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        Selenide.closeWebDriver();
    }
}
