package configs;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CustomExpect {
    protected Page page;

    public CustomExpect(Page page) {
        this.page = page;
    }


    public void toBeVisible(Locator locator, int timeout) {
        try {
            assertThat(locator).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(timeout));
        } catch (Exception e) {
            LogManager.error("Ошибка при проверке видимости локатора: " + locator + " Ошибка: " + e.getMessage());
            throw e;
        }
    }

    public void notToBeVisible(Locator locator, int timeout) {
        try {
            assertThat(locator).not().isVisible(new LocatorAssertions.IsVisibleOptions()
                    .setTimeout(timeout));
        } catch (Exception e) {
            LogManager.error("Ошибка при проверке, что элемент не виден: " + locator + " Ошибка: " + e.getMessage());
            throw e;
        }
    }

    public void toBeChecked(Locator locator, int timeout) {
        try {
            assertThat(locator).isChecked(new LocatorAssertions.IsCheckedOptions().setTimeout(timeout));
        } catch (Exception e) {
            LogManager.error("Ошибка при проверке, что элемент " + locator + " выбран в течение " + timeout
                    + " миллисекунд. " + "Ошибка: " + e.getMessage());
            throw e;
        }
    }
}
