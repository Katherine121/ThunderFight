package file;

/**
 * 这是储存用户信息的类
 * readFile()函数将读取的用户信息转换为user类
 * writeFile(UserInfo userinfo)将修改后的用户信息写入文件中
 */

import java.io.*;
import java.util.*;
import server.*;

public class DealFile {

	//读取文件，将保存在文件里面的玩家信息转换为users集合
	public UserInfo readFile() {
		UserInfo userinfo = new UserInfo();
		
		Scanner scanner;
		try {
			//开启文件输入流
			scanner = new Scanner(new FileInputStream("D:\\JAVA\\ThunderFight\\userinfo.txt"));
			//按空格读取并转换成相应的格式
			while(scanner.hasNext()){
				userinfo.addUser(scanner.next(), scanner.next(), 
						Integer.valueOf(scanner.next()), Integer.valueOf(scanner.next()), 
						Integer.valueOf(scanner.next()), Integer.valueOf(scanner.next()),
						(new Time()).getDate(scanner.next()) );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return userinfo;
	}
	
	//写文件，将更新后的users集合重新写入文件
	public void writeFile(UserInfo userinfo) {

		File f = new File("D:\\JAVA\\ThunderFight\\userinfo.txt");
		
		//判断文件是否存在
		if(!f.exists()){ 
		   f.getParentFile().mkdirs();	// 创建父目录
		   
		   try {
			   f.createNewFile();		// 创建文件自身 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//创建文件输出流
		FileWriter fw = null;
		//获取迭代器
		Iterator<User> userIter = userinfo.getUsers();
		
		try {
			fw = new FileWriter(f);
			//依次写入文件
			while (userIter.hasNext()) {
				User user = (User) userIter.next();
				fw.write(user.getName());
				fw.write("\t");
				fw.write(user.getPass());
				fw.write("\t");
				fw.write(String.valueOf(user.getTime()));
				fw.write("\t");
				fw.write(String.valueOf(user.getSign()));
				fw.write("\t");
				fw.write(String.valueOf(user.getMoney()));
				fw.write("\t");
				fw.write(String.valueOf(user.getHeart()));
				fw.write("\t");
				fw.write( (new Time()).getTimeStr(user.getDate()) );//将日期类转换成字符串
				fw.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			//关闭文件流
		    if( fw != null )
		    	try {
		    		fw.close();
		    	} catch(Throwable e) {
		    		
		    	}
		}
	}
}
