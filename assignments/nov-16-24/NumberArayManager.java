public class NumberArayManager {
    public static void main(String[] args) {
        int[] numbers = {83, 45, 45, 16, 16, 24, -24, 78, 94};
        
        int largest = max(numbers);
        int minimum = min(numbers);        
        
        System.out.println("The largest is " + largest + "\nThe minimum is " + minimum);
        
        numberOccurs(numbers);
    }
    
    public static int max(int[] numbers) {
        int largest = numbers[0];
        
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            }
        }
        
        return largest;
    }
    
    public static int min(int[] numbers) {
        int minimum = numbers[0];
        
        for (int number : numbers) {
            if (number < minimum) {
                minimum = number;
            }
        }
        return minimum;
    }
    
    public static void numberOccurs(int[] numbers){
      for (int element = 0; element < numbers.length; element++) {
        int number = numbers[element];
        int occurence = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (number == numbers[index]) {
                occurence += 1;
            }
            
        }
        System.out.println(number + " occured " + occurence + ((occurence > 1) ? "time" : " times"));
      }
    }
}
