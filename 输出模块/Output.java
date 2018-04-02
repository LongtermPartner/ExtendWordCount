package wcPro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
//输出功能   将对读取的文件单词计数排序结果输出到输出文件
public class Output {
	public static void output(ArrayList<Entry<String, Integer>> list, File outputFile) throws IOException{
		   //输出实现
		   if(outputFile==null){
	        	 outputFile=new File("result.txt");
	      
	         } 
	      
		  FileWriter fW=new FileWriter(outputFile);
	         BufferedWriter bw=new BufferedWriter(fW);
	    
	       String str="";
	      
	       int count=0;
		for (Map.Entry<String, Integer> entry : list) {
            if(count<100){
			str = entry.getKey() + "  " + entry.getValue();
			bw.write(str + "\r\n");
			count++;
            }
            else break;
		}
		

		bw.close();
	}
}
