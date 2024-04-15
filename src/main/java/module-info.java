module com.example.paragosojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.paragosojavafx to javafx.fxml;
    exports com.example.paragosojavafx;
}