public class Main {
    public static void main(String[] args) {

    }
    public static boolean shouldWakeUp(boolean barking, int timeOfDay){
        return barking && ((timeOfDay >= 0 && timeOfDay < 8) || (timeOfDay == 23));
    }

}