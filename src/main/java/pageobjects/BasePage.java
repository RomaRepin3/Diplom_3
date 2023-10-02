package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class BasePage {

    private final WebDriver driver;

    // кнопка "Личный кабинет" в хедере
    final By personalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");

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
     * <H3>Ожидание присутствия элемента в DOM и его видимости.</H3>
     *
     * @param elementSelector Селектор элемента для проверки.
     */
    protected void waitVisibilityOfElementLocated(By elementSelector) {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(elementSelector)
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
     * <H3>Нажатие кнопки "Личный кабинет" в хедере.</H3>
     */
    public void clickPersonalCabinetButton() {
        clickElement(personalCabinetButton);
    }
}
