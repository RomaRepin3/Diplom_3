import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobjects.MainPage;
import pageobjects.MainPageConstructorSections;


/**
 * <H2>Тесты конструктора на Главной странице.</H2>
 */
@Epic("Раздел \"Конструктор\"")
public class ConstructorTest extends BaseTest{

    @Test
    @DisplayName("Переход к разделу \"Булки\"")
    public void goToRollsSection() {

        //given
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.checkMainPage(false);
        mainPage.clickFillingsTab();
        mainPage.checkMainPage(false, MainPageConstructorSections.FILLINGS);

        //when
        mainPage.clickRollsTab();

        //then
        mainPage.checkMainPage(false, MainPageConstructorSections.ROLLS);

    }

    @Test
    @DisplayName("Переход к разделу \"Соусы\"")
    public void goToSaucesSection() {

        //given
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.checkMainPage(false);

        //when
        mainPage.clickSaucesTab();

        //then
        mainPage.checkMainPage(false, MainPageConstructorSections.SAUCES);

    }

    @Test
    @DisplayName("Переход к разделу \"Начинки\"")
    public void goToFillingsSection() {

        //given
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.checkMainPage(false);

        //when
        mainPage.clickFillingsTab();

        //then
        mainPage.checkMainPage(false, MainPageConstructorSections.FILLINGS);

    }
}
