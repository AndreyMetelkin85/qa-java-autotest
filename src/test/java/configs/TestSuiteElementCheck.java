package configs;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class TestSuiteElementCheck {
    private final PlaywrightDriver driver;
    private final PageStorage pageStorage;

    public TestSuiteElementCheck() {
        this.driver = new PlaywrightDriver();
        Page page = driver.getPage();
        this.pageStorage = new PageStorage(page);
    }

    @Test
    public void test_home_page() {
        var checkTitle = pageStorage.getHomePage().title_page();
        assert checkTitle.isVisible();

        var selectCategory = pageStorage.getHomePage().category_cards_home_page();
        selectCategory.getFirst().click();

        var selectLeftPanelButton = pageStorage.getHomePage().left_panel_buttons();
        selectLeftPanelButton.getFirst().click();



    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
