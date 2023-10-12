package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * <H2>Класс страницы авторизации.</H2>
 */
public class LoginPage extends BasePage {

    // поле ввода email
    private final By emailField = By.cssSelector("fieldset:nth-child(1) input");

    // поле ввода пароля
    private final By passwordField = By.cssSelector("fieldset:nth-child(2) input");

    // кнопка "Войти"
    private final By loginButton = By.xpath("//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * <H3>Открытие страницы авторизации.</H3>
     */
    public void openLoginPage() {
        getUrl("https://stellarburgers.nomoreparties.site/login");
    }

    /**
     *<H3>Проверка страницы авторизации.</H3>
     */
    public void checkLoginPage() {
        baseCheck();
        waitVisibilityOfElementLocated(emailField);
        waitVisibilityOfElementLocated(passwordField);
        waitVisibilityOfElementLocated(loginButton);
    }

    /**
     * <H3>Заполнение поля email.</H3>
     *
     * @param email Значение email.
     */
    @Step("Заполнить поле email начением {email}")
    public void fillEmailField(String email) {
        fillField(emailField, email);
    }

    /**
     * <H3>Заполнение поля пароль.</H3>
     *
     * @param password Значение пароля.
     */
    @Step("Заполнить поле пароль значением {password}")
    public void fillPasswordField(String password) {
        fillField(passwordField, password);
    }

    @Step("Заполнить страницу авторизации значениями email {email}  пароля {password}")
    public void fillLoginPage(String email, String password) {
        fillEmailField(email);
        fillPasswordField(password);
    }

    /**
     *<H3>Нажатие кнопки "Войти".</H3>
     */
    @Step("Нажать кнопку входа на странице автризации")
    public void clickLoginButton() {
        clickElement(loginButton);
    }
}
