package com.decroly.simulacroexamen;



import Utils.FileUtils;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    SQLAccesManager miData = new SQLAccesManager();
    private void selectPanelVisible(int panel) {
        switch (panel) {

            case 0:
                vBoxPrincipal.setVisible(true);
                vBoxREgistrarPaciente.setVisible(false);
                vBoxREgistrarMedico.setVisible(false);
                vBoxListaMedicos.setVisible(false);
                vBoxUpdate.setVisible(false);
                break;

            case 1:
                vBoxPrincipal.setVisible(false);
                vBoxREgistrarPaciente.setVisible(true);
                vBoxREgistrarMedico.setVisible(false);
                vBoxListaMedicos.setVisible(false);
                vBoxUpdate.setVisible(false);
                break;

            case 2:
                vBoxPrincipal.setVisible(false);
                vBoxREgistrarPaciente.setVisible(false);
                vBoxREgistrarMedico.setVisible(true);
                vBoxListaMedicos.setVisible(false);
                vBoxUpdate.setVisible(false);
                break;
            case 3:
                vBoxPrincipal.setVisible(false);
                vBoxREgistrarPaciente.setVisible(false);
                vBoxREgistrarMedico.setVisible(false);
                vBoxListaMedicos.setVisible(true);
                vBoxUpdate.setVisible(false);
                break;
            case 4:
                vBoxPrincipal.setVisible(false);
                vBoxREgistrarPaciente.setVisible(false);
                vBoxREgistrarMedico.setVisible(false);
                vBoxListaMedicos.setVisible(false);
                vBoxUpdate.setVisible(true);
                break;

        }
    }

    private void limpiarFormularioMe() {
        TextFieldDniM.setText("");
        TextFieldNombreM.setText("");
        TextFieldDirecM.setText("");
        TextFieldFechaM.setText("");
    }

    //Validadores
    private boolean validateName(String name){
        return (name.length() > 3 && name.matches("[A-Z]{1}[a-z]{2,25}"));
    }

    private boolean validatePhone(String phone){
        return phone.matches("[1-9]{9}");
    }

    private boolean validateEmail(String email){
        String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(emailPattern);
    }

    private boolean validateAge(String age){
        return age.matches("[1-9]{1,3}");
    }

    private boolean validateDni(String dni){
        return dni.matches("[0-9]{7,8}[A-Z a-z]");
    }
    public static boolean validarFormatoFecha(String fecha) {
        return fecha.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$");
    }




    @Override
    public void initialize(URL location, ResourceBundle resources){
    selectPanelVisible(0);
    limpiarFormularioMe();
    comboBoxEs.getItems().setAll(Especialidad.values());
    comboBoxEs1.getItems().setAll(Especialidad.values());

    TextFieldFechaM.setPromptText("dd/MM/yyyy");

        //Validadores
        TextFieldNombreM.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validateName(TextFieldNombreM.getText())){
                    TextFieldNombreM.setText("");
                    TextFieldNombreM.setPromptText("Valor incorrecto");
                }
            }
        });

        TextFieldDniM.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validateDni(TextFieldDniM.getText())){
                    TextFieldDniM.setText("");
                    TextFieldDniM.setPromptText("Valor incorrecto");
                }
            }
        });

        TextFieldFechaM.focusedProperty().addListener((observable, oldValue, newValue) -> {
           if(!newValue){
               if(!validarFormatoFecha(TextFieldFechaM.getText())){
                   TextFieldFechaM.setText("");
                   TextFieldFechaM.setPromptText("Valor incorrecto");
               }
           }
        });

    }

    //Paneles
    @FXML
    private VBox vBoxPrincipal;
    @FXML
    private VBox vBoxREgistrarPaciente;
    @FXML
    private VBox vBoxREgistrarMedico;
    @FXML
    private VBox vBoxListaMedicos;
    @FXML
    private VBox vBoxUpdate;

    //Botones MainPanel
    @FXML
    private Button ButtonReMe;
    @FXML
    private Button ButtonRePa;
    @FXML
    private Button ButtonVerMe;
    @FXML
    private Button ExitMainPanel;

    //Botones Registro Medico
    @FXML
    private Button ButtonInicioReMe;
    @FXML
    private Button ButtonsaveReMe;

    //Cosas panel Lista Medicos
    @FXML
    private Button ButtonExport;
    @FXML
    private Button ButtonInicioLMe;
    @FXML
    private Button ButtonDeleteMe;
    @FXML
    private Button ButtonUpdateList;
    @FXML
    private ListView<Medicos> ListViewMe;

    //Formulario registrar medico
    @FXML
    private TextField TextFieldDniM;
    @FXML
    private TextField TextFieldNombreM;
    @FXML
    private TextField TextFieldDirecM;
    @FXML
    private TextField TextFieldFechaM;
    @FXML
    private ComboBox<Especialidad> comboBoxEs;

    //Botones y text fields de actualizar
    @FXML
    private Button ButtonCancelar;
    @FXML
    private Button ButtonUpdate;
    @FXML
    private TextField TextFieldDniM1;
    @FXML
    private TextField TextFieldNombreM1;
    @FXML
    private TextField TextFieldDirecM1;
    @FXML
    private TextField TextFieldFechaM1;
    @FXML
    private ComboBox<Especialidad> comboBoxEs1;


    //Botones funcionales mover entre paneles solo
    @FXML
    protected void onButtonReMe(){
        selectPanelVisible(2);
    }
    @FXML
    protected void onButtonRePa(){
        selectPanelVisible(1);
    }
    @FXML
    protected void onButtonVerMe(){
        selectPanelVisible(3);
        //Listview
        ListViewMe.setItems(FXCollections.observableList(miData.getMedicos()));
        ListViewMe.refresh();
    }
    @FXML
    protected void onExitMainPanel(){
        Platform.exit();
    }
    @FXML
    protected void onButtonInicioLMe(){
        selectPanelVisible(0);
    }
    @FXML
    protected void onButtonInicioReMe(){
        selectPanelVisible(0);
    }
    @FXML
    protected void onButtonUpdateList(){
        selectPanelVisible(4);
    }
    @FXML
    protected void onButtonCancelar(){
        selectPanelVisible(3);
    }

    //Botones con metodos
    //Boton registrar Medico
    @FXML
    protected void onButtonsaveReMe(){
        selectPanelVisible(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(TextFieldFechaM.getText(), formatter);
        Medicos newMedico = new Medicos(
                TextFieldDniM.getText(),
                TextFieldNombreM.getText(),
                TextFieldDirecM.getText(),
                fechaNacimiento,
                comboBoxEs.getValue()
        );
        miData.insertarMedico(newMedico);
        limpiarFormularioMe();
        ListViewMe.refresh();

    }
    //Boton para Eliminar
    @FXML
    protected void onButtonDeleteMe(){
    try {
        Medicos selectedMedico = ListViewMe.getSelectionModel().getSelectedItem();
        if (selectedMedico != null) {
            ListViewMe.getItems().remove(selectedMedico);
            miData.eliminarMedico(selectedMedico);
        }
    }catch (Exception e) {
        throw new RuntimeException(e);
    }
    }
    //Boton de Exportan a fichero
    @FXML
    protected void onButtonExport(){
        FileUtils.writeFile("export_Medicos.dat",new LinkedList<>(miData.getMedicos()));
    }

    @FXML
    protected void updateMedico(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento1 = LocalDate.parse(TextFieldFechaM1.getText(), formatter);
      Medicos updateMedico = new Medicos(
              TextFieldDniM1.getText(),
              TextFieldNombreM1.getText(),
              TextFieldDirecM1.getText(),
              fechaNacimiento1,
              comboBoxEs1.getValue()
      );
      miData.updateMedico(updateMedico);
      selectPanelVisible(3);
      ListViewMe.setItems(FXCollections.observableList(miData.getMedicos()));

    }






}//