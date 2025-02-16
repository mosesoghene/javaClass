import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProblemsTest {
    private Problem problem;

    @BeforeEach
    public void setUp(){
        problem = new Problem("Money problem", ProblemType.FINANCIAL);
    }

    @Test
    public void isSolvedReturnsFalseWhenCreated_ProblemTest(){
        assertFalse(problem.isSolved());
    }

    @Test
    public void isSolvedIsFalse_ISolveProblem_ProblemIsSolved_ProblemTest(){
        assertFalse(problem.isSolved());
        problem.solve();
        assertTrue(problem.isSolved());
    }
}
