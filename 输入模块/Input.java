package wcPro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//���빦��    ���ļ����Ƿ�����жϣ������ļ�������������ģ�麯��
public class Input {
	//���������һ��������Ϊ0���Ͷ���������
    public  static File input(String[] args) {
    	File inputFile=null;
	    String filePath = null;
	    String fileP = null;
	    String fileName=null;
	   //һ������    -x���ļ���filename�������
		if (args.length == 1) {
			if(args[0].equals("-x")){
				//ͼ�ν���ѡ���ļ�
		
				
				JFileChooser jfc=new JFileChooser();
				jfc.setDialogTitle("��ѡ��һ���ļ�");
				jfc.showOpenDialog(null);
				jfc.setVisible(true);
				
				//�õ��û�ѡ����ļ�·��
				if(jfc.getSelectedFile()!=null){
					fileName=jfc.getSelectedFile().getAbsolutePath();
					inputFile=new File(fileName);
					return inputFile;
				}
				else{
				
					JOptionPane.showMessageDialog(null, "��ѡ���ļ�"," ", JOptionPane.INFORMATION_MESSAGE); 
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
					JOptionPane.showMessageDialog(null, "�ļ�����ʽ����(��֧��txt��ʽ)"," ", JOptionPane.INFORMATION_MESSAGE); 
					System.exit(0);
					throw new IllegalArgumentException();
				}
				
	
			
				inputFile = new File(fileName);
			}

		}
		//������һ���������    0���Ͷ�������Ƿ�����    ���������ʽ����Ի���
		else{
			JOptionPane.showMessageDialog(null, "�����ʽ����(��֧��һ���������)", " ", JOptionPane.INFORMATION_MESSAGE); 
		     System.exit(0);
		}
		return inputFile;

    }
	

}
