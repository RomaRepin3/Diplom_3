package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * <H2>Класс страницы "Личный кабинет".</H2>
 */
public class PersonalCabinetPage extends BasePage{

    // ссылка "Выход"
    private final By exitLink = By.xpath("//button[text()='Выход']");

    // поле с именем пользователя
    private final By nameField = By.cssSelector("ul > li:nth-child(1) input");

    // поле с логином пользователя
    private final By emailField = By.cssSelector("ul > li:nth-child(2) input");

    public PersonalCabinetPage(WebDriver driver) {
        super(driver);
    }

    /**
     * <H3>Проверка страницы личного кабинета.</H3>
     */
    @Step("Проверить страницу личного кабинета")
    public void checkPersonalCabinetPage() {

        baseCheck();
        waitVisibilityOfElementLocated(exitLink);
        waitVisibilityOfElementLocated(nameField);
        waitVisibilityOfElementLocated(emailField);
    }

    /**
     * <H3>Получение имени пользователя из поля в личном кабинете.</H3>
     *
     * @return Имя пользователя из страницы личного кабинета.
     */
    @Step("Получить имя пользователя из поля в Личном кабинете")
    public String getNameValue() {
        return getValueFromElement(nameField);
    }

    /**
     * <H3>Получение email пользователя из поля в личном кабинете.</H3>
     *
     * @return Email пользователя из страницы личного каюбинета.
     */
    @Step("Получить email пользователя из поля в Личном кабинете")
    public String getEmailValue() {
        return getValueFromElement(emailField);
    }

    /**
     * <H3>Нажитие ссылки "Выход".</H3>
     */
    @Step("Нажать ссылку выхода на странице личного кабинета")
    public void clickExitLink() {
        clickElement(exitLink);
    }
}
