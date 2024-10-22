package Ui_tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.CustomExpect;
import utils.DataGenerator;
import pages.PageStorage;
import drivers.PlaywrightDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

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

        var checkTitle = pageStorage.homePage.title_page();
        expect.toBeVisible(checkTitle, 2000);

        var selectCategory = pageStorage.homePage.category_cards_home_page();
        selectCategory.getFirst().click();

        var selectLeftPanelButton = pageStorage.homePage.left_panel_buttons();
        selectLeftPanelButton.getFirst().click();

        // Генерируем данные для заполнения полей
        String generatedFullName = DataGenerator.FullName();
        String generatedEmail = DataGenerator.Email();
        String generatedCurrentAddress = DataGenerator.CurrentAddress();
        String generatedPermanentAddress = DataGenerator.PermanentAddress();

        var inputFullName = pageStorage.textBoxPage.userFullName();
        inputFullName.fill(generatedFullName);

        var inputEmail = pageStorage.textBoxPage.userEmail();
        inputEmail.fill(generatedEmail);

        var inputCurrentAddress = pageStorage.textBoxPage.userCurrentAddress();
        inputCurrentAddress.fill(generatedCurrentAddress);

        var inputPermanentAddress = pageStorage.textBoxPage.userPermanentAddress();
        inputPermanentAddress.fill(generatedPermanentAddress);

        var clickButtonSubmit = pageStorage.textBoxPage.submitButton();
        clickButtonSubmit.click();

        var checkResults = pageStorage.textBoxPage.outputField();
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
        var selectCategory = pageStorage.homePage.category_cards_home_page();
        selectCategory.getFirst().click();

        var elementsButtonCheckBox = pageStorage.homePage.left_panel_buttons();
        elementsButtonCheckBox.get(1).click();

        var boxExpandButton = pageStorage.elementsPage.expandAllButton();
        boxExpandButton.click();

        var openCheckAllFolders = pageStorage.elementsPage.gettingAllFolders();
        System.out.println("Найдено папок после раскрытия: " + openCheckAllFolders.size());

        // В цикле проверяем, что все разделы раскрыты и все папки отображаются.
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

        // В цикле проверяем, что все разделы скрыты и папки не отображаются.
        for (var resultsClose : closeCheckAllFolders) {
            if (!resultsClose.isVisible()) {
                System.out.println("Папка " + resultsClose.textContent() + " успешно скрыта");
            } else {
                System.out.println("Ошибка: папка " + resultsClose.textContent() + " всё ещё видима");
            }
        }
    }

    @Test
    @DisplayName("В тесте проверяем, что пользователь может кликнуть по кнопкам radio button")
    public void testRadioButtonCheck() {
        var selectCategory = pageStorage.homePage.category_cards_home_page();
        selectCategory.getFirst().click();

        var elementsButtonCheckBox = pageStorage.homePage.left_panel_buttons();
        elementsButtonCheckBox.get(2).click();

        var checkTitle = pageStorage.elementsPage.radioButtonPageTitle();
        expect.toBeVisible(checkTitle, 500);

        var clickRadioButtonYes = pageStorage.elementsPage.radioButtonYes();
        clickRadioButtonYes.click(new Locator.ClickOptions().setForce(true));

        var checkResponseTitleYes = pageStorage.elementsPage.responseHeaderSelect().textContent();
        assert checkResponseTitleYes.contains("Yes");

        var clickRadioButtonImpressive = pageStorage.elementsPage.radioButtonImpressive();
        clickRadioButtonImpressive.click(new Locator.ClickOptions().setForce(true));

        var checkResponseTitleImpressive = pageStorage.elementsPage.responseHeaderSelect().textContent();
        assert checkResponseTitleImpressive.contains("Impressive");

        var checkButtonNoStatusDisable = pageStorage.elementsPage.radioButtonNo();
        expect.toBeVisible(checkButtonNoStatusDisable, 500);
        expect.isDisabled(checkButtonNoStatusDisable, 500);
    }


    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
