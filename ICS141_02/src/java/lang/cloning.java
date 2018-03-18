package java.lang;

import java.util.ArrayList;

public class cloning{
	public static void main(String[] args) {
		ArrayList<String> names=new ArrayList<>();
		names.add("Ian");
		names.add("Gormley");
	
	@SuppressWarnings({ "unchecked", "unused" })
	ArrayList<String> myNames=(ArrayList<String>)names.clone();
	
	
}
}