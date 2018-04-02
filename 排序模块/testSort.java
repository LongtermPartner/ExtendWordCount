package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import wcPro.CountAndSort;
import junit.framework.TestCase;

//��������ģ����Ҫ�Ǹı��ı����ݽ������������ܵ���ȷ��
public class testSort extends TestCase {

	//����CountAndSort��Sort������
	//�����������    �׺в��ԣ���������֧��·������       �ںв��ԣ��ȼ������    ��Ч�ȼ�����ԣ���Ч�ȼ�����ԣ��߽�ֵ��������
	
	TreeMap<String, Integer> hMap=new TreeMap<String, Integer>();      //�������������map����
	LinkedHashMap<String, Integer> eMap= new LinkedHashMap<String, Integer>();    //������������Ľ��
	ArrayList<Map.Entry<String, Integer>> actual=new ArrayList<Map.Entry<String,Integer>>();  //ʵ��ֵ
	ArrayList<Map.Entry<String, Integer>> expected=null;                     //����ֵ
	//�ı�����Ϊ�� 
	public void test1(){
	
		//�ı�hMap����
		 actual=CountAndSort.Sort(hMap);
		 expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
		
	}
	//�ı�����Ϊһ������
	public void test2(){
		
		// �ı�hMap����
		hMap.put("a", 1);
		actual = CountAndSort.Sort(hMap);
		eMap.put("a", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
		
		
	}
	
	//�ı����������
	   //��ͬƵ��
		 //������ĸ����
	        //�����Ƿ�������-�ַ�
	         //���ʲ��ظ�
	
	// ��򵥵���  ���ɵ�����ĸ���
	// a   1
	// b   1 
	public void test3(){
		// �ı�hMap����
		hMap.put("a", 1);
		hMap.put("b",1);
		actual = CountAndSort.Sort(hMap);
		eMap.put("a", 1);
		eMap.put("b",1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
	}
	//������-����ĸ
	public void test4(){
		// �ı�hMap����
		hMap.put("a", 1);
		hMap.put("-",1);
		actual = CountAndSort.Sort(hMap);
		eMap.put("-",1);
		eMap.put("a", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
		
	}
	//����������put()�Ž���˳���ϵ
		public void test5(){
			// �ı�hMap����
			hMap.put("aa", 1);
			hMap.put("ab",1);
			actual = CountAndSort.Sort(hMap);
			eMap.put("aa", 1);
			eMap.put("ab",1);
			expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
			assertEquals(expected, actual);
			
		}
		//�������ʷŽ�˳��
		public void test6(){
			// �ı�hMap����
			hMap.put("ab", 1);
			hMap.put("aa", 1);
			actual = CountAndSort.Sort(hMap);
			eMap.put("aa", 1);
			eMap.put("ab", 1);
			expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
			assertEquals(expected, actual);

		}
	//��������ĸ��-��ɵĵ���
	public void test7(){
		// �ı�hMap����
		hMap.put("ab", 1);
		hMap.put("a-b", 1);
		actual = CountAndSort.Sort(hMap);
		eMap.put("a-b", 1);
		eMap.put("ab", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
					
	}
	// ���Ժ�����ͬ���ʴ�Ƶ��ͬ����
	public void test8() {
		// �ı�hMap����
		hMap.put("aa", 1);
		hMap.put("aa", 1);
		actual = CountAndSort.Sort(hMap);
		eMap.put("aa", 1);
		eMap.put("aa", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);

	}
	
	//��Ƶ��ͬ
	
	public void test9(){
		// �ı�hMap����
		hMap.put("a", 1);
		hMap.put("b", 2);
		actual = CountAndSort.Sort(hMap);
		eMap.put("b", 2);
		eMap.put("a", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
					
	}
	//����������put()�Ž���˳���ϵ
		public void test10(){
			// �ı�hMap����
		hMap.put("aa", 1);
		hMap.put("ab", 2);
		actual = CountAndSort.Sort(hMap);
		eMap.put("ab", 2);
		eMap.put("aa", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
						
		}
		//�������ʷŽ�˳��
		public void test11(){
			hMap.put("ab", 2);
			hMap.put("aa", 1);
			actual = CountAndSort.Sort(hMap);
			eMap.put("ab", 2);
			eMap.put("aa", 1);
			expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
			assertEquals(expected, actual);
							
		}
	//��������ĸ��-��ɵĵ���
	public void test12(){
		hMap.put("ab", 1);
		hMap.put("a-b", 2);
		actual = CountAndSort.Sort(hMap);
		eMap.put("a-b", 2);
		eMap.put("ab", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
						
	}
	
	
	//���Ժ��в�ͬ���ʴ�Ƶ��ͬ����
	public void test13() {
		hMap.put("aa", 1);
		hMap.put("-aa", 2);
		actual = CountAndSort.Sort(hMap);
		eMap.put("-aa", 2);
		eMap.put("aa", 1);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);
						
	}
	//���в�ͬ���ʴ�Ƶ��ͬ
	public void test14() {
		TreeMap<String, Integer> hMap = new TreeMap<String, Integer>();
		// �ı�hMap����
		hMap.put("aa", 2);
		hMap.put("-aa", 2);
		actual = CountAndSort.Sort(hMap);
		eMap.put("-aa", 2);
		eMap.put("aa", 2);
		expected = new ArrayList<Map.Entry<String, Integer>>(eMap.entrySet());
		assertEquals(expected, actual);

	}
	//���Զ������
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

	// ����Ƶ�Ƚϴ�ʱ
	public void test16() {
		// �ı�hMap����
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

	// ���Զ��������Ƶ�ȴ�ʱ
	public void test17() {
		TreeMap<String, Integer> hMap = new TreeMap<String, Integer>();
		// �ı�hMap����
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

	// ���Զ�������ҵ��ʺ��������ַ�
	public void test18() {
		TreeMap<String, Integer> hMap = new TreeMap<String, Integer>();
		// �ı�hMap����
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

	// ���Զ�����ʺ�����ĸ����
	public void test19() {
		TreeMap<String, Integer> hMap = new TreeMap<String, Integer>();
		// �ı�hMap����
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

	//�ۺϲ���   ���Զ�����ʺ��и��������ַ������Ҵ�Ƶ��ȴ�
	public void test20() {
		TreeMap<String, Integer> hMap = new TreeMap<String, Integer>();
		// �ı�hMap����
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
