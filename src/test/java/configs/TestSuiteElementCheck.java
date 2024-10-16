package configs;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSuiteElementCheck {
    private final PlaywrightDriver driver;
    private final PageStorage pageStorage;
    private final CustomExpect expect;

    public TestSuiteElementCheck() {
        this.driver = new PlaywrightDriver();
        Page page = driver.getPage();
        this.pageStorage = new PageStorage(page);
        this.expect = new CustomExpect(page);

    }

    @Test
    @DisplayName("Проверяем переход по сайту и заполнение формы валидными данными.")
    public void testElementTextBox() {

        var checkTitle = pageStorage.getHomePage().title_page();
        expect.toBeVisible(checkTitle, 2000);

        var selectCategory = pageStorage.getHomePage().category_cards_home_page();
        selectCategory.getFirst().click();

        var selectLeftPanelButton = pageStorage.getHomePage().left_panel_buttons();
        selectLeftPanelButton.getFirst().click();

        // Генерируем данные для заполнения полей
        String generatedFullName = DataGenerator.FullName();
        String generatedEmail = DataGenerator.Email();
        String generatedCurrentAddress = DataGenerator.CurrentAddress();
        String generatedPermanentAddress = DataGenerator.PermanentAddress();

        var inputFullName = pageStorage.getTextBoxPage().userFullName();
        inputFullName.fill(generatedFullName);

        var inputEmail = pageStorage.getTextBoxPage().userEmail();
        inputEmail.fill(generatedEmail);

        var inputCurrentAddress = pageStorage.getTextBoxPage().userCurrentAddress();
        inputCurrentAddress.fill(generatedCurrentAddress);

        var inputPermanentAddress = pageStorage.getTextBoxPage().userPermanentAddress();
        inputPermanentAddress.fill(generatedPermanentAddress);

        var clickButtonSubmit = pageStorage.getTextBoxPage().submitButton();
        clickButtonSubmit.click();

        var checkResults = pageStorage.getTextBoxPage().outputField();
        for (var result : checkResults) {
            String textResult = result.textContent();

            // Проверяем каждую строку на наличие сгенерированных данных
            if (textResult.contains(generatedFullName)) {
                System.out.println("Полное имя совпадает: " + textResult);
            } else if (textResult.contains(generatedEmail)) {
                System.out.println("Email совпадает: " + textResult);
            } else if (textResult.contains(generatedCurrentAddress)) {
                System.out.println("Текущий адрес совпадает: " + textResult);
            } else if (textResult.contains(generatedPermanentAddress)) {
                System.out.println("Постоянный адрес совпадает: " + textResult);
            } else {
                System.out.println("Найден неизвестный результат: " + textResult);
            }
        }
    }

    @Test
    @DisplayName("Проверяем работу кнопок на открытие и закрытие + отображения папок")
    public void testCheckBoxExpandAndCloseFolders() {
        var selectCategory = pageStorage.getHomePage().category_cards_home_page();
        selectCategory.getFirst().click();

        var elementsButtonCheckBox = pageStorage.getHomePage().left_panel_buttons();
        elementsButtonCheckBox.get(1).click();

        var boxExpandButton = pageStorage.elementsPage.expandAllButton();
        boxExpandButton.click();

        var openCheckAllFolders = pageStorage.elementsPage.gettingAllFolders();
        System.out.println("Найдено папок после раскрытия: " + openCheckAllFolders.size());
        for (var resultsOpen : openCheckAllFolders) {
            if (resultsOpen.isVisible()) {
                System.out.println("Папка под названием: " + resultsOpen.textContent() + " отображается");
            } else {
                System.out.println("Папка: " + resultsOpen.textContent() + " не отображается");
            }
        }

        var boxCollapseAllButton = pageStorage.elementsPage.collapseAllButton();
        boxCollapseAllButton.click();

        var closeCheckAllFolders = pageStorage.elementsPage.gettingAllFolders();
        System.out.println("Найдено папок после закрытия: " + closeCheckAllFolders.size());

        for (var resultsClose : closeCheckAllFolders) {
            if (!resultsClose.isVisible()) {
                System.out.println("Папка " + resultsClose.textContent() + " успешно скрыта");
            } else {
                System.out.println("Ошибка: папка " + resultsClose.textContent() + " всё ещё видима");
            }
        }
    }


    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
