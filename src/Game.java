import java.util.List;
import java.util.Scanner;

public class Game {
    private final Scanner sc = new Scanner(System.in);
    private final CaseManager caseManager = new CaseManager();
    private int completedCases;
    private int totalScore;

    public Game() {
        int[] savedProgress = SaveManager.load();
        completedCases = savedProgress[0];
        totalScore = savedProgress[1];
    }

    public void start() {
        if (completedCases > 0) {
            System.out.println("\nPrevious progress loaded: " + completedCases
                    + "/5 cases completed. Total score: " + totalScore);
        }
        System.out.println("\n==================================");
        System.out.println("             CASECRAFT");
        System.out.println("      A Crime Investigation Game");
        System.out.println("==================================");

        boolean running = true;
        while (running) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Start / Continue Game");
            System.out.println("2. Detective Profile");
            System.out.println("3. View Case List");
            System.out.println("0. Exit");
            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1 -> playCases();
                case 2 -> showProfile();
                case 3 -> showCases();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        System.out.println("Thank you for playing CaseCraft.");
    }

    private void playCases() {
        List<CaseData> cases = caseManager.getCases();
        if (completedCases == cases.size()) {
            System.out.println("You have completed all five cases!");
            return;
        }

        CaseData current = cases.get(completedCases);
        System.out.println("\nCASE " + current.getNumber() + ": " + current.getTitle());
        System.out.println(current.getBriefing());

        Investigation investigation = new Investigation(current, sc);
        int score = investigation.run();

        if (score >= 50) {
            completedCases++;
            totalScore += score;
            SaveManager.save(completedCases, totalScore);
            System.out.println("\nCase completed. The next case is now unlocked.");
        } else {
            System.out.println("\nThe case remains unresolved. Review the clues and try again.");
        }
    }

    private void showProfile() {
        System.out.println("\nDETECTIVE PROFILE");
        System.out.println("Cases completed: " + completedCases + "/5");
        System.out.println("Total score: " + totalScore);
        System.out.println("Rank: " + getRank());
    }

    private String getRank() {
        if (totalScore >= 400) return "Master Detective";
        if (totalScore >= 250) return "Senior Detective";
        if (totalScore >= 100) return "Investigator";
        return "Rookie Detective";
    }

    private void showCases() {
        System.out.println("\nCASE ARCHIVE");
        for (CaseData c : caseManager.getCases()) {
            String status = c.getNumber() <= completedCases ? "COMPLETED"
                    : c.getNumber() == completedCases + 1 ? "UNLOCKED" : "LOCKED";
            System.out.println(c.getNumber() + ". " + c.getTitle() + " - " + status);
        }
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
