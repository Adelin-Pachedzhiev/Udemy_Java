import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        1
        Runnable runnable = () ->{
          String myString = "Lets split this up into an array";
          String[] parts = myString.split(" ");
          Arrays.stream(parts).forEach(System.out::println);
        };
        new Thread((runnable)).start();

//        2
        Function<String, String> function= (String source) -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i<source.length(); i++){
                if(i%2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondCharacter("1234567890", function));

//        3
        Supplier<String> iLoveJava = () -> "I love Java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

//        4
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        System.out.println(topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count());

        System.out.println(topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .count());
    }


    public static String everySecondCharacter(String str, Function<String, String> function){
        return function.apply(str);
    }
}