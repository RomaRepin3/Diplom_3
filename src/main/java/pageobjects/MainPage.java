package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


/**
 * <H2>Класс главной страницы.</H2>
 */
public class MainPage extends BasePage {

    // длительность ожидания после переключения в конструкторе
    private final int afterClickTabTimeout = 1;

    // таб "Булки" на главной странице
    private final By rollsTab = By.xpath("//span[text()='Булки']");

    // таб "Соусы" на главной странице
    private final By saucesTab = By.xpath("//span[text()='Соусы']");

    // таб "Начинки" на главной странице
    private final By fillingsTab = By.xpath("//span[text()='Начинки']");

    // активный таб конструктора
    private final By activeTab = By.cssSelector(".tab_tab_type_current__2BEPc span");

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
    @Step("Открыть главную страницу")
    public void openMainPage() {
        getUrl("https://stellarburgers.nomoreparties.site");
    }

    /**
     *<H3>Проверка Главной страницы с указанием текущего раздела в конструкторе.</H3>
     *
     * @param has_authenticated Признак авторизации пользователя.
     */
    @Step("Проверить главную страницу, пользователь авторизован {has_authenticated}")
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
     * <H3>Нажатие таба "Булки".</H3>
     */
    @Step("Нажать таб \"Булки\"")
    public void clickRollsTab() throws InterruptedException {

        clickElement(rollsTab);
        TimeUnit.SECONDS.sleep(afterClickTabTimeout);

    }

    /**
     * <H3>Нажатие таба "Соусы".</H3>
     */
    @Step("Нажать таб \"Соусы\"")
    public void clickSaucesTab() throws InterruptedException {

        clickElement(saucesTab);
        TimeUnit.SECONDS.sleep(afterClickTabTimeout);

    }

    /**
     * <H3>Нажатие таба "Начинки".</H3>
     */
    @Step("Нажать таб \"Начинки\"")
    public void clickFillingsTab() throws InterruptedException {

        clickElement(fillingsTab);
        TimeUnit.SECONDS.sleep(afterClickTabTimeout);

    }

    /**
     * <H3>Получение названия активного таба.</H3>
     *
     * @return Навзание активного таба.
     */
    @Step("Получить название активного таба")
    public String getActiveTabName() {
        return getTextFromElement(activeTab);
    }

    /**
     * <H3>Нажатие кнопки "Войти в аккаунт".</H3>
     */
    @Step("Нажать кнопку \"Войти в аккаунт\"")
    public void clickLoginToAccountButton() {

        clickElement(loginToAccountButton);

    }
}
