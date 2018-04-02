package test;

import java.io.File;

import wcPro.Input;
import junit.framework.TestCase;

//测试输入模块
public class testInput extends TestCase{
     String[] args=null;
   
     File expected=null;
     File actual=null;
    
   
     //测试用例
 	public void test1(){
 		//改变cmd窗口输入内容
 		args=new String[1];
 		args[0]="";
 		 actual=Input.input(args);
 		assertEquals(expected, actual);
 	}
     
     //测试用例   点非.txt文件
	public void test2(){
		//改变cmd窗口输入内容
		args=new String[1];
		args[0]="-x";
		 actual=Input.input(args);
		assertEquals(expected, actual);
	}
	 //测试用例   点.txt文件
 	public void test3(){
 		//改变cmd窗口输入内容
 		args=new String[1];
 		args[0]="";
 		 actual=Input.input(args);
 		assertEquals(expected, actual);
 	}
     
     //测试用例
	public void test4(){
		//改变cmd窗口输入内容
		args=new String[1];
		args[0]="test.txt";
		actual=Input.input(args);
		expected=new File("test.txt");
		assertEquals(expected, actual);
		
	}
	 //测试用例
 	public void test5(){
 		//改变cmd窗口输入内容
 		args=new String[1];
 		args[0]="wcPro.txt";
 		 actual=Input.input(args);
 		expected=new File(args[0]);
		assertEquals(expected, actual);
 	}
     
     //测试用例
	public void test6(){
		//改变cmd窗口输入内容
		args=new String[1];
		args[0]="-a";
		 actual=Input.input(args);
		assertEquals(expected, actual);
	}
	 //测试用例
 	public void test7(){
 		//改变cmd窗口输入内容
 		args=new String[2];
 		args[0]="-x";
 		args[1]="-a";
 		 actual=Input.input(args);
 		assertEquals(expected, actual);
 	}
     
     //测试用例
	public void test8(){
		//改变cmd窗口输入内容
		args=new String[1];
		args[0]="test.c";
		actual=Input.input(args);
		expected=new File(args[0]);
		assertEquals(expected, actual);
	}
	 //测试用例
 	public void test9(){
 		//改变cmd窗口输入内容
 		args=new String[1];
 		args[0]="text.c";
 		 actual=Input.input(args);
 		expected=new File(args[0]);
		assertEquals(expected, actual);
 	}
     
     //测试用例
	public void test10(){
		//改变cmd窗口输入内容
		args=new String[2];
		args[0]="-x";
		args[1]="test.txt";
		 actual=Input.input(args);
	 		expected=new File(args[1]);
			assertEquals(expected, actual);
	}
	
	//
	   //测试用例
	 	public void test11(){
	 		//改变cmd窗口输入内容
	 		args=new String[2];
	 		args[0]="test.txt";
	 		args[1]="-x";
	 		 actual=Input.input(args);
	  		expected=new File(args[0]);
	 		assertEquals(expected, actual);
	 	}
	     
	     //测试用例   
		public void test12(){
			//改变cmd窗口输入内容
			args=new String[2];
			args[0]="-x";
			args[1]="test.c";
			 actual=Input.input(args);
		 	expected=new File(args[1]);
			assertEquals(expected, actual);
		}
		 //测试用例   点.txt文件
	 	public void test13(){
	 		//改变cmd窗口输入内容
	 		args=new String[2];
	 		args[0]="-a";
	 		args[1]="text.txt";
	 		 actual=Input.input(args);
	  		expected=new File(args[1]);
	 		assertEquals(expected, actual);
	 	}
	     
	     //测试用例
		public void test14(){
			//改变cmd窗口输入内容
			args=new String[2];
			args[0]="-a";
	 		args[1]="test.txt";
	 		 actual=Input.input(args);
	  		expected=new File(args[1]);
	 		assertEquals(expected, actual);
		}
		 //测试用例
	 	public void test15(){
	 		//改变cmd窗口输入内容
	 		args=new String[2];
	 		args[0]="test.txt";
	 		args[1]="text.txt";
	 		 actual=Input.input(args);
	  		expected=new File(args[0]);
	 		assertEquals(expected, actual);
	 	}
	     
	     //测试用例
		public void test16(){
			//改变cmd窗口输入内容
			args=new String[1];
			args[0]="-x";
			 actual=Input.input(args);
			assertEquals(expected, actual);
		}
		 //测试用例
	 	public void test17(){
	 		//改变cmd窗口输入内容
	 		args=new String[1];
	 		args[0]="f:\\wordCount.txt";
	 		 actual=Input.input(args);
	  		expected=new File(args[0]);
	 		assertEquals(expected, actual);
	 	}
	     
	     //测试用例
		public void test18(){
			//改变cmd窗口输入内容
			args=new String[1];
			args[0]="f:\\test.c";
			 actual=Input.input(args);
		 		expected=new File(args[0]);
				assertEquals(expected, actual);
		}
		 //测试用例
	 	public void test19(){
	 		//改变cmd窗口输入内容
	 		args=new String[2];
	 		args[0]="-a";
	 		args[1]="text.c";
	 		 actual=Input.input(args);
	  		expected=new File(args[1]);
	 		assertEquals(expected, actual);
	 	}
	     
	     //测试用例
		public void test20(){
			//改变cmd窗口输入内容
			args=new String[2];
			args[0]="-x";
			args[1]="test.c";
			 actual=Input.input(args);
		 	expected=new File(args[1]);
			assertEquals(expected, actual);
		}
}
