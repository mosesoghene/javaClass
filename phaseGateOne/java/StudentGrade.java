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
    printSubjectStatistics(studentScores);
    
    
    
    //System.out.println(Arrays.deepToString(studentScores));
    
  }
  
  private static void savingNotice(){
    System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved succesfully\n");
  }
  
  private static void printScoreTable(int[][] studentScores){
    int[] totalScores = getTotalScores(studentScores);
    
    System.out.println("===========================================================");
    System.out.printf("| %-9s ", "STUDENT");
    for (int i = 0; i < studentScores[0].length; i++){
      System.out.printf("| SUB%2d ", i+1);      
    }    
    System.out.printf("| %5s | %5s | %3s |%n", "TOT", "AVE", "POS");
    System.out.println("===========================================================");
    
    for (int student = 0; student < studentScores.length; student++){
      System.out.printf("| Student %d ", student + 1);
      for (int score = 0; score < studentScores[student].length; score++){
        System.out.printf("| %5d ", studentScores[student][score]);
      }      
      
      System.out.printf("| %5d | %5.2f ", getTotalOf(studentScores[student]), getAverageOf(studentScores[student]));
      for (int i = 0; i < totalScores.length; i++){
        if (totalScores[i] == getTotalOf(studentScores[student]))
        System.out.printf("| %3d |%n", totalScores.length - i);
      }
    }
  }
  
  private static int[][] collectStudentScoresFor(int studentNumber, int subjectNumber){
    Scanner input = new Scanner(System.in);
    int[][] studentScores = new int[studentNumber][subjectNumber];
    
    for (int studentIndex = 0; studentIndex < studentNumber; studentIndex++){
      for (int subjectIndex = 0; subjectIndex < subjectNumber; subjectIndex++){
        System.out.printf("Entering score for student %d%nEnter score for subject %d%n", studentIndex + 1, subjectIndex + 1);
        int score = input.nextInt();
        if (score >= 0 && score <= 100){
          studentScores[studentIndex][subjectIndex] = score;
        } else {
          System.out.println("INVALID SCORE: must be between 0 - 100");
          subjectIndex--;
        }
      }
    }
    
    return studentScores;
  }
  
  
  private static void printSubjectStatistics(int[][] studentScores){
    int[] totalScores = getTotalScores(studentScores);    
    
    
    int highestScoringStudent = 0;
    int lowestScoringStudent = 0;
    
    for (int i = 0; i < studentScores.length; i++){
      System.out.printf("Subject %d%n", i + 1);
      if (totalScores[totalScores.length - 1] == getTotalOf(studentScores[i])){
        highestScoringStudent = i;
      }
      if (totalScores[i] == getTotalOf(studentScores[i])){
        lowestScoringStudent = i;
      }   
      System.out.printf("Highest Scoring student is: Student %d Scoring %n", highestScoringStudent); 
      System.out.printf("Lowest Scoring student is: Student %d Scoring %n", lowestScoringStudent);
    }
    
    System.out.printf("Best Graduating student is: ");
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
    return IntStream.of(totalScores).sorted().toArray();
  }
  
  
}
