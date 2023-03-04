module com.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ManipulasiString to javafx.fxml;
    exports com.ManipulasiString;

    exports com.Statistika;
    opens com.Statistika to javafx.graphics;
}
