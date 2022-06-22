package client;

/**
 * 这是游戏的第一个界面，有登录，注册，退出游戏三个功能
 */

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.MalformedURLException;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import image.BackgroundPanel;

public class MainClient extends JFrame implements ActionListener, Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton jb1,jb2,jb3;	//声明各组件
	JLabel jlb1,jlb2,jlb3;
	ImageIcon background;
	BackgroundPanel bgp;
	AudioClip ac;
	
	public MainClient() {
		
		//设置背景音乐
	    try {          
	    	ac = Applet.newAudioClip((new File("D:\\JAVA\\ThunderFight\\TroubleMaker.wav")).toURL());          
	    	ac.loop();      
	    } catch (MalformedURLException e) {        
	    	e.printStackTrace();      
	    }
	    
	 	Font f = new Font("Helvetica", Font.BOLD, 60);	//定义字体
	 	Font f1 = new Font("Helvetica", Font.BOLD, 25);
	 	
	 	jlb1 = new JLabel("欢迎来到");	//定义标签
	 	jlb2 = new JLabel("雷霆世界!");
	 	jlb3 = new JLabel("适度游戏益脑，沉迷游戏伤身，要合理安排时间嗷！");
	 	jlb1.setBounds( 200,80,300,100); 	//设置位置
	 	jlb2.setBounds( 300,190,300,100); 
	 	jlb3.setBounds( 10,10,750,25); 
        jlb1.setFont(f);		//设置颜色和字体
        jlb1.setForeground(Color.red);		
        jlb2.setFont(f);
        jlb2.setForeground(Color.red);
        jlb3.setFont(f1);
        jlb3.setForeground(Color.WHITE);
        
		jb1 = new JButton("登录"); 	//创建按钮
        jb2 = new JButton("注册");
        jb3 = new JButton("退出游戏");
        jb1.setBounds( 320,350,90,60);   
        jb2.setBounds( 320,425,90,60);
        jb3.setBounds( 320,500,90,60);
        
        jb1.addActionListener(this);	//设置监听器
        jb2.addActionListener(this);
        jb3.addActionListener(this);
      
        this.add(jlb1); 	//添加组件
        this.add(jlb2);
        this.add(jlb3);
        this.add(jb1);  
        this.add(jb2);  
        this.add(jb3); 
        
        ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//改变窗口图标
        this.setIconImage(imageIcon.getImage());  
        this.setTitle("雷霆战机");//设置标题
        this.setSize(800, 650);   //设置大小
        this.setLayout(null);     //设置布局
             
        Container ct = this.getContentPane();	//设置窗体背景
        this.setLayout(null);
        bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back1.jpg")).getImage());
        bgp.setBounds(0,0,800,650);
        ct.add(bgp);
   	
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
        this.setVisible(true);  //设置可见
	}
	
	//监听器
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			//登录界面
			new Login(ac);
		}
		if(e.getSource() == jb2) {
			//注册界面
		    new Sign(ac);
		}
		if(e.getSource() == jb3) {
		    //亲亲确定要退出游戏嘛？
			//忍痛退出，再玩会儿
			JButton jb1,jb2;
			JLabel jlb1;
			jb1 = new JButton("拜拜"); 	//创建按钮
	        jb2 = new JButton("算了");
			jlb1 = new JLabel("亲亲确定要退出游戏嘛？");  //添加标签
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
	        
	        Container ct = jf.getContentPane();		//设置窗体背景
	        jf.setLayout(null);		
	        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
	        bgp.setBounds(0,0,300,200);
	        ct.add(bgp);
	        
	        jf.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
	        jf.setVisible(true);  //设置可见
	        
	        jb1.addActionListener(new ActionListener() { //退出游戏
		    	   public void actionPerformed(ActionEvent e)  {
		    		   System.exit(0);
		    	   }
	        });
	        jb2.addActionListener(new ActionListener() { 	//放弃退出
		    	   public void actionPerformed(ActionEvent e)  {
		    		   jf.dispose();
		    	   }
	        });
		}
	}
    
	public static void main(String[] args) {
	    MainClient mc = new MainClient();
	    //开启客户端线程
	    new Thread(mc).start();
	}

	public void run() {
		// TODO Auto-generated method stub
	}
}
