package pages;


import com.microsoft.playwright.Page;

public class PageStorage {
    public final HomePage homePage;
    public final TextBoxPage textBoxPage;
    public final ElementsPage elementsPage;

    public PageStorage(Page page) {
        this.homePage = new HomePage(page);
        this.textBoxPage = new TextBoxPage(page);
        this.elementsPage = new ElementsPage(page);
    }

    public HomePage getHomePage() {
        return homePage;
    }
    public  TextBoxPage getTextBoxPage() {
        return textBoxPage;
    }
    public ElementsPage getElementsPage() {
        return elementsPage;
    }

}
