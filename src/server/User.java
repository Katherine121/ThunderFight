package server;

/**
 * �û��࣬��¼�û�����������
 */

import java.util.*;

public class User {
	
	private String name;	//����û���
	private String password;	//����
	private int time;		//��óɼ����ʱ�䣩
	private int signin;		//�Ƿ�ǩ��
	private int money;		//�����
	private int heart;		//�������
	private Date date;		//���һ��ǩ��ʱ�䣨�����ࣩ
	
	//���캯��
	public User() {
		
	}
	
	//���ƹ��캯��
	public User(User user) {
		this.name = user.getName();
		this.password = user.getPass();
		this.time = user.getTime();
		this.signin = user.getSign();
		this.money = user.getMoney();
		this.heart = user.getHeart();
	}
	
	//���캯��
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
