package be.kdg.screenreader.model;

import java.io.*;


public class SaveAndLoadService {

    public static void saveGame(File file, Game game) throws IOException {
        if (file == null)
            throw new IOException("File does not exist");

        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)))) {

            pw.format("%s%n", game.getUsername());
            pw.format("%s%n", game.isBiggerBoard());

            for (Person person : game.getBoard(true).getPeople(game.isBiggerBoard())) {
                pw.format("%b-", person.isEliminated());
            }
            pw.println();
        }
    }
}
