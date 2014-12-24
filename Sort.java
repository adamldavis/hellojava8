import static java.lang.System.out;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Tests whether filtering before or after sorting makes a difference.
 * Spoiler-alert: it does.
 * 
 * @author adamd
 */
public class Sort {

	public static long time(Runnable r) {
		long start = System.currentTimeMillis();
		r.run();
		return System.currentTimeMillis() - start;
	}

	// number of random numbers
	public static final int n = 123456;

	// just here to give algorithm something to modify...
	public static int sum = 0;

	public static long[] count = new long[3];

	static final Random rnd = new Random();

	public static void noFilter() {
		Stream.generate(() -> rnd.nextInt()).limit(n).sorted((x, y) -> {
			count[0]++;
			return x > y ? 1 : -1;
		}).forEach(x -> sum += x);
	}

	public static void filteredFirst() {
		Stream.generate(() -> rnd.nextInt()).limit(n).filter(x -> x > 0)
				.sorted((x, y) -> {
					count[1]++;
					return x > y ? 1 : -1;
				}).forEach(x -> sum += x);
	}

	public static void filteredSecond() {
		Stream.generate(() -> rnd.nextInt()).limit(n).sorted((x, y) -> {
			count[2]++;
			return x > y ? 1 : -1;
		}).filter(x -> x > 0).forEach(x -> sum += x);
	}

	public static void main(String... args) {
		Arrays.fill(count, 0);

		long t1 = time(Sort::noFilter);
		long t2 = time(Sort::filteredFirst);
		long t3 = time(Sort::filteredSecond);
		out.println("sum=" + sum); // meaningless
		out.println("t1=" + t1 + " count=" + count[0]);
		out.println("t2=" + t2 + " count=" + count[1]);
		out.println("t3=" + t3 + " count=" + count[2]);
		out.println("t1-t2 = " + ((double) (t1 - t2) / 1000.0) + " sec");
		out.println("t1-t3 = " + ((double) (t1 - t3) / 1000.0) + " sec");
		// time saved is probably negative or zero
		out.println("count diffs =");
		out.println("noFilter - filter1st: " + (count[0] - count[1]));
		out.println("noFilter - filter2nd: " + (count[0] - count[2]));
		// if the diff is small then sorting happened before the filtering.
	}
}
