package be.kdg.screenreader.view.game;

import be.kdg.screenreader.model.Game;
import be.kdg.screenreader.model.Question;
import be.kdg.screenreader.view.home.HomePresenter;
import be.kdg.screenreader.view.home.HomeView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Popup;

import java.util.ArrayList;

public class GameView extends BorderPane {

    private MenuItem exit;
    private MenuItem info;
    private Button confirmQuestion;
    private ToggleButton guessButton;
    private Label name;
    private Button doneEliminating;

    private GridPane gameGrid;
    private final int ROWS = 4;
    private final int COLUMNS = 5;

    private ArrayList<String> persons;

    private Button confirmPerson;
    private ImageView confirmedPerson;
    private ComboBox<String> comboBoxQuestion;

    private Popup popup;

    public GameView() {
        this.persons = new ArrayList<>();
        this.fillPersons();

        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        this.exit = new MenuItem("Exit");
        this.info = new MenuItem("Info");

        //Initiliaze buttons & labels
        this.confirmQuestion = new Button("Confirm question");
        this.guessButton = new ToggleButton("Take a Guess!");
        this.name = new Label();
        this.doneEliminating = new Button("Done eliminating");

        //Confirmed person image view
        this.confirmPerson = new Button("Confirm person");
        this.confirmedPerson = new ImageView();

        //Initiliaze questions
        this.comboBoxQuestion = new ComboBox<String>();
    }

    private void layoutNodes() {
        Menu gameMenu = new Menu("Game", null, this.exit);
        Menu aboutMenu = new Menu("About", null, this.info);

        MenuBar menuBar = new MenuBar(gameMenu, aboutMenu);
        this.setTop(menuBar);

        gameGrid = new GridPane();
        gameGrid.setPadding(new Insets(10));


        //Default selected person
        setConfirmedPerson(new ImageView("BackPhoto.png").getImage());
        VBox vBox = new VBox(10, confirmedPerson, confirmPerson);

        //Put the VBox at the right center of the screen
        vBox.setAlignment(Pos.CENTER_RIGHT);

        this.setRight(vBox);

        gameGrid.setHgap(10);
        gameGrid.setVgap(10);

        int index = 0;
        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                GamePersonView person = new GamePersonView(this.persons.get(index), i, j);
                gameGrid.add(person, i, j);
                index++;
            }
        }
        this.setCenter(gameGrid);
        //Make a hBox with the guessButton and the confirmQuestion button
        HBox hBox = new HBox(10, this.comboBoxQuestion, confirmQuestion, guessButton);

        //Put them at the bottom of the screen on the right
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        this.setBottom(hBox);

        //Put the comboBox and the confirmButton with the same padding around them
        BorderPane.setMargin(vBox, new Insets(10, 75, 10, 10));
        BorderPane.setMargin(hBox, new Insets(10, 10, 10, 10));
    }

    public Button getConfirmPerson() {
        return confirmPerson;
    }

    public Button getConfirmQuestion() {
        return confirmQuestion;
    }


    private void fillPersons() {
        persons.add("Amy.png");
        persons.add("Andrew.png");
        persons.add("Anne.png");
        persons.add("David.png");
        persons.add("Graham.png");
        persons.add("Harry.png");
        persons.add("Jenny.png");
        persons.add("John.png");
        persons.add("Joshua.png");
        persons.add("Kate.png");
        persons.add("Kevin.png");
        persons.add("Lauren.png");
        persons.add("Lucy.png");
        persons.add("Megan.png");
        persons.add("Michael.png");
        persons.add("Neil.png");
        persons.add("Paul.png");
        persons.add("Peter.png");
        persons.add("Simon.png");
        persons.add("Thomas.png");
    }

    public GridPane getGameGrid() {
        return gameGrid;
    }

    void setConfirmedPerson(Image image) {
        this.confirmedPerson.setImage(image);
    }

    public ComboBox<String> getComboBoxQuestion() {
        return comboBoxQuestion;
    }
}

