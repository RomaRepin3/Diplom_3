import com.github.javafaker.Faker;
import dto.UserRegisterDto;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import requests.ManageUsers;

public abstract class BaseTest {

    protected static WebDriver driver;

    private static final Faker faker = new Faker();

    protected static final String testUserName = faker.name().firstName();

    protected static final String testUserEmail = faker.internet().emailAddress();

    protected static final String testUserPassword = faker.internet().password(6, 7);

    protected static final String invalidUserPassword = faker.internet().password(5, 6);

    private static String testUserAccessToken;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();

        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setName(testUserName);
        userRegisterDto.setEmail(testUserEmail);
        userRegisterDto.setPassword(testUserPassword);

        testUserAccessToken = ManageUsers.createUser(userRegisterDto);
    }

    @After
    public void tearDown() {
        ManageUsers.deleteUser(testUserAccessToken);

        driver.quit();
    }

}
