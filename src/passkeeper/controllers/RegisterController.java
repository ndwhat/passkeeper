package passkeeper.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import passkeeper.helpers.SceneHelper;
import passkeeper.objects.Users;
import passkeeper.properties.Pages;
import passkeeper.properties.Validator;
import passkeeper.validators.LoginValidator;
import passkeeper.validators.RegisterValidator;

public class RegisterController implements SceneHelper {
    @FXML
    private Label actiontarget;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nameField;

    @FXML
    private Button submit;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("");
        Users users = new Users();
        String login = loginField.getText();
        String name = nameField.getText();
        String password = passwordField.getText();
        Validator status = users.addUser(login, password, name);
        RegisterValidator registerValidator = new RegisterValidator();
        actiontarget.setTextFill(registerValidator.getPaint(status.isError()));

        if (status.isError())
            actiontarget.setText(status.getMessage());
        else
            actiontarget.setText(Validator.SUCCESS_REGISTER.getMessage());
    }

    @FXML
    protected void handleLogin(ActionEvent event) {
        SceneHelper.changeScene(event, Pages.LOGIN.getPage());
    }

    @FXML
    protected void handleType(KeyEvent event) {
        LoginValidator validator = new LoginValidator();
        validator.validateEmptyFields(submit,loginField,passwordField,nameField);
    }

}