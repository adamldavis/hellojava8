
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class Grouping {

    public static class Dragon {
        Dragon(String name) {this.name = name;}
        String name;
        public String getName() {return name; }
        public String toString() {return name; }
        public boolean isGreen() {return Math.random() > 0.5;}
    }

    public static List<Dragon> getDragons() {
        return Arrays.asList(new Dragon("Smaug"), new Dragon("Norbert"));
    }

    public static void main(String...args) {

        List<Dragon> dragons = getDragons();
        Map<Character,List<Dragon>> map = dragons.stream()
                .collect(groupingBy(dragon -> dragon.getName().charAt(0)));
                
        System.out.println(map);           
        
        Map<Boolean,List<Dragon>> map2 = dragons.stream()
            .collect(partitioningBy(Dragon::isGreen));


        System.out.println(map2);
    }
}
