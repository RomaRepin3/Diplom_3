package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * <H2>Класс страницы "Личный кабинет".</H2>
 */
public class PersonalCabinetPage extends BasePage{

    // ссылка "Профиль"
    private final By profileLink = By.xpath("//a[text()='Профиль']");

    // ссылка "История заказов"
    private final By orderHistoryLink = By.xpath("//a[text()='История заказов']");

    // ссылка "Выход"
    private final By exitLink = By.xpath("//button[text()='Выход']");

    // надпись "Имя"
    private final By nameLabel = By.xpath("//label[text()='Имя']");

    // надпись "Логин"
    private final By loginLabel = By.xpath("//label[text()='Логин']");

    // надпись "Пароль"
    private final By passwordLabel = By.xpath("//label[text()='Пароль']");

    // информационное сообщение в личном кабинете
    private final By helpMessage = By.xpath(
            "//p[text()='В этом разделе вы можете изменить свои персональные данные']"
    );

    // кнопка "Отмена"
    private final By cancelButton = By.xpath("//button[text()='Отмена']");

    // кнопка "Сохранить"
    private final By saveButton = By.xpath("//button[text()='Сохранить']");

    public PersonalCabinetPage(WebDriver driver) {
        super(driver);
    }

    /**
     * <H3>Проверка страницы личного кабинета.</H3>
     *
     * @param user_name Имя пользователя.
     * @param login Логин пользователя.
     */
    @Step("Проверить страницу личного кабинета, имя пользователя {user_name}, логин {login}")
    public void checkPersonalCabinetPage(String user_name, String login) {

        // паттрен для формирования XPath селекторов для полей Имя и Логин
        String nameAndLoginSelectorPattern = "//input[@value='%s']";

        baseCheck();
        waitVisibilityOfElementLocated(profileLink);
        waitVisibilityOfElementLocated(orderHistoryLink);
        waitVisibilityOfElementLocated(exitLink);
        waitVisibilityOfElementLocated(nameLabel);
        waitVisibilityOfElementLocated(
                By.xpath(String.format(nameAndLoginSelectorPattern, user_name))
        );
        waitVisibilityOfElementLocated(loginLabel);
        waitVisibilityOfElementLocated(
                By.xpath(String.format(nameAndLoginSelectorPattern, login))
        );
        waitVisibilityOfElementLocated(passwordLabel);
        waitVisibilityOfElementLocated(
                By.xpath(String.format(nameAndLoginSelectorPattern, "*****"))
        );
        waitVisibilityOfElementLocated(helpMessage);
        waitVisibilityOfElementLocated(cancelButton);
        waitVisibilityOfElementLocated(saveButton);
    }

    /**
     * <H3>Нажитие ссылки "Выход".</H3>
     */
    @Step("Нажать ссылку выхода на странице личного кабинета")
    public void clickExitLink() {
        clickElement(exitLink);
    }
}
