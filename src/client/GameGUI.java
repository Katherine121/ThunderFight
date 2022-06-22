package client;

/**
 * ��Ϸ����
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
    
    private Image sky = GetImage.getImage("image/sky.jpg");  //������պͷɻ�
    private Image planeImg = GetImage.getImage("image/plane.png");
    private Image offScreenImage = null;
    
    private Plane plane = new Plane(planeImg, 400, 400);  //�½�һ���ɻ���
    private Shell[] shells;    //�½�һ���ڵ���
    private Explode bao;  //����һ�±�ը��
    private int shellnum;
    
    DealFile file;		//�����Ϣ
    UserInfo userinfo;
	Iterator<User> userIter;
    User user;
    
    private Date startTime = new Date();    //��Ϸ��ʼʱ��
    private Date endTime;               //������Ϸ����ʱ��
    private int contime;  				//��Ϸ������ʱ��
    private Date stopdate1;				//��Ϸ��ͣ��ʼʱ��
    private Date stopdate2;				//��Ϸ��ͣ����ʱ��
    private long stoptime = 0L;			//��Ϸ��ͣ����ʱ��
    private boolean flag = true;		//�Ƿ������ı�־
    private boolean better = false;		//�ɼ��Ƿ��Ƽ�¼�ı�־
    
    public GameGUI(User user, int shellnum) {
    	
    	//��������Ϣ
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
    	ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//�ı䴰��ͼ��
        this.setIconImage(imageIcon.getImage());  
    	this.setTitle("����ս��");    //���ñ���
        this.setSize(800, 650);    //���ô�С
        this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����
        this.setVisible(true);  //���ÿɼ�
        
        new PaintThread().start();    //���������ػ����ڣ�ʵ�ֶ�����Ч��
        this.addKeyListener(new KeyMonitor());    //���������Ӽ��̼���
        
        //��ʼ���ڵ���
        shells = new Shell[this.shellnum];
        for(int i = 0; i < shells.length; i++) {
            shells[i] = new Shell();
        }
    }
    
    //�Զ�������
    public void paint(Graphics g) {  
    	
        g.drawImage(sky, 0, 0, null);	//����ձ���
        plane.drawSelf(g);  //���ɻ�
        
        if(flag == true) {
	        for(int i = 0; i < shells.length; i++) {
	            shells[i].draw(g);     //���ڵ�    
	            boolean peng = shells[i].getRect().intersects(plane.getRect());     //���μ�⣬�ж��ڵ��ͷɻ��Ƿ�����
	           
	            if(peng) {
	                if(bao == null) {    //ʹ��һ�����ϴ�����ըЧ�������������ص���ͬʱ�������
	                    bao = new Explode(plane.getX(), plane.getY());    //�½�һ����ը�࣬�ڷɻ�����λ�ô�����ըЧ��
	                    bao.draw(g);    //����draw������������ըЧ��   
	                }
		            endTime = new Date();  //��ȡ��Ϸ����ʱ��
		            contime = (int)( ( endTime.getTime() - startTime.getTime() ) / 1000 - stoptime);    //�õ���Ϸ����ʱ��
		            
		            //�ж��Ƿ��Ƽ�¼���޸������Ϣ���������ļ���
		            if(contime > user.getTime()) {
		            	user.setTime(contime);
		            	file.writeFile(userinfo);
		            	better = true;
		            }
		            //�ı���Ϸ����״̬
	                flag = false;
	                //��ʼ��ͣ
	                stopdate1 = new Date();
	            }
	        }
            if(flag == false) {
            	
            	JButton jb1,jb2,jb3,jb4;	//��������
    			JLabel jlb1,jlb2;
    			//�����Ƽ�¼����������Ӧ�ķ���
    			if(better == true) {
    				jlb1 = new JLabel(contime + "�룡��ϲ���Ƽ�¼��");
    			}
    			else {
    				jlb1 = new JLabel(contime + "�룡���ź�û���Ƽ�¼");
    			}
    			
    			jlb2 = new JLabel("���׻�������һ���");  //��ӱ�ǩ
    			jb1 = new JButton("ʹ�ø������");	//������ť
    			jb2 = new JButton("5��Ҹ���"); 	
    			jb3 = new JButton("����һ��"); 	
    	        jb4 = new JButton("��������");
    			JFrame jf = new JFrame();
    			
    			jlb1.setFont(new java.awt.Font("����",Font.ITALIC,18));	//���������λ��
    			jlb1.setBounds( 50,10,200,20); 
    			jlb2.setFont(new java.awt.Font("����",Font.ITALIC,18));
    			jlb2.setBounds( 50,40,200,20); 
    			jb1.setFont(new java.awt.Font("����",Font.ITALIC,20));
    			jb1.setBounds( 100,80,180,30);   
    			jb2.setFont(new java.awt.Font("����",Font.ITALIC,20));
    	        jb2.setBounds( 100,120,180,30);
    	        jb3.setFont(new java.awt.Font("����",Font.ITALIC,20));
    	        jb3.setBounds( 100,160,180,30);
    	        jb4.setFont(new java.awt.Font("����",Font.ITALIC,20));
    	        jb4.setBounds( 100,200,180,30);
    	        
    			jf.add(jlb1);	//��Ӹ����
    			jf.add(jlb2);
    			jf.add(jb1);
    			jf.add(jb2);
    			jf.add(jb3);
    			jf.add(jb4);
    			
    			ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//�ı䴰��ͼ��
    	        jf.setIconImage(imageIcon.getImage()); 
    	        jf.setTitle("����ս��");//���ñ���
    	        jf.setSize(400, 300);   //���ô�С
    	        
    	        Container ct = jf.getContentPane();	//���ô��屳��
    	        jf.setLayout(null);		
    	        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
    	        bgp.setBounds(0,0,400,300);
    	        ct.add(bgp);
    	        
    	        jf.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
    	        jf.setVisible(true);  //���ÿɼ�
    	        
    	        //ѡ��ʹ�ø������
    	        jb1.addActionListener(new ActionListener() { 
 		    	   public void actionPerformed(ActionEvent e)  {
 		    		    //�жϻ���û�и������
 		    		   	if(user.getHeart() > 0 ) {
 		    		   	   //�رս���
 		    		   	   jf.dispose();
 		    		   	   //��ʼ���ɻ����ڵ�
 		            	   plane = new Plane(planeImg, 50 + (int)(Math.random() * 500), 50 + (int)(Math.random() * 500));
 			    		   bao = null;
 			    		   //�޸ĸ����������д�ļ�
 			    		   user.setHeart(user.getHeart() - 1);
 			    		   file.writeFile(userinfo);
 			    		   //ֹͣ��ͣ״̬
 			    		   stopdate2 = new Date();
 			    		   //������ͣʱ��
 			    		   stoptime = stoptime + (stopdate2.getTime() - stopdate1.getTime())  / 1000;
 			    		   //������
 			    		   flag = true;
 		            	}
 		            	else {
 		            	   //��ʾ��Ҳ��ܸ���
 		            	   JOptionPane.showMessageDialog(null,"���ĸ���������㣡");
 		            	}
 		    	   }
    	        });
    	        
    	        //ѡ��ʹ��5����Ҹ���
    	        jb2.addActionListener(new ActionListener() { 
 		    	   public void actionPerformed(ActionEvent e)  {
 		    		   //�ж���û��5�����
 		    		   if(user.getMoney() >= 5) {
 		    			   //�رս���
	 		    		   jf.dispose();
	 		    		   //��ʼ���ɻ����ڵ�
	 		    		   plane = new Plane(planeImg, 50 + (int)(Math.random() * 500), 50 + (int)(Math.random() * 500));
			    		   bao = null;
			    		   //�޸Ľ��������д�ļ�
			    		   user.setMoney(user.getMoney() - 5);
			    		   file.writeFile(userinfo);
			    		   //ֹͣ��ͣ״̬
			    		   stopdate2 = new Date();
			    		   //������ͣʱ��
 			    		   stoptime = stoptime + (stopdate2.getTime() - stopdate1.getTime()) / 1000;
 			    		   //������
			    		   flag = true;
 		    		   }
 		    		   else {
 		    			   //��ʾ��Ҳ��ܸ���
 		    			   JOptionPane.showMessageDialog(null,"���Ľ�������㣡");
 		    		   }
 		    	   }
    	        });
    	        
    	        //ѡ�����¿�ʼ
    	        jb3.addActionListener(new ActionListener() { 
    		    	   public void actionPerformed(ActionEvent e)  {
    		    		   //�رս���
    		    		   jf.dispose();
    		    		   //��ʼ���ɻ����ڵ�
    		    		   plane = new Plane(planeImg, 400, 400);
    		    		   shells = new Shell[shellnum];
    		    	        for(int i = 0; i < shells.length; i++) {
    		    	            shells[i] = new Shell();
    		    	        }
    		    		   bao = null;
    		    		   //���¿�ʼ��Ϸʱ��
    		    		   startTime = new Date();
    		    		   //������ͣʱ��
    		    		   stoptime = 0L;
    		    		   //������
    		    		   better = false;
    		    		   flag = true;
    		    	   }
    	        });
    	        
    	        //ѡ������
    	        jb4.addActionListener(new ActionListener() { 
 		    	   public void actionPerformed(ActionEvent e)  {
 		    		   //�رս���
 		    		   jf.dispose();
 		    		   //������
 		    		   better = false;
 		    		   flag = false;
 		    	   }
    	        });
    	    }
        }
    }
    
    //���ظ��µ��û���Ϣ
    public User getUser() {
    	return this.user;
    }
    
    //�������Ƿ����ػ�����
    class PaintThread extends Thread{
        
        //��дrun������ʵ�ִ����ػ�
        public void run() {
            while(true) {
            	//�ػ�
                repaint();
                //����˯��
                try {
                    Thread.sleep(40);  //��Ϸ���ʣ�40֡
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //������̼����ڲ���
    class KeyMonitor extends KeyAdapter{
        //��дkeyPressed�࣬��ʾ�ɻ����й켣
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
            System.out.println("�½�" + e.getExtendedKeyCode());
        }

        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
            System.out.println("����" + e.getExtendedKeyCode());
        }
    }
    
    /*
         * ���˫���漼���������Ϸ������˸����
         * ���ڴ��д����뻭��һ�µĻ�����
         * �ڻ�������ͼ
         * ��������λͼ���Ƶ���ǰ������
         * �ͷ��ڴ滺����
     */
    public void update(Graphics g) {
        if(offScreenImage == null)
        	//�½�һ��ͼ�񻺴�ռ�,��Ⱥ͸߶���800*650
            offScreenImage = this.createImage(800, 650);
        //�����Ļ����ù���,��gImage����
        Graphics gOff = offScreenImage.getGraphics();
        //��Ҫ���Ķ�������ͼ�񻺴�ռ�ȥ 
        paint(gOff);
        //Ȼ��һ������ʾ���� 
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
