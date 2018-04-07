public static TreeMap<String,Integer> parse(String filename) throws IOException{
	FileReader fileReader = null;
	BufferedReader bufferedReader = null;
	
	//ÿ�����ַ���
	String str;
	//ÿ��ʶ�𵽵ĵ���
	String word;
	//���ʱ���ŵ��ʺʹ�Ƶ
	final TreeMap<String, Integer> wordList=new TreeMap<String,Integer>();
	char ch1;
	char ch2;

	//������ʼ������λ�á��̺���λ�ã���1��ʼ��
	int startIndex;
	int endIndex;
	try {
		fileReader=new FileReader(new File(filename));
		bufferedReader=new BufferedReader(fileReader);
		
		while((str=bufferedReader.readLine())!=null){
			startIndex=0;
			endIndex=0;
			
			for(int i=0;i<str.length();i++){
				ch1=str.charAt(i);
									
				//����ǵ�һ����ĸ
				if(startIndex==0&&(ch1>=65&&ch1<=90||ch1>=97&&ch1<=122)){
					startIndex=i+1;
				}
				
				//��һ����ĸ����ģ��жϵ��ʺδ�����
				if(startIndex!=0){
					
					//�ַ��ǡ�-��
					if(ch1==45){
						if(i<str.length()-1){
							ch2=str.charAt(i+1);
							//��-��������Ĳ�����ĸ
							if(ch2<65||ch2>90&&ch2<97||ch2>122){
								endIndex=i+1;
							}
						}
						else{
							endIndex=i+1;
						}
					}
					//���ַ�������ĸҲ���ǡ�-��
					else if(ch1<65||ch1>90&&ch1<97||ch1>122){
						endIndex=i+1;
					}
					//����ѵ���ĩ
					else if(i==str.length()-1){
						endIndex=i+2;
					}
					
					//������ʽ���
					if(endIndex!=0){
						//�õ��˵��ʣ�ȫ����Сд��
						word=str.substring(startIndex-1, endIndex-1).toLowerCase();
						//���map���д˵��ʣ���Ƶ��1
						if(wordList.containsKey(word)){
							wordList.put(word, wordList.get(word)+1);
						}
						//�޴˵��ʣ���ӽ�ȥ
						else{
							wordList.put(word, 1);
						}
						
						startIndex=0;
						endIndex=0;
					}
				}	
			}
		}
		
	} catch (FileNotFoundException e) {
		JOptionPane.showMessageDialog(null, "�ļ�������","  ", JOptionPane.INFORMATION_MESSAGE); 
		System.exit(0);
		
	}finally{
		//�ر��ļ���
		bufferedReader.close();
		fileReader.close();
	}
	return wordList;
}
