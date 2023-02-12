public class Main {
    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(1234));
    }
//    Write a method named getEvenDigitSum with one parameter of type int called number.
//
//    The method should return the sum of the even digits within the number.
//
//    If the number is negative, the method should return -1 to indicate an invalid value.

    public static int getEvenDigitSum(int number){
        if (number < 0 ){
            return  -1;
        }
        int sum = 0;
        while(number > 0){
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0){
                sum += lastDigit;
            }
            number /= 10;
        }
        return sum;
    }
}