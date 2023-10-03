import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.PersonalCabinetPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginByLoginButtonOnMainPage() {
        //given
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.checkMainPage(false);

        //when
        mainPage.clickLoginToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkLoginPage();
        loginPage.fillLoginPage(testUserEmail, testUserPassword);
        loginPage.clickLoginButton();

        //then
        mainPage.checkMainPage(true);
        mainPage.clickPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.checkPersonalCabinetPage(testUserName, testUserEmail);
    }

    @Test
    public void loginByPersonalCabinetButton() {
        //given
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.checkMainPage(false);

        //when
        mainPage.clickPersonalCabinetButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkLoginPage();
        loginPage.fillLoginPage(testUserEmail, testUserPassword);
        loginPage.clickLoginButton();

        //then
        mainPage.checkMainPage(true);
        mainPage.clickPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.checkPersonalCabinetPage(testUserName, testUserEmail);
    }

}
