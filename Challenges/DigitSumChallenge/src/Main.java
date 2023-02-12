public class Main {
    public static void main(String[] args) {
        System.out.println(sumDigit(125));
        System.out.println(1/10);
    }
    public static int sumDigit(int number){
        if (number < 10){
            return -1;
        }
        int sum = 0;
        while(number != 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}