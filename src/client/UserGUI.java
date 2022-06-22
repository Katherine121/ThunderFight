package client;

/**
 * 这是用户登录后的用户主界面，也是主功能界面
 * 包括三种难度的游戏，商店（购买金币），游戏规则，
 * 签到（增加金币），排行榜，用户信息和改密功能
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Date;
import java.util.Iterator;
import file.*;
import image.*;
import server.*;

public class UserGUI implements ActionListener{

	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;	//定义各组件
	JLabel jlb1,jlb2;
	JFrame JF;
	ImageIcon background;
	BackgroundPanel bgp;
	
	DealFile file;	//用户信息
	UserInfo userinfo;
	Iterator<User> userIter;
	User user;
	
	public UserGUI(String name, String pw) {
		file = new DealFile();		//找到对应的玩家信息
		userinfo = file.readFile();
		userIter = userinfo.getUsers();
	    	
		    while (userIter.hasNext()) {
		    	User user1 = userIter.next();
			      
			    	  if ( user1.getName().equals(name) && user1.getPass().equals(pw) ) {
			    		  this.user = user1;
			    		  break;
			    	  } 
		    }
		 	Font f = new Font("Helvetica", Font.BOLD, 30);	//定义字体
		 	
		 	jlb1 = new JLabel("个人中心");	//创建标签
		 	jlb2 = new JLabel(name);
		 	jlb1.setBounds( 20,20,200,40); //设置位置和字体
		 	jlb2.setBounds( 20,70,200,30); 
	        jlb1.setFont(f);
	        jlb1.setForeground(Color.YELLOW);
	        jlb2.setFont(f);
	        jlb2.setForeground(Color.YELLOW);
			
	        jb1 = new JButton("简单模式");	//创建按钮
	        jb2 = new JButton("困难模式");
	        jb3 = new JButton("地狱模式");
	        jb4 = new JButton("商店"); 
	        jb5 = new JButton("游戏规则"); 
	        jb6 = new JButton("退出登录");
	        jb7 = new JButton("签到"); 
	        jb8 = new JButton("排行榜");
	        jb9 = new JButton("个人信息");
	        jb10 = new JButton("改密");
	        JF = new JFrame();
	        
	        jb1.setBounds( 100,350,90,60);   //设置位置
	        jb2.setBounds( 330,350,90,60);
	        jb3.setBounds( 560,350,90,60);
	        jb4.setBounds( 90,500,110,70);
	        jb5.setBounds( 320,500,110,70);
	        jb6.setBounds( 550,500,110,70);
	        jb7.setBounds( 650,20,100,45);
	        jb8.setBounds( 650,80,100,45);
	        jb9.setBounds( 650,140,100,45);
	        jb10.setBounds( 650,200,100,45);
	        
	        jb7.setBackground(Color.GREEN);	//设置颜色
	        jb8.setBackground(Color.GREEN);
	        jb9.setBackground(Color.GREEN);
	        jb10.setBackground(Color.GREEN);
	        
	        jb1.addActionListener(this);	//设置监听器
	        jb2.addActionListener(this);
	        jb3.addActionListener(this);
	        jb4.addActionListener(this);
	        jb5.addActionListener(this);
	        jb6.addActionListener(this);
	        jb7.addActionListener(this);
	        jb8.addActionListener(this);
	        jb9.addActionListener(this);
	        jb10.addActionListener(this);
	        
	        JF.add(jlb1); 	//添加各组件
	        JF.add(jlb2); 
	        JF.add(jb1);  
	        JF.add(jb2);  
	        JF.add(jb3); 
	        JF.add(jb4); 
	        JF.add(jb5); 
	        JF.add(jb6); 
	        JF.add(jb7); 
	        JF.add(jb8); 
	        JF.add(jb9); 
	        JF.add(jb10);
	        
	        ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//改变窗口图标
	        JF.setIconImage(imageIcon.getImage());  
	        JF.setTitle("雷霆战机");//设置标题
	        JF.setSize(800, 650);   //设置大小
	        JF.setLayout(null);           //设置布局
	             
	        Container ct = JF.getContentPane();	//设置窗体背景
	        JF.setLayout(null);
	        bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back1.jpg")).getImage());
	        bgp.setBounds(0,0,800,650);
	        ct.add(bgp);
	   	
	        JF.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
	        JF.setVisible(true);  //设置可见
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			//登录界面
			JOptionPane.showMessageDialog(null, "小试牛刀，快来涨涨经验吧！");
			//将玩家信息和10个炮弹传入
			GameGUI gg1 = new GameGUI(user, 10);
			this.user = gg1.getUser();
		}
		
		if(e.getSource() == jb2) {
			//登录界面
			JOptionPane.showMessageDialog(null, "能力加成，小主人进步太快啦！");
			//将玩家信息和25个炮弹传入
			GameGUI gg2 = new GameGUI(user, 25);
			this.user = gg2.getUser();
		}
		
		if(e.getSource() == jb3) {
			//登录界面
			JOptionPane.showMessageDialog(null, "勇气可嘉，请接收魔鬼考验吧！");
			//将玩家信息和40个炮弹传入
			GameGUI gg3 = new GameGUI(user, 40);
			this.user = gg3.getUser();
		}
		
		if(e.getSource() == jb4) {
			//商店
			JLabel jlb1 = new JLabel("50金币\t12次复活");	//创建标签
			JLabel jlb2 = new JLabel("100金币\t30次复活");
			JLabel jlb3 = new JLabel("500金币\t160次复活");
			JLabel jlb4 = new JLabel("其他商品敬请期待...");
			JButton jb1 = new JButton("购买");		//创建按钮
			JButton jb2 = new JButton("购买");
			JButton jb3 = new JButton("购买");
			JFrame jf = new JFrame();
			
			jlb1.setFont(new java.awt.Font("黑体",Font.ITALIC,15));	//设置字体和位置
			jlb1.setBounds( 20,10,150,15); 
			jlb2.setFont(new java.awt.Font("黑体",Font.ITALIC,15));
			jlb2.setBounds( 20,50,150,15); 
			jlb3.setFont(new java.awt.Font("黑体",Font.ITALIC,15));
			jlb3.setBounds( 20,90,150,15); 
			
			jb1.setFont(new java.awt.Font("黑体",Font.ITALIC,12));
			jb1.setBounds(200,5,60,30);   
			jb2.setFont(new java.awt.Font("黑体",Font.ITALIC,12));
	        jb2.setBounds(200,45,60,30);
	        jb3.setFont(new java.awt.Font("黑体",Font.ITALIC,12));
	        jb3.setBounds(200,85,60,30);
	        jlb4.setFont(new java.awt.Font("黑体",Font.ITALIC,20));
			jlb4.setBounds( 20,120,250,20); 
			
			jf.add(jlb1);	//添加各组件
			jf.add(jlb2);
			jf.add(jlb3);
			jf.add(jlb4);
			jf.add(jb1);
			jf.add(jb2);
			jf.add(jb3);
			
			ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//改变窗口图标
	        jf.setIconImage(imageIcon.getImage()); 
	        jf.setTitle("雷霆战机");//设置标题
	        jf.setSize(300, 200);   //设置大小
	        
	        Container ct = jf.getContentPane();	//设置窗体背景
	        jf.setLayout(null);		
	        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
	        bgp.setBounds(0,0,300,200);
	        ct.add(bgp);
	        
	        jf.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
	        jf.setVisible(true);  //设置可见
	        
	        //监听器
	        jb1.addActionListener(new ActionListener() { 
		    	   public void actionPerformed(ActionEvent e)  {
		    		   //只有拥有50个金币才能购买12次复活机会
		    		   if(user.getMoney() >= 50) {
		    			   //玩家信息更新
			    		   user.setHeart(user.getHeart() + 12);
			    		   user.setMoney(user.getMoney() - 50);
			    		   
			    		   //保存文件
			    		   DealFile file = new DealFile();
			    		   UserInfo userinfo1 = file.readFile();
			    		   Iterator<User> userIter1 = userinfo1.getUsers();
			   	    	
			   		       while (userIter1.hasNext()) {
			   		    	  User user1 = userIter1.next();
		   			    	  if ( user1.getName().equals(user.getName()) && user1.getPass().equals(user.getPass()) ) {
		   			    		  user1.setHeart(user1.getHeart() + 12);
					    		  user1.setMoney(user1.getMoney() - 50);
		   			    		  break;
		   			    	  } 
			   		       }
			    		   file.writeFile(userinfo1);
			    		   
			    		   JOptionPane.showMessageDialog(null,"您已经成功购买12次复活机会！");
		    		   }
		    		   else {
		    			   JOptionPane.showMessageDialog(null,"您的金币数不足，购买失败！");
		    		   }
		    	   }
	        });
	        jb2.addActionListener(new ActionListener() { 
		    	   public void actionPerformed(ActionEvent e)  {
		    		   //只有拥有100个金币才能购买30次复活机会
		    		   if(user.getMoney() >= 100) {
		    			   //玩家信息更新
			    		   user.setHeart(user.getHeart() + 30);
			    		   user.setMoney(user.getMoney() - 100);
			    		   
			    		   //保存文件
			    		   DealFile file = new DealFile();
			    		   UserInfo userinfo1 = file.readFile();
			    		   Iterator<User> userIter1 = userinfo1.getUsers();
			   	    	
			   		       while (userIter1.hasNext()) {
			   		    	  User user1 = userIter1.next();
		   			    	  if ( user1.getName().equals(user.getName()) && user1.getPass().equals(user.getPass()) ) {
		   			    		  user1.setHeart(user1.getHeart() + 30);
					    		  user1.setMoney(user1.getMoney() - 100);
		   			    		  break;
		   			    	  } 
			   		       }
			    		   file.writeFile(userinfo1);
			    		   
			    		   JOptionPane.showMessageDialog(null,"您已经成功购买30次复活机会！");
		    		   }
		    		   else {
		    			   JOptionPane.showMessageDialog(null,"您的金币数不足，购买失败！");
		    		   }
		    	   }
	        });
	        jb3.addActionListener(new ActionListener() { 
		    	   public void actionPerformed(ActionEvent e)  {
		    		   //只有拥有500个金币才能购买160次复活机会
		    		   if(user.getMoney() >= 500) {
		    			   //玩家信息更新
			    		   user.setHeart(user.getHeart() + 160);
			    		   user.setMoney(user.getMoney() - 500);
			    		   
			    		   //保存文件
			    		   DealFile file = new DealFile();
			    		   UserInfo userinfo1 = file.readFile();
			    		   Iterator<User> userIter1 = userinfo1.getUsers();
			   	    	
			   		       while (userIter1.hasNext()) {
			   		    	  User user1 = userIter1.next();
		   			    	  if ( user1.getName().equals(user.getName()) && user1.getPass().equals(user.getPass()) ) {
		   			    		  user1.setHeart(user1.getHeart() + 160);
					    		  user1.setMoney(user1.getMoney() - 500);
		   			    		  break;
		   			    	  } 
			   		       }
			    		   file.writeFile(userinfo1);
			    		   
			    		   JOptionPane.showMessageDialog(null,"您已经成功购买160次复活机会！");
		    		   }
		    		   else {
		    			   JOptionPane.showMessageDialog(null,"您的金币数不足，购买失败！");
		    		   }
		    	   }
	        });
		}
		
		if(e.getSource() == jb5) {
			//游戏规则
			JTextArea jta = new JTextArea("亲爱的小主人~您好\t\n"	//定义文本区和滚动条
					+ "这是一个飞机躲避炸弹的小游戏\n"
					+ "您需要按下键盘的左移/右移/\n"
					+ "上移/下移键来控制飞机的飞行\n"
					+ "一旦飞机撞到炸弹，游戏结束\n"
					+ "您将有四个选择：\n"
					+ "1)使用复活机会\n"
					+ "2)花费5个金币复活一次\n"
					+ "3)重新开始\n"
					+ "4)退出游戏\n"
					+ "商店可以花费金币购买复活次数\n"
					+ "定时签到可以增加金币数目\n"
					+ "排行榜可以查看朋友们的战绩\n"
					+ "个人信息用于查看自己的信息\n"
					+ "改密要求包含数字，大小写字母哦\n"
					+ "祝您好运！\n");
			JScrollPane jsp = new JScrollPane(jta);
			JFrame jf = new JFrame();
			jta.setBounds(10,5,250,150);	//设置位置和不可编辑
			jta.setEditable(false);
			jsp.setBounds(10,5,250,150);	//设置位置
			jf.add(jsp);
			
			ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//改变窗口图标
	        jf.setIconImage(imageIcon.getImage()); 
	        jf.setTitle("雷霆战机");//设置标题
	        jf.setSize(300, 200);   //设置大小
	        
	        Container ct = jf.getContentPane();	//设置窗体背景
	        jf.setLayout(null);		
	        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
	        bgp.setBounds(0,0,300,200);
	        ct.add(bgp);
	        
	        jf.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
	        jf.setVisible(true);  //设置可见
		}
		
		if(e.getSource() == jb6) {
		    //亲亲确定要退出游戏嘛？
			//忍痛退出，再玩会儿
			JButton jb1,jb2;
			JLabel jlb1;
			jb1 = new JButton("拜拜"); 	//创建按钮
	        jb2 = new JButton("算了");
			jlb1 = new JLabel("亲亲确定要退出登录嘛？");  //添加标签
			JFrame jf = new JFrame();
			
			jlb1.setFont(new java.awt.Font("黑体",Font.ITALIC,18));	//设置字体和位置
			jlb1.setBounds( 30,20,200,15); 
			jb1.setFont(new java.awt.Font("黑体",Font.ITALIC,15));
			jb1.setBounds( 100,60,90,40);   
			jb2.setFont(new java.awt.Font("黑体",Font.ITALIC,15));
	        jb2.setBounds( 100,110,90,40);
	        
			jf.add(jlb1);	//添加各组件
			jf.add(jb1);
			jf.add(jb2);
			
			ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//改变窗口图标
	        jf.setIconImage(imageIcon.getImage()); 
	        jf.setTitle("雷霆战机");//设置标题
	        jf.setSize(300, 200);   //设置大小
	        
	        Container ct = jf.getContentPane();	//设置窗体背景
	        jf.setLayout(null);		
	        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
	        bgp.setBounds(0,0,300,200);
	        ct.add(bgp);
	        
	        jf.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
	        jf.setVisible(true);  //设置可见
	        
	        //关闭登录界面
	        jb1.addActionListener(new ActionListener() { 
		    	   public void actionPerformed(ActionEvent e)  {
		    		   jf.dispose();
		    		   JF.dispose();
		    	   }
	        });
	        //仅关闭询问界面
	        jb2.addActionListener(new ActionListener() { 
		    	   public void actionPerformed(ActionEvent e)  {
		    		   jf.dispose();
		    	   }
	        });
		}
		
		if(e.getSource() == jb7) {
			//签到
			if(user.getSign() == 1) {
				Date date1 = new Date();
				
				//判断是否已经超过了一分钟
				//超过一分钟更改金币数和新的签到时间
				if(date1.getTime() - user.getDate().getTime() >= 60*1000) {
					user.setMoney(user.getMoney() + 5);
					user.setSign(1);
					user.setDate(date1);
					
					//保存文件
					DealFile file = new DealFile();
		    		UserInfo userinfo1 = file.readFile();
		    		Iterator<User> userIter1 = userinfo1.getUsers();
		   	    	
	   		        while (userIter1.hasNext()) {
	   		        	User user1 = userIter1.next();
	   			    	if ( user1.getName().equals(user.getName()) && user1.getPass().equals(user.getPass()) ) {
	   			    		user1.setMoney(user1.getMoney() + 5);
	   						user1.setSign(1);
	   						user1.setDate(date1);
	   			    		break;
	   			    	} 
	   		        }
	    		    file.writeFile(userinfo1);
					
					JOptionPane.showMessageDialog(null,"签到成功，获得金币5个\n坚持签到可以增加金币数目哦! ");
				}
				else {
					JOptionPane.showMessageDialog(null,"您已经签过到啦，一分钟之后再来吧");
				}
			}
			//尚未签到，记录金币数和当前签到时间
			if(user.getSign() == 0) {
				Date date1 = new Date();
				user.setMoney(user.getMoney() + 5);
				user.setSign(1);
				user.setDate(date1);
				
				//保存文件
				DealFile file = new DealFile();
	    		UserInfo userinfo1 = file.readFile();
	    		Iterator<User> userIter1 = userinfo1.getUsers();
	   	    	
   		        while (userIter1.hasNext()) {
   		        	User user1 = userIter1.next();
		    	    if ( user1.getName().equals(user.getName()) && user1.getPass().equals(user.getPass()) ) {
			    		user1.setMoney(user1.getMoney() + 5);
						user1.setSign(1);
						user1.setDate(date1);
			    		break;
		    	    } 
   		        }
    		    file.writeFile(userinfo1);
				
				JOptionPane.showMessageDialog(null,"签到成功，获得金币5个\n坚持签到可以增加金币数目哦! ");
			}
		}
		
		if(e.getSource() == jb8) {
			//排行榜
			JTextArea jta = new JTextArea();	//定义文本区和滚动条
			JScrollPane jsp = new JScrollPane(jta);
			JFrame jf = new JFrame();
			//读取文件，转换为集合
			//迭代器，冒泡排序法
			UserInfo userinfo1 = file.readFile();
			for(int i = 0; i < userinfo1.getNumOfUsers(); i++) {
				//两两对比，把最低成绩换到后面
		    	for(int j = 0; j < userinfo1.getNumOfUsers() - i - 1; j++) {
						if( userinfo1.getUser(j).getTime() < userinfo1.getUser(j + 1).getTime() ) {
							User usertemp = new User(userinfo1.getUser(j));
							userinfo1.setUser(userinfo1.getUser(j), userinfo1.getUser(j + 1));
							userinfo1.setUser(userinfo1.getUser(j + 1), usertemp);
						}
					}
				}
			jta.setText("名次\t用户名\t成绩s\n");
			for(int i = 0; i < userinfo1.getNumOfUsers(); i++) {
				int j = i + 1;
				jta.setText(jta.getText() + j
						+ "\t" + userinfo1.getUser(i).getName() 
						+ "\t" + userinfo1.getUser(i).getTime() 
						+ "\n");
			}
			jta.setBounds(10,5,250,150);	//设置位置和不可编辑
			jta.setEditable(false);
			jsp.setBounds(10,5,250,150);	//设置位置
			jf.add(jsp);
			
			ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//改变窗口图标
	        jf.setIconImage(imageIcon.getImage()); 
	        jf.setTitle("雷霆战机");//设置标题
	        jf.setSize(300, 200);   //设置大小
	        
	        Container ct = jf.getContentPane();	//设置窗体背景
	        jf.setLayout(null);		
	        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
	        bgp.setBounds(0,0,300,200);
	        ct.add(bgp);
	        
	        jf.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
	        jf.setVisible(true);  //设置可见
		}
		
		if(e.getSource() == jb9) {
			//个人信息
			JTextArea jta = new JTextArea();	//定义文本区和滚动条
			JScrollPane jsp = new JScrollPane(jta);
			JFrame jf = new JFrame();
			jta.setText("用户名\t" + user.getName() + "\n" + "成绩\t" + user.getTime() + "秒\n"
						+ "金币数\t" + user.getMoney() + "\n" + "复活次数\t" + user.getHeart() + "\n"
						+ "签到时间\t" + new Time().getTimeStr(user.getDate()) );
			
			jta.setBounds(10,5,250,150);	//设置位置和不可编辑
			jta.setEditable(false);
			jsp.setBounds(10,5,250,150);
			jf.add(jta);
			
			ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//改变窗口图标
	        jf.setIconImage(imageIcon.getImage()); 
	        jf.setTitle("雷霆战机");//设置标题
	        jf.setSize(300, 200);   //设置大小
	        
	        Container ct = jf.getContentPane();	//设置窗体背景
	        jf.setLayout(null);		
	        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
	        bgp.setBounds(0,0,300,200);
	        ct.add(bgp);
	        
	        jf.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
	        jf.setVisible(true);  //设置可见
		}
		
		if(e.getSource() == jb10) {
			//改密
			JLabel jlb1 = new JLabel("请输入原密码");	//设置标签
			JLabel jlb2 = new JLabel("请输入新密码");	
			JLabel jlb3 = new JLabel("	请再次输入");
			JButton jb1 = new JButton("确定");			//设置按钮
			JButton jb2 = new JButton("重置");
			JPasswordField jpf = new JPasswordField();	//设置密码框
			JTextField jtf1 = new JTextField();			//设置文本框
			JTextField jtf2 = new JTextField();
			JTextArea jta = new JTextArea("密码由大写字母，小写字母和数字组成，共六位\n");		//设置文本区
			JFrame jf = new JFrame();		//设置框架
			
			jlb1.setBounds(10, 5, 100, 25);	//设置位置
	        jpf.setBounds(120, 5, 150, 25);
	        jlb2.setBounds(10, 35, 100, 25);
	        jtf1.setBounds(120, 35, 150, 25);
	        jlb3.setBounds(10, 65, 100, 25);
	        jtf2.setBounds(120, 65, 150, 25);
	        jb1.setBounds(70, 100, 80, 40);
	        jb2.setBounds(160, 100, 80, 40);
			
	        jf.add(jlb1);	//添加各组件
	        jf.add(jpf);
	        jf.add(jlb2);
	        jf.add(jtf1);
	        jf.add(jlb3);
	        jf.add(jtf2);
	        jf.add(jb1);
	        jf.add(jb2);
	        
	        ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//改变窗口图标
	        jf.setIconImage(imageIcon.getImage());  
	        jf.setTitle("雷霆战机");//设置标题
	        jf.setSize(300, 200);   //设置大小
	        
	        Container ct = jf.getContentPane();	//设置窗体背景
	        jf.setLayout(null);		
	        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
	        bgp.setBounds(0,0,300,200);
	        ct.add(bgp);
	        
	        jf.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
	        jf.setVisible(true);  //设置可见
	   	     	   	     
	   	    jb1.addActionListener(new ActionListener() { // 设置确定按钮监听器
				public void actionPerformed(ActionEvent e) {
				  //原密码正确
   		    	  if ( jpf.getText().equals(user.getPass()) ) {
   		    		  	  //新密码符合要求且不和原密码相同
   		    			  if(check1(jtf1.getText()) == true && check2(jtf1.getText()) == true 
   		    					  && check3(jtf1.getText()) == true && jtf1.getText().equals(jtf2.getText())
   		    					  && !jtf1.getText().equals(user.getPass())) {
   		    				  user.setPass(jtf1.getText()); 
   		    				  
   		    				  //保存文件
	   		   				  DealFile file = new DealFile();
	   		   				  UserInfo userinfo1 = file.readFile();
	   		   	    		  Iterator<User> userIter1 = userinfo1.getUsers();
	   		   	   	    	
	   		      		         while (userIter1.hasNext()) {
	   		      		        	 User user1 = userIter1.next();
		   		   		    	     if ( user1.getName().equals(user.getName()) ) {
		   		   			    		user1.setPass(jtf1.getText()); 
		   		   		    	     } 
	   		      		         }
	   		      		      file.writeFile(userinfo1);
	   		      		     
	   		      		      //获取数据库信息
	   		      	  		  //SQL语句 
	   		      	  		  String sql = "select * from userdata"; 
	   		      	  		  //创建DataBase对象
	   		      	  		  DataBase db1 = new DataBase(sql);
	   		      	  		  //修改数据库密码
	   		      	  		  db1.modify(user.getName(), jtf1.getText());
	   		      	        
   		    				  JOptionPane.showMessageDialog(null,"改密成功，下次登录请输入新密码！");
   		    				  jf.dispose();
   		    			  }
   		    			  else{
   		    				  //提示玩家密码错误信息
   		    				  if (check1(jtf1.getText()) != true)
   		    					  JOptionPane.showMessageDialog(null,"密码必须包含小写字母!");
	   		    			  if (check2(jtf1.getText()) != true)
	   		    				  JOptionPane.showMessageDialog(null,"密码必须包含大写字母!");
	   		    			  if (check3(jtf1.getText()) != true) 
	   		    				  JOptionPane.showMessageDialog(null,"密码必须包含数字!");
	   		    			  if (!jtf1.getText().equals(jtf2.getText()))
	   		    				  JOptionPane.showMessageDialog(null,"密码不同，请重新输入!");
	   		    			  if (jtf1.getText().equals(user.getPass()))
	   		    				JOptionPane.showMessageDialog(null,"新密码不能与原密码相同!");
		   		    	 }
		   		    }
   		    	    else {
   		    	    	JOptionPane.showMessageDialog(null,"原密码不正确!");
   		    	    }
				}
				//检验密码是否符合要求的函数
				//小写字母
		  		public boolean check1(String pw1) {
		  			int num = 0;
			    	for(int i = 0; i < pw1.length(); i++) {
			             if (pw1.charAt(i) <= 'z' && pw1.charAt(i) >= 'a') {
			             	num++;
			             } 
			    	}
			    	if(num > 0)
			    		return true;
			        else 
			            return false;
		  		}
		  		//大写字母
		  		public boolean check2(String pw1) {
		  			int num = 0;
			    	for(int i = 0; i < pw1.length(); i++) {
			    		if (pw1.charAt(i) <= 'Z' && pw1.charAt(i) >= 'A') {
			             	num++;
			             } 
			    	}
			    	if(num > 0)
			    		return true;
			        else 
			            return false;
		  		}
		  		//数字
		  		public boolean check3(String pw1) {
		  			int num = 0;
			    	for(int i = 0; i < pw1.length(); i++) {
			    		if (pw1.charAt(i) <= '9' && pw1.charAt(i) >= '0') {
			    			num++;
			             } 
			    	}
			    	if(num > 0)
			    		return true;
			        else 
			            return false;
		  		}
	   	     });
		   	 jb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//清空改密信息
					jpf.setText("");
					jtf1.setText("");
					jtf2.setText("");
				}
		   	 });
		}
	}
}
