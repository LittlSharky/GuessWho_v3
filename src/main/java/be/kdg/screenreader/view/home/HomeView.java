package be.kdg.screenreader.view.home;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class HomeView extends VBox {

    private Label label;
    // label om iets te laten tonen aan de gebruiker

    private TextField confirmName;
    private Button start;
    private Image image;
    private ImageView imageView;// Create VBox container


    public HomeView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        this.label = new Label("Guess Who?");
        this.confirmName = new TextField("Give here your username");
        this.start = new Button("START");
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

