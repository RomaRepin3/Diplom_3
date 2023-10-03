package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * <H2>Класс главной страницы.</H2>
 */
public class MainPage extends BasePage {

    // кнопка "Войти в аккаунт" на главной странице
    private final By loginToAccountButton = By.xpath("//button[text()='Войти в аккаунт']");

    // кнопка "Оформить заказ" на главной странице
    private final By placeOrderButton = By.xpath("//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * <H3>Открытие Главной страницы.</H3>
     */
    public void openMainPage() {
        getUrl("https://stellarburgers.nomoreparties.site");
    }

    /**
     *<H3>Проверка Главной страницы.</H3>
     */
    public void checkMainPage(boolean has_authenticated) {
        baseCheck();
        if (!has_authenticated) {
            waitVisibilityOfElementLocated(loginToAccountButton);
        }
        else {
            waitVisibilityOfElementLocated(placeOrderButton);
        }
    }

    /**
     * <H3>Нажатие кнопки "Войти в аккаунт".</H3>
     */
    public void clickLoginToAccountButton() {
        clickElement(loginToAccountButton);
    }
}
