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
        try {
            LogManager.info("Получение элемента по locator" + locator);
            return page.locator(locator);
        } catch (Exception e) {
            LogManager.error("Ошибка при получении элемента: " + locator + " :" + e.getMessage());
        }
        return null;
    }

    public List<Locator> get_elements(String locator) {
        try {
            LogManager.info("Получение элементов по локатору: " + locator);
            return page.locator(locator).all();
        } catch (Exception e) {
            LogManager.error("Ошибка при получении элементов по локатору: " + locator + " :" + e.getMessage());
        }
        return null;
    }

    public Locator get_by_role(AriaRole role, String name) {
        try {
            LogManager.info("Получение элемента по роли: " + role + " и имени: " + name);
            return page.getByRole(role, new Page.GetByRoleOptions().setName(name));
        } catch (Exception e) {
            LogManager.error("Ошибка при получении элемента по роли : " + role + " и имени: " + name + e.getMessage());
        }
        return null;
    }

    public Locator get_by_text(String text) {
        try {
            LogManager.info("Получение элемента по тексту: " + text);
            return page.getByText(text);
        } catch (Exception e) {
            LogManager.error("Ошибка при получении элемента по тексту: " + text + " :" + e.getMessage());
        }
        return null;
    }
}
