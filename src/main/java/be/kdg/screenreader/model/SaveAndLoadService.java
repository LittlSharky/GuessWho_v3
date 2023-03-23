package be.kdg.screenreader.model;

import java.io.*;


public class SaveAndLoadService {

    public static void saveGame(File file, Game game) throws IOException {
        int counter = 0;
        if (file == null)
            throw new IOException("File does not exist");

        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)))) {
            pw.format("Big board: %s%n", game.isBiggerBoard());

            pw.format("Saved data from the player:%n");
            pw.format("Username: %s%n", game.getUsername());
            pw.format("%nChosen person from %s: %s%n", game.getUsername(), game.getBoard(true).getChosenPerson().getName());
            pw.format("Eliminated people:%n");
            for (Person person : game.getBoard(true).getPeople(game.isBiggerBoard())) {
                pw.format("%s: %b - ", person.getName(), person.isEliminated());
            }
            pw.format("%nThese are the questions:%n");
            for (String question : game.getBoard(true).getQuestions()) {
                counter++;
                pw.format("%d. %s%n", counter, question);
                // ^ questions human
            }
            counter = 0;
            pw.format("%nSaved data from the AI:%n");
            pw.format("Chosen person: %s%n", game.getBoard(false).getChosenPerson().getName());
            pw.format("Eliminated people or not eliminated:%n");
            for(Person person: game.getBoard(false).getPeople(game.isBiggerBoard())) {
                pw.format("%s: %b - ", person.getName(), person.isEliminated());
            }
            pw.format("%n%nThese are the question from the AI:%n");
            for (String question : game.getBoard(false).getQuestions()) {
                counter++;
                pw.format("%d. %s%n", counter, question);
                // ^ questions AI
            }
            pw.println();
        }
    }
   /* public static boolean loadGame(File file, Game game) throws IOException {
        if (file == null || !file.exists())
            throw new IOException("File does not exist");

        try (BufferedReader br =
                new BufferedReader(
                        new FileReader(file)))) {

            if (dis.available() > 0) {
                Schijf[][] bord = new Schijf[RIJEN][KOLOMMEN];

                for (int i = 0; i < RIJEN; i++) {
                    for (int j = 0; j < KOLOMMEN; j++) {
                        bord[i][j] = Schijf.valueOf(dis.readUTF());
                    }
                }

                model.reset(bord);
                return true;
            }
        }

        return false;
    }*/
}
