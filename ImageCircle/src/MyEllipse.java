import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javafx.scene.layout.VBox.setMargin;

public class MyEllipse extends Application {
    private Ellipse ceiling;
    private ImageView ceiling_image;
    private VBox nav;
    private HBox buttonSet;
    private Label presentation_title;
    private TextArea info;
    private Button previous;
    private Button comment;
    private Button next;

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        Scene primaryScene = new Scene(root, 900, 800);
        initializeCeiling(root);
        initializeNav(root);
        initializeContent(root);
        initializePrimaryStage(primaryStage, primaryScene);
        primaryStage.show();
    }

    private void initializePrimaryStage(Stage primaryStage, Scene primaryScene) {
        primaryStage.setTitle("Refugees");
        primaryStage.setScene(primaryScene);
        primaryStage.setWidth(900);
        primaryStage.setHeight(700);
        primaryStage.setResizable(false);
//        primaryStage.minHeightProperty().setValue(800);
//        primaryStage.maxHeightProperty().setValue(800);
//        primaryStage.minWidthProperty().setValue(900);
//        primaryStage.maxWidthProperty().setValue(900);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initializeCeiling(AnchorPane root) {
        ceiling = new Ellipse();
        ceiling.centerXProperty().bind(root.widthProperty().multiply(0.5));
        ceiling.centerYProperty().setValue(0);
        ceiling.radiusXProperty().bind(root.widthProperty().multiply(0.8));
        ceiling.radiusYProperty().bind(root.heightProperty().multiply(0.6));
    }

    private void initializeNav(AnchorPane root) {
        nav = new VBox();
        initializeControls(nav);
        AnchorPane.setBottomAnchor(nav, 20.0);
        AnchorPane.setLeftAnchor(nav, 120.0);
        AnchorPane.setRightAnchor(nav, 120.0);
        root.getChildren().add(nav);
    }

    private void initializeControls(VBox nav) {
        info = new TextArea();
        setMargin(info, new Insets(10, 0, 0, 0));
        info.setWrapText(true);
        info.setEditable(true);
        buttonSet = new HBox();
        initializeButtonSet(nav);
        presentation_title = new Label("About this photo");
        presentation_title.setId("titulo");
        nav.alignmentProperty().setValue(Pos.CENTER);
        nav.getChildren().addAll(presentation_title, info, buttonSet);
    }

    private void initializeButtonSet(VBox nav) {
        previous = new Button("<");
        comment = new Button("Send comments");
        comment.setId("comment_button");
        next = new Button(">");
        buttonSet.spacingProperty().bind(nav.widthProperty().multiply(0.15));
        buttonSet.setAlignment(Pos.CENTER);
        setMargin(buttonSet, new Insets(10, 0, 0, 0));
        buttonSet.getChildren().addAll(previous, comment, next);
    }

    private void initializeContent(AnchorPane root) {
        Image image = new Image(
                "refugees.jpg"
        );
        
        ceiling_image = new ImageView(image);      
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setContrast(0);
        colorAdjust.setHue(-0.5);
        colorAdjust.setBrightness(0);
        colorAdjust.setSaturation(0);
//        ceiling_image.setEffect(colorAdjust);
        
        ceiling_image.setEffect(new GaussianBlur());
        ceiling_image.setClip(ceiling);
        root.getChildren().add(ceiling_image);
    }
}
