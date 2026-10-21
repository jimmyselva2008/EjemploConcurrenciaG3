module com.tuempresa.ejemploconcurrenciag3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejemploconcurrenciag3 to javafx.fxml;
    exports com.tuempresa.ejemploconcurrenciag3;
}