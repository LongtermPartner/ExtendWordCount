package wcPro;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.ldap.SortControl;
import javax.swing.JOptionPane;
import javax.xml.bind.ParseConversionEvent;

public class CountAndSort {
	
	public  static ArrayList<Entry<String, Integer>> countAndSort(File file) throws IOException {

		TreeMap<String, Integer> hMap=parse(file.getName());
		ArrayList<Map.Entry<String, Integer>> list=Sort(hMap);
		
		return list;
		
	}
	

		
		//对统计的单词进行词频排序
		public static ArrayList<Map.Entry<String, Integer>> Sort(TreeMap<String, Integer> wordsCount){
			// 升序比较器
			Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			
				return o2.getValue()-o1.getValue()==0?getInt(o2.getKey())-getInt(o1.getKey()):o2.getValue()-o1.getValue();
			}

			private int getInt(String key) {
				
				int i=0;
				try{
				Pattern pattern=Pattern.compile("^\\d+");
				Matcher matcher=pattern.matcher(key);
				if(matcher.find()){
					i=Integer.valueOf(matcher.group());
				}
				}catch(NumberFormatException e){
					e.printStackTrace();
				}
				return i;
			}
			};
			
			
			// map转换成list进行排序
			ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(wordsCount.entrySet());
			// 排序
			Collections.sort(list,valueComparator);

			return list;
		}

}
