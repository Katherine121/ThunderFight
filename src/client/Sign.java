package client;

/**
 *ע���࣬��������������Ƿ���ϸ�ʽ��
 * �����ȷ����ע����Ϣ���͸�����ˣ��ɷ�����������û���Ϣ
 * �������ȷ���򵯳���ʾ��������������
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

	JButton jb1,jb2;	//��������
	JLabel jlb1,jlb2,jlb3;
	JTextField jtf1,jtf2,jtf3;
	JPasswordField jpf1;
	JPanel jp1,jp2,jp3,jp4;
	JFrame jf;
	
	// ��ʼ�� socket �� streams
	Socket connection = null;
	PrintStream out = null;
	BufferedReader in = null;
	InetAddress server;
		
	public Sign(AudioClip ac) {
		
		//��������
		//ac.loop();
		
		jb1 = new JButton("ȷ��"); 	//������ť
        jb2 = new JButton("����");
        
        jp1 = new JPanel();  //�������
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jlb1 = new JLabel("���������û���");  //��ӱ�ǩ
        jlb2 = new JLabel("����������");
        jlb3 = new JLabel("���ٴ���������");

        jtf1 = new JTextField(10);   //�����ı���������
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
        jf = new JFrame();		
        
        jlb1.setBounds(10, 5, 100, 25);	//����λ��
        jtf1.setBounds(120, 5, 150, 25);
        jlb2.setBounds(10, 35, 100, 25);
        jtf2.setBounds(120, 35, 150, 25);
        jlb3.setBounds(10, 65, 100, 25);
        jtf3.setBounds(120, 65, 150, 25);
        jb1.setBounds(70, 100, 80, 40);
        jb2.setBounds(160, 100, 80, 40);
        
        jf.add(jlb1);	//��Ӹ����
        jf.add(jtf1);
        jf.add(jlb2);
        jf.add(jtf2);
        jf.add(jlb3);
        jf.add(jtf3);
        jf.add(jb1);
        jf.add(jb2);
        
        jb1.addActionListener(this);	//���ü�����
        jb2.addActionListener(this);
      
        ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//�ı䴰��ͼ��
        jf.setIconImage(imageIcon.getImage());  
        jf.setTitle("����ս��");//���ñ���
        jf.setSize(300, 200);   //���ô�С
        
        Container ct = jf.getContentPane();	//���ô��屳��
        jf.setLayout(null);		
        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
        bgp.setBounds(0,0,300,200);
        ct.add(bgp);
        
        jf.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
        jf.setVisible(true);  //���ÿɼ�
        
        // ���Ӷ˿�2019
	      try {
	  		connection = new Socket("127.0.0.1", 2019);
	  		server = connection.getInetAddress();
	  		System.out.println("���ӳɹ�,�˿ں�Ϊ" + connection.getPort());
	  	} catch (IOException e) {
	  		e.printStackTrace();
	  	}
	  	
	  	// ��ʼ��socket�����������
	  	try {
	  		out = new PrintStream(connection.getOutputStream());
	  		in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	  	} catch (IOException ioe) {
	  		ioe.printStackTrace();
	  	}
	}
	
	//������
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			try {
				//�������Ҫ����ע����Ϣ���͸������
				if( check1(jtf2.getText()) == true && check2(jtf2.getText()) == true
						&& check3(jtf2.getText()) == true && jtf2.getText().equals(jtf3.getText())) {
					
					out.println("sign");
					out.println(jtf1.getText());
					out.println(jtf2.getText());
					//�յ�����˷��ص���Ϣ
					String result = in.readLine();
					JOptionPane.showMessageDialog(null,result);
					if(result.equals("ע��ɹ�!"))
						jf.dispose();
					
				}
				else {
					//��ʾ������������Ϣ
					  if (check1(jtf2.getText()) != true)
	    				  JOptionPane.showMessageDialog(null,"����������Сд��ĸ!");
		    			 
	    			  if (check2(jtf2.getText()) != true)
	    				  JOptionPane.showMessageDialog(null,"������������д��ĸ!");
	    			  
	    			  if (check3(jtf2.getText()) != true)
	    				  JOptionPane.showMessageDialog(null,"��������������!");
	    			  
	    			  if (!jtf2.getText().equals(jtf3.getText()))
	    				  JOptionPane.showMessageDialog(null,"���벻ͬ������������!");
				}
				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		//���ע����Ϣ
		if(e.getSource() == jb2) {
		    jtf1.setText("");
		    jtf2.setText("");
		    jtf3.setText("");
		}	
	}

	//���������Ƿ����Ҫ����
	//��������
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
	//������д��ĸ
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
	//����Сд��ĸ
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
