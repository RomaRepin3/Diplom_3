import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;

public class RegistrationPageTest extends BaseTest {

    private static final String testUserName = "test_user";

    private static final String testUserEmail = "test@test.com";

    private static final String testUserPassword = "Qwerty12345!";

    private static final String invalidUserPassword = "12345";

    @Test
    public void successRegister() {
        //given
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.checkPasswordRecoveryPage(false);

        //when
        registrationPage.fillRegistrationPage(
                testUserName,
                testUserEmail,
                testUserPassword
        );
        registrationPage.clickLoginButton();

        //then
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkLoginPage();
    }

    @Test
    public void getErrorWithInvalidPassword() {
        //given
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.checkPasswordRecoveryPage(false);

        //when
        registrationPage.fillRegistrationPage(
                testUserName,
                testUserEmail,
                invalidUserPassword
        );
        registrationPage.clickLoginButton();

        //then
        registrationPage.checkPasswordRecoveryPage(true);
    }
}
