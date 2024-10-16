package configs;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class ElementsPage extends BasePage {
    public ElementsPage(Page page) {
        super(page);
    }
    public Locator expandAllButton() {
        return get_element("//button[@class=\"rct-option rct-option-expand-all\" and @type=\"button\"]");
    }
    public Locator collapseAllButton() {
        return get_element("//button[@class=\"rct-option rct-option-collapse-all\" and @type=\"button\"]");
    }
    public List<Locator> gettingAllFolders() {
        return get_elements("//span[text()=\"Home\"]/following::ol//child::li//span[3]");
    }


}
