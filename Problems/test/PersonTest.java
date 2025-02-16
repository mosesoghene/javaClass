import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    public void problemsAreZero_PersonTest(){
        assertEquals(0, person.problemCount());
    }

    @Test
    public void addProblemX_problemCountIsOne_personTest(){
        assertEquals(0, person.problemCount());
        person.addProblem(new Problem("Wife", ProblemType.MARITAL));
        assertEquals(1, person.problemCount());
    }

    @Test


}
