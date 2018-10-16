package passkeeper.validators;

import passkeeper.objects.Users;
import passkeeper.properties.Validator;

public class RegisterValidator implements InterfaceValidator {

    public Validator validate(String login) {
        Validator status = checkKey(login);

        if (status.isError())
            return status;

        return Validator.SUCCESS_REGISTER;
    }

    private Validator checkKey(String login) {
        Users users = new Users();
        if (users.isLoginExists(login)) {
            return Validator.ERROR_LOGIN_ALREADY_CREATED;
        }
        return Validator.SUCCESS_REGISTER;
    }
}
