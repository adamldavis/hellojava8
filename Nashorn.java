import java.io.*;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
public class Nashorn {

	public static void main(String... args) throws Throwable {
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("nashorn");

		engine.eval("function p(s) { print(s) }");
		engine.eval("p('Hello Nashorn');");
//		engine.eval(new FileReader("hello.js"));
//		engine.eval(new FileReader("sum2.js"));
//		engine.eval(new FileReader("imports.js"));
/*        Invocable inv = (Invocable) engine;
        inv.invokeFunction("p", "hello");
        JPrinter printer = inv.getInterface(JPrinter.class);
        printer.p("Hello again!");
        //*/
	}
	public static interface JPrinter {
	    void p(String s);
	}
}
