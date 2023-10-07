import org.junit.Test;
import pageobjects.MainPage;
import pageobjects.MainPageConstructorSections;

public class ConstructorTest extends BaseTest{

    @Test
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
