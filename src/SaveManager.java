import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveManager {
    private static final String SAVE_FILE = "savegame.txt";

    public static int[] load() {
        File file = new File(SAVE_FILE);
        if (!file.exists()) {
            return new int[]{0, 0};
        }

        try (Scanner reader = new Scanner(file)) {
            int completedCases = reader.nextInt();
            int totalScore = reader.nextInt();

            if (completedCases < 0 || completedCases > 5 || totalScore < 0) {
                System.out.println("Save file is invalid. Starting a new game.");
                return new int[]{0, 0};
            }
            return new int[]{completedCases, totalScore};
        } catch (Exception e) {
            System.out.println("Could not read save file. Starting a new game.");
            return new int[]{0, 0};
        }
    }

    public static void save(int completedCases, int totalScore) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_FILE))) {
            writer.println(completedCases);
            writer.println(totalScore);
            System.out.println("Progress saved successfully.");
        } catch (IOException e) {
            System.out.println("Warning: progress could not be saved.");
        }
    }
}
