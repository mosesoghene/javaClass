import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStudentGrade{
  @Test
  public void testThatEverageReturnsCorrectResult(){
    int[][] studentScores = {{1,2,3,1,2,3},{1,2,3,4,5}};
    double actual = StudentGrade.getAverageOf(studentScores[0]);
    double expected = 2.0;
    assertEquals(expected, actual);
  }
  
  
  
}
