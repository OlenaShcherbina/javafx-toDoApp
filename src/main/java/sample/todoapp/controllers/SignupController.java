package sample.todoapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.todoapp.database.DatabaseHandler;
import sample.todoapp.model.User;

public class SignupController {
  @FXML private ResourceBundle resources;

  @FXML private URL location;

  @FXML private Button signUpButton;

  @FXML private CheckBox signUpCheckBoxFemale;

  @FXML private CheckBox signUpCheckBoxMale;

  @FXML private TextField signUpFirstName;

  @FXML private TextField signUpLastName;

  @FXML private TextField signUpLocation;

  @FXML private PasswordField signUpPassword;

  @FXML private TextField signUpUserName;

  @FXML
  void initialize() {

    signUpButton.setOnAction(
        event -> {
          createUser();
        });
  }

  private void createUser(){
    DatabaseHandler databaseHandler = new DatabaseHandler();

    String name = signUpFirstName.getText();
    String lastName = signUpLastName.getText();
    String userName = signUpUserName.getText();
    String password = signUpPassword.getText();
    String location = signUpLocation.getText();
    String gender = "";
    if(signUpCheckBoxFemale.isSelected()){
      gender = "Female";
    }else{
      gender = "Male";
    }

    User user = new User(name, lastName, userName,password,location, gender);
    databaseHandler.signUpUser(user);

  }
}
