module com.example.problemsolving {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.problemsolving to javafx.fxml;
    exports com.example.problemsolving;
}