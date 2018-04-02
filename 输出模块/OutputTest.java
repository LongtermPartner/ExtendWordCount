package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Output;

public class OutputTest {

	private ArrayList<Entry<String,Integer>> wordList;
	private TreeMap<String,Integer> map;
	private FileReader fileReader;
	private BufferedReader bReader;
	
	@Before
	public void before() throws FileNotFoundException{
		map=new TreeMap<String,Integer>();
		wordList=new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		fileReader=new FileReader("result.txt");
		bReader=new BufferedReader(fileReader);
	}
	
	@After
	public void after() throws IOException{
		bReader.close();
		fileReader.close();
	}
	
	
	@Test
	public void test1() throws IOException {
		map.put("a",2);
		map.put("b",1);
		//向ArrayList里加数据，将其输出到文件result.txt
		wordList.add(map.ceilingEntry("a"));
		wordList.add(map.ceilingEntry("b"));
		Output.output(wordList, null);
		
		assertEquals("a  2",bReader.readLine());
		assertEquals("b  1",bReader.readLine());
	}

	@Test
	public void test2() throws IOException {
		map.put("how",5);
		map.put("many",3);
		map.put("a",1);
		wordList.add(map.ceilingEntry("how"));
		wordList.add(map.ceilingEntry("many"));
		wordList.add(map.ceilingEntry("a"));
		Output.output(wordList, null);
		
		assertEquals("how  5",bReader.readLine());
		assertEquals("many  3",bReader.readLine());
		assertEquals("a  1",bReader.readLine());
	}
	
	@Test
	public void test3() throws IOException {
		//数据为空时
		Output.output(wordList, null);
		assertEquals(null,bReader.readLine());
	}
	
	@Test
	public void test4() throws IOException {
		map.put("abc",10);
		wordList.add(map.ceilingEntry("abc"));
		Output.output(wordList, null);
		assertEquals("abc  10",bReader.readLine());
	}
	
	@Test
	public void test5() throws IOException {
		map.put("a",5);
		//100个记录
		for(int i=0;i<100;i++){
			wordList.add(map.ceilingEntry("a"));
		}
		Output.output(wordList, null);
		
		for(int j=0;j<100;j++){
			assertEquals("a  5",bReader.readLine());
		}
	}
	
	@Test
	public void test6() throws IOException {
		map.put("a",5);
		//100个记录
		for(int i=0;i<101;i++){
			wordList.add(map.ceilingEntry("a"));
		}
		Output.output(wordList, null);
		
		for(int j=0;j<100;j++){
			assertEquals("a  5",bReader.readLine());
		}
		//只有100行，剩余为空
		assertEquals(null,bReader.readLine());
	}
	
	@Test
	public void test7() throws IOException {
		map.put("a",5);
		//100个记录
		for(int i=0;i<150;i++){
			wordList.add(map.ceilingEntry("a"));
		}
		Output.output(wordList, null);
		
		for(int j=0;j<100;j++){
			assertEquals("a  5",bReader.readLine());
		}
		//只有100行，剩余为空
		assertEquals(null,bReader.readLine());
	}
	
	@Test
	public void test8() throws IOException {
		map.put("dua",1);
		wordList.add(map.ceilingEntry("dua"));
		Output.output(wordList, null);
		assertEquals("dua  1",bReader.readLine());
	}
	
	@Test
	public void test9() throws IOException {
		map.put("ad",5);
		map.put("dw",1);
		map.put("www",1);
		wordList.add(map.ceilingEntry("ad"));
		wordList.add(map.ceilingEntry("dw"));
		wordList.add(map.ceilingEntry("www"));
		Output.output(wordList, null);
		
		assertEquals("ad  5",bReader.readLine());
		assertEquals("dw  1",bReader.readLine());
		assertEquals("www  1",bReader.readLine());
	}
	
	@Test
	public void test10() throws IOException {
		map.put("dwu",4);
		map.put("ww",4);
		wordList.add(map.ceilingEntry("dwu"));
		wordList.add(map.ceilingEntry("ww"));
		Output.output(wordList, null);
		assertEquals("dwu  4",bReader.readLine());
		assertEquals("ww  4",bReader.readLine());
	}
	
	@Test
	public void test11() throws IOException {
		map.put("this",10);
		wordList.add(map.ceilingEntry("this"));
		Output.output(wordList, null);
		assertEquals("this  10",bReader.readLine());
	}
	
	@Test
	public void test12() throws IOException {
		map.put("kuai",1);
		map.put("ui", 1);
		wordList.add(map.ceilingEntry("kuai"));
		wordList.add(map.ceilingEntry("ui"));
		Output.output(wordList, null);
		assertEquals("kuai  1",bReader.readLine());
		assertEquals("ui  1",bReader.readLine());
	}
	
	@Test
	public void test14() throws IOException {
		map.put("too",35);
		map.put("much",20);
		wordList.add(map.ceilingEntry("too"));
		wordList.add(map.ceilingEntry("much"));
		Output.output(wordList, null);
		assertEquals("too  35",bReader.readLine());
		assertEquals("much  20",bReader.readLine());
	}
	
	@Test
	public void test15() throws IOException {
		map.put("then",2);
		wordList.add(map.ceilingEntry("then"));
		Output.output(wordList, null);
		assertEquals("then  2",bReader.readLine());
	}
	
	@Test
	public void test16() throws IOException {
		map.put("many",40);
		wordList.add(map.ceilingEntry("many"));
		Output.output(wordList, null);
		assertEquals("many  40",bReader.readLine());
	}
	
	@Test
	public void test17() throws IOException {
		map.put("abcdefg",20);
		wordList.add(map.ceilingEntry("abcdefg"));
		Output.output(wordList, null);
		assertEquals("abcdefg  20",bReader.readLine());
	}
	
	@Test
	public void test18() throws IOException {
		map.put("how-about",2);
		wordList.add(map.ceilingEntry("how-about"));
		Output.output(wordList, null);
		assertEquals("how-about  2",bReader.readLine());
	}
	
	@Test
	public void test19() throws IOException {
		map.put("zui",5);
		map.put("hou",3);
		wordList.add(map.ceilingEntry("zui"));
		wordList.add(map.ceilingEntry("hou"));
		Output.output(wordList, null);
		assertEquals("zui  5",bReader.readLine());
		assertEquals("hou  3",bReader.readLine());
	}
	
	@Test
	public void test20() throws IOException {
		map.put("finished",3);
		wordList.add(map.ceilingEntry("finished"));
		Output.output(wordList, null);
		assertEquals("finished  3",bReader.readLine());
	}
}
