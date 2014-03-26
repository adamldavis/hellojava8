import java.util.regex.Pattern;

public class Patt {
    public static void main(String...args) {
        Pattern patt = Pattern.compile("[, ]+");
        patt.splitAsStream("a, b, c")
            .forEach(System.out::println);
    }
}
