package client;

/**
 * 游戏界面
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import file.*;
import image.*;
import object.*;
import server.*;

public class GameGUI extends JFrame {
    
    private Image sky = GetImage.getImage("image/sky.jpg");  //导入天空和飞机
    private Image planeImg = GetImage.getImage("image/plane.png");
    private Image offScreenImage = null;
    
    private Plane plane = new Plane(planeImg, 400, 400);  //新建一个飞机类
    private Shell[] shells;    //新建一个炮弹类
    private Explode bao;  //声明一下爆炸类
    private int shellnum;
    
    DealFile file;		//玩家信息
    UserInfo userinfo;
	Iterator<User> userIter;
    User user;
    
    private Date startTime = new Date();    //游戏开始时间
    private Date endTime;               //声明游戏结束时间
    private int contime;  				//游戏持续的时间
    private Date stopdate1;				//游戏暂停开始时间
    private Date stopdate2;				//游戏暂停结束时间
    private long stoptime = 0L;			//游戏暂停持续时间
    private boolean flag = true;		//是否继续玩的标志
    private boolean better = false;		//成绩是否破纪录的标志
    
    public GameGUI(User user, int shellnum) {
    	
    	//获得玩家信息
    	file = new DealFile();
		userinfo = file.readFile();
		userIter = userinfo.getUsers();
	    	
	    while (userIter.hasNext()) {
	    	  User user1 = userIter.next();
	    	  if ( user1.getName().equals(user.getName()) ) {
	    		  this.user = user1;
	    		  break;
	    	  } 
	    }
		this.shellnum = shellnum; 
    	ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//改变窗口图标
        this.setIconImage(imageIcon.getImage());  
    	this.setTitle("雷霆战机");    //设置标题
        this.setSize(800, 650);    //设置大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
        this.setVisible(true);  //设置可见
        
        new PaintThread().start();    //启动反复重画窗口，实现动画的效果
        this.addKeyListener(new KeyMonitor());    //给窗口增加键盘监听
        
        //初始化炮弹类
        shells = new Shell[this.shellnum];
        for(int i = 0; i < shells.length; i++) {
            shells[i] = new Shell();
        }
    }
    
    //自动被调用
    public void paint(Graphics g) {  
    	
        g.drawImage(sky, 0, 0, null);	//画天空背景
        plane.drawSelf(g);  //画飞机
        
        if(flag == true) {
	        for(int i = 0; i < shells.length; i++) {
	            shells[i].draw(g);     //画炮弹    
	            boolean peng = shells[i].getRect().intersects(plane.getRect());     //矩形检测，判断炮弹和飞机是否碰上
	           
	            if(peng) {
	                if(bao == null) {    //使第一次碰上触发爆炸效果，而不是在重叠的同时触发多次
	                    bao = new Explode(plane.getX(), plane.getY());    //新建一个爆炸类，在飞机所在位置触发爆炸效果
	                    bao.draw(g);    //调用draw方法，触发爆炸效果   
	                }
		            endTime = new Date();  //获取游戏结束时间
		            contime = (int)( ( endTime.getTime() - startTime.getTime() ) / 1000 - stoptime);    //得到游戏持续时间
		            
		            //判断是否破纪录并修改玩家信息，保存在文件中
		            if(contime > user.getTime()) {
		            	user.setTime(contime);
		            	file.writeFile(userinfo);
		            	better = true;
		            }
		            //改变游戏进行状态
	                flag = false;
	                //开始暂停
	                stopdate1 = new Date();
	            }
	        }
            if(flag == false) {
            	
            	JButton jb1,jb2,jb3,jb4;	//定义各组件
    			JLabel jlb1,jlb2;
    			//根据破纪录情况给玩家相应的反馈
    			if(better == true) {
    				jlb1 = new JLabel(contime + "秒！恭喜你破纪录啦");
    			}
    			else {
    				jlb1 = new JLabel(contime + "秒！很遗憾没有破纪录");
    			}
    			
    			jlb2 = new JLabel("亲亲还想再玩一次嘛？");  //添加标签
    			jb1 = new JButton("使用复活机会");	//创建按钮
    			jb2 = new JButton("5金币复活"); 	
    			jb3 = new JButton("再玩一次"); 	
    	        jb4 = new JButton("不想玩了");
    			JFrame jf = new JFrame();
    			
    			jlb1.setFont(new java.awt.Font("黑体",Font.ITALIC,18));	//设置字体和位置
    			jlb1.setBounds( 50,10,200,20); 
    			jlb2.setFont(new java.awt.Font("黑体",Font.ITALIC,18));
    			jlb2.setBounds( 50,40,200,20); 
    			jb1.setFont(new java.awt.Font("黑体",Font.ITALIC,20));
    			jb1.setBounds( 100,80,180,30);   
    			jb2.setFont(new java.awt.Font("黑体",Font.ITALIC,20));
    	        jb2.setBounds( 100,120,180,30);
    	        jb3.setFont(new java.awt.Font("黑体",Font.ITALIC,20));
    	        jb3.setBounds( 100,160,180,30);
    	        jb4.setFont(new java.awt.Font("黑体",Font.ITALIC,20));
    	        jb4.setBounds( 100,200,180,30);
    	        
    			jf.add(jlb1);	//添加各组件
    			jf.add(jlb2);
    			jf.add(jb1);
    			jf.add(jb2);
    			jf.add(jb3);
    			jf.add(jb4);
    			
    			ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//改变窗口图标
    	        jf.setIconImage(imageIcon.getImage()); 
    	        jf.setTitle("雷霆战机");//设置标题
    	        jf.setSize(400, 300);   //设置大小
    	        
    	        Container ct = jf.getContentPane();	//设置窗体背景
    	        jf.setLayout(null);		
    	        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
    	        bgp.setBounds(0,0,400,300);
    	        ct.add(bgp);
    	        
    	        jf.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
    	        jf.setVisible(true);  //设置可见
    	        
    	        //选择使用复活机会
    	        jb1.addActionListener(new ActionListener() { 
 		    	   public void actionPerformed(ActionEvent e)  {
 		    		    //判断还有没有复活机会
 		    		   	if(user.getHeart() > 0 ) {
 		    		   	   //关闭界面
 		    		   	   jf.dispose();
 		    		   	   //初始化飞机，炮弹
 		            	   plane = new Plane(planeImg, 50 + (int)(Math.random() * 500), 50 + (int)(Math.random() * 500));
 			    		   bao = null;
 			    		   //修改复活次数，重写文件
 			    		   user.setHeart(user.getHeart() - 1);
 			    		   file.writeFile(userinfo);
 			    		   //停止暂停状态
 			    		   stopdate2 = new Date();
 			    		   //计算暂停时间
 			    		   stoptime = stoptime + (stopdate2.getTime() - stopdate1.getTime())  / 1000;
 			    		   //继续玩
 			    		   flag = true;
 		            	}
 		            	else {
 		            	   //提示玩家不能复活
 		            	   JOptionPane.showMessageDialog(null,"您的复活次数不足！");
 		            	}
 		    	   }
    	        });
    	        
    	        //选择使用5个金币复活
    	        jb2.addActionListener(new ActionListener() { 
 		    	   public void actionPerformed(ActionEvent e)  {
 		    		   //判断有没有5个金币
 		    		   if(user.getMoney() >= 5) {
 		    			   //关闭界面
	 		    		   jf.dispose();
	 		    		   //初始化飞机，炮弹
	 		    		   plane = new Plane(planeImg, 50 + (int)(Math.random() * 500), 50 + (int)(Math.random() * 500));
			    		   bao = null;
			    		   //修改金币数，重写文件
			    		   user.setMoney(user.getMoney() - 5);
			    		   file.writeFile(userinfo);
			    		   //停止暂停状态
			    		   stopdate2 = new Date();
			    		   //计算暂停时间
 			    		   stoptime = stoptime + (stopdate2.getTime() - stopdate1.getTime()) / 1000;
 			    		   //继续玩
			    		   flag = true;
 		    		   }
 		    		   else {
 		    			   //提示玩家不能复活
 		    			   JOptionPane.showMessageDialog(null,"您的金币数不足！");
 		    		   }
 		    	   }
    	        });
    	        
    	        //选择重新开始
    	        jb3.addActionListener(new ActionListener() { 
    		    	   public void actionPerformed(ActionEvent e)  {
    		    		   //关闭界面
    		    		   jf.dispose();
    		    		   //初始化飞机，炮弹
    		    		   plane = new Plane(planeImg, 400, 400);
    		    		   shells = new Shell[shellnum];
    		    	        for(int i = 0; i < shells.length; i++) {
    		    	            shells[i] = new Shell();
    		    	        }
    		    		   bao = null;
    		    		   //重新开始游戏时间
    		    		   startTime = new Date();
    		    		   //清零暂停时间
    		    		   stoptime = 0L;
    		    		   //继续玩
    		    		   better = false;
    		    		   flag = true;
    		    	   }
    	        });
    	        
    	        //选择不玩了
    	        jb4.addActionListener(new ActionListener() { 
 		    	   public void actionPerformed(ActionEvent e)  {
 		    		   //关闭界面
 		    		   jf.dispose();
 		    		   //不玩了
 		    		   better = false;
 		    		   flag = false;
 		    	   }
    	        });
    	    }
        }
    }
    
    //返回更新的用户信息
    public User getUser() {
    	return this.user;
    }
    
    //帮助我们反复重画窗口
    class PaintThread extends Thread{
        
        //重写run方法，实现窗口重画
        public void run() {
            while(true) {
            	//重画
                repaint();
                //程序睡眠
                try {
                    Thread.sleep(40);  //游戏画质：40帧
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //定义键盘监听内部类
    class KeyMonitor extends KeyAdapter{
        //重写keyPressed类，显示飞机运行轨迹
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
            System.out.println("下降" + e.getExtendedKeyCode());
        }

        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
            System.out.println("上升" + e.getExtendedKeyCode());
        }
    }
    
    /*
         * 添加双缓存技术，解决游戏画面闪烁问题
         * 在内存中创建与画布一致的缓冲区
         * 在缓冲区画图
         * 将缓冲区位图复制到当前画布上
         * 释放内存缓冲区
     */
    public void update(Graphics g) {
        if(offScreenImage == null)
        	//新建一个图像缓存空间,宽度和高度是800*650
            offScreenImage = this.createImage(800, 650);
        //把它的画笔拿过来,由gImage保存
        Graphics gOff = offScreenImage.getGraphics();
        //将要画的东西画到图像缓存空间去 
        paint(gOff);
        //然后一次性显示出来 
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
