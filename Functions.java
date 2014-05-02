import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

import java.time.*;


public class Functions {

    public static void main(String...args) {
    
        Function<Integer,String> f = Function.<Integer>identity()
            .andThen(i -> 2*i).andThen(i -> "str" + i);
        
        System.out.println(
            Stream.iterate(1, i -> i + 1)
                .limit(10)
                .map(f)
                .collect(joining(","))
        );
        
        
        Function<LocalDate,LocalDateTime> plusTwoM = Function.<LocalDate>identity()
            .andThen(dateTimeFunction(d -> d.plusMonths(2)));
        
        System.out.println(
            Stream.iterate(LocalDate.now(), d -> d.plusDays(1))
                .limit(10)
                .map(plusTwoM)
                .map(Object::toString)
                .collect(joining(", "))
        );
    }
    
    public static Function<LocalDate,LocalDateTime> dateTimeFunction(
        final Function<LocalDate,LocalDate> f) {
        
        return f.andThen(d -> d.atTime(2, 2));
    }
}
