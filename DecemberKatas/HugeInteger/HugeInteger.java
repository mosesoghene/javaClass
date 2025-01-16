package HugeInteger;

import java.math.BigInteger;
import java.util.ArrayList;

public class HugeInteger {
    private final ArrayList<Integer> numbers = new ArrayList<>();

//  Constructor to create and object of the class HugeInteger for use
    public HugeInteger(String numbers) {
        parse(numbers);
    }

//    Takes the numbers of type String, converts to Integer(int) type and saves in arrayList of Integer
    public void parse(String numbers) {
       if (numbers.length() > 40 ) {
           throw new IllegalArgumentException("HugeInteger: Number is too large");
       } else {
           for (Character character : numbers.toCharArray()) {
               this.numbers.add(character - '0');
           }
       }
    }

//    Overrides the String class's .toString() method to convert our ArrayList of integers to string and returns the string
    @Override
    public String toString() {
//        String numbersToString = "";
//        for (Integer number : this.numbers) {
//            numbersToString += number;
//        }
//        return numbersToString;

        StringBuilder numbersToString = new StringBuilder();
        for (Integer number : this.numbers) {
            numbersToString.append(number);
        }
        return numbersToString.toString();
    }

    private BigInteger getValue() {
        return new BigInteger(toString());
    }

    public void add(HugeInteger other) {
        BigInteger total = this.getValue().add(other.getValue());
        this.numbers.clear();
        String numbers = total.toString();
        parse(numbers);
    }

    public void subtract(HugeInteger other) {
        BigInteger total = this.getValue().subtract(other.getValue());
        this.numbers.clear();
        String numbers = total.toString();
        parse(numbers);
    }

    public void multiply(HugeInteger other) {
        BigInteger total = this.getValue().multiply(other.getValue());
        this.numbers.clear();
        String numbers = total.toString();
        parse(numbers);
    }

    public void divide(HugeInteger other) {
        BigInteger total = this.getValue().divide(other.getValue());
        this.numbers.clear();
        String numbers = total.toString();
        parse(numbers);
    }
    
    public void modulus(HugeInteger other) {
        BigInteger total = this.getValue().mod(other.getValue());
        this.numbers.clear();
        String numbers = total.toString();
        parse(numbers);
    }

    public boolean isEqualTo(HugeInteger other) {
        return this.toString().equals(other.toString());
    }

    public boolean isNotEqualTo(HugeInteger other) {
        return !(this.toString().equals(other.toString()));
    }

    public boolean isGreaterThan(HugeInteger other) {
        return this.toString().compareTo(other.toString()) > 0;
//        return getValue() > Integer.parseInt(other.toString());
    }
    
    public boolean isLessThan(HugeInteger other) {
        return this.toString().compareTo(other.toString()) < 0;
//        return getValue() < Integer.parseInt(other.toString());
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger other) {
        return this.toString().compareTo(other.toString()) >= 0;
//        return getValue() >= Integer.parseInt(other.toString());
    }

    public boolean isLessThanOrEqualTo(HugeInteger other) {
        return this.toString().compareTo(other.toString()) <= 0;
//        return getValue() <= Integer.parseInt(other.toString());
    }

    public static void main(String[] args) {
        HugeInteger h = new HugeInteger("12");
//        h.parse("12");
        System.out.println(h);

        System.out.println(h.isEqualTo(new HugeInteger("12")));
        System.out.println(h.isNotEqualTo(new HugeInteger("12")));
        System.out.println(h.isGreaterThan(new HugeInteger("12")));
        System.out.println(h.isLessThan(new HugeInteger("12")));
        System.out.println(h.isGreaterThanOrEqualTo(new HugeInteger("12")));
        System.out.println(h.isLessThanOrEqualTo(new HugeInteger("12")));
        System.out.println(h.isGreaterThanOrEqualTo(new HugeInteger("13")));
        System.out.println(h.isLessThanOrEqualTo(new HugeInteger("13")));
//
        h.add(new HugeInteger("12"));
        System.out.println(h);
//
        h.subtract(new HugeInteger("5"));
        System.out.println(h);
//
        h.multiply(new HugeInteger("2"));
        System.out.println(h);
//
        h.divide(new HugeInteger("2"));
        System.out.println(h);
//
        h.modulus(new HugeInteger("2"));
        System.out.println(h);
//
        h.add(new HugeInteger("111202122"));
        h.multiply(new HugeInteger("19"));
//
        System.out.println(h);
    }
}
