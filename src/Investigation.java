import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Investigation {
    private final CaseData caseData;
    private final Scanner sc;
    private final List<Evidence> collectedEvidence = new ArrayList<>();
    private final List<String> questionedSuspects = new ArrayList<>();
    private boolean solved = false;

    public Investigation(CaseData caseData, Scanner sc) {
        this.caseData = caseData;
        this.sc = sc;
    }

    public int run() {
        while (!solved) {
            System.out.println("\n--- INVESTIGATION MENU ---");
            System.out.println("1. Explore crime scene");
            System.out.println("2. View suspects");
            System.out.println("3. Interrogate a suspect");
            System.out.println("4. View collected evidence");
            System.out.println("5. Review case notes");
            System.out.println("6. Make final accusation");
            System.out.println("0. Return to main menu");
            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1 -> explore();
                case 2 -> showSuspects();
                case 3 -> interrogate();
                case 4 -> showEvidence();
                case 5 -> showNotes();
                case 6 -> {
                    int score = accuse();
                    if (solved) return score;
                }
                case 0 -> {
                    return 0;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
        return 0;
    }

    private void explore() {
        List<Evidence> all = caseData.getEvidence();
        boolean found = false;
        for (Evidence evidence : all) {
            if (!collectedEvidence.contains(evidence)) {
                collectedEvidence.add(evidence);
                System.out.println("\nYou discovered: " + evidence.getName());
                System.out.println(evidence.getDescription());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("You have examined all available locations.");
    }

    private void showSuspects() {
        System.out.println("\nSUSPECTS");
        for (int i = 0; i < caseData.getSuspects().size(); i++) {
            Suspect s = caseData.getSuspects().get(i);
            System.out.println((i + 1) + ". " + s.getName() + " - " + s.getRole());
        }
    }

    private void interrogate() {
        showSuspects();
        int choice = readInt("Choose a suspect to question (0 to cancel): ");
        if (choice == 0) return;
        if (choice < 1 || choice > caseData.getSuspects().size()) {
            System.out.println("Invalid suspect.");
            return;
        }

        Suspect suspect = caseData.getSuspects().get(choice - 1);
        if (!questionedSuspects.contains(suspect.getName())) {
            questionedSuspects.add(suspect.getName());
        } else {
            System.out.println("\nYou have already questioned this suspect. You can review their statement again.");
        }
        System.out.println("\nINTERROGATION: " + suspect.getName());
        System.out.println("\"" + suspect.getStatement() + "\"");
        System.out.println("Alibi: " + suspect.getAlibi());

        if (suspect.getExtraInfo() != null && !suspect.getExtraInfo().isBlank()) {
            System.out.println("Additional information: " + suspect.getExtraInfo());
        }
    }

    private void showEvidence() {
        System.out.println("\nCOLLECTED EVIDENCE");
        if (collectedEvidence.isEmpty()) {
            System.out.println("No evidence collected yet.");
            return;
        }
        for (int i = 0; i < collectedEvidence.size(); i++) {
            Evidence e = collectedEvidence.get(i);
            System.out.println((i + 1) + ". " + e.getName() + " (" + e.getType() + ")");
            System.out.println("   " + e.getDescription());
        }
    }

    private void showNotes() {
        System.out.println("\nCASE NOTES");
        System.out.println("Evidence collected: " + collectedEvidence.size()
                + "/" + caseData.getEvidence().size());
        System.out.println("Suspects questioned: " + questionedSuspects.size()
                + "/" + caseData.getSuspects().size());
        System.out.println("Tip: compare the suspects' statements with the evidence before accusing anyone.");
    }

    private int accuse() {
        showSuspects();
        int choice = readInt("Who is responsible? (0 to cancel): ");
        if (choice == 0) return 0;
        if (choice < 1 || choice > caseData.getSuspects().size()) {
            System.out.println("Invalid suspect.");
            return 0;
        }

        Suspect selected = caseData.getSuspects().get(choice - 1);
        System.out.println("\nYour accusation: " + selected.getName());
        System.out.println("Your reasoning: " + caseData.getSolutionExplanation());

        if (selected.getName().equals(caseData.getCulprit())) {
            solved = true;
            double evidenceBonus = (double) collectedEvidence.size()
                    / caseData.getEvidence().size() * 25;
            double interrogationBonus = (double) questionedSuspects.size()
                    / caseData.getSuspects().size() * 25;
            int score = 50 + (int) Math.round(evidenceBonus + interrogationBonus);
            System.out.println("\nCORRECT! You solved the case.");
            System.out.printf("Evidence score: %.1f/25%n", evidenceBonus);
            System.out.printf("Interrogation score: %.1f/25%n", interrogationBonus);
            System.out.println("Score: " + score + "/100");
            System.out.println("The culprit was " + caseData.getCulprit() + ".");
            System.out.println("Explanation: " + caseData.getSolutionExplanation());
            return score;
        } else {
            System.out.println("\nThat accusation is incorrect. The evidence does not support it.");
            System.out.println("Review the statements and try again.");
            return 0;
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
