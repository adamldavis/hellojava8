import java.io.*;
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
	}
}
