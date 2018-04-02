package wcPro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//输入功能    对文件名是否存在判断，并将文件传给计数排序模块函数
public class Input {
	//输入情况有一个参数或为0个和多个参数情况
    public  static File input(String[] args) {
    	File inputFile=null;
	    String filePath = null;
	    String fileP = null;
	    String fileName=null;
	   //一个参数    -x和文件名filename两种情况
		if (args.length == 1) {
			if(args[0].equals("-x")){
				//图形界面选择文件
		
				
				JFileChooser jfc=new JFileChooser();
				jfc.setDialogTitle("请选择一个文件");
				jfc.showOpenDialog(null);
				jfc.setVisible(true);
				
				//得到用户选择的文件路径
				if(jfc.getSelectedFile()!=null){
					fileName=jfc.getSelectedFile().getAbsolutePath();
					inputFile=new File(fileName);
					return inputFile;
				}
				else{
				
					JOptionPane.showMessageDialog(null, "请选择文件"," ", JOptionPane.INFORMATION_MESSAGE); 
					System.exit(0);
				}

					
			}
			else{
				filePath = args[0];
				File file = new File(filePath);
				fileName = file.getName();
				
				String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
				if (suffix.equals("txt")) {
					fileP = filePath;
				} else {
					JOptionPane.showMessageDialog(null, "文件名格式不对(仅支持txt格式)"," ", JOptionPane.INFORMATION_MESSAGE); 
					System.exit(0);
					throw new IllegalArgumentException();
				}
				
	
			
				inputFile = new File(fileName);
			}

		}
		//其他非一个参数情况    0个和多个参数非法输入    弹出输入格式错误对话框
		else{
			JOptionPane.showMessageDialog(null, "输入格式有误(仅支持一个输入参数)", " ", JOptionPane.INFORMATION_MESSAGE); 
		     System.exit(0);
		}
		return inputFile;

    }
	

}
