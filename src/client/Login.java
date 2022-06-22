package client;
/**
 *登录类，检验输入的用户名和密码是否正确，
 * 如果正确，则跳转到主用户界面
 * 如果不正确，则弹出提示框提醒重新输入
 */

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.applet.AudioClip;
import javax.swing.*;
import file.*;
import image.*;

public class Login implements ActionListener {
	
	JButton jb1,jb2;	//定义各组件
	JLabel jlb1,jlb2;
	JTextField jtf1;
	JPasswordField jpf1;
	JFrame jf;
	
	public Login(AudioClip ac) {
		
		//继续播放
		//ac.loop();
	    
		jb1 = new JButton("确定"); 	//创建按钮
        jb2 = new JButton("重置");
        
        jlb1 = new JLabel("用户名");  //添加标签
        jlb2 = new JLabel("密码");

        jtf1 = new JTextField(10);   //创建文本框和密码框
        jpf1 = new JPasswordField(10);
        jf = new JFrame();		
        
        jlb1.setBounds(30, 20, 50, 25);	//设置位置
        jtf1.setBounds(100, 20, 150, 25);
        jlb2.setBounds(30, 50, 50, 25);
        jpf1.setBounds(100, 50, 150, 25);
        jb1.setBounds(70, 100, 80, 40);
        jb2.setBounds(160, 100, 80, 40);
        
        jf.add(jlb1);		//添加各组件
        jf.add(jtf1);
        jf.add(jlb2);
        jf.add(jpf1);
        jf.add(jb1);
        jf.add(jb2);
        
        jb1.addActionListener(this); //设置监听器
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
	}
	
	//监听器
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			try {
				if(check(jtf1.getText(), jpf1.getText()) == true) {
					JOptionPane.showMessageDialog(null, "登录成功!");
					//关闭登录界面，跳转到用户主界面
					jf.dispose();
					UserGUI uc = new UserGUI(jtf1.getText(), jpf1.getText());
				}
				else {
		    		JOptionPane.showMessageDialog(null,"账号或者密码错误!");
		    		//清空登录信息
		    		jtf1.setText("");
				    jpf1.setText("");
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		//清空登录信息
		if(e.getSource() == jb2) {
		    jtf1.setText("");
		    jpf1.setText("");
		}
	}
	
    //检验函数，检验用户输入的卡号和密码是否正确
  	public boolean check(String na,String pw) {
  		//获取数据库信息
  		//SQL语句 
  		String sql = "select * from userdata"; 
  		//创建DataBase对象
    	DataBase db1 = new DataBase(sql);
        try {  
        	//执行语句，得到结果集 
        	ResultSet ret = db1.pst.executeQuery();
        	//依次对比用户信息
        	while (ret.next()) {  
                String name = ret.getString(1);  
                String pass = ret.getString(2);
                if(na.equals(name) && pw.contentEquals(pass)) {
                	//找到相应的用户
                	return true;
                }
            }
            ret.close(); 
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
	    
	    return false;
    }
}
