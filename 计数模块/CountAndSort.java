public static TreeMap<String,Integer> parse(String filename) throws IOException{
	FileReader fileReader = null;
	BufferedReader bufferedReader = null;
	
	//每行总字符串
	String str;
	//每个识别到的单词
	String word;
	//单词表，存放单词和词频
	final TreeMap<String, Integer> wordList=new TreeMap<String,Integer>();
	char ch1;
	char ch2;

	//单词起始、结束位置、短横线位置（从1开始）
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
									
				//如果是第一个字母
				if(startIndex==0&&(ch1>=65&&ch1<=90||ch1>=97&&ch1<=122)){
					startIndex=i+1;
				}
				
				//第一个字母后面的，判断单词何处结束
				if(startIndex!=0){
					
					//字符是“-”
					if(ch1==45){
						if(i<str.length()-1){
							ch2=str.charAt(i+1);
							//“-”后面跟的不是字母
							if(ch2<65||ch2>90&&ch2<97||ch2>122){
								endIndex=i+1;
							}
						}
						else{
							endIndex=i+1;
						}
					}
					//此字符不是字母也不是“-”
					else if(ch1<65||ch1>90&&ch1<97||ch1>122){
						endIndex=i+1;
					}
					//如果已到行末
					else if(i==str.length()-1){
						endIndex=i+2;
					}
					
					//如果单词结束
					if(endIndex!=0){
						//得到此单词（全部按小写）
						word=str.substring(startIndex-1, endIndex-1).toLowerCase();
						//如果map中有此单词，词频加1
						if(wordList.containsKey(word)){
							wordList.put(word, wordList.get(word)+1);
						}
						//无此单词，添加进去
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
		JOptionPane.showMessageDialog(null, "文件不存在","  ", JOptionPane.INFORMATION_MESSAGE); 
		System.exit(0);
		
	}finally{
		//关闭文件流
		bufferedReader.close();
		fileReader.close();
	}
	return wordList;
}
