public class Suspect extends Person {
    private final String statement;
    private final String alibi;
    private final String extraInfo;

    public Suspect(String name, String role, String statement, String alibi, String extraInfo) {
        super(name, role);
        this.statement = statement;
        this.alibi = alibi;
        this.extraInfo = extraInfo;
    }

    public String getStatement() { return statement; }
    public String getAlibi() { return alibi; }
    public String getExtraInfo() { return extraInfo; }
}
