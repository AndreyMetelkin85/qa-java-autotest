package configs;


import com.microsoft.playwright.Page;

public class PageStorage {
    private final HomePage homePage;
    private final TextBoxPage textBoxPage;

    public PageStorage(Page page) {
        this.homePage = new HomePage(page);
        this.textBoxPage = new TextBoxPage(page);
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public  TextBoxPage getTextBoxPage() {
        return textBoxPage;
    }
}
