import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;


public class TailTest {

	@Test
	public void streamFactorial_should_work_with_1() {
		assertEquals(BigInteger.valueOf(1), Tail.streamFactorial(1));
	}

	@Test
	public void streamFactorial_should_work_with_2() {
		assertEquals(BigInteger.valueOf(2), Tail.streamFactorial(2));
	}

	@Test
	public void streamFactorial_should_work_with_3() {
		assertEquals(BigInteger.valueOf(6), Tail.streamFactorial(3));
	}
	
	@Test
	public void stackFactorial_should_work_with_1() {
		assertEquals(BigInteger.valueOf(1), Tail.stackFactorial(1));
	}

	@Test
	public void stackFactorial_should_work_with_2() {
		assertEquals(BigInteger.valueOf(2), Tail.stackFactorial(2));
	}

	@Test
	public void stackFactorial_should_work_with_3() {
		assertEquals(BigInteger.valueOf(6), Tail.stackFactorial(3));
	}
	
	@Test
	public void should_have_equal_factorials_of_555() {
		assertEquals(Tail.streamFactorial(555), Tail.stackFactorial(555));
	}

	@Test
	public void should_have_equal_factorials_of_1234() {
		assertEquals(Tail.streamFactorial(1234), Tail.stackFactorial(1234));
	}

	@Test(expected=StackOverflowError.class)
	public void should_throw_stack_overflow() {
		Tail.stackFactorial(56789);
	}
	
	@Test
	public void should_not_throw_stack_overflow() {
		Tail.streamFactorial(56789);
	}

}
