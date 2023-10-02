package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * <H2>Класс страницы регистрации.</H2>
 */
public class RegistrationPage extends BasePage{

    // поле ввода имени
    private final By nameField = By.cssSelector("fieldset:nth-child(1) input");

    // поле ввода email
    private final By emailField = By.cssSelector("fieldset:nth-child(2) input");

    // поле ввода пароля
    private final By passwordField = By.cssSelector("fieldset:nth-child(3) input");

    // ошибка при невалидном пароле
    private final By passwordErrorLabel = By.xpath("//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * <H3>Открытие страницы регистрации.</H3>
     */
    public void openRegistrationPage() {
        getUrl("https://stellarburgers.nomoreparties.site/register");
    }

    /**
     * <H3>Проверка страницы регистрации.</H3>
     */
    public void checkPasswordRecoveryPage(boolean has_password_error) {
        waitVisibilityOfElementLocated(nameField);
        waitVisibilityOfElementLocated(emailField);
        waitVisibilityOfElementLocated(passwordField);
        waitVisibilityOfElementLocated(loginButton);

        if (has_password_error) {
            waitVisibilityOfElementLocated(passwordErrorLabel);
        }
    }

    /**
     * <H3>Заполнение поля ввода имени.</H3>
     *
     * @param name Имя пользователя.
     */
    public void fillNameField(String name) {
        fillField(nameField, name);
    }

    /**
     * <H3>Заполнение поля ввода email.</H3>
     *
     * @param email email пользователя.
     */
    public void fillEmailField(String email) {
        fillField(emailField, email);
    }

    /**
     * <H3>Заполнение поля ввода пароля.</H3>
     *
     * @param password Пароль пользователя.
     */
    public void fillPasswordField(String password) {
        fillField(passwordField, password);
    }

    public void fillRegistrationPage(String name, String email, String password) {
        fillNameField(name);
        fillEmailField(email);
        fillPasswordField(password);
    }

    /**
     * <H3>Нажатие кнопки "Войти".</H3>
     */
    public void clickLoginButton() {
        clickElement(loginButton);
    }
}
