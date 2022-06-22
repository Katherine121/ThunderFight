package file;

/**
 * ���Ǵ����û���Ϣ����
 * readFile()��������ȡ���û���Ϣת��Ϊuser��
 * writeFile(UserInfo userinfo)���޸ĺ���û���Ϣд���ļ���
 */

import java.io.*;
import java.util.*;
import server.*;

public class DealFile {

	//��ȡ�ļ������������ļ�����������Ϣת��Ϊusers����
	public UserInfo readFile() {
		UserInfo userinfo = new UserInfo();
		
		Scanner scanner;
		try {
			//�����ļ�������
			scanner = new Scanner(new FileInputStream("D:\\JAVA\\ThunderFight\\userinfo.txt"));
			//���ո��ȡ��ת������Ӧ�ĸ�ʽ
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
	
	//д�ļ��������º��users��������д���ļ�
	public void writeFile(UserInfo userinfo) {

		File f = new File("D:\\JAVA\\ThunderFight\\userinfo.txt");
		
		//�ж��ļ��Ƿ����
		if(!f.exists()){ 
		   f.getParentFile().mkdirs();	// ������Ŀ¼
		   
		   try {
			   f.createNewFile();		// �����ļ����� 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//�����ļ������
		FileWriter fw = null;
		//��ȡ������
		Iterator<User> userIter = userinfo.getUsers();
		
		try {
			fw = new FileWriter(f);
			//����д���ļ�
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
				fw.write( (new Time()).getTimeStr(user.getDate()) );//��������ת�����ַ���
				fw.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			//�ر��ļ���
		    if( fw != null )
		    	try {
		    		fw.close();
		    	} catch(Throwable e) {
		    		
		    	}
		}
	}
}
