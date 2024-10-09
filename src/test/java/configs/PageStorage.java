package configs;


import com.microsoft.playwright.Page;

public class PageStorage {
    private final HomePage homePage;
    private final DataGenerator testData;

    public PageStorage(Page page, DataGenerator testData) {
        this.homePage = new HomePage(page);
        this.testData = new DataGenerator();
    }

    public HomePage getHomePage() {
        return homePage;
    }
    public DataGenerator getTestData() {
        return testData;
    }
}
