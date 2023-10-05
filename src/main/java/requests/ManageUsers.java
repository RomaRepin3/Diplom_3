package requests;

import dto.UserAuthorizationDto;
import dto.UserRegisterDto;

import static io.restassured.RestAssured.given;


/**
 * <H2>Класс запрос для управления тестовыми пользователями.</H2>
 */
public class ManageUsers {

    private final static String REGISTER_USER_URL = "https://stellarburgers.nomoreparties.site/api/auth/register";
    private final static String LOGIN_USER_URL = "https://stellarburgers.nomoreparties.site/api/auth/login";
    private final static String DELETE_USER_URL = "https://stellarburgers.nomoreparties.site/api/auth/user";

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    private static final String AUTH_HEADER = "Authorization";

    private static final String ACCESS_TOKEN = "accessToken";

    /**
     * <H3>Регистрация нового пользователя через API.</H3>
     *
     * @param body DTO с данными для регистрации нового пользователя.
     * @return Токен авторизации.
     */
    public static String createUser(UserRegisterDto body) {
        return given()
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(body)
                .when()
                .post(REGISTER_USER_URL)
                .then()
                .extract()
                .path(ACCESS_TOKEN);
    }

    /**
     * <H3>Получение токена автризации пользователя.</H3>
     *
     * @param body DTO с данными для автризации пользователя.
     * @return Токен аторизации.
     */
    public static String getAuthToken(UserAuthorizationDto body) {
        return given()
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(body)
                .when()
                .post(LOGIN_USER_URL)
                .then()
                .extract()
                .path(ACCESS_TOKEN);
    }

    /**
     * <H3>Удаление пользователя по email и паролю.</H3>
     *
     * @param userAuthorizationDto DTO с данными для авторизации.
     */
    public static void deleteUser(UserAuthorizationDto userAuthorizationDto) {
        String accessToken = getAuthToken(userAuthorizationDto);
        given().header(AUTH_HEADER, accessToken).delete(DELETE_USER_URL);
    }
}
