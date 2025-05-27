module com.decroly.simulacroexamen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.decroly.simulacroexamen to javafx.fxml;
    exports com.decroly.simulacroexamen;
}