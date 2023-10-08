import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
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

    @Test
    @Epic("Личный кабинет")
    @DisplayName("Переход в личный кабинет")
    public void goToPersonalCabinet() {
        //given
        ManageUsers.createUser(DtoFactory.getUserRegisterDto(testUserName, testUserEmail, testUserPassword));

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
        personalCabinetPage.checkPersonalCabinetPage(testUserName, testUserEmail);

        ManageUsers.deleteUser(DtoFactory.getUserAuthorizationDto(testUserEmail, testUserPassword));
    }

    @Test
    @Epic("Личный кабинет")
    @DisplayName("Переход из личного кабинета в конструктор")
    public void goToConstructorFromPersonalCabinet() {
        //given
        ManageUsers.createUser(DtoFactory.getUserRegisterDto(testUserName, testUserEmail, testUserPassword));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.checkLoginPage();
        loginPage.fillLoginPage(testUserEmail, testUserPassword);
        loginPage.clickLoginButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.checkMainPage(true);
        mainPage.clickPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.checkPersonalCabinetPage(testUserName, testUserEmail);

        //when
        personalCabinetPage.clickLogoButton();

        //then
        mainPage.checkMainPage(true);

        ManageUsers.deleteUser(DtoFactory.getUserAuthorizationDto(testUserEmail, testUserPassword));
    }

    @Test
    @Epic("Личный кабинет")
    @DisplayName("Выход из аккаунта")
    public void logout() {
        //given
        ManageUsers.createUser(DtoFactory.getUserRegisterDto(testUserName, testUserEmail, testUserPassword));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.checkLoginPage();
        loginPage.fillLoginPage(testUserEmail, testUserPassword);
        loginPage.clickLoginButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.checkMainPage(true);
        mainPage.clickPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.checkPersonalCabinetPage(testUserName, testUserEmail);

        //when
        personalCabinetPage.clickExitLink();

        //then
        loginPage.checkLoginPage();

        ManageUsers.deleteUser(DtoFactory.getUserAuthorizationDto(testUserEmail, testUserPassword));
    }
}
