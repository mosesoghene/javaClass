studentNumber = input("How many students do you have?\n");
subjectNumber = input("How many subjects do they offer?\n");

scores = collectAllScores(studentNumber, subjectNumber);   
studentTotals = calculateTotals(scores);
studentAverages = calculateAverages(studentTotals, subjectNumber);
positions = calculateStudentPositions(studentTotals);
displayResultsTable(scores, studentTotals, studentAverages, positions);
displaySubjectSummaries(scores);
displayOverallAnalysis(scores, studentTotals, studentAverages);

def displaySubjectSummaries(scores):
    for subject in range(len(scores[0])):
        stats = calculateSubjectStatistics(scores, subject);
        print("\nSubject Summary:");
        print(f"\nSubject {subject + 1}");
        print(f"Highest scoring student is: Student {stats[2] + 1} Scoring {stats[0]}");
        print(f"Lowest scoring student is: Student {stats[3] + 1} Scoring {stats[1]}");
        print(f"Total Score is: {stats[5]}");      
        print(f"Number of passes: {stats[4]}");
        print(f"Number of Fails: {len(scores) - stats[4]}");


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
