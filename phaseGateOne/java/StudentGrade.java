import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;


public class StudentGrade{

  private static Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    
    System.out.println("How many students do you have?");
    int studentNumber = input.nextInt();
    
    System.out.println("How many subjects do they offer?");
    int subjectNumber = input.nextInt();
    savingNotice();
    
    int[][] scores = collectAllScores(studentNumber, subjectNumber);    
    savingNotice();
    
    int[] studentTotals = calculateTotals(scores);
    double[] studentAverages = calculateAverages(studentTotals, subjectNumber);
    int[] positions = calculateStudentPositions(studentTotals);

    displayResultsTable(scores, studentTotals, studentAverages, positions);
    displaySubjectSummaries(scores);
    displayOverallAnalysis(scores, studentTotals, studentAverages);
    
  }
  
  public static void savingNotice(){
    System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved succesfully\n");
  }
  
  private static void displaySubjectSummaries(int[][] scores) {
    for (int subject = 0; subject < scores[0].length; subject++) {
      int[] stats = calculateSubjectStatistics(scores, subject);
      System.out.println("\nSubject Summary:");
      System.out.printf("\nSubject %d\n", subject + 1);
      System.out.printf("Highest scoring student is: Student %d Scoring %d\n", stats[2] + 1, stats[0]);
      System.out.printf("Lowest scoring student is: Student %d Scoring %d\n", stats[3] + 1, stats[1]);
      System.out.printf("Total Score is: %d\n", stats[5]);      
      System.out.printf("Number of passes: %d\n", stats[4]);
      System.out.printf("Number of Fails: %d\n", scores.length - stats[4]);
    }
  }
  
  private static void displayResultsTable(int[][] scores, int[] totals, double[] averages, int[] positions) {
    System.out.println("\nClass Score Summary:");
    System.out.println("<<================================================================================>>");
    System.out.print("| STUDENT   ");
    for (int i = 1; i <= scores[0].length; i++) {
      System.out.printf("| SUB%2d", i);
    }    
    System.out.printf("| %4s | %6s | %2s |\n", "TOT", "AVE", "POS");
    
    System.out.println("<<================================================================================>>");
    
    for (int i = 0; i < scores.length; i++) {
      System.out.printf("| Student %d ", (i + 1));
      for (int j = 0; j < scores[i].length; j++) {
        System.out.printf("| %4d ", scores[i][j]);
      }
      System.out.printf("| %4d | %4.2f | %2d |\n", totals[i], averages[i], positions[i]);
    }    
    System.out.println("<<================================================================================>>\n");
    
    System.out.println("<<================================================================================>>");
  }
  
  private static void displayOverallAnalysis(int[][] scores, int[] totals,double[] averages) {
        int[] subjectPasses = calculateSubjectPasses(scores);
        int[] overallStats = calculateOverallHighestLowest(scores);
        int[] subjectDifficulty = findSubjectDifficulty(subjectPasses, scores.length);
        int[] bestWorst = findBestAndWorstStudents(averages);
        int totalClassScore = calculateTotalClassScore(totals);

        System.out.println("\nOverall Class Summary:");
        
        
        System.out.printf("Hardest Subject is Subject %d with %d failures\n",
                         subjectDifficulty[0] + 1,
                         scores.length - subjectPasses[subjectDifficulty[0]]);
        System.out.printf("Easiest Subject is Subject %d with %d Passes\n",
                         subjectDifficulty[1] + 1, 
                         subjectPasses[subjectDifficulty[1]]);
        
        
        System.out.printf("Overall Highest Score is scored by Student %d in Subject %d scoring %d\n",
                          overallStats[2] + 1, overallStats[4] + 1, overallStats[0]);
        System.out.printf("Overall Lowest Score is Student %d in Subject %d scoring %d)\n",
                         overallStats[3] + 1, overallStats[5] + 1, overallStats[1]);        
        System.out.println("<<================================================================================>>");
        System.out.println();
        System.out.println("CLASS SUMMARY");
        System.out.println("<<================================================================================>>");
        
        System.out.printf("Best Graduating Student is: Student %d  with an average: %.2f\n",
                         bestWorst[0] + 1, averages[bestWorst[0]]);
        System.out.println("<<================================================================================>>");
        System.out.println();
        System.out.println("<<================================================================================>>");
        System.out.printf("Worst Graduating Student is: Student %d  with an average: %.2f\n",
                         bestWorst[1] + 1, averages[bestWorst[1]]);
        System.out.println("<<================================================================================>>");
        
        System.out.println();
        System.out.println("<<================================================================================>>");
        double classAverage = (double) totalClassScore / (scores.length * scores[0].length);
        System.out.printf("Class Total is: %d\n", totalClassScore);
        System.out.printf("Class Average Score is: %.2f\n", classAverage);
        System.out.println("<<================================================================================>>");
    }

  
    
  
  public static int[][] collectAllScores(int studentNumber, int subjectNumber){
    int[][] scores = new int[studentNumber][subjectNumber];
    for (int i = 0; i < studentNumber; i++) {
      System.out.println("\nEntering scores for Student " + (i + 1));
      for (int j = 0; j < subjectNumber; j++) {
        scores[i][j] = getValidScore(j);
      }
    }
    return scores;
  }
  
  private static int getValidScore(int subject) {
    int score;
    do {
      System.out.print("Enter score for Subject " + (subject + 1) + ": ");
      score = scanner.nextInt();
      if (score < 0 || score > 100) {
        System.out.println("Invalid score! Score must be between 0 and 100.");
      }
    } while (score < 0 || score > 100);
    return score;
  }
  
  private static int[] calculateSubjectStatistics(int[][] scores, int subject) {
    int highest = 0; 
    int lowest = 100;
    int highestStudent = 0; 
    int lowestStudent = 0; 
    int passes = 0;
    int totalScore = 0;
    
    for (int student = 0; student < scores.length; student++) {
      if (scores[student][subject] > highest) {
        highest = scores[student][subject];
        highestStudent = student;
      }
      if (scores[student][subject] < lowest) {
        lowest = scores[student][subject];
        lowestStudent = student;
      }
      if (scores[student][subject] >= 50) passes++;
      totalScore += scores[student][subject];
    }
    
    return new int[]{highest, lowest, highestStudent, lowestStudent, passes, totalScore};
  }
  
  private static int[] calculateSubjectPasses(int[][] scores) {
    int[] subjectPasses = new int[scores[0].length];
    for (int j = 0; j < scores[0].length; j++) {
      for (int i = 0; i < scores.length; i++) {
        if (scores[i][j] >= 50) 
          subjectPasses[j]++;
      }
    }
    return subjectPasses;
  }
  
  private static double[] calculateAverages(int[] totals, int numSubjects) {
    double[] averages = new double[totals.length];
    for (int i = 0; i < totals.length; i++) {
      averages[i] = (double) totals[i] / numSubjects;
    }
    return averages;
  }
  
  private static int[] calculateStudentPositions(int[] totals) {
    int[] positions = new int[totals.length];
    for (int i = 0; i < totals.length; i++) {
      int position = 1;
      for (int j = 0; j < totals.length; j++) {
        if (totals[j] > totals[i]) {
          position++;
        }
      }
      positions[i] = position;
    }
    return positions;
  }
  
  private static int[] calculateTotals(int[][] scores) {
    int[] totals = new int[scores.length];
    for (int i = 0; i < scores.length; i++) {
      for (int j = 0; j < scores[i].length; j++) {
        totals[i] += scores[i][j];
      }
    }
    return totals;
  }
  
  private static int calculateTotalClassScore(int[] totals) {
    int sum = 0;
    for (int total : totals) {
      sum += total;
    }
    return sum;
  }
  
  private static int[] calculateOverallHighestLowest(int[][] scores) {
    int highest = 0, lowest = 100;
    int highestStudent = 0, lowestStudent = 0;
    int highestSubject = 0, lowestSubject = 0;
    
    for (int i = 0; i < scores.length; i++) {
      for (int j = 0; j < scores[i].length; j++) {
        if (scores[i][j] > highest) {
          highest = scores[i][j];
          highestStudent = i;
          highestSubject = j;
        }
        if (scores[i][j] < lowest) {
          lowest = scores[i][j];
          lowestStudent = i;
          lowestSubject = j;
        }
      }
    }
    
    return new int[]{highest, lowest, highestStudent, lowestStudent, highestSubject, lowestSubject};
  }
  
  private static int[] findBestAndWorstStudents(double[] averages) {
    int bestStudent = 0, worstStudent = 0;
    for (int i = 1; i < averages.length; i++) {
      if (averages[i] > averages[bestStudent]) {
        bestStudent = i;
      }
      if (averages[i] < averages[worstStudent]) {
        worstStudent = i;
      }
    }
    return new int[]{bestStudent, worstStudent};
  }
  
  private static int[] findSubjectDifficulty(int[] subjectPasses, int numStudents) {
    int hardest = 0, easiest = 0;
    int minPasses = numStudents, maxPasses = 0;
    
    for (int i = 0; i < subjectPasses.length; i++) {
      if (subjectPasses[i] < minPasses) {
        minPasses = subjectPasses[i];
        hardest = i;
      }
      if (subjectPasses[i] > maxPasses) {
        maxPasses = subjectPasses[i];
        easiest = i;
      }
    }
    
    return new int[]{hardest, easiest};
  }
}
