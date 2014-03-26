import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Compares Java 7 code to Java 8 equivalent.
 *
 * @author adavis
 */
public class Compare {
    
    public String toString() {
        return "Hello!";
    }
    
    public Runnable makeRunnable() {
        // Java 7
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Compare.this.toString());
            }
        };
        // Java 8
        Runnable r8 = () -> System.out.println(toString());

        return r8;
    }

    public ActionListener makeListener() {
        // Java 7
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
            }
        };
        // Java 8
        ActionListener al8 = e -> System.out.println(e.getActionCommand());

        return al8;
    }

    public List<String> printStrings(List<String> list) {
        // Java 7
        for (String s : list) {
            System.out.println(s);
        }
        //Java 8
        list.forEach(System.out::println);

        return list;
    }
    
    public List<String> sortStrings(List<String> list) {
        // Java 7
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        //Java 8
        Collections.sort(list, (s1, s2) -> s1.length() - s2.length());
        // or
        list.sort(Comparator.comparingInt(String::length));

        return list;
    }

    public double max(List<Double> list) {
        assert list.size() > 0;
        // Java 7
        double max = 0;

        for (Double d : list) {
            if (d > max) {
                max = d;
            }
        }
        //Java 8
        max = list.stream().reduce(0.0, Math::max);
        // or
        max = list.stream().mapToDouble(Number::doubleValue).max().getAsDouble();

        return max;
    }

    public double average(List<Double> list) {
        assert list.size() > 0;
        double total = 0;
        double ave = 0;
        // Java 7
        for (Double d : list) {
            total += d;
        }
        ave = total / ((double) list.size());
        //Java 8
        ave = list.stream().mapToDouble(Number::doubleValue).average().getAsDouble();

        return ave;
    }
    
    public void print1to10() {
        // Java 7
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
        // Java 8
        IntStream.range(1, 11)
                .forEach(System.out::println);
        //or
        Stream.iterate(1, i -> i+1).limit(10)
                .forEach(System.out::println);
    }

    public static class Person {

        String firstName;
        String lastName;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

    public List<Person> sortPeople(List<Person> list) {
        // Java 7
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int n = p1.getLastName().compareTo(p2.getLastName());
                if (n == 0) {
                    return p1.getFirstName().compareTo(p2.getFirstName());
                }
                return n;
            }
        });
        //Java 8
        list.sort(Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName));

        return list;
    }
    
    public static void main(String ... args) {
        Compare c = new Compare();
        
        c.makeRunnable().run();
        System.out.println("---------------");
//        List<String> list = Arrays.asList("foo", "bar", "bash", "bo");
//        c.sortStrings(list);
//        c.printStrings(list);
//        System.out.println("---------------");
//        c.print1to10();
//        System.out.println(c.max(Arrays.asList(0.1, 0.2, 0.21)));
//        System.out.println(c.average(Arrays.asList(0.1, 0.2, 0.21)));
    }

}
