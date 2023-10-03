import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;

public class RegistrationPageTest extends BaseTest {

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
