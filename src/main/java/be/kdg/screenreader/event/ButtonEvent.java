package be.kdg.screenreader.event;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Er is geklikt op de knop!");
    }
}
