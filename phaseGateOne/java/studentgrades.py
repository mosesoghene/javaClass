student_scores = []

student_number = int(input("How many students do you have? \n"))
subject_number = int(input("How many Subjects do they offer? \n"))

def collect_scores(student_number, subject_number):
    student_scores []
    
    for student in range(1, student_number + 1):
        student_scores.append({student: []})
        print(f"Entering Scores for student {student}")
        for subject in range(1, subject_number + 1):
            score = int(input(f"Enter score for subject {subject} \n"))
            if score >=0 and score <= 100:
                student_scores[student - 1][student].append(score)
            else:
                subject -= 1
                print("invalid input")
    return student_scores
    
    
for i in student_scores:
    for j in i:
        print(j, i.get(j))
print(student_scores)
