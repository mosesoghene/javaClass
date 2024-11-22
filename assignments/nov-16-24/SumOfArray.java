public class SumOfArray {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 7, 8, 100};
        
        int sum = sum(numbers);        
               
        System.out.println("Total: " + sum);
    }
    
    public static int sum(int[] numbers){
      int sum = 0;
        
        for (int number : numbers) {
            sum += number;
        }
        
        return sum;
    }
}
