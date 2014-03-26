import static java.lang.System.out;
import java.util.function.*;


public class Func {


	static Function<String, String> f = (name) -> {return name + "-";};
	static Function<String, Integer> leng = (name) -> {return name.length();};
	static Function<String, Integer> leng2 = String::length;
	//static Supplier<Func> ff = ()-> new Func();

	public String name() { return "foo"; }
	
	public static void main(String ... args) {
	    String[] strs = {"foo", "bar", "bash" };

		for (String s : strs) out.println(leng.apply(s));
		//for (String s : strs) out.println(leng2.apply(s));

		Function<Func, String> name = Func::name;

		out.println(name.apply(new Func()));
	}

}

