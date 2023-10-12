package utils;

import dto.UserAuthorizationDto;
import dto.UserRegisterDto;


/**
 * <H2>Фабрики сборки DTO.</H2>
 */
public class DtoFactory {

    /**
     * <H3>Создание UserAuthorizationDto.</H3>
     *
     * @param email Email адрес.
     * @param password Пароль пользователя.
     * @return DTO для запроса авторизации.
     */
    public static UserAuthorizationDto getUserAuthorizationDto(String email, String password) {
        UserAuthorizationDto userAuthorizationDto = new UserAuthorizationDto();

        userAuthorizationDto.setEmail(email);
        userAuthorizationDto.setPassword(password);
        return userAuthorizationDto;
    }

    /**
     * <H3>Создание UserRegisterDto.</H3>
     *
     * @param name Имя пользователя.
     * @param email Email адрес.
     * @param password Пароль пользователя.
     * @return DTO регистрации пользователя.
     */
    public static UserRegisterDto getUserRegisterDto(String name, String email, String password) {
        UserRegisterDto userRegisterDto = new UserRegisterDto();

        userRegisterDto.setName(name);
        userRegisterDto.setEmail(email);
        userRegisterDto.setPassword(password);
        return userRegisterDto;
    }
}
