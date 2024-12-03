student_number = int(input("How many students do you have? \n"))
subject_number = int(input("How many Subjects do they offer? \n"))

def collect_scores(student_number, subject_number):
    student_scores = []
    
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
    
    
def get_total_score_of(student_scores):
    return max(student_scores)

def get_average_score_of(student_scores):
    return sum(student_scores) / len(student_scores)

def get_all_student_totals(scores_db):
    all_student_total_scores = []
    for i in range(1, len(scores_db) + 1):    
        all_student_total_scores.append(max(scores_db[i-1].get(i)))
        
    return all_student_total_scores

scores_db = collect_scores(student_number, subject_number)
print(get_all_student_totals(scores_db))
    
