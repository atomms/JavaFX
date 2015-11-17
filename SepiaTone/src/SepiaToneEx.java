import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SepiaToneEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        StackPane root = new StackPane();
        
        Image image = new Image("file:mushroom.png");

        ImageView iw = new ImageView(image);

        SepiaTone sepia = new SepiaTone();
        iw.effectProperty().bind(
                Bindings
                    .when(iw.hoverProperty())
                        .then((Effect) sepia)
                        .otherwise((Effect) null)
        );

        iw.setCache(true);
        iw.setCacheHint(CacheHint.SPEED);  
        
        root.getChildren().add(iw);

        Scene scene = new Scene(root);

        stage.setTitle("SepiaTone");
        scene.setFill(Color.WHITESMOKE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}