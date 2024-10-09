package configs;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void open(String url) {
        page.navigate(url);
    }

    public Locator get_element(String locator) {
        return page.locator(locator);
    }

    public List<Locator> get_elements(String locator) {
        return page.locator(locator).all();
    }

    public Locator get_by_role(AriaRole role, String name) {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(name));
    }

    public Locator get_by_text(String text) {
        return page.getByText(text);
    }
}
