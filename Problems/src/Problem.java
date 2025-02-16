public class Problem {
    private String problemName;
    private ProblemType problemType;
    private boolean isSolved = false;

    public Problem(String name, ProblemType type) {
        this.problemName = name;
        this.problemType = type;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void solve() {
        isSolved = true;
    }
}
