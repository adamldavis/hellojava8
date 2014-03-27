import static java.lang.System.out;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

// kudos to https://github.com/bbejeck
public class ThreeTen {

    private static LocalDate today = LocalDate.of(2014, 3, 27);
    
    public static void main(String...args) {
        out.println("today=" + today);
        out.println("month=" + today.getMonth());
        out.println("year=" + today.getYear());
        
        LocalDate thirtyDaysFromNow = today.plusDays(30);
        out.println(thirtyDaysFromNow);
        
        out.println("today still=" + today);

        LocalDate nextMonth = today.plusMonths(1);
        out.println(nextMonth);

        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        out.println(nextWeek);
        
        LocalDate easter = LocalDate.of(2014, 4, 20);
        out.println("easter=" + easter);
/*        
        Period twoMonths = Period.ofMonths(2);
        out.println("2months=" + twoMonths);
        
        out.println("2months from now=" + today.plus(twoMonths));
        //*/
/*        
        Period timeUntilEaster = today.until(easter);
        out.println("timeUntilEaster=" + timeUntilEaster);
        out.println("timeUntilEaster=" + timeUntilEaster.getDays() + " days");
        
        out.println("today - timeUntilEaster = " + today.minus(timeUntilEaster));
        
        LocalDateTime ldt = today.atTime(6,45,0);
        out.println("time=" + ldt);
        //*/
    }
}
