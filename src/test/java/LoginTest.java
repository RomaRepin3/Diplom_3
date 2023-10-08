import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobjects.*;
import requests.ManageUsers;
import utils.DtoFactory;


/**
 * <H2>Тесты авториазции.</H2>
 */
public class LoginTest extends BaseTest {

    @Test
    @Epic("Авторизация")
    @DisplayName("Вход по конпке \"Войти\" на главной")
    public void loginByLoginButtonOnMainPage() {
        //given
        ManageUsers.createUser(DtoFactory.getUserRegisterDto(testUserName, testUserEmail, testUserPassword));

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

        ManageUsers.deleteUser(DtoFactory.getUserAuthorizationDto(testUserEmail, testUserPassword));
    }

    @Test
    @Epic("Авторизация")
    @DisplayName("Вход через кнопку личный кабинет")
    public void loginByPersonalCabinetButton() {
        //given
        ManageUsers.createUser(DtoFactory.getUserRegisterDto(testUserName, testUserEmail, testUserPassword));

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
        ManageUsers.deleteUser(DtoFactory.getUserAuthorizationDto(testUserEmail, testUserPassword));
    }

    @Test
    @Epic("Авторизация")
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginByLoginButtonOnRegistrationPage() {
        //given
        ManageUsers.createUser(DtoFactory.getUserRegisterDto(testUserName, testUserEmail, testUserPassword));

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.checkRegistrationPage(false);

        //when
        registrationPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginPage(testUserEmail, testUserPassword);
        loginPage.clickLoginButton();

        //then
        MainPage mainPage = new MainPage(driver);
        mainPage.checkMainPage(true);
        mainPage.clickPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.checkPersonalCabinetPage(testUserName, testUserEmail);

        ManageUsers.deleteUser(DtoFactory.getUserAuthorizationDto(testUserEmail, testUserPassword));
    }

    @Test
    @Epic("Авторизация")
    @DisplayName("Вход через кнопку  форме осстановления пароля")
    public void loginByLoginButtonOnPasswordRecoveryPage() {
        //given
        ManageUsers.createUser(DtoFactory.getUserRegisterDto(testUserName, testUserEmail, testUserPassword));

        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.openPasswordRecoveryPage();
        passwordRecoveryPage.checkPasswordRecoveryPage();

        //when
        passwordRecoveryPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginPage(testUserEmail, testUserPassword);
        loginPage.clickLoginButton();

        //then
        MainPage mainPage = new MainPage(driver);
        mainPage.checkMainPage(true);
        mainPage.clickPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.checkPersonalCabinetPage(testUserName, testUserEmail);

        ManageUsers.deleteUser(DtoFactory.getUserAuthorizationDto(testUserEmail, testUserPassword));
    }
}
