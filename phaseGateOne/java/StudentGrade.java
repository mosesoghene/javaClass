import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Comparator;


public class StudentGrade{
  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    
    System.out.println("How many students do you have?");
    int studentNumber = input.nextInt();
    
    System.out.println("How many subjects do they offer?");
    int subjectNumber = input.nextInt();
    savingNotice();

    int[][] studentScores = collectStudentScoresFor(studentNumber, subjectNumber);
    savingNotice();
    
    printScoreTable(studentScores);
    printSubjectStatistics(studentScores);
    
    
  }
  
  public static void savingNotice(){
    System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved succesfully\n");
  }
  
  public static void printScoreTable(int[][] studentScores){
    int[] totalScores = getTotalScores(studentScores);
    int[][] studentPosition = getStudentPosition(studentScores);
    System.out.println("===========================================================");
    System.out.printf("| %-9s ", "STUDENT");
    for (int i = 0; i < studentScores[0].length; i++){
      System.out.printf("| SUB%2d ", i+1);      
    }    
    System.out.printf("| %5s | %5s | %3s |%n", "TOT", "AVE", "POS");
    System.out.println("===========================================================");
    
    for (int student = 0; student < studentScores.length; student++){
      int total = 0;
      System.out.printf("| Student %d ", student + 1);
      for (int score = 0; score < studentScores[student].length; score++){
        System.out.printf("| %5d ", studentScores[student][score]);
        total += studentScores[student][score];
      }      
      
      System.out.printf("| %5d | %5.2f |%n", getTotalOf(studentScores[student]), getAverageOf(studentScores[student]));
      /*
      for (int i = 0; i < totalScores.length; i++){
        if (studentPosition[totalScores.length - 1][1] == getTotalOf(studentScores[student])){
          System.out.printf("| %3d |%n", studentPosition[0][i]);
        }
      }*/
    }
  }
  
  public static int[][] getStudentPosition(int[][] totalScores){
    Integer[][] array = new Integer[2][totalScores[0].length];
    Integer[][] mappedArray = new Integer[2][totalScores[0].length];
    for (int i = 0; i < array[0].length; i++){
        array[0][i] = totalScores[0][i];
        array[1][i] = totalScores[1][i];
        mappedArray[0][i] = totalScores[0][i];
        mappedArray[1][i] = totalScores[1][i];
      }
    
    int[][] sorted = new int[2][mappedArray.length];
    
    Arrays.sort(mappedArray[1], Comparator.comparingInt(a -> a));
        for (int i = 0; i < mappedArray[1].length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                if (mappedArray[1][i].equals(array[1][j])) {
                    mappedArray[0][i] = array[0][j];
                    break;
                }
            }
        }
      
     
      for (int i = 0; i < sorted[0].length; i++){
        sorted[0][i] = mappedArray[0][i];
        sorted[1][i] = mappedArray[1][i];
      }
        
      
      return sorted;
  }
  
  public static int[][] collectStudentScoresFor(int studentNumber, int subjectNumber){
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
  
  
  public static void printSubjectStatistics(int[][] studentScores){
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
  
  public static int getTotalOf(int[] studentScores){
    return IntStream.of(studentScores).sum();
  }
  
  public static double getAverageOf(int[] studentScores){
    return IntStream.of(studentScores).average().getAsDouble();
  }
  
   public static int[] getTotalScores(int[][] studentScores){
    int[] totalScores = new int[studentScores.length];
    for(int i = 0; i < studentScores.length; i++){  
      totalScores[i] = IntStream.of(studentScores[i]).sum();
    }
    return totalScores;
  }
  
  
}
