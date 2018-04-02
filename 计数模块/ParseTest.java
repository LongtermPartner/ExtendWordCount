package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.CountAndSort;

public class ParseTest {

	private FileWriter fileWriter;
	TreeMap<String,Integer> actual;
	TreeMap<String,Integer> expected;
	
	@Before
	public void before() throws IOException{
		//初始化输入流和预期结果
		fileWriter=new FileWriter(new File("test.txt"));
		expected=new TreeMap<String,Integer>();
	}
	
	@Test
	public void test1() throws IOException {
		//向文件中写入，关闭输入流
		fileWriter.write("this is a sentence.");
		fileWriter.close();
		//得到预期结果
		expected.put("this", 1);
		expected.put("is", 1);
		expected.put("a",1);
		expected.put("sentence",1);

		//解析文件并与预期结果比较
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test2() throws IOException {
		
		fileWriter.write("THIS IS A SENTENCE.");
		fileWriter.close();
		
		expected.put("this", 1);
		expected.put("is", 1);
		expected.put("a",1);
		expected.put("sentence",1);

		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test3() throws IOException {
		fileWriter.write("This and this is the same.");
		fileWriter.close();
		
		expected.put("this", 2);
		expected.put("is", 1);
		expected.put("and",1);
		expected.put("the",1);
		expected.put("same",1);

		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test4() throws IOException {
		fileWriter.write("Maybe long-term is just one word.");
		fileWriter.close();
		
		expected.put("maybe", 1);
		expected.put("long-term", 1);
		expected.put("is",1);
		expected.put("just",1);
		expected.put("one",1);
		expected.put("word",1);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test5() throws IOException {
		fileWriter.write("how about-");
		fileWriter.close();
		
		expected.put("how", 1);
		expected.put("about", 1);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test6() throws IOException {
		fileWriter.write("is -this a word?");
		fileWriter.close();
		
		expected.put("is", 1);
		expected.put("this", 1);
		expected.put("a", 1);
		expected.put("word", 1);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test7() throws IOException {
		fileWriter.write("~`words like_this&[]this");
		fileWriter.close();
		
		expected.put("words", 1);
		expected.put("like", 1);
		expected.put("this", 2);
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test8() throws IOException {
		fileWriter.write("#amazing!%%^12interesting!...");
		fileWriter.close();
		
		expected.put("amazing", 1);
		expected.put("interesting", 1);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test9() throws IOException {
		fileWriter.write("45-is \t\t  \n");
		fileWriter.close();
		
		expected.put("is", 1);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test10() throws IOException {
		fileWriter.write("(hello friend-:'maybe\"luck\"),");
		fileWriter.close();
		
		expected.put("hello", 1);
		expected.put("friend", 1);
		expected.put("maybe", 1);
		expected.put("luck", 1);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test11() throws IOException {
		fileWriter.write("it's so difficult\"DIFFICULT\"");
		fileWriter.close();
		
		expected.put("it", 1);
		expected.put("s", 1);
		expected.put("so", 1);
		expected.put("difficult", 2);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test12() throws IOException {
		fileWriter.write("too>>>> many test.case");
		fileWriter.close();
		
		expected.put("too", 1);
		expected.put("many", 1);
		expected.put("test", 1);
		expected.put("case", 1);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test13() throws IOException {
		fileWriter.write("111TEST.222test:333test");
		fileWriter.close();
		
		expected.put("test", 3);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test14() throws IOException {
		fileWriter.write("t-o-o t-o-o_h-a-r-d");
		fileWriter.close();
		
		expected.put("t-o-o", 2);
		expected.put("h-a-r-d", 1);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test15() throws IOException {
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test16() throws IOException {
		fileWriter.write("?!`-e+=5:/|");
		fileWriter.close();
		
		expected.put("e", 1);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test17() throws IOException {
		fileWriter.write("```just-in_a-minute123-emmm");
		fileWriter.close();
		
		expected.put("just-in", 1);
		expected.put("a-minute", 1);
		expected.put("emmm", 1);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test18() throws IOException {
		fileWriter.write("15%3=?");
		fileWriter.close();
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test19() throws IOException {
		fileWriter.write("n-ull\t null\n\t  ");
		fileWriter.close();
		
		expected.put("null", 1);
		expected.put("n-ull", 1);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void test20() throws IOException {
		fileWriter.write("FiniSh-Ed!fiNish-ed!!!");
		fileWriter.close();
		
		expected.put("finish-ed", 2);
		
		actual=CountAndSort.parse("test.txt");
		assertEquals(expected, actual);
	}

}
