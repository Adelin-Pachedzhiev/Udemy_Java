public class Main {
    public static void main(String[] args) {

        printYearsAndDays(0);
    }
    public static void printYearsAndDays(long minutes){
        if (minutes < 0 ){
            System.out.println("Invalid Value");
            return;
        }
        long days = minutes/(60*24);
        System.out.println(minutes + " min = "+ days/365 +" y and "+days%365+ " d");
    }
}