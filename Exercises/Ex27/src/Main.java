import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        inputThenPrintSumAndAverage();
    }

//    Write a method called inputThenPrintSumAndAverage that does not have any parameters.
//    The method should not return anything (void) and it needs to keep reading int numbers from the keyboard.
//    When the user enters something that is not an int then it needs to print a message in the format "SUM = XX AVG = YY".
//    XX represents the sum of all entered numbers of type int.
//    YY represents the calculated average of all numbers of type long.

    public static void inputThenPrintSumAndAverage(){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        while(true){
            boolean isInt = sc.hasNextInt();
            if (isInt){
                sum+= sc.nextInt();
                count++;
            } else {
                break;
            }
            sc.nextLine();
        }
        sc.close();
        System.out.println("SUM = " + sum + " AVG = " + Math.round((double)sum/(double)count));
    }
}