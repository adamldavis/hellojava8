import java.util.*;

public class Lists {
public static void main(String ... args) {
	List<String> list = new LinkedList<>();

	list.add("Smaug");
	list.add("Gilda");

	System.out.println(list);

	final StringBuilder userNames = new StringBuilder("(");

		for (String value : list) {
			if (userNames.length() > 1) {
				userNames.append(", ");
			}
			userNames.append('\'').append(value).append('\'');
		}
		userNames.append(')');
	System.out.println(userNames);
}
}//END
