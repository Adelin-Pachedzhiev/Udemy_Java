import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("year");
        int year = sc.nextInt();

        System.out.println("year2");
        int year2 = sc.nextInt();

        System.out.println("name");
        String name = sc.next();

        System.out.println("name2");
        String name2 = sc.nextLine();

        System.out.println(year+ year2 + name + name2);
        printSquareStar(8);
    }

    //    Write a method named printSquareStar with one parameter of type int named number.
//    If number is < 5, the method should print "Invalid Value".
//    The method should print diagonals to generate a rectangular pattern composed of stars (*). This should be accomplished by using loops (see examples below).
    public static void printSquareStar(int num) {
        if (num < 5) {
            System.out.println("Invalid Value");
            return;
        }
        for (int i = 1; i <= num; i++) {
            for (int y = 1; y <= num; y++) {
                if (y == 1 || y == num || i == 1 || i == num || i == y || y == num - i + 1 ) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}