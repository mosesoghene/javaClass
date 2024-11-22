public class Operators{
  public static void main(String[] args){
  	int a, b, c, d;
  	a = 2; b = 3; c = 4; d = 5;
    if (!(a > b && a > c || b < c & b < d | b < c) ^ b < c){
    	System.out.println("Evaluation True");
    }else {
      System.out.println("Evaluation False");
    }
  }
}
