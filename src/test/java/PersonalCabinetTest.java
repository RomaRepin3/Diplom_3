import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.PersonalCabinetPage;
import requests.ManageUsers;
import utils.DtoFactory;


/**
 * <H2>Тесты для личного кабинета.</H2>
 */
public class PersonalCabinetTest extends BaseTest{

    @Before
    public void createTestUser() {
        ManageUsers.createUser(DtoFactory.getUserRegisterDto(testUserName, testUserEmail, testUserPassword));
    }

    @After
    public void deleteTestUser() {
        ManageUsers.deleteUser(DtoFactory.getUserAuthorizationDto(testUserEmail, testUserPassword));
    }

    @Test
    @Epic("Личный кабинет")
    @DisplayName("Переход в личный кабинет")
    public void goToPersonalCabinet() {
        //given
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.checkLoginPage();
        loginPage.fillLoginPage(testUserEmail, testUserPassword);
        loginPage.clickLoginButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.checkMainPage(true);

        //when
        mainPage.clickPersonalCabinetButton();

        //then
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.checkPersonalCabinetPage();
        Assert.assertEquals(testUserName, personalCabinetPage.getNameValue());
        Assert.assertEquals(testUserEmail, personalCabinetPage.getEmailValue());
    }

    @Test
    @Epic("Личный кабинет")
    @DisplayName("Переход из личного кабинета в конструктор")
    public void goToConstructorFromPersonalCabinet() {
        //given
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.checkLoginPage();
        loginPage.fillLoginPage(testUserEmail, testUserPassword);
        loginPage.clickLoginButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.checkMainPage(true);
        mainPage.clickPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.checkPersonalCabinetPage();
        Assert.assertEquals(testUserName, personalCabinetPage.getNameValue());
        Assert.assertEquals(testUserEmail, personalCabinetPage.getEmailValue());

        //when
        personalCabinetPage.clickLogoButton();

        //then
        mainPage.checkMainPage(true);
    }

    @Test
    @Epic("Личный кабинет")
    @DisplayName("Выход из аккаунта")
    public void logout() {
        //given
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.checkLoginPage();
        loginPage.fillLoginPage(testUserEmail, testUserPassword);
        loginPage.clickLoginButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.checkMainPage(true);
        mainPage.clickPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.checkPersonalCabinetPage();
        Assert.assertEquals(testUserName, personalCabinetPage.getNameValue());
        Assert.assertEquals(testUserEmail, personalCabinetPage.getEmailValue());

        //when
        personalCabinetPage.clickExitLink();

        //then
        loginPage.checkLoginPage();
    }
}
