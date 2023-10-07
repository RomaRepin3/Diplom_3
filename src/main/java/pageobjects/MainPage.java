package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * <H2>Класс главной страницы.</H2>
 */
public class MainPage extends BasePage {

    // таб "Булки" на главной странице
    private final By rollsTab = By.xpath("//span[text()='Булки']");

    // надпись "Булки" в конструкторе
    private final By rollsLabel = By.xpath("//h2[text()='Булки']");

    // изображение "Флюоресцентная булка" в конструкторе
    private final By fluorescentRollImage = By.cssSelector("img[alt='Флюоресцентная булка R2-D3']");

    // надпись "Флюоресцентная булка" в конструкторе
    private final By fluorescentRollLabel = By.xpath("//p[text()='Флюоресцентная булка R2-D3']");

    // изображение "Краторная булка" в конструкторе
    private final By craterRollImage = By.cssSelector("img[alt='Краторная булка N-200i']");

    // надпись "Краторная булка" в конструкторе
    private final By craterRollLabel = By.xpath("//p[text()='Краторная булка N-200i']");

    // таб "Соусы" на главной странице
    private final By saucesTab = By.xpath("//span[text()='Соусы']");

    // надпись "Соусы" в конструкторе
    private final By saucesLabel = By.xpath("//h2[text()='Соусы']");

    // изображение "Соус Spicy-X" в конструкторе
    private final By spicyXSauceImage = By.cssSelector("img[alt='Соус Spicy-X']");

    // надпись "Соус Spicy-X" в конструкторе
    private final By spicyXSauceLabel = By.xpath("//p[text()='Соус Spicy-X']");

    // изображение "Соус фирменный Space Sauce" в конструкторе
    private final By brandedSauceSpaceSauceImage = By.cssSelector("img[alt='Соус фирменный Space Sauce']");

    // надпись "Соус фирменный Space Sauce" в конструкторе
    private final By brandedSauceSpaceSauceLabel = By.xpath("//p[text()='Соус фирменный Space Sauce']");

    // таб "Начинки" на главной странице
    private final By fillingsTab = By.xpath("//span[text()='Начинки']");

    // надпись "Начинки" в конструкторе
    private final By fillingsLabel = By.xpath("//h2[text()='Начинки']");

    // изображение "Мясо бессмертных моллюсков Protostomia" в конструкторе
    private final By immortalMollusksProtostomiaMeatFillingImage = By.cssSelector(
            "img[alt='Мясо бессмертных моллюсков Protostomia']"
    );

    // надпись "Мясо бессмертных моллюсков Protostomia" в конструкторе
    private final By immortalMollusksProtostomiaMeatFillingLabel = By.xpath(
            "//p[text()='Мясо бессмертных моллюсков Protostomia']"
    );

    // изображение "Говяжий метеорит (отбивная)" в конструкторе
    private final By beefMeteoriteChopFillingImage = By.cssSelector("img[alt='Говяжий метеорит (отбивная)']");

    // надпись "Говяжий метеорит (отбивная)" в конструкторе
    private final By beefMeteoriteChopFillingLabel = By.xpath("//p[text()='Говяжий метеорит (отбивная)']");

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
     * <H3>Проверка Главной страницы с отображением конструктора по умолчанию</H3>
     *
     * @param has_authenticated Признак авторизации пользователя.
     */
    public void checkMainPage(boolean has_authenticated) {
        checkMainPage(has_authenticated, MainPageConstructorSections.ROLLS);
    }

    /**
     *<H3>Проверка Главной страницы с указанием текущего раздела в конструкторе.</H3>
     *
     * @param has_authenticated Признак авторизации пользователя.
     * @param checkingSection Текущая отображаемая секция в конструкторе.
     */
    public void checkMainPage(boolean has_authenticated, MainPageConstructorSections checkingSection) {

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

        if (checkingSection == MainPageConstructorSections.ROLLS) {
            waitVisibilityOfElementLocated(rollsLabel);
            waitVisibilityOfElementLocated(fluorescentRollImage);
            waitVisibilityOfElementLocated(fluorescentRollLabel);
            waitVisibilityOfElementLocated(craterRollImage);
            waitVisibilityOfElementLocated(craterRollLabel);
        }
        if (checkingSection == MainPageConstructorSections.SAUCES) {
            waitVisibilityOfElementLocated(saucesLabel);
            waitVisibilityOfElementLocated(spicyXSauceImage);
            waitVisibilityOfElementLocated(spicyXSauceLabel);
            waitVisibilityOfElementLocated(brandedSauceSpaceSauceImage);
            waitVisibilityOfElementLocated(brandedSauceSpaceSauceLabel);
        }
        if (checkingSection == MainPageConstructorSections.FILLINGS) {
            waitVisibilityOfElementLocated(fillingsLabel);
            waitVisibilityOfElementLocated(immortalMollusksProtostomiaMeatFillingImage);
            waitVisibilityOfElementLocated(immortalMollusksProtostomiaMeatFillingLabel);
            waitVisibilityOfElementLocated(beefMeteoriteChopFillingImage);
            waitVisibilityOfElementLocated(beefMeteoriteChopFillingLabel);
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
