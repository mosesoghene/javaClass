import java.util.Random;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathQuiz {
    private static final int TOTAL_QUESTIONS = 10;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            runQuiz();
        } catch (Exception e) {
            System.out.println("\nAn error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void runQuiz() {
        int currentQuestion = 1;
        int score = 0;
        int fails = 0;

        System.out.println("\n=== Math Quiz Game ===");
        System.out.println("You will be asked " + TOTAL_QUESTIONS + " questions.");
        System.out.println("Round your answers to 2 decimal places when necessary.");
        System.out.println("====================\n");

        while (currentQuestion <= TOTAL_QUESTIONS) {

            Question question = generateQuestion();


            double correctAnswer = calculateAnswer(question);
            double formattedAnswer = formatNumber(correctAnswer);


            System.out.printf("Question %d: %d %s %d = ",
                    currentQuestion, question.left, question.operator, question.right);

            double userAnswer = getValidInput();
            double formattedUserAnswer = formatNumber(userAnswer);


            if (formattedUserAnswer == formattedAnswer) {
                System.out.println("✓ Correct!");
                score++;
            } else {
                System.out.printf("✗ Incorrect! The answer is %.2f%n", formattedAnswer);
                fails++;
            }

            currentQuestion++;
            System.out.println();
        }


        printResults(score, fails);
    }



    private static Question generateQuestion() {
        int left = random.nextInt(20) + 1;
        int right = random.nextInt(20) + 1;
        String[] operators = {"+", "-", "*", "/"};
        String operator = operators[random.nextInt(operators.length)];

        if (operator.equals("/")) {
            while (right == 0) {
                right = random.nextInt(20) + 1;
            }
            left = right * (random.nextInt(10) + 1);
        }

        return new Question(left, right, operator);
    }

    private static double calculateAnswer(Question q) {
        switch (q.operator) {
            case "+":
                return q.left + q.right;
            case "-":
                return q.left - q.right;
            case "*":
                return q.left * q.right;
            case "/":
                return (double) q.left / q.right;
            default:
                throw new IllegalArgumentException("Invalid operator: " + q.operator);
        }
    }

    private static double getValidInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.print("Please enter a number: ");
                    continue;
                }
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static double formatNumber(double number) {
        BigDecimal bd = new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
        return bd.stripTrailingZeros().doubleValue();
    }

    private static void printResults(int score, int fails) {
        System.out.println("====================");
        System.out.println("Quiz Complete!");
        System.out.println("Correct answers: " + score);
        System.out.println("Incorrect answers: " + fails);
        double percentage = (double) score / TOTAL_QUESTIONS * 100;
        System.out.printf("Final score: %.1f%%%n", percentage);
        System.out.println("====================");
    }

    private static class Question {
        int left;
        int right;
        String operator;

        Question(int left, int right, String operator) {
            this.left = left;
            this.right = right;
            this.operator = operator;
        }
    }
}