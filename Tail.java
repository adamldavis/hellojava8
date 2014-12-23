
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

    static BigInteger streamFactorial(int n) {
        return streamFactorial(BigInteger.ONE, n).invoke();
    }
    static Tail<BigInteger> streamFactorial(BigInteger x, int n) {
        return () -> {
            switch (n) {
                case 1:
                    return Tail.done(x);
                default:
                    return streamFactorial(x.multiply(BigInteger.valueOf(n)), n - 1);
            }
        };
    }
    
    static BigInteger stackFactorial(int n) {
        return stackFactorial(BigInteger.ONE, n);
    }
    static BigInteger stackFactorial(BigInteger x, int n) {
        if (n==1) return x;
        else return stackFactorial(x.multiply(BigInteger.valueOf(n)), n - 1);
    }
    
    public static void main(String...args) {
        long start = System.currentTimeMillis();
        final int num = 55555;
        System.out.println("calculating " + num + "!");
        try {
        	stackFactorial(num);
        	System.out.println("stack: " + (System.currentTimeMillis() - start));
        } catch (StackOverflowError e) {
        	System.err.println(e);
        }
        streamFactorial(num);
        System.out.println("stream: " + (System.currentTimeMillis() - start) + "ms");
    }
    
}

