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
    VBox vbox;
    ImageView imageView;// Create VBox container


    public HomeView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        this.label = new Label("Guess Who?");
        this.confirmName = new TextField("Give here your username");
        this.start = new Button("START");
        this.vbox = new VBox();


        // dit gaat zowel text als button initialiseren
    }

    private void layoutNodes() {
        //we zetten alles van de lijst samen
        VBox.setMargin(this.confirmName, new Insets(10, 10, 10, 10));
        vbox.setPrefSize(1400, 800);
        this.image = new Image("file:" + "src/main/java/be/kdg/screenreader/resources/Title.png");
        this.imageView = new ImageView(this.image);
        vbox.getChildren().add(imageView); // Add ImageView to VBox


        // resources is enkel voor hardcoded images en savefiles eerder in de documenten van de gebruiker

        this.getChildren().addAll(this.label, this.confirmName, this.start);
        this.setAlignment(Pos.CENTER);

        this.label.setFont(new Font(22));
        this.label.setTextFill(Color.BLUE);
        this.confirmName.setMaxWidth(450);


    }

    Button getButton() {
        return this.start;
    }

    public TextField getConfirmName() {
        return confirmName;
    }


}

