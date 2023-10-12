import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobjects.MainPage;


/**
 * <H2>Тесты конструктора на Главной странице.</H2>
 */
public class ConstructorTest extends BaseTest{

    private static String activeTabName;

    @Test
    @DisplayName("Переход к разделу \"Булки\"")
    public void goToRollsSection() throws InterruptedException {

        //given
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.checkMainPage(false);
        activeTabName = mainPage.getActiveTabName();
        Assert.assertEquals("Булки", activeTabName);
        mainPage.clickFillingsTab();
        mainPage.checkMainPage(false);
        activeTabName = mainPage.getActiveTabName();
        Assert.assertEquals("Начинки", activeTabName);

        //when
        mainPage.clickRollsTab();

        //then
        mainPage.checkMainPage(false);
        activeTabName = mainPage.getActiveTabName();
        Assert.assertEquals("Булки", activeTabName);
    }

    @Test
    @Epic("Раздел \"Конструктор\"")
    @DisplayName("Переход к разделу \"Соусы\"")
    public void goToSaucesSection() throws InterruptedException {

        //given
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.checkMainPage(false);

        //when
        mainPage.clickSaucesTab();

        //then
        mainPage.checkMainPage(false);
        activeTabName = mainPage.getActiveTabName();
        Assert.assertEquals("Соусы", activeTabName);

    }

    @Test
    @Epic("Раздел \"Конструктор\"")
    @DisplayName("Переход к разделу \"Начинки\"")
    public void goToFillingsSection() throws InterruptedException {

        //given
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.checkMainPage(false);

        //when
        mainPage.clickFillingsTab();

        //then
        mainPage.checkMainPage(false);
        activeTabName = mainPage.getActiveTabName();
        Assert.assertEquals("Начинки", activeTabName);

    }
}
