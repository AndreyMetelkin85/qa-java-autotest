package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import base.BasePage;

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
    public Locator radioButtonPageTitle() {
        return get_by_text("Do you like the site?");
    }
    public Locator radioButtonYes() {
        return get_element("//input[@id=\"yesRadio\"]");
    }
    public Locator radioButtonImpressive() {
        return get_element("//input[@id=\"impressiveRadio\"]");
    }
    public Locator radioButtonNo() {
        return get_element("//input[@id=\"noRadio\"]");
    }
    public Locator responseHeaderSelect() {
        return get_element("//p[@class=\"mt-3\"]");
    }


}
