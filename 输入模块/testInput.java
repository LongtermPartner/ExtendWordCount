package test;

import java.io.File;

import wcPro.Input;
import junit.framework.TestCase;

//��������ģ��
public class testInput extends TestCase{
     String[] args=null;
   
     File expected=null;
     File actual=null;
    
   
     //��������
 	public void test1(){
 		//�ı�cmd������������
 		args=new String[1];
 		args[0]="";
 		 actual=Input.input(args);
 		assertEquals(expected, actual);
 	}
     
     //��������   ���.txt�ļ�
	public void test2(){
		//�ı�cmd������������
		args=new String[1];
		args[0]="-x";
		 actual=Input.input(args);
		assertEquals(expected, actual);
	}
	 //��������   ��.txt�ļ�
 	public void test3(){
 		//�ı�cmd������������
 		args=new String[1];
 		args[0]="";
 		 actual=Input.input(args);
 		assertEquals(expected, actual);
 	}
     
     //��������
	public void test4(){
		//�ı�cmd������������
		args=new String[1];
		args[0]="test.txt";
		actual=Input.input(args);
		expected=new File("test.txt");
		assertEquals(expected, actual);
		
	}
	 //��������
 	public void test5(){
 		//�ı�cmd������������
 		args=new String[1];
 		args[0]="wcPro.txt";
 		 actual=Input.input(args);
 		expected=new File(args[0]);
		assertEquals(expected, actual);
 	}
     
     //��������
	public void test6(){
		//�ı�cmd������������
		args=new String[1];
		args[0]="-a";
		 actual=Input.input(args);
		assertEquals(expected, actual);
	}
	 //��������
 	public void test7(){
 		//�ı�cmd������������
 		args=new String[2];
 		args[0]="-x";
 		args[1]="-a";
 		 actual=Input.input(args);
 		assertEquals(expected, actual);
 	}
     
     //��������
	public void test8(){
		//�ı�cmd������������
		args=new String[1];
		args[0]="test.c";
		actual=Input.input(args);
		expected=new File(args[0]);
		assertEquals(expected, actual);
	}
	 //��������
 	public void test9(){
 		//�ı�cmd������������
 		args=new String[1];
 		args[0]="text.c";
 		 actual=Input.input(args);
 		expected=new File(args[0]);
		assertEquals(expected, actual);
 	}
     
     //��������
	public void test10(){
		//�ı�cmd������������
		args=new String[2];
		args[0]="-x";
		args[1]="test.txt";
		 actual=Input.input(args);
	 		expected=new File(args[1]);
			assertEquals(expected, actual);
	}
	
	//
	   //��������
	 	public void test11(){
	 		//�ı�cmd������������
	 		args=new String[2];
	 		args[0]="test.txt";
	 		args[1]="-x";
	 		 actual=Input.input(args);
	  		expected=new File(args[0]);
	 		assertEquals(expected, actual);
	 	}
	     
	     //��������   
		public void test12(){
			//�ı�cmd������������
			args=new String[2];
			args[0]="-x";
			args[1]="test.c";
			 actual=Input.input(args);
		 	expected=new File(args[1]);
			assertEquals(expected, actual);
		}
		 //��������   ��.txt�ļ�
	 	public void test13(){
	 		//�ı�cmd������������
	 		args=new String[2];
	 		args[0]="-a";
	 		args[1]="text.txt";
	 		 actual=Input.input(args);
	  		expected=new File(args[1]);
	 		assertEquals(expected, actual);
	 	}
	     
	     //��������
		public void test14(){
			//�ı�cmd������������
			args=new String[2];
			args[0]="-a";
	 		args[1]="test.txt";
	 		 actual=Input.input(args);
	  		expected=new File(args[1]);
	 		assertEquals(expected, actual);
		}
		 //��������
	 	public void test15(){
	 		//�ı�cmd������������
	 		args=new String[2];
	 		args[0]="test.txt";
	 		args[1]="text.txt";
	 		 actual=Input.input(args);
	  		expected=new File(args[0]);
	 		assertEquals(expected, actual);
	 	}
	     
	     //��������
		public void test16(){
			//�ı�cmd������������
			args=new String[1];
			args[0]="-x";
			 actual=Input.input(args);
			assertEquals(expected, actual);
		}
		 //��������
	 	public void test17(){
	 		//�ı�cmd������������
	 		args=new String[1];
	 		args[0]="f:\\wordCount.txt";
	 		 actual=Input.input(args);
	  		expected=new File(args[0]);
	 		assertEquals(expected, actual);
	 	}
	     
	     //��������
		public void test18(){
			//�ı�cmd������������
			args=new String[1];
			args[0]="f:\\test.c";
			 actual=Input.input(args);
		 		expected=new File(args[0]);
				assertEquals(expected, actual);
		}
		 //��������
	 	public void test19(){
	 		//�ı�cmd������������
	 		args=new String[2];
	 		args[0]="-a";
	 		args[1]="text.c";
	 		 actual=Input.input(args);
	  		expected=new File(args[1]);
	 		assertEquals(expected, actual);
	 	}
	     
	     //��������
		public void test20(){
			//�ı�cmd������������
			args=new String[2];
			args[0]="-x";
			args[1]="test.c";
			 actual=Input.input(args);
		 	expected=new File(args[1]);
			assertEquals(expected, actual);
		}
}
