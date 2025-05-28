package com.decroly.examen3ev;


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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class VetController implements Initializable {
    SQLAccesManager miData = new SQLAccesManager();
    private void selectPanelVisible(int panel) {
        switch (panel) {

            case 0:
                MainPanel.setVisible(true);
                vBoxReMa.setVisible(false);
                vBoxReProp.setVisible(false);
                vBoxReConsulta.setVisible(false);
                vBoxBuscarMa.setVisible(false);
                break;

            case 1:
                MainPanel.setVisible(false);
                vBoxReMa.setVisible(true);
                vBoxReProp.setVisible(false);
                vBoxReConsulta.setVisible(false);
                vBoxBuscarMa.setVisible(false);
                break;

            case 2:
                MainPanel.setVisible(false);
                vBoxReMa.setVisible(false);
                vBoxReProp.setVisible(true);
                vBoxReConsulta.setVisible(false);
                vBoxBuscarMa.setVisible(false);
                break;
            case 3:
                MainPanel.setVisible(false);
                vBoxReMa.setVisible(false);
                vBoxReProp.setVisible(false);
                vBoxReConsulta.setVisible(true);
                vBoxBuscarMa.setVisible(false);
                break;
            case 4:
                MainPanel.setVisible(false);
                vBoxReMa.setVisible(false);
                vBoxReProp.setVisible(false);
                vBoxReConsulta.setVisible(false);
                vBoxBuscarMa.setVisible(true);
                break;

        }
    }
    private void limpiarReProp() {
        NombrePo.setText("");
        ApellidosPo.setText("");
        DniPo.setText("");
        TelefonoPo.setText("");
        DireccionPo.setText("");
        EmailPo.setText("");
    }
    private void limpiarReMa() {
        pasaporteMa.setText("");
        nombreMa.setText("");
        nacimientoMa.setText("");
        pseoMa.setText("");
    }

    protected void limpiarReConsulta() {
        fechaCon.setText("");
        duracionCon.setText("");
        observacionesCon.setText("");
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

    private boolean validateDni(String dni){
        return dni.matches("[0-9]{7,8}[A-Z a-z]");
    }

    private boolean validatePasaporte(String dni){
        return dni.matches("[0-9]{7}[A-Z a-z]{2}");
    }

    public static boolean validarFormatoFecha(String fecha) {
        return fecha.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$");
    }

    //inicialable
    @Override
    public void initialize(URL location, ResourceBundle resources){
    selectPanelVisible(0);



    //Validadores Propietario
        NombrePo.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validateName(NombrePo.getText())){
                    NombrePo.setText("");
                    NombrePo.setPromptText("Valor incorrecto");
                }
            }
        });

        DniPo.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validateDni(DniPo.getText())){
                    DniPo.setText("");
                    DniPo.setPromptText("Valor incorrecto");
                }
            }
        });

        TelefonoPo.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validatePhone(TelefonoPo.getText())){
                    TelefonoPo.setText("");
                    TelefonoPo.setPromptText("Valor incorrecto");
                }
            }
        });

        EmailPo.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validateEmail(EmailPo.getText())){
                    EmailPo.setText("");
                    EmailPo.setPromptText("Valor incorrecto");
                }
            }
        });

        //Validadores Mascotas
        pasaporteMa.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validatePasaporte(pasaporteMa.getText())){
                    pasaporteMa.setText("");
                    pasaporteMa.setPromptText("Valor incorrecto");
                }
            }
        });

        nacimientoMa.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validarFormatoFecha(nacimientoMa.getText())){
                    nacimientoMa.setText("");
                    nacimientoMa.setPromptText("Valor incorrecto");
                }
            }
        });
        nacimientoMa.setPromptText("dd/MM/yyyy");
        fechaCon.setPromptText("dd/MM/yyyy HH:mm");

    }

    //Paneles
    @FXML
    private VBox MainPanel;
    @FXML
    private VBox vBoxReMa;
    @FXML
    private VBox vBoxReProp;
    @FXML
    private VBox vBoxReConsulta;
    @FXML
    private VBox vBoxBuscarMa;

    //Main Panel
    //Botones
    @FXML
    private Button mainReMa;
    @FXML
    private Button mainRePo;
    @FXML
    private Button mainReCo;
    @FXML
    private Button mainBuMa;
    @FXML
    private Button ButtonExportar;
    @FXML
    private Button ExitButton;

    //panel registrar Propietario
    //botones
    @FXML
    private Button InicioReProp;
    @FXML
    private Button SaveProp;
    //TextFields
    @FXML
    private TextField NombrePo;
    @FXML
    private TextField ApellidosPo;
    @FXML
    private TextField DniPo;
    @FXML
    private TextField TelefonoPo;
    @FXML
    private TextField DireccionPo;
    @FXML
    private TextField EmailPo;

    //Panel registrar Mascota
    //Botones
    @FXML
    private Button inicioReMa;
    @FXML
    private Button saveMa;
    //Formulario
    @FXML
    private TextField pasaporteMa;
    @FXML
    private TextField nombreMa;
    @FXML
    private TextField nacimientoMa;
    @FXML
    private TextField pseoMa;
    @FXML
    private ListView<Tipo> ListViewTipos;
    @FXML
    private ListView<Propietario> ListViewProp;

    //Panel Registrar Consulta
    //Botones
    @FXML
    private Button inicioReCon;
    @FXML
    private Button saveCon;
    //Formulario
    @FXML
    private TextField fechaCon;
    @FXML
    private TextField duracionCon;
    @FXML
    private TextArea observacionesCon;
    @FXML
    private ListView<Mascota> ListViewMasCon;

    //Panel de Buscar Mascota
    @FXML
    private Button Buscar;
    @FXML
    private Button ButtonBusOut;
    @FXML
    private TextField TextFieldBuscar;
    @FXML
    private ListView<Mascota> ListViewSelect;

    //Botones del main Panel
    @FXML
    protected void onMainReMa() {
        selectPanelVisible(1);
        ListViewProp.setItems(FXCollections.observableList(miData.getProp()));
        ListViewTipos.setItems(FXCollections.observableList(miData.getTipos()));
    }
    @FXML
    protected void onMainRePo() {
        selectPanelVisible(2);
    }
    @FXML
    protected void onMainReCo() {
        selectPanelVisible(3);
        ListViewMasCon.setItems(FXCollections.observableList(miData.getMascota()));
    }
    @FXML
    protected void onMainBuMa() {
        selectPanelVisible(4);
    }
    @FXML
    protected void onExitButton() {
        Platform.exit();
    }
    //Boton de Exportan a fichero
    @FXML
    protected void onButtonExportar(){
        FileUtils.writeFile("export_Mascotas.dat",new LinkedList<>(miData.getMascota()));
    }


    //Botones panel registrar Propietario
    @FXML
    protected void oninicioReProp(){
        selectPanelVisible(0);
    }
    @FXML
    protected void onsaveProp(){
        Propietario nuevop = new Propietario(
                NombrePo.getText(),
                ApellidosPo.getText(),
                DniPo.getText(),
                TelefonoPo.getText(),
                DireccionPo.getText(),
                EmailPo.getText()

        );
        miData.insertarPropietario(nuevop);
        selectPanelVisible(0);
        limpiarReProp();

    }

    //Botones panel registrar mascota
    @FXML
    protected void onInicioReMa(){
        selectPanelVisible(0);
    }
    @FXML
    protected void onsaveMa(){
        //El formato para la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(nacimientoMa.getText(), formatter);
        //Que me seleccione el tipo que es la mascota y el Propietario con click en la listview
        Propietario selectProp = ListViewProp.getSelectionModel().getSelectedItem();
        Tipo selectTipo = ListViewTipos.getSelectionModel().getSelectedItem();
        Mascota mascota = new Mascota(
                pasaporteMa.getText(),
                nombreMa.getText(),
                pseoMa.getText(),
                fechaNacimiento,
                selectProp.getDni(),
                selectTipo.getIdTpo()
        );
        miData.insertarMascota(mascota);
        selectPanelVisible(0);
        limpiarReMa();
    }

    //Botones panel registrar consulta
    @FXML
    protected void onInicioReCon(){
        selectPanelVisible(0);
    }
    @FXML
    protected void saveCon(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime fecha = LocalDateTime.parse(fechaCon.getText(), formatter);
        Mascota selectMas = ListViewMasCon.getSelectionModel().getSelectedItem();
        Consulta consultas  = new Consulta(
                fecha,
                duracionCon.getText(),
                observacionesCon.getText(),
                selectMas.getPasaporte(),
                selectMas.getPropietario()
        );

        miData.insertarConsulta(consultas);
        selectPanelVisible(0);
        limpiarReConsulta();
    }

    //Panel de Buscar
    @FXML
    protected void onBuscar(){
        String Buscar = TextFieldBuscar.getText();
        ListViewSelect.setItems(FXCollections.observableList(miData.getMascotaPasaporte(Buscar)));

    }

    @FXML
    protected void onButtonBusOut(){
        selectPanelVisible(0);
    }




}