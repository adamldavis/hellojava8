import java.nio.file.*;
import java.nio.*;
import java.io.*;
import java.util.stream.*;


public class FilesTest {

    public static void main(String...args) throws IOException {
    
        Path path = Paths.get("Nio.java");
        
        try (Stream st = Files.lines(path)) {
            st.forEach(System.out::println);
        }
    }
}

