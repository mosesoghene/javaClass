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


def displayOverallAnalysis(scores, totals, averages) {
    subjectPasses = calculateSubjectPasses(scores);
    overallStats = calculateOverallHighestLowest(scores);
    subjectDifficulty = findSubjectDifficulty(subjectPasses, scores.length);
    bestWorst = findBestAndWorstStudents(averages);
    totalClassScore = calculateTotalClassScore(totals);

    print("\nOverall Class Summary:");


    print(f"Hardest Subject is Subject {subjectDifficulty[0] + 1} with {scores.length - subjectPasses[subjectDifficulty[0]]} failures");
    print(f"Easiest Subject is Subject {subjectDifficulty[1] + 1} with {subjectPasses[subjectDifficulty[1]]} Passes");


    print(f"Overall Highest Score is scored by Student {overallStats[2] + 1} in Subject {overallStats[4] + 1} scoring {overallStats[0]}");
    print(f"Overall Lowest Score is Student {overallStats[3] + 1} in Subject {overallStats[5] + 1} scoring {overallStats[1]}");        
    print("<<================================================================================>>");
    print();
    print("CLASS SUMMARY");
    print("<<================================================================================>>");

    print(f"Best Graduating Student is: Student {bestWorst[0] + 1}  with an average: {averages[bestWorst[0]]:.2f}");
    print("<<================================================================================>>");
    print();
    print("<<================================================================================>>");
    print(f"Worst Graduating Student is: Student {bestWorst[1] + 1}  with an average: {averages[bestWorst[1]]:.2f}");
    print("<<================================================================================>>");

    print();
    print("<<================================================================================>>");
    classAverage = (double) totalClassScore / (scores.length * scores[0].length);
    print(f"Class Total is: {totalClassScore}");
    print(f"Class Average Score is: {classAverage:.2f}", );
    print("<<================================================================================>>");
    }



studentNumber = int(input("How many students do you have?\n"));
subjectNumber = int(input("How many subjects do they offer?\n"));

scores = collectAllScores(studentNumber, subjectNumber);   
studentTotals = calculateTotals(scores);
studentAverages = calculateAverages(studentTotals, subjectNumber);
positions = calculateStudentPositions(studentTotals);
displayResultsTable(scores, studentTotals, studentAverages, positions);
displaySubjectSummaries(scores);
displayOverallAnalysis(scores, studentTotals, studentAverages);


