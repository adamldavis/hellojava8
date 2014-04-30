import java.time.*;
import static java.time.temporal.TemporalAdjusters.*;

public class Temporal {

    public static void main(String...args) {
    
        LocalDate nextTuesday = LocalDate.now().with(next(DayOfWeek.TUESDAY));
        
        System.out.println(nextTuesday);
        
    }
}
