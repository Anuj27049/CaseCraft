import java.util.List;

public class CaseData {
    private final int number;
    private final String title;
    private final String briefing;
    private final List<Suspect> suspects;
    private final List<Evidence> evidence;
    private final String culprit;
    private final String solutionExplanation;

    public CaseData(int number, String title, String briefing, List<Suspect> suspects,
                    List<Evidence> evidence, String culprit, String solutionExplanation) {
        this.number = number;
        this.title = title;
        this.briefing = briefing;
        this.suspects = suspects;
        this.evidence = evidence;
        this.culprit = culprit;
        this.solutionExplanation = solutionExplanation;
    }

    public int getNumber() { return number; }
    public String getTitle() { return title; }
    public String getBriefing() { return briefing; }
    public List<Suspect> getSuspects() { return suspects; }
    public List<Evidence> getEvidence() { return evidence; }
    public String getCulprit() { return culprit; }
    public String getSolutionExplanation() { return solutionExplanation; }
}
