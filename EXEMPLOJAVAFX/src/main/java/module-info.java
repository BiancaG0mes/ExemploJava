module com.enem.analyze.exemplojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.enem.analyze.exemplojavafx to javafx.fxml;
    exports com.enem.analyze.exemplojavafx;
}