module com.decroly.examen3ev {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.decroly.examen3ev to javafx.fxml;
    exports com.decroly.examen3ev;
}