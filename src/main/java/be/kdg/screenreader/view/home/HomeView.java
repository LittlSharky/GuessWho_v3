package be.kdg.screenreader.view.home;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Window;

public class HomeView extends VBox {

    private Label label;
    // label om iets te laten tonen aan de gebruiker

    private TextField confirmName;
    private Button start;
    private Image image;
    private VBox vbox;
    private ImageView imageView;// Create VBox container
    private Label usernameLabel;


    public HomeView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        this.label = new Label("Guess Who?");
        this.confirmName = new TextField("Give here your username");
        this.start = new Button("START");
        this.vbox = new VBox();
        this.imageView = new ImageView();

        // dit gaat zowel text als button initialiseren
    }

    private void layoutNodes() {
        //put the image in the imageview
        this.image = new Image("Title.png");
        imageView.setImage(image);
        this.confirmName.setMaxWidth(450);
        this.getChildren().addAll(imageView, this.confirmName, this.start);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    Button getButton() {
        return this.start;
    }

    public TextField getConfirmName() {
        return confirmName;
    }


}
