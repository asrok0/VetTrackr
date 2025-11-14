module com.example.vettrackr {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.datatransfer;

    opens com.example.vettrackr to javafx.fxml;
    exports com.example.vettrackr;
}