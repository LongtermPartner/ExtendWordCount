package wcPro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.JOptionPane;

public class CountAndSort {
	public  static ArrayList<Entry<String, Integer>> countAndSort(File file) throws IOException {

		TreeMap<String, Integer> hMap=parse(file.getName());
		ArrayList<Map.Entry<String, Integer>> list=sort(hMap);
		return list;
		
	}
	protected static Pattern pattern;
	protected static Matcher matcher;

	//对统计的单词进行词频排序
	public static ArrayList<Map.Entry<String, Integer>> sort(TreeMap<String, Integer> wordsCount){
		// 升序比较器
		Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {

		@Override
		public int compare(Entry<String, Integer> word1, Entry<String, Integer> word2) {
		  //若是词频相同则比较键值大小即String转化成int数值类型
			return word2.getValue()-word1.getValue()==0?getInt(word2.getKey())-getInt(word1.getKey()):word2.getValue()-word1.getValue();
		}
          //将String类型转化成数值类型
		private int getInt(String key) {
			
			int integer=0;
			try{
			pattern=Pattern.compile("^\\d+");
			 matcher=pattern.matcher(key);
			if(matcher.find()){
				integer=Integer.valueOf(matcher.group());
			}
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
			return integer;
		}
		};
		
		// map转换成list进行排序
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(wordsCount.entrySet());
		// 排序
		Collections.sort(list,valueComparator);
		return list;
	}



}
