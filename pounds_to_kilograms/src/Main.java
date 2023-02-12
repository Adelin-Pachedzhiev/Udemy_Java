import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double weightLB = 10;
        double result = weightLB / 2.2;
        Scanner scanner = new Scanner(System.in);

        boolean a = scanner.nextBoolean();
        if (a){
            System.out.println(result);
        }

    }
}