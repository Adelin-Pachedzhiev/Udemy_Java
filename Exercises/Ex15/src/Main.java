public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-13331));
    }
    public static boolean isPalindrome(int number){
        int numberCopy = Math.abs(number);
        int reverseNum = 0;
        while(numberCopy > 0) {
            reverseNum *= 10;
            reverseNum += numberCopy % 10;
            numberCopy /= 10;
        }
        return Math.abs(number) == reverseNum;
    }
}