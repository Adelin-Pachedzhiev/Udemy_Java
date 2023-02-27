import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";

        Pattern pattert = Pattern.compile("I want a \\w+.");
        Matcher matcher = pattert.matcher(challenge1);
        System.out.println(matcher.matches());

        matcher = pattert.matcher(challenge2);
        System.out.println(matcher.matches());

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[a-g]+"));

        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));

        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^\\w+\\.\\d+$"));

        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("\\w+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);
        while(matcher8.find()){
            System.out.println(matcher8.group(1));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\t";
        Pattern pattern9 = Pattern.compile("\\w+\\.(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);
        while(matcher9.find()){
            System.out.println(matcher9.group(1));
        }

        String challenge10 = "abcd.135uvqz.7tzik.999";
        Pattern pattern10 = Pattern.compile("\\w+\\.(\\d+)");
        Matcher matcher10 = pattern10.matcher(challenge10);
        while(matcher10.find()){
            System.out.println("Start: "+ matcher10.start(1) + " end: " + (matcher10.end(1) - 1));
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern pattern11 = Pattern.compile("[{](\\d), (\\d)[}]");
        Matcher matcher11 = pattern11.matcher(challenge11);
        while(matcher11.find()){
            System.out.println(matcher11.group(1) + " " + matcher11.group(2));
        }

//        12. zip code
        String challenge12 = "11111";
        Pattern pattern12 = Pattern.compile("^\\d{5}$");
        Matcher matcher12 = pattern12.matcher(challenge12);
        while(matcher12.find()){
            System.out.println(matcher12.group(0));
        }

        String challenge13 = "11111-1111";
        Pattern pattern13 = Pattern.compile("^\\d{5}-\\d{4}$");
        Matcher matcher13 = pattern13.matcher(challenge13);
        while(matcher13.find()){
            System.out.println(matcher13.group(0));
        }

        String challenge14 = "11111";
        Pattern pattern14 = Pattern.compile("^\\d{5}(-\\d{4})?$");
        Matcher matcher14 = pattern14.matcher(challenge14);
        while(matcher14.find()){
            System.out.println(matcher14.group(0));
        }


    }
}