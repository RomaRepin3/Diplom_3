package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class BasePage {

    private final WebDriver driver;

    // кнопка "Конструктор"
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");

    // логотип в хедере
    private final By logoButton = By.cssSelector("header div svg");

    // кнопка "Личный кабинет" в хедере
    private final By personalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");

    // кнопка "Войти" на странице регистрации и восстановления пароля
    protected final By loginButton = By.cssSelector("p.text_type_main-default > a");

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * <H3>Переход на указанный url-адрес.</H3>
     *
     * @param url Адрес для перехода.
     */
    protected void getUrl(String url) {
        driver.get(url);
    }

    /**
     * <H3>Проверка хедера страницы.</H3>
     */
    protected void baseCheck() {
        waitVisibilityOfElementLocated(constructorButton);
        waitVisibilityOfElementLocated(logoButton);
        waitVisibilityOfElementLocated(personalCabinetButton);
    }

    /**
     * <H3>Ожидание присутствия элемента в DOM и его видимости.</H3>
     *
     * @param elementSelector Селектор элемента для проверки.
     */
    protected void waitVisibilityOfElementLocated(By elementSelector) {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(elementSelector)
        );
    }

    /**
     * <H3>Поиск и клик по указанному элементу.</H3>
     *
     * @param elementSelector Селектор элемента.
     */
    protected void clickElement(By elementSelector) {
        driver.findElement(elementSelector).click();
    }

    /**
     * <H3>Очистка и заполнение поля по указанному селектору.</H3>
     *
     * @param elementSelector Селектор поля.
     * @param text Текст для ввода.
     */
    protected void fillField(By elementSelector, String text) {
        driver.findElement(elementSelector).clear();
        driver.findElement(elementSelector).sendKeys(text);
    }

    /**
     * <H3>Нажатие кнопки "Конструктор" в хедере.</H3>
     */
    public void clickConstructorButton() {
        clickElement(constructorButton);
    }

    /**
     * <H3>Нажатие на логотип в хедере.</H3>
     */
    public void clickLogoButton() {
        clickElement(logoButton);
    }

    /**
     * <H3>Нажатие кнопки "Личный кабинет" в хедере.</H3>
     */
    public void clickPersonalCabinetButton() {
        clickElement(personalCabinetButton);
    }
}
