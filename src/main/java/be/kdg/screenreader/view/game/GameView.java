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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Popup;

import java.util.ArrayList;

public class GameView extends BorderPane {
    private MenuItem newGame;
    private MenuItem loadGame;
    // TODO vragen aan maarten voor name, loadgame en savegame
    private MenuItem saveGame;
    private MenuItem exit;
    private MenuItem howToPlay;
    private MenuItem rules;
    private MenuItem info;
    private Button confirmQuestion;
    private ToggleButton guessButton;
    private Label name;
    private Button endTurn;
    private GridPane gameGrid;
    private final int ROWS = 4;
    private final int COLUMNS = 5;

    private ArrayList<String> persons;

    private Button confirmPerson;
    private ImageView confirmedPerson;
    private ComboBox<String> comboBoxQuestion;

    public GameView() {
        this.persons = new ArrayList<>();
        this.fillPersons();


        initializeNodes();
        layoutNodes();
    }


    private void initializeNodes() {
        //Initialize menuitems
        this.exit = new MenuItem("Exit");
        this.info = new MenuItem("Info");
        this.saveGame = new MenuItem("Save game");
        this.loadGame = new MenuItem("Load game");
        this.newGame = new MenuItem("New game");
        this.howToPlay = new MenuItem("How to play");
        this.rules = new MenuItem("Rules");

        //Initialize buttons & labels
        this.confirmQuestion = new Button("Confirm question");
        this.guessButton = new ToggleButton("Take a Guess!");
        this.name = new Label();
        this.endTurn = new Button("End turn");

        //Confirmed person image view
        this.confirmPerson = new Button("Confirm person");
        this.confirmedPerson = new ImageView();

        //Initialize questions
        this.comboBoxQuestion = new ComboBox<>();
    }

    private void layoutNodes() {
        Menu gameMenu = new Menu("Game", null,  this.newGame, this.loadGame, this.saveGame,this.exit);
        Menu helpMenu = new Menu("Help", null, this.howToPlay, this.rules);
        Menu aboutMenu = new Menu("About",null, this.info);
        MenuBar menuBar = new MenuBar(gameMenu, helpMenu,aboutMenu);

        gameGrid = new GridPane();
        gameGrid.setPadding(new Insets(10));
        gameGrid.setHgap(10);
        gameGrid.setVgap(10);

        int index = 0;
        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                GamePersonView person = new GamePersonView(this.persons.get(index), i, j);
                // TODO this.persons.get(index) vragen aan Maarten
                gameGrid.add(person, i, j);
                index++;
            }
        }


        //Default selected person
        setConfirmedPerson(new ImageView("BackPhoto.png").getImage());
        VBox vBoxConfirm = new VBox(10, confirmedPerson, confirmPerson);
        //Put the VBox at the right center of the screen
        vBoxConfirm.setAlignment(Pos.CENTER_RIGHT);

        HBox left = new HBox();
        left.getChildren().addAll(gameGrid, endTurn);
        left.setPadding(new Insets(10, 0, 0, 10));
        left.setAlignment(Pos.TOP_RIGHT);

        this.name.setText(" ");
        this.name.setPadding(new Insets(10));
        this.name.setBackground(new Background(new BackgroundFill(Color.PINK, null, null)));
        this.name.setAlignment(Pos.BASELINE_LEFT);


        //Make a hBox with the guessButton and the confirmQuestion button
        HBox hBox = new HBox(10, this.comboBoxQuestion, confirmQuestion, guessButton);
        //Put them at the bottom of the screen on the right
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        //Put the comboBox and the confirmButton with the same padding around them
        BorderPane.setMargin(vBoxConfirm, new Insets(10, 100, 10, 10));
        BorderPane.setMargin(hBox, new Insets(10, 10, 10, 10));

        GridPane.setHgrow(gameGrid, Priority.ALWAYS);
        GridPane.setVgrow(gameGrid, Priority.ALWAYS);

        HBox.setHgrow(left, Priority.ALWAYS);
        VBox.setVgrow(vBoxConfirm, Priority.ALWAYS);
        HBox.setHgrow(hBox, Priority.ALWAYS);

        this.setTop(menuBar);
        this.setRight(vBoxConfirm);
        this.setLeft(left);
        this.setBottom(hBox);


    }

    public MenuItem getNewGame() {
        return newGame;
    }

    public MenuItem getLoadGame() {
        return loadGame;
    }

    public MenuItem getSaveGame() {
        return saveGame;
    }

    public MenuItem getHowToPlay() {
        return howToPlay;
    }

    public MenuItem getRules() {
        return rules;
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

    public ToggleButton getGuessButton() {
        return guessButton;
    }

    public Button getEndTurn() {
        return endTurn;
    }

    public MenuItem getExit() {
        return exit;
    }

    public MenuItem getInfo() {
        return info;
    }

}

