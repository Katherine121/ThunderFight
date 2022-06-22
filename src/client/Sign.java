package client;

/**
 *注册类，检验输入的密码是否符合格式，
 * 如果正确，则将注册信息发送给服务端，由服务端增加新用户信息
 * 如果不正确，则弹出提示框提醒重新输入
 */

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.applet.AudioClip;
import image.*;

public class Sign implements ActionListener {

	JButton jb1,jb2;	//定义各组件
	JLabel jlb1,jlb2,jlb3;
	JTextField jtf1,jtf2,jtf3;
	JPasswordField jpf1;
	JPanel jp1,jp2,jp3,jp4;
	JFrame jf;
	
	// 初始化 socket 和 streams
	Socket connection = null;
	PrintStream out = null;
	BufferedReader in = null;
	InetAddress server;
		
	public Sign(AudioClip ac) {
		
		//继续播放
		//ac.loop();
		
		jb1 = new JButton("确定"); 	//创建按钮
        jb2 = new JButton("重置");
        
        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jlb1 = new JLabel("请输入新用户名");  //添加标签
        jlb2 = new JLabel("请输入密码");
        jlb3 = new JLabel("请再次输入密码");

        jtf1 = new JTextField(10);   //创建文本框和密码框
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
        jf = new JFrame();		
        
        jlb1.setBounds(10, 5, 100, 25);	//设置位置
        jtf1.setBounds(120, 5, 150, 25);
        jlb2.setBounds(10, 35, 100, 25);
        jtf2.setBounds(120, 35, 150, 25);
        jlb3.setBounds(10, 65, 100, 25);
        jtf3.setBounds(120, 65, 150, 25);
        jb1.setBounds(70, 100, 80, 40);
        jb2.setBounds(160, 100, 80, 40);
        
        jf.add(jlb1);	//添加各组件
        jf.add(jtf1);
        jf.add(jlb2);
        jf.add(jtf2);
        jf.add(jlb3);
        jf.add(jtf3);
        jf.add(jb1);
        jf.add(jb2);
        
        jb1.addActionListener(this);	//设置监听器
        jb2.addActionListener(this);
      
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
        
        // 连接端口2019
	      try {
	  		connection = new Socket("127.0.0.1", 2019);
	  		server = connection.getInetAddress();
	  		System.out.println("连接成功,端口号为" + connection.getPort());
	  	} catch (IOException e) {
	  		e.printStackTrace();
	  	}
	  	
	  	// 初始化socket的输入输出流
	  	try {
	  		out = new PrintStream(connection.getOutputStream());
	  		in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	  	} catch (IOException ioe) {
	  		ioe.printStackTrace();
	  	}
	}
	
	//监听器
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			try {
				//密码符合要求则将注册信息发送给服务端
				if( check1(jtf2.getText()) == true && check2(jtf2.getText()) == true
						&& check3(jtf2.getText()) == true && jtf2.getText().equals(jtf3.getText())) {
					
					out.println("sign");
					out.println(jtf1.getText());
					out.println(jtf2.getText());
					//收到服务端返回的消息
					String result = in.readLine();
					JOptionPane.showMessageDialog(null,result);
					if(result.equals("注册成功!"))
						jf.dispose();
					
				}
				else {
					//提示玩家密码错误信息
					  if (check1(jtf2.getText()) != true)
	    				  JOptionPane.showMessageDialog(null,"密码必须包含小写字母!");
		    			 
	    			  if (check2(jtf2.getText()) != true)
	    				  JOptionPane.showMessageDialog(null,"密码必须包含大写字母!");
	    			  
	    			  if (check3(jtf2.getText()) != true)
	    				  JOptionPane.showMessageDialog(null,"密码必须包含数字!");
	    			  
	    			  if (!jtf2.getText().equals(jtf3.getText()))
	    				  JOptionPane.showMessageDialog(null,"密码不同，请重新输入!");
				}
				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		//清空注册信息
		if(e.getSource() == jb2) {
		    jtf1.setText("");
		    jtf2.setText("");
		    jtf3.setText("");
		}	
	}

	//检验密码是否符合要求函数
	//包含数字
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
	//包含大写字母
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
	//包含小写字母
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
}
