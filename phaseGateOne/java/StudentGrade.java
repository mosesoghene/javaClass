import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;


public class StudentGrade{
  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    
    System.out.println("How many students do you have?");
    int studentNumber = input.nextInt();
    
    System.out.println("How many subjects do they offer?");
    int subjectNumber = input.nextInt();
    savingNotice();
    
    //collectStudentScoresFor(studentNumber, subjectNumber);
    savingNotice();
    int[][] studentScores = collectStudentScoresFor(studentNumber, subjectNumber);
    printScoreTable(studentScores);
    
    
    
    //System.out.println(Arrays.deepToString(studentScores));
    
  }
  
  private static void savingNotice(){
    System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved succesfully\n");
  }
  
  private static void printScoreTable(int[][] studentScores){
    totalScores = getTotalScores(studentScores);
    
    System.out.println("===========================================================");
    System.out.printf("| %-9s ", "STUDENT");
    for (int i = 0; i < studentScores[0].length; i++){
      System.out.printf("| SUB%2d ", i+1);      
    }    
    System.out.printf("| %5s | %5s | %5s |%n", "TOT", "AVE", "POS");
    System.out.println("===========================================================");
    
    for (int student = 0; student < studentScores.length; student++){
      System.out.printf("| Student %d ", student + 1);
      for (int score = 0; score < studentScores[student].length; score++){
        System.out.printf("| %5d ", studentScores[student][score]);
      }      
      
      System.out.printf("| %5d | %5.2f | %3d |%n", getTotalOf(studentScores[student]), getAverageOf(studentScores[student]), ArrayUtils.indexOf(totalScores, getTotalOf(studentScores[student])) );
    }
  }
  
  private static int[][] collectStudentScoresFor(int studentNumber, int subjectNumber){
    Scanner input = new Scanner(System.in);
    int[][] studentScores = new int[studentNumber][subjectNumber];
    
    for (int studentIndex = 0; studentIndex < studentNumber; studentIndex++){
      for (int subjectIndex = 0; subjectIndex < subjectNumber; subjectIndex++){
        System.out.printf("Entering score for student %d%nEnter score for subject %d%n", studentIndex + 1, subjectIndex + 1);
        int score = input.nextInt();
        studentScores[studentIndex][subjectIndex] = score;
      }
    }
    
    return studentScores;
  }
  
  private static int getTotalOf(int[] studentScores){
    return IntStream.of(studentScores).sum();
  }
  
  private static double getAverageOf(int[] studentScores){
    return IntStream.of(studentScores).average().getAsDouble();
  }
  
   private static int[] getTotalScores(int[][] studentScores){
    int[] totalScores = new int[studentScores.length];
    for(int i = 0; i < studentScores.length; i++){
      totalScores[i] = IntStream.of(studentScores[i]).sum();
    }
    return totalScores;
  }
  
  
}
