package client;

/**
 * ������Ϸ�ĵ�һ�����棬�е�¼��ע�ᣬ�˳���Ϸ��������
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
	JButton jb1,jb2,jb3;	//���������
	JLabel jlb1,jlb2,jlb3;
	ImageIcon background;
	BackgroundPanel bgp;
	AudioClip ac;
	
	public MainClient() {
		
		//���ñ�������
	    try {          
	    	ac = Applet.newAudioClip((new File("D:\\JAVA\\ThunderFight\\TroubleMaker.wav")).toURL());          
	    	ac.loop();      
	    } catch (MalformedURLException e) {        
	    	e.printStackTrace();      
	    }
	    
	 	Font f = new Font("Helvetica", Font.BOLD, 60);	//��������
	 	Font f1 = new Font("Helvetica", Font.BOLD, 25);
	 	
	 	jlb1 = new JLabel("��ӭ����");	//�����ǩ
	 	jlb2 = new JLabel("��������!");
	 	jlb3 = new JLabel("�ʶ���Ϸ���ԣ�������Ϸ����Ҫ������ʱ��໣�");
	 	jlb1.setBounds( 200,80,300,100); 	//����λ��
	 	jlb2.setBounds( 300,190,300,100); 
	 	jlb3.setBounds( 10,10,750,25); 
        jlb1.setFont(f);		//������ɫ������
        jlb1.setForeground(Color.red);		
        jlb2.setFont(f);
        jlb2.setForeground(Color.red);
        jlb3.setFont(f1);
        jlb3.setForeground(Color.WHITE);
        
		jb1 = new JButton("��¼"); 	//������ť
        jb2 = new JButton("ע��");
        jb3 = new JButton("�˳���Ϸ");
        jb1.setBounds( 320,350,90,60);   
        jb2.setBounds( 320,425,90,60);
        jb3.setBounds( 320,500,90,60);
        
        jb1.addActionListener(this);	//���ü�����
        jb2.addActionListener(this);
        jb3.addActionListener(this);
      
        this.add(jlb1); 	//������
        this.add(jlb2);
        this.add(jlb3);
        this.add(jb1);  
        this.add(jb2);  
        this.add(jb3); 
        
        ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//�ı䴰��ͼ��
        this.setIconImage(imageIcon.getImage());  
        this.setTitle("����ս��");//���ñ���
        this.setSize(800, 650);   //���ô�С
        this.setLayout(null);     //���ò���
             
        Container ct = this.getContentPane();	//���ô��屳��
        this.setLayout(null);
        bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back1.jpg")).getImage());
        bgp.setBounds(0,0,800,650);
        ct.add(bgp);
   	
        this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
        this.setVisible(true);  //���ÿɼ�
	}
	
	//������
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			//��¼����
			new Login(ac);
		}
		if(e.getSource() == jb2) {
			//ע�����
		    new Sign(ac);
		}
		if(e.getSource() == jb3) {
		    //����ȷ��Ҫ�˳���Ϸ�
			//��ʹ�˳���������
			JButton jb1,jb2;
			JLabel jlb1;
			jb1 = new JButton("�ݰ�"); 	//������ť
	        jb2 = new JButton("����");
			jlb1 = new JLabel("����ȷ��Ҫ�˳���Ϸ�");  //��ӱ�ǩ
			JFrame jf = new JFrame();
			
			jlb1.setFont(new java.awt.Font("����",Font.ITALIC,18));	//���������λ��
			jlb1.setBounds( 30,20,200,15); 
			jb1.setFont(new java.awt.Font("����",Font.ITALIC,15));
			jb1.setBounds( 100,60,90,40);   
			jb2.setFont(new java.awt.Font("����",Font.ITALIC,15));
	        jb2.setBounds( 100,110,90,40);
	        
			jf.add(jlb1);	//��Ӹ����
			jf.add(jb1);
			jf.add(jb2);
			
			ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//�ı䴰��ͼ��
	        jf.setIconImage(imageIcon.getImage()); 
	        jf.setTitle("����ս��");//���ñ���
	        jf.setSize(300, 200);   //���ô�С
	        
	        Container ct = jf.getContentPane();		//���ô��屳��
	        jf.setLayout(null);		
	        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
	        bgp.setBounds(0,0,300,200);
	        ct.add(bgp);
	        
	        jf.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
	        jf.setVisible(true);  //���ÿɼ�
	        
	        jb1.addActionListener(new ActionListener() { //�˳���Ϸ
		    	   public void actionPerformed(ActionEvent e)  {
		    		   System.exit(0);
		    	   }
	        });
	        jb2.addActionListener(new ActionListener() { 	//�����˳�
		    	   public void actionPerformed(ActionEvent e)  {
		    		   jf.dispose();
		    	   }
	        });
		}
	}
    
	public static void main(String[] args) {
	    MainClient mc = new MainClient();
	    //�����ͻ����߳�
	    new Thread(mc).start();
	}

	public void run() {
		// TODO Auto-generated method stub
	}
}
