package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * <H2>Классс страницы восстановления пароля.</H2>
 */
public class PasswordRecoveryPage extends BasePage {

    // заголовок "Восстановление пароля"
    private final By passwordRecoveryLabel = By.xpath("//h2[text()='Восстановление пароля']");

    // поле ввода email
    private final By emailField = By.cssSelector("input.text");

    // кнопка "Восстановить"
    private final By recoveryButton = By.xpath("//button[text()='Восстановить']");

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    /**
     * <H3>Открытие страницы восстановления пароля.</H3>
     */
    @Step("Открыть страницу восстановления пароля")
    public void openPasswordRecoveryPage() {
        getUrl("https://stellarburgers.nomoreparties.site/forgot-password");
    }

    /**
     * <H3>Проверка страницы восстановления пароля.</H3>
     */
    @Step("Проверить страницу восстановления пароля")
    public void checkPasswordRecoveryPage() {
        baseCheck();
        waitVisibilityOfElementLocated(passwordRecoveryLabel);
        waitVisibilityOfElementLocated(emailField);
        waitVisibilityOfElementLocated(loginButton);
        waitVisibilityOfElementLocated(recoveryButton);
    }

    /**
     * <H3>Нажатие кнопки "Войти".</H3>
     */
    @Step("Нажать кнопку входа на странице восстановления пароля")
    public void clickLoginButton() {
        clickElement(loginButton);
    }
}
