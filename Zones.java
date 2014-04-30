import java.time.*;
import java.util.*;

public class Zones {

    public static void main(String...args) {
        ZoneId zone = ZoneId.of("America/Denver");
        System.out.println( zone );
        System.out.println( ZoneId.systemDefault() );
        
        Date date = new Date();
        Instant now = date.toInstant();
        System.out.println( now );
        
        System.out.println( "Denver:" + LocalDateTime.ofInstant(now, zone) );
        System.out.println( "Here:" + LocalDateTime.ofInstant(now, ZoneId.systemDefault()) );

        System.out.println(ZoneId.getAvailableZoneIds() );        
        
    }
}

