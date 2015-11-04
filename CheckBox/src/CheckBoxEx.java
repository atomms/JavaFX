import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CheckBoxEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        HBox root = new HBox();
        root.setPadding(new Insets(10, 0, 0, 10));
        
        CheckBox cbox = new CheckBox("Show title");
        cbox.setSelected(true);
        
        cbox.setOnAction((ActionEvent event) -> {
            if (cbox.isSelected()) {
                stage.setTitle("CheckBox");
            } else {
                stage.setTitle("");
            }
        });
        
        root.getChildren().add(cbox);

        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("CheckBox");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}