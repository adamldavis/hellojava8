import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Streams {

    public static void write(FileWriter fw, String s) {
        try {fw.write(s); }
        catch (IOException e) {e.printStackTrace(); }
    }
        

    public static void main(String...args) throws IOException {
        try (FileWriter fw = new FileWriter("file")) {
            Stream.of("hello\n", "file\n").forEach(s -> write(fw, s));
        }
        try (FileReader fr = new FileReader("file");
            BufferedReader br = new BufferedReader(fr)) {
            br.lines().forEach(System.out::println);
        }
    }
}
