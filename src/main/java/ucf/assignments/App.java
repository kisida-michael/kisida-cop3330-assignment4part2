package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    double x,y = 0;
    @Override
    public void start(Stage stage) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxml);
       // stage.initStyle(StageStyle.UNDECORATED);
        fxml.setOnMousePressed(evt -> {
            x = evt.getSceneX();
            y = evt.getSceneY();
        });

        fxml.setOnMouseDragged(evt -> {
            stage.setX(evt.getScreenX()-x);
            stage.setY(evt.getScreenY()-y);
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}