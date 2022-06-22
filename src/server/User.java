package server;

/**
 * 用户类，记录用户的所有属性
 */

import java.util.*;

public class User {
	
	private String name;	//玩家用户名
	private String password;	//密码
	private int time;		//最好成绩（最长时间）
	private int signin;		//是否签到
	private int money;		//金币数
	private int heart;		//复活次数
	private Date date;		//最近一次签到时间（日期类）
	
	//构造函数
	public User() {
		
	}
	
	//复制构造函数
	public User(User user) {
		this.name = user.getName();
		this.password = user.getPass();
		this.time = user.getTime();
		this.signin = user.getSign();
		this.money = user.getMoney();
		this.heart = user.getHeart();
	}
	
	//构造函数
	public User(String name, String password, int time, int signin, int money, int heart, Date date) {
		this.name = name;
		this.password = password;
		this.time = time;
		this.signin = signin;
		this.money = money;
		this.heart = heart;
		this.date = date;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPass() {
		return this.password;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getSign() {
		return this.signin;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public int getHeart() {
		return this.heart;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPass(String pw) {
		this.password = pw;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public void setSign(int signin) {
		this.signin = signin;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void setHeart(int heart) {
		this.heart = heart;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
