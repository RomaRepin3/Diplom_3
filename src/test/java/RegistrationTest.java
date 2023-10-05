import org.junit.Assert;
import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;
import requests.ManageUsers;
import utils.DtoFactory;

/**
 * <H2>Тесты регистрации.</H2>
 */
public class RegistrationTest extends BaseTest {

    @Test
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
