package configs;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

import java.util.List;

public class PlaywrightDriver {
    private final Playwright playwright;
    private final Browser browser;
    private final Page page;

    public PlaywrightDriver() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(List.of("--start-maximized")));
        page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();
        page.navigate("https://demoqa.com", new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }

    public Page getPage() {
        return page;
    }

    public void close() {
        browser.close();
        playwright.close();
    }
}
