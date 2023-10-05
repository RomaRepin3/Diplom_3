package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * <H2>Класс главной страницы.</H2>
 */
public class MainPage extends BasePage {

    // таб "Булки" на главной странице
    private final By rollsTab = By.xpath("//span[text()='Булки']");

    // таб "Соусы" на главной странице
    private final By saucesTab = By.xpath("//span[text()='Соусы']");

    // таб "Начинки" на главной странице
    private final By fillingsTab = By.xpath("//span[text()='Начинки']");

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
        waitVisibilityOfElementLocated(rollsTab);
        waitVisibilityOfElementLocated(saucesTab);
        waitVisibilityOfElementLocated(fillingsTab);
        if (!has_authenticated) {
            waitVisibilityOfElementLocated(loginToAccountButton);
        }
        else {
            waitVisibilityOfElementLocated(placeOrderButton);
        }
    }

    /**
     * <H3>Нажитие таба "Булки".</H3>
     */
    public void clickRollsTab() {
        clickElement(rollsTab);
    }

    /**
     * <H3>Нажатие таба "Соусы".</H3>
     */
    public void clickSaucesTab() {
        clickElement(saucesTab);
    }

    /**
     * <H3>Нажатие таба "Начинки".</H3>
     */
    public void clickFillingsTab() {
        clickElement(fillingsTab);
    }

    /**
     * <H3>Нажатие кнопки "Войти в аккаунт".</H3>
     */
    public void clickLoginToAccountButton() {
        clickElement(loginToAccountButton);
    }
}
