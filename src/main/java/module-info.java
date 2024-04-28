module com.example.paragosojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.paragosojavafx to javafx.fxml;
    exports com.example.paragosojavafx;
}