public class Main {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(27));
    }

//    Write a method named isPerfectNumber with one parameter of type int named number.
//    If number is < 1, the method should return false.
//    The method must calculate if the number is perfect. If the number is perfect, the method should return true; otherwise, it should return false.

    public static boolean isPerfectNumber(int num){
        if(num < 1){
            return false;
        }
        int deviderSum = 0;
        for (int i= 1; i < num; i++){
            if (num % i == 0){
                deviderSum += i;
            }
        }
        return deviderSum == num;
    }
}