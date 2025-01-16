def displaySubjectSummaries(scores):
    for subject in range(len(scores[0])):
        stats = calculateSubjectStatistics(scores, subject)
        print("\nSubject Summary:")
        print(f"\nSubject {subject + 1}")
        print(f"Highest scoring student is: Student {stats[2] + 1} Scoring {stats[0]}")
        print(f"Lowest scoring student is: Student {stats[3] + 1} Scoring {stats[1]}")
        print(f"Total Score is: {stats[5]}")      
        print(f"Number of passes: {stats[4]}")
        print(f"Number of Fails: {len(scores) - stats[4]}")


def displayResultsTable(scores, totals, averages, positions):
    print("\nClass Score Summary:")
    print("<<================================================================================>>")
    print("| STUDENT   ", end="")
    for i in range(1, len(scores[0])):
      print(f"| SUB{i:>2}", end="")

    print(f"| TOT | AVE | POS |")
    
    print("<<================================================================================>>")
    
    for i in range(len(scores)):
      print(f"| Student {i + 1} ", end="")
      for j in range(len(scores[i])):
        print(f"| {scores[i][j]} ", end="")
      
      print(f"| {totals[i]} | {averages[i]:.2f} | {positions[i]} |")
        
    print("<<================================================================================>>")
    
    print("<<================================================================================>>")


def displayOverallAnalysis(scores, totals, averages):
    subjectPasses = calculateSubjectPasses(scores)
    overallStats = calculateOverallHighestLowest(scores)
    subjectDifficulty = findSubjectDifficulty(subjectPasses, len(scores))
    bestWorst = findBestAndWorstStudents(averages)
    totalClassScore = calculateTotalClassScore(totals)

    
    print("<<================================================================================>>")
    print("\nOverall Class Summary:")


    print(f"Hardest Subject is Subject {subjectDifficulty[0] + 1} with {len(scores) - subjectPasses[subjectDifficulty[0]]} failures")
    print(f"Easiest Subject is Subject {subjectDifficulty[1] + 1} with {subjectPasses[subjectDifficulty[1]]} Passes")


    print(f"Overall Highest Score is scored by Student {overallStats[2] + 1} in Subject {overallStats[4] + 1} scoring {overallStats[0]}")
    print(f"Overall Lowest Score is Student {overallStats[3] + 1} in Subject {overallStats[5] + 1} scoring {overallStats[1]}")        
    print("<<================================================================================>>")
    print()
    print("CLASS SUMMARY")
    print("<<================================================================================>>")

    print(f"Best Graduating Student is: Student {bestWorst[0] + 1}  with an average: {averages[bestWorst[0]]:.2f}")
    print("<<================================================================================>>")
    print()
    print("<<================================================================================>>")
    print(f"Worst Graduating Student is: Student {bestWorst[1] + 1}  with an average: {averages[bestWorst[1]]:.2f}")
    print("<<================================================================================>>")

    print()
    print("<<================================================================================>>")
    classAverage = totalClassScore / (len(scores) * len(scores[0]))
    print(f"Class Total is: {totalClassScore}")
    print(f"Class Average Score is: {classAverage:.2f}", )
    print("<<================================================================================>>")
    

def collectAllScores(studentNumber, subjectNumber):
    scores = []
    for i in range(studentNumber):
        scores.append([])
        print(f"\nEntering scores for Student {(i + 1)}" )
        for j in range(subjectNumber):
            scores[i].append(getValidScore(j))
     
    return scores
  
def getValidScore(subject):
    score = -1
    while (score < 0 or score > 100):    
        score = input(f"Enter score for Subject {subject + 1}: ")
        if score.isdigit():
            score = int(score)
            if (score < 0 or score > 100):
                print("Invalid score! Score must be between 0 and 100.")
        else:
            print("Input not a valid number")
      
    return score
  

def calculateSubjectStatistics(scores, subject):
    highest = 0 
    lowest = 100
    highestStudent = 0 
    lowestStudent = 0 
    passes = 0
    totalScore = 0

    for student in range(len(scores)):
      if (scores[student][subject] > highest):
        highest = scores[student][subject]
        highestStudent = student
      
      if (scores[student][subject] < lowest):
        lowest = scores[student][subject]
        lowestStudent = student
      
      if (scores[student][subject] >= 50): passes += 1
      totalScore += scores[student][subject]
    

    return [highest, lowest, highestStudent, lowestStudent, passes, totalScore]

def calculateSubjectPasses(scores):
    subjectPasses = []
    for j in range(len(scores[0])):
        passes = 0
        for i in range(len(scores)):
            if (scores[i][j] >= 50): 
                passes += 1
        subjectPasses.append(passes)
    return subjectPasses

def calculateAverages(totals, numSubjects):
    averages = []
    for i in range(len(totals)):
        averages.append(totals[i] / numSubjects)
    
    return averages
  

def calculateStudentPositions(totals):
    positions = []
    for i in range(len(totals)):
      position = 1
      for j in range(len(totals)):
        if (totals[j] > totals[i]):
          position += 1
      
      positions.append(position)
    
    return positions
 
def calculateTotals(scores):
    totals = []
    for i in range(len(scores)):
        total = 0
        for j in range(len(scores[i])):
            total += scores[i][j]
        totals.append(total)
    
    return totals

def calculateTotalClassScore(totals):
    total_sum = 0
    for total in totals:
      total_sum += total
    
    return total_sum


def calculateOverallHighestLowest(scores):
    highest, lowest = 0, 100
    highestStudent, lowestStudent, highestSubject, lowestSubject = 0, 0, 0, 0
    
    for i in range(len(scores)):
      for j in range(len(scores[i])):
        if (scores[i][j] > highest):
            highest = scores[i][j]
            highestStudent = i
            highestSubject = j
        if (scores[i][j] < lowest):
            lowest = scores[i][j]
            lowestStudent = i
            lowestSubject = j
    
    return [highest, lowest, highestStudent, lowestStudent, highestSubject, lowestSubject]
  
def findBestAndWorstStudents(averages):
    bestStudent, worstStudent = 0, 0
    for i in range(1,len(averages)):
        if (averages[i] > averages[bestStudent]):
            bestStudent = i
        if (averages[i] < averages[worstStudent]):
            worstStudent = i
        
    return [bestStudent, worstStudent]
  
def findSubjectDifficulty(subjectPasses, numStudents):
    hardest, easiest, minPasses, numStudents, maxPasses = 0, 0, 0, 0, 0

    for i in range(len(subjectPasses)):
        if (subjectPasses[i] < minPasses):
            minPasses = subjectPasses[i]
            hardest = i
        if (subjectPasses[i] > maxPasses):
            maxPasses = subjectPasses[i]
            easiest = i        

    return [hardest, easiest]
    


"""
studentNumber = int(input("How many students do you have?\n"))
subjectNumber = int(input("How many subjects do they offer?\n"))

scores = collectAllScores(studentNumber, subjectNumber)   
studentTotals = calculateTotals(scores)
studentAverages = calculateAverages(studentTotals, subjectNumber)
positions = calculateStudentPositions(studentTotals)
displayResultsTable(scores, studentTotals, studentAverages, positions)
displaySubjectSummaries(scores)
displayOverallAnalysis(scores, studentTotals, studentAverages)
"""

