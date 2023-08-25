module com.champlain.oop2lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.champlain.oop2lab1 to javafx.fxml;
    exports com.champlain.oop2lab1;
}