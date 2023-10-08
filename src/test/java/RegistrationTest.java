import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;
import requests.ManageUsers;
import utils.DtoFactory;

/**
 * <H2>Тесты регистрации.</H2>
 */
@Epic("Регистрация")
public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegister() {
        //given
        String accessToken = ManageUsers.getAuthToken(
                DtoFactory.getUserAuthorizationDto(
                        testUserEmail,
                        testUserPassword
                )
        );
        Assert.assertNull(accessToken);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.checkRegistrationPage(false);

        //when
        registrationPage.fillRegistrationPage(
                testUserName,
                testUserEmail,
                testUserPassword
        );
        registrationPage.clickRegistrationButton();

        //then
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkLoginPage();

        accessToken = ManageUsers.getAuthToken(
                DtoFactory.getUserAuthorizationDto(
                        testUserEmail,
                        testUserPassword
                )
        );
        Assert.assertNotNull(accessToken);

        ManageUsers.deleteUser(DtoFactory.getUserAuthorizationDto(testUserEmail, testUserPassword));
    }

    @Test
    @DisplayName("Ошибка при регистрации: некорректный пароль")
    public void getErrorWithInvalidPassword() {
        //given
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.checkRegistrationPage(false);

        //when
        registrationPage.fillRegistrationPage(
                testUserName,
                testUserEmail,
                invalidUserPassword
        );
        registrationPage.clickRegistrationButton();

        //then
        registrationPage.checkRegistrationPage(true);
    }
}
