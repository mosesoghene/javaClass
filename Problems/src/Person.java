import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Problem> problems = new ArrayList<>();

    public int problemCount() {
        return (int) problems.stream().filter(this::isProblem).count();
    }

    public void addProblem(Problem problem) {
        problems.add(problem);
    }

    private boolean isProblem(Problem problem) {
        return problem.isSolved() == false;
    }
}
