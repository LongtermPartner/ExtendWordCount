package wcPro;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	private static File outputFile=null;
	private static ArrayList<Entry<String, Integer>> count=null;
	
	public static void main(String[] args) throws IOException{
		
		File file=Input.input(args);
		count=CountAndSort.countAndSort(file);
		Output.output(count,outputFile);
	}
}
