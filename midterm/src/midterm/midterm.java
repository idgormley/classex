package midterm;

import java.util.LinkedList;
import java.util.List;

public class midterm {
//written in the way the specification gives.
	public static List<String> getGreetings(List<String> names) {
		if (names == null) {
			throw new NullPointerException();
		} else {
			List<String> greetings = new LinkedList<>();
			if (names.size() > 0) {
			
				for (String name : names) {
					greetings.add(String.format("Hello, %s!", name));
			}
				// do when looping through arrays and collections. instead of doing
				// for (int i=0; i<names.size();i++){
				// greetings.add(String.format("hello,%s!", names.get(i)));
				// }
			} else {
				greetings.add("Hello, World!");
			}
			return greetings;
		}
	}
}
