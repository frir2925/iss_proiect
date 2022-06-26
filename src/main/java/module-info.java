module ProiectFinal.main {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires java.sql;

    opens com.example.proiectiss;

    opens com.example.proiectiss.Domain to javafx.fxml;
    exports com.example.proiectiss.Domain;
}