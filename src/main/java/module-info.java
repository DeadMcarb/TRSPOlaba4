module org.example.trspolaba4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.trspolaba4 to javafx.fxml;
    exports org.example.trspolaba4;
}