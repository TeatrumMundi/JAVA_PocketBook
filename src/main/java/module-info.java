module com.example.java_pocketbook {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_pocketbook to javafx.fxml;
    exports com.example.java_pocketbook;
}