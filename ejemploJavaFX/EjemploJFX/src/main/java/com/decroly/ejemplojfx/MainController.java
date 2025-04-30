package com.decroly.ejemplojfx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import com.decroly.ejemplojfx.model.Persona;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    private Persona person;

    @FXML
    private VBox mainPanel;

    //Campos de texto del formulario
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneTextField;


    //Eventos
    @FXML
    protected void onSaveButtonAction(ActionEvent event) {
    person = new Persona();
        try {
            person.setNombre(nameTextField.getText());
            person.setApellido(surnameTextField.getText());
            person.setEmail(emailTextField.getText());
            person.setEdad(Integer.parseInt(ageTextField.getText()));
            person.setTelefono(phoneTextField.getText());

            mainPanel.setVisible(false);

        }   catch (NumberFormatException e) {
            ageTextField.setText("");
            ageTextField.setPromptText("Tiene que introducir un numero");
        }

    }

    @FXML
    protected void onCloseButtonAction(ActionEvent event) {
    Platform.exit();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTextField.setPromptText("Nombre");
        surnameTextField.setPromptText("Apellido");
        ageTextField.setPromptText("Edad");
        emailTextField.setPromptText("Email");
        phoneTextField.setPromptText("Telefono");
    }
}
