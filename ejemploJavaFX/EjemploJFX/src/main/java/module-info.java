module com.decroly.ejemplojfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.decroly.ejemplojfx to javafx.fxml;
    exports com.decroly.ejemplojfx;
}