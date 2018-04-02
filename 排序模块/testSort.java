package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import wcPro.CountAndSort;
import junit.framework.TestCase;

//测试排序模块主要是改变文本内容进而测试排序功能的正确性
public class testSort extends TestCase {

	//调用CountAndSort的Sort排序函数
	//输入参数测试    白盒测试：条件，分支，路径测试       黑盒测试：等价类测试    有效等价类测试，无效等价类测试，边界值分析测试
	
	TreeMap<String, Integer> hMap=new TreeMap<String, Integer>();      //接收输入待排序map数据
	LinkedHashMap<String, Integer> eMap= new LinkedHashMap<String, Integer>();    //有序放入排序后的结果
	ArrayList<Map.Entry<String, Integer>> actual=new ArrayList<Map.Entry<String,Integer>>();  //实际值
	ArrayList<Map.Entry<String, Integer>> expected=null;                     //期望值
	//文本内容为空 
	public void test1(){
	
		//改变hMap内容
		 actual=CountAndSort.Sort(hMap);
		 expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
		
	}
	//文本内容为一个单词
	public void test2(){
		
		// 改变hMap内容
		hMap.put("a", 1);
		actual = CountAndSort.Sort(hMap);
		eMap.put("a", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
		
		
	}
	
	//文本含多个单词
	   //相同频度
		 //单词字母个数
	        //单词是否含有特殊-字符
	         //单词不重复
	
	// 测简单单词  仅由单个字母组成
	// a   1
	// b   1 
	public void test3(){
		// 改变hMap内容
		hMap.put("a", 1);
		hMap.put("b",1);
		actual = CountAndSort.Sort(hMap);
		eMap.put("a", 1);
		eMap.put("b",1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
	}
	//测试有-和字母
	public void test4(){
		// 改变hMap内容
		hMap.put("a", 1);
		hMap.put("-",1);
		actual = CountAndSort.Sort(hMap);
		eMap.put("-",1);
		eMap.put("a", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
		
	}
	//测试排序与put()放进的顺序关系
		public void test5(){
			// 改变hMap内容
			hMap.put("aa", 1);
			hMap.put("ab",1);
			actual = CountAndSort.Sort(hMap);
			eMap.put("aa", 1);
			eMap.put("ab",1);
			expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
			assertEquals(expected, actual);
			
		}
		//交换单词放进顺序
		public void test6(){
			// 改变hMap内容
			hMap.put("ab", 1);
			hMap.put("aa", 1);
			actual = CountAndSort.Sort(hMap);
			eMap.put("aa", 1);
			eMap.put("ab", 1);
			expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
			assertEquals(expected, actual);

		}
	//测试有字母和-组成的单词
	public void test7(){
		// 改变hMap内容
		hMap.put("ab", 1);
		hMap.put("a-b", 1);
		actual = CountAndSort.Sort(hMap);
		eMap.put("a-b", 1);
		eMap.put("ab", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
					
	}
	// 测试含有相同单词词频相同排序
	public void test8() {
		// 改变hMap内容
		hMap.put("aa", 1);
		hMap.put("aa", 1);
		actual = CountAndSort.Sort(hMap);
		eMap.put("aa", 1);
		eMap.put("aa", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);

	}
	
	//词频不同
	
	public void test9(){
		// 改变hMap内容
		hMap.put("a", 1);
		hMap.put("b", 2);
		actual = CountAndSort.Sort(hMap);
		eMap.put("b", 2);
		eMap.put("a", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
					
	}
	//测试排序与put()放进的顺序关系
		public void test10(){
			// 改变hMap内容
		hMap.put("aa", 1);
		hMap.put("ab", 2);
		actual = CountAndSort.Sort(hMap);
		eMap.put("ab", 2);
		eMap.put("aa", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
						
		}
		//交换单词放进顺序
		public void test11(){
			hMap.put("ab", 2);
			hMap.put("aa", 1);
			actual = CountAndSort.Sort(hMap);
			eMap.put("ab", 2);
			eMap.put("aa", 1);
			expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
			assertEquals(expected, actual);
							
		}
	//测试有字母和-组成的单词
	public void test12(){
		hMap.put("ab", 1);
		hMap.put("a-b", 2);
		actual = CountAndSort.Sort(hMap);
		eMap.put("a-b", 2);
		eMap.put("ab", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
						
	}
	
	
	//测试含有不同单词词频不同排序
	public void test13() {
		hMap.put("aa", 1);
		hMap.put("-aa", 2);
		actual = CountAndSort.Sort(hMap);
		eMap.put("-aa", 2);
		eMap.put("aa", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
						
	}
	//含有不同单词词频相同
	public void test14() {
		TreeMap<String, Integer> hMap = new TreeMap<String, Integer>();
		// 改变hMap内容
		hMap.put("aa", 2);
		hMap.put("-aa", 2);
		actual = CountAndSort.Sort(hMap);
		eMap.put("-aa", 2);
		eMap.put("aa", 2);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);

	}
	//测试多个单词
	public void test15() {
		hMap.put("this", 2);
		hMap.put("word", 1);
		hMap.put("hello", 3);
		actual = CountAndSort.Sort(hMap);
		eMap.put("hello", 3);
		eMap.put("this", 2);
		eMap.put("word", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
						
	}

	// 测试频度较大时
	public void test16() {
		// 改变hMap内容
		hMap.put("this", 2000);
		hMap.put("word", 100);
		hMap.put("hello", 3358);
		actual = CountAndSort.Sort(hMap);
		eMap.put("hello", 3358);
		eMap.put("this", 2000);
		eMap.put("word", 100);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
		
	}

	// 测试多个单词且频度大时
	public void test17() {
		TreeMap<String, Integer> hMap = new TreeMap<String, Integer>();
		// 改变hMap内容
		hMap.put("this", 2225);
		hMap.put("word", 100);
		hMap.put("hello", 3999);
		hMap.put("map", 2225);
		hMap.put("test", 100);
		hMap.put("heal", 3999);
		actual = CountAndSort.Sort(hMap);
		eMap.put("heal", 3999);
		eMap.put("hello", 3999);
		eMap.put("map", 2225);
		eMap.put("this", 2225);
		eMap.put("test", 100);
		eMap.put("word", 100);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);

	}

	// 测试多个单词且单词含有特殊字符
	public void test18() {
		TreeMap<String, Integer> hMap = new TreeMap<String, Integer>();
		// 改变hMap内容
		hMap.put("this-", 2);
		hMap.put("word-test", 1);
		hMap.put("#hello", 3);
		actual = CountAndSort.Sort(hMap);
		eMap.put("#hello", 3);
		eMap.put("this-", 2);
		eMap.put("word-test", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);

	}

	// 测试多个单词含有字母数字
	public void test19() {
		TreeMap<String, Integer> hMap = new TreeMap<String, Integer>();
		// 改变hMap内容
		hMap.put("this1", 2);
		hMap.put("1word1", 1);
		hMap.put("hello2", 3);
		actual = CountAndSort.Sort(hMap);
		eMap.put("hello2", 3);
		eMap.put("this1", 2);
		eMap.put("1word1", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);

	}

	//综合测试   测试多个单词含有各种特殊字符数字且词频跨度大
	public void test20() {
		TreeMap<String, Integer> hMap = new TreeMap<String, Integer>();
		// 改变hMap内容
		hMap.put("this-world", 20);
		hMap.put("word-", 1);
		hMap.put("-hello", 3);
		hMap.put("thisworld", 200);
		hMap.put("1word-", 5551);
		hMap.put("-hello1", 113);
		actual = CountAndSort.Sort(hMap);
		eMap.put("1word-", 5551);
		eMap.put("thisworld", 200);
		eMap.put("-hello1", 113);
		eMap.put("this-world", 20);
		eMap.put("-hello", 3);
		eMap.put("word-", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
		
	}

}
