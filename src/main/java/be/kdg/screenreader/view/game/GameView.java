package be.kdg.screenreader.view.game;

import be.kdg.screenreader.model.Game;
import be.kdg.screenreader.model.Question;
import be.kdg.screenreader.view.home.HomePresenter;
import be.kdg.screenreader.view.home.HomeView;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class GameView extends BorderPane {

    private MenuItem exit;
    private MenuItem info;
    private Button confirmQuestion;
    private Button guess;
    private Label name;
    private ComboBox<String> questions;
    private Question question;

    private GridPane gameGrid;
    private final int ROWS = 5;
    private final int COLUMNS = 4;
    Game game;

    private ArrayList<String> persons;

    private Button confirmPerson;
    private ImageView confirmedPerson;


    public GameView() {
        this.persons = new ArrayList<>();
        this.fillPersons();

        initializeNodes();
        layoutNodes();
    }


    private void initializeNodes() {
        this.exit = new MenuItem("Exit");
        this.info = new MenuItem("Info");

        //Initiliaze buttons
        this.confirmQuestion = new Button();
        this.guess = new Button();//pic
        this.name = new Label();
        //Initiliaze questions

        question = new Question();
        questions = new ComboBox<>();
        //ObservableList<String> questionObservable = FXCollections.observableArrayList(question.getListQuestion());
        //questions.setItems(questionObservable);

        //Confirmed person image view
        this.confirmPerson = new Button("Confirm person");
        this.confirmedPerson = new ImageView();

    }

    private void layoutNodes() {
        Menu gameMenu = new Menu("Game", null, this.exit);
        Menu aboutMenu = new Menu("About", null, this.info);

        MenuBar menuBar = new MenuBar(gameMenu, aboutMenu);
        this.setTop(menuBar);

        gameGrid = new GridPane();
        gameGrid.setPadding(new Insets(10));

        //gameGrid.add(questions, 4, 5);

        //confirmQuestion.setText("Confirm question");
        //gameGrid.add(confirmQuestion, 5, 5);

        //confirmPerson.setText("Confirm person");
        //gameGrid.add(confirmPerson, 5, 2);

        //guess.setText("Take a Guess!");
        //gameGrid.add(guess, 5, 4);

        //Default selected person
        setConfirmedPerson(new ImageView("BackPhoto.png").getImage());
        this.setRight(new VBox(10, confirmedPerson, confirmPerson));

        gameGrid.setHgap(10);
        gameGrid.setVgap(10);

        int index = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                GamePersonView person = new GamePersonView(this.persons.get(index), j, i);
                gameGrid.add(person, j, i);
                index++;
            }
        }
        this.setCenter(gameGrid);
    }

    public Button getConfirmPerson() {
        return confirmPerson;
    }

    public Button getConfirmQuestion() {
        return confirmQuestion;
    }

    public Button getGuess() {
        return guess;
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
        this.confirmedPerson = new ImageView(image);
        this.setRight(new VBox(10, confirmedPerson, confirmPerson));
    }
}

