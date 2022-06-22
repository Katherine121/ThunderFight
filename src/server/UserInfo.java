package server;

/**
 * �û���Ϣ����
 * ���ļ���Ϣ����ת�������ڸ����û���Ϣ
 */

import java.util.*;

public class UserInfo {

	  //���������Ϣ�ļ���
	  private ArrayList<User> users;
	  
	  //���캯������ʼ��users���ϵ�����
	  public UserInfo() {
		users = new ArrayList<User>(50);
	  }
	
	  //����һ�����
	  public void addUser(String name, String password, int time, int signin, int money, int heart, Date date) {
		  User user = new User(name, password, time, signin, money, heart, date);
		  users.add(user);
	  }
	  
	  //�������������Ŀ
	  public int getNumOfUsers() {
		  return users.size();
	  }
	  
	  //����ĳ�������Ϣ
	  public User getUser(int index) {
		  return this.users.get(index);
	  }
	 
	  //�����2����Ϣ���Ƹ����1
	  public void setUser(User user1, User user2) {
			user1.setName(user2.getName());
			user1.setPass(user2.getPass());
			user1.setTime(user2.getTime());
			user1.setSign(user2.getSign());
			user1.setMoney(user2.getMoney());
			user1.setDate(user2.getDate());
	  }
	  
	  //���ؼ��ϵĵ�����
	  public Iterator<User> getUsers() {
		  return this.users.iterator();
	  }
}
