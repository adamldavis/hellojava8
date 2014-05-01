
import java.util.stream.Stream;
import java.math.*;

/**
 * Implements tail-call using Java 8 Stream.
 * 
 * @author adavis
 */
@FunctionalInterface
public interface Tail<T> {
    
    Tail<T> apply();
    
    default boolean isDone() {
        return false;
    }
    
    default T result() {
        throw new UnsupportedOperationException("Not done yet.");
    }
    
    default T invoke() {
        return Stream.iterate(this, Tail::apply)
                .filter(Tail::isDone)
                .findFirst()
                .get()
                .result();
    }
    
    static <T> Tail<T> done(final T value) {
        return new Tail<T>() {
            @Override
            public T result() {
                return value;
            }  
            @Override
            public boolean isDone() {
                return true;
            }
            @Override
            public Tail<T> apply() {
                throw new UnsupportedOperationException("Not supported.");
            }
        };
    }

    static Long fastFactorial(int n) {
        return fastFactorial(1L, n).invoke();
    }
    static Tail<Long> fastFactorial(Long x, int n) {
        return () -> {
            switch (n) {
                case 1:
                    return Tail.done(x);
                default:
                    return fastFactorial(x * n, n - 1);
            }
        };
    }
    static Long dumbFactorial(int n) {
        return dumbFactorial(1L, n);
    }
    static Long dumbFactorial(Long x, int n) {
        if (n==1) return x;
        else return dumbFactorial(x * n, n - 1);
    }
    public static void main(String...args) {
        long start = System.currentTimeMillis();
        System.out.println(fastFactorial(42));
        System.out.println(System.currentTimeMillis() - start);
    }
    
}

