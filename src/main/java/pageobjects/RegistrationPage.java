package pageobjects;

import io.qameta.allure.Step;
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

    // кнопка "Зарегистрироваться"
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * <H3>Открытие страницы регистрации.</H3>
     */
    @Step("Открыть страницу регистрации")
    public void openRegistrationPage() {
        getUrl("https://stellarburgers.nomoreparties.site/register");
    }

    /**
     * <H3>Проверка страницы регистрации.</H3>
     */
    @Step("Проверить страницу регистрации, отображение ошибки валидации пароля {has_password_error}")
    public void checkRegistrationPage(boolean has_password_error) {
        waitVisibilityOfElementLocated(nameField);
        waitVisibilityOfElementLocated(emailField);
        waitVisibilityOfElementLocated(passwordField);
        waitVisibilityOfElementLocated(registrationButton);
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
    @Step("Заполнение поля ввода имени на странице регистрации значением {name}")
    public void fillNameField(String name) {
        fillField(nameField, name);
    }

    /**
     * <H3>Заполнение поля ввода email.</H3>
     *
     * @param email email пользователя.
     */
    @Step("Заполнение поля ввода email на странице регистрации значением {email}")
    public void fillEmailField(String email) {
        fillField(emailField, email);
    }

    /**
     * <H3>Заполнение поля ввода пароля.</H3>
     *
     * @param password Пароль пользователя.
     */
    @Step("Заполнение поля ввода пароля на странице регистрации значением {password}")
    public void fillPasswordField(String password) {
        fillField(passwordField, password);
    }

    /**
     * <H3>Заполнение страницы регистрации.</H3>
     *
     * @param name Имя пользователя.
     * @param email email адрес пользователя.
     * @param password Пароль пользователя.
     */
    @Step("Заполнение страницы регистрации, имя {name}, email {email}, пароль {password}")
    public void fillRegistrationPage(String name, String email, String password) {
        fillNameField(name);
        fillEmailField(email);
        fillPasswordField(password);
    }

    /**
     * <H3>Нажатие кнопки "Зарегистрироваться".</H3>
     */
    @Step("Нажать кнопку \"Зарегистрироваться\" на странице регистрации")
    public void clickRegistrationButton() {
        clickElement(registrationButton);
    }

    /**
     * <H3>Нажатие кнопки "Войти".</H3>
     */
    @Step("Нажать кнопку \"Войти\" на странице регистрации")
    public void clickLoginButton() {
        clickElement(loginButton);
    }
}
