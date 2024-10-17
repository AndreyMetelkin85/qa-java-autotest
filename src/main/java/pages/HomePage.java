package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import base.BasePage;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(Page page) {
        super(page);
    }
    public Locator title_page() {
        return get_element("//*[@id=\"app\"]/header//a");
    }

    public List<Locator> category_cards_home_page() {
        return get_elements("//div[@class=\"home-content\"]/child::div[2]/div/div");
    }

    public List<Locator> left_panel_buttons() {
        return get_elements("//div[@class=\"element-list collapse show\"]//descendant::li");
    }
}
