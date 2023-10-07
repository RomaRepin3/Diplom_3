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
}
