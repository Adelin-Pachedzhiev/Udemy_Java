public class Main {
    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(123,21,423));
    }

//    Write a method named hasSameLastDigit with three parameters of type int.
//    Each number should be within the range of 10 (inclusive) - 1000 (inclusive). If one of the numbers is not within the range, the method should return false.
//    The method should return true if at least two of the numbers share the same rightmost digit; otherwise, it should return false.

    public static boolean isValid(int number){
        return number >= 10 && number <= 1000;
    }
    public static boolean hasSameLastDigit(int num1, int num2, int num3){
        if(!isValid(num1) || !isValid(num2) || !isValid(num3) ){
            return false;
        }
        int num1LastDigit = num1 % 10;
        int num2LastDigit = num2 % 10;
        int num3LastDigit = num3 % 10;
        return num1LastDigit == num2LastDigit || num2LastDigit == num3LastDigit || num3LastDigit == num1LastDigit;
    }
}