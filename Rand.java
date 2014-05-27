import java.util.Random;

public class Rand {

    public static void main(String...args) {
        Random rnd = new Random();
        rnd.ints().limit(10)
            .sorted()
            .forEach(System.out::println);
    }
}
