package server;

/**
 * 用户信息表类
 * 与文件信息进行转换，便于更新用户信息
 */

import java.util.*;

public class UserInfo {

	  //保存玩家信息的集合
	  private ArrayList<User> users;
	  
	  //构造函数，初始化users集合的容量
	  public UserInfo() {
		users = new ArrayList<User>(50);
	  }
	
	  //增加一个玩家
	  public void addUser(String name, String password, int time, int signin, int money, int heart, Date date) {
		  User user = new User(name, password, time, signin, money, heart, date);
		  users.add(user);
	  }
	  
	  //返回所有玩家数目
	  public int getNumOfUsers() {
		  return users.size();
	  }
	  
	  //返回某个玩家信息
	  public User getUser(int index) {
		  return this.users.get(index);
	  }
	 
	  //把玩家2的信息复制给玩家1
	  public void setUser(User user1, User user2) {
			user1.setName(user2.getName());
			user1.setPass(user2.getPass());
			user1.setTime(user2.getTime());
			user1.setSign(user2.getSign());
			user1.setMoney(user2.getMoney());
			user1.setDate(user2.getDate());
	  }
	  
	  //返回集合的迭代器
	  public Iterator<User> getUsers() {
		  return this.users.iterator();
	  }
}
