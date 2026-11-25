import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaseManager {
    private final List<CaseData> cases = new ArrayList<>();

    public CaseManager() {
        loadCases();
    }

    public List<CaseData> getCases() {
        return cases;
    }

    private void loadCases() {
        cases.add(new CaseData(1, "The Midnight Murder",
                "Businessman Rajiv Malhotra is found dead in his locked study at 11:30 PM. Three people were inside Blackwood Mansion that night.",
                Arrays.asList(
                        new Suspect("Aarav Malhotra", "Son",
                                "I was in my bedroom all evening.",
                                "He says he never left the bedroom after 10:00 PM.",
                                "He recently argued with his father about money."),
                        new Suspect("Meera Malhotra", "Wife",
                                "I was in the garden when it happened.",
                                "She says she was outside from 10:30 PM until the body was found.",
                                "She knew the study's spare key was kept in the hallway."),
                        new Suspect("Mahesh Pawar", "Butler",
                                "I left the mansion at 10:00 PM.",
                                "He claims he had already gone home before the estimated time of death.",
                                "A delivery driver confirms seeing him leave.")
                ),
                Arrays.asList(
                        new Evidence("Broken wristwatch", "Physical",
                                "The victim's watch stopped at 10:45 PM after receiving a sharp impact."),
                        new Evidence("Garden footprints", "Physical",
                                "The footprints near the garden door are small and do not match the victim's shoes."),
                        new Evidence("Spare key record", "Documentary",
                                "The household log shows Meera borrowed the study's spare key at 10:35 PM.")
                ),
                "Meera Malhotra",
                "The spare-key record places Meera in possession of the study key shortly before the estimated time of death. Her claim that she remained in the garden is not supported by the evidence."
        ));

        cases.add(new CaseData(2, "The Vanishing Witness",
                "Journalist Maya Sen disappears one day before giving evidence in a corruption inquiry. Her last confirmed location was the Central District railway station.",
                Arrays.asList(
                        new Suspect("Rohan Mehta", "Colleague",
                                "Maya left the office alone.",
                                "He says he was working late at the newsroom.",
                                "He had access to Maya's travel schedule."),
                        new Suspect("Vikram Sethi", "Security guard",
                                "I did not see Maya enter the station.",
                                "He was assigned to the station entrance that evening.",
                                "His shift log contains a missing entry."),
                        new Suspect("Nisha Kapoor", "Friend",
                                "I spoke to Maya by phone, but I never met her.",
                                "She says she was at home all evening.",
                                "She received a message from Maya shortly before the disappearance.")
                ),
                Arrays.asList(
                        new Evidence("Station receipt", "Documentary",
                                "A receipt shows Maya purchased a ticket at 8:15 PM."),
                        new Evidence("CCTV still", "Digital",
                                "A blurred image shows a person matching Maya's description entering the east exit."),
                        new Evidence("Deleted message", "Digital",
                                "A recovered message says: 'Meet me near the old platform. Come alone.'")
                ),
                "Vikram Sethi",
                "The CCTV image and the missing security log entry place Vikram at the east exit, where Maya was last seen. His claim that he never saw her is contradicted by the station records."
        ));

        cases.add(new CaseData(3, "The Silent Server",
                "Confidential files disappear from Asterion Technologies. The server records show no authorized download, but someone accessed the system after midnight.",
                Arrays.asList(
                        new Suspect("Arjun Rao", "System administrator",
                                "No one accessed the server after 10 PM.",
                                "He says he was at home.",
                                "He had administrator privileges."),
                        new Suspect("Leena Das", "Data analyst",
                                "I finished work at 9 PM and left.",
                                "She says she did not return to the office.",
                                "Her account was used in a late-night login."),
                        new Suspect("Kabir Shah", "Operations manager",
                                "I had no reason to access those files.",
                                "He says he attended a dinner outside the city.",
                                "He approved the project whose files disappeared.")
                ),
                Arrays.asList(
                        new Evidence("Access log", "Digital",
                                "A login using Leena's account occurred at 12:18 AM."),
                        new Evidence("Backup fragment", "Digital",
                                "A partial backup shows the files were copied to an external drive."),
                        new Evidence("Office entry record", "Documentary",
                                "A staff card registered entry at 12:10 AM. The card belonged to Leena.")
                ),
                "Leena Das",
                "The access log and entry record show Leena's account and staff card were used after she claimed to have left. The evidence places her at the office during the theft."
        ));

        cases.add(new CaseData(4, "A Debt in Ashes",
                "A warehouse belonging to a major supplier burns down. The fire is reported as an accident, but several financial records were destroyed.",
                Arrays.asList(
                        new Suspect("Dev Malhotra", "Warehouse supervisor",
                                "The electrical system had been faulty for weeks.",
                                "He says he was at home when the fire started.",
                                "He filed a maintenance complaint."),
                        new Suspect("Pooja Nair", "Accountant",
                                "I sent the financial records to head office.",
                                "She says she left the warehouse at 7 PM.",
                                "The records she claims to have sent cannot be found."),
                        new Suspect("Sameer Gill", "Supplier",
                                "I had no involvement with the warehouse.",
                                "He says he was attending a business meeting.",
                                "He would lose a large contract if the records were audited.")
                ),
                Arrays.asList(
                        new Evidence("Burn pattern report", "Physical",
                                "The fire appears to have started near the records storage room, not the electrical panel."),
                        new Evidence("Unsent email", "Digital",
                                "A draft email from Pooja says the financial records were still in the warehouse."),
                        new Evidence("Contract copy", "Documentary",
                                "The contract contains payments that were not recorded in the official accounts.")
                ),
                "Pooja Nair",
                "Pooja claimed that the records had already been sent, but her unsent email confirms they were still in the warehouse. The fire destroyed the records she had failed to submit."
        ));

        cases.add(new CaseData(5, "The Final Testimony",
                "Evidence from the previous investigations points to a coordinated cover-up. A senior investigator is found dead shortly before presenting the final report.",
                Arrays.asList(
                        new Suspect("Arvind Rathore", "Commissioner",
                                "I ordered a review, nothing more.",
                                "He says he was at headquarters all night.",
                                "He supervised the original investigations."),
                        new Suspect("Mira Khanna", "Legal adviser",
                                "I only handled the paperwork.",
                                "She says she was preparing documents at home.",
                                "Her signature appears on several disputed approvals."),
                        new Suspect("Neeraj Deshmukh", "Investigator",
                                "I was following the evidence independently.",
                                "He says he met the victim earlier that evening.",
                                "He possesses copies of all four earlier case files.")
                ),
                Arrays.asList(
                        new Evidence("Combined case file", "Documentary",
                                "All four earlier cases contain approvals from the same senior office."),
                        new Evidence("Meeting recording", "Digital",
                                "A recovered recording captures an order to stop the investigation."),
                        new Evidence("Headquarters access record", "Digital",
                                "The victim's office was accessed using Arvind Rathore's credentials shortly before the death.")
                ),
                "Arvind Rathore",
                "The combined files establish a pattern of interference. The recording reveals an order to suppress the inquiry, and the access record links the commissioner to the victim's office."
        ));
    }
}
