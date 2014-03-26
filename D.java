import static java.util.stream.Collectors.*;
import java.util.Arrays;

public class D {

    public static void main(String...ags) {
        double[] dd = {1.0,2.0,3.0};

        System.out.println(
            Arrays.stream(dd).max().getAsDouble()
        );
        System.out.println(
            Arrays.stream(dd).average().getAsDouble()
        );
    }
}
