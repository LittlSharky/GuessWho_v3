package be.kdg.screenreader.view.game;

import be.kdg.screenreader.model.Question;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class GamePersonView extends Canvas {

    private final GraphicsContext gc;
    private final ImageView photo;

    private boolean eliminated;
    private final double WIDTH;
    private final double HEIGHT;

    private final int COORD_X;
    private final int COORD_Y;
    private Question[] questions;

    public GamePersonView(String path, int columnIndex, int rowIndex) {
        this.photo = new ImageView(path);
        this.eliminated = false;

        this.WIDTH = this.photo.getImage().getWidth();
        this.HEIGHT = this.photo.getImage().getHeight();

        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);

        this.gc = this.getGraphicsContext2D(); //zorgt ervoor dat je op de canvas kan tekenen
        this.gc.drawImage(this.photo.getImage(), 0, 0); //tekenen van de foto

        this.COORD_X = columnIndex;
        this.COORD_Y = rowIndex;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;

        if (this.eliminated) {
            this.gc.setStroke(Color.RED);
            this.gc.setLineWidth(10);

            this.gc.strokeLine(0, 0, WIDTH, HEIGHT);
            this.gc.strokeLine(WIDTH, 0, 0, HEIGHT);
        } else {
            this.gc.clearRect(0, 0, WIDTH, HEIGHT);//clear de canvas
            this.gc.drawImage(this.photo.getImage(), 0, 0);
        }
    }



    public Image getPhoto() {
        return photo.getImage();
    }

    public int getCOORD_X() {
        return COORD_X;
    }

    public int getCOORD_Y() {
        return COORD_Y;
    }
}
