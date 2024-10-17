package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import base.BasePage;

import java.util.List;

public class TextBoxPage extends BasePage {
    public TextBoxPage(Page page) {
        super(page);
    }
    public Locator userFullName() {
        return get_element("//input[@id=\"userName\"]");
    }
    public Locator userEmail() {
        return get_element("//input[@id=\"userEmail\"]");
    }
    public Locator userCurrentAddress() {
        return get_element("//textarea[@id=\"currentAddress\"]");
    }
    public Locator userPermanentAddress() {
        return get_element("//textarea[@id=\"permanentAddress\"]");
    }
    public Locator submitButton() {
        return get_element("//button[@id=\"submit\"]");
    }
    public List<Locator> outputField() {
        return get_elements("//div[@id=\"output\"]//descendant::p");
    }

}
