import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        printArray(sortArray(getIntegers(6)));
    }

    public static int[] getIntegers(int num) {
        int[] array = new int[num];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter values of the array \r");
        for (int i = 0; i < num; i++) {
            System.out.println("Enter element #" + i + "\r");
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortArray(int[] array) {
        int[] sortedArray = array.clone();
        for (int i = 0; i < sortedArray.length; i++) {
            int maxIndex = i;
            for (int y = i; y < sortedArray.length; y++) {
                if (sortedArray[y] > sortedArray[maxIndex]){
                    maxIndex = y;
                }
            }
            int temp = sortedArray[i];
            sortedArray[i] = sortedArray[maxIndex];
            sortedArray[maxIndex] = temp;
        }
        return sortedArray;
    }
}