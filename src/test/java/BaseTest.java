import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public abstract class BaseTest {

    protected static WebDriver driver;

    private static final Faker faker = new Faker();

    protected static final String testUserName = faker.name().firstName();

    protected static final String testUserEmail = faker.internet().emailAddress();

    protected static final String testUserPassword = faker.internet().password(6, 7);

    protected static final String invalidUserPassword = faker.internet().password(5, 6);

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
