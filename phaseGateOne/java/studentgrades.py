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


def displayResultsTable(scores, totals, averages, positions):
    print("\nClass Score Summary:");
    print("<<================================================================================>>");
    print("| STUDENT   ", end="");
    for i in range(1, len(scores[0])):
      print(f"| SUB{i:>2}", end="");

    print(f"| TOT | AVE | POS |");
    
    print("<<================================================================================>>");
    
    for i in range(len(scores)):
      print(f"| Student {i + 1} ", end="");
      for j in range(len(scores[i])):
        print(f"| {scores[i][j]} ", end="");
      
      print(f"| {totals[i]} | {averages[i]:.2f} | {positions[i]} |");
        
    print("<<================================================================================>>");
    
    print("<<================================================================================>>");
  
