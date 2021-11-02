module ucf.assignments.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires org.junit.jupiter.api;

    opens ucf.assignments to javafx.fxml;
    exports ucf.assignments;
}