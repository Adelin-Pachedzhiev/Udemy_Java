/*
    Only add/edit code where it is stated in the description.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static Map<String, String> vocabulary = new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        command();

    }

    public static void command() {
        vocabulary.put("quit", "Q");
        vocabulary.put("south", "S");
        vocabulary.put("east", "E");
        vocabulary.put("north", "N");
        vocabulary.put("west", "W");

        int currLocation = 1;
        while (true) {
            System.out.println(locations.get(currLocation).getDescription());

            if (currLocation == 0) {
                break;
            }


            Map<String, Integer> exits = locations.get(currLocation).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            String command = sc.nextLine().toLowerCase();
            boolean isFound = false;
            if (command.length() > 1) {
                for (String com : command.split(" ")) {
                    if (vocabulary.containsKey(com)) {
                        isFound = true;
                        currLocation = exits.get(vocabulary.get(com));
                        break;
                    }

                }
            }
            if (exits.containsKey(command.toUpperCase())) {
                currLocation = exits.get(command.toUpperCase());
                isFound = true;
            }

            if (!isFound) {
                System.out.println("You cannot go in that direction");
            }
        }


    }
}