package client;

/**
 * �����û���¼����û������棬Ҳ�������ܽ���
 * ���������Ѷȵ���Ϸ���̵꣨�����ң�����Ϸ����
 * ǩ�������ӽ�ң������а��û���Ϣ�͸��ܹ���
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

	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;	//��������
	JLabel jlb1,jlb2;
	JFrame JF;
	ImageIcon background;
	BackgroundPanel bgp;
	
	DealFile file;	//�û���Ϣ
	UserInfo userinfo;
	Iterator<User> userIter;
	User user;
	
	public UserGUI(String name, String pw) {
		file = new DealFile();		//�ҵ���Ӧ�������Ϣ
		userinfo = file.readFile();
		userIter = userinfo.getUsers();
	    	
		    while (userIter.hasNext()) {
		    	User user1 = userIter.next();
			      
			    	  if ( user1.getName().equals(name) && user1.getPass().equals(pw) ) {
			    		  this.user = user1;
			    		  break;
			    	  } 
		    }
		 	Font f = new Font("Helvetica", Font.BOLD, 30);	//��������
		 	
		 	jlb1 = new JLabel("��������");	//������ǩ
		 	jlb2 = new JLabel(name);
		 	jlb1.setBounds( 20,20,200,40); //����λ�ú�����
		 	jlb2.setBounds( 20,70,200,30); 
	        jlb1.setFont(f);
	        jlb1.setForeground(Color.YELLOW);
	        jlb2.setFont(f);
	        jlb2.setForeground(Color.YELLOW);
			
	        jb1 = new JButton("��ģʽ");	//������ť
	        jb2 = new JButton("����ģʽ");
	        jb3 = new JButton("����ģʽ");
	        jb4 = new JButton("�̵�"); 
	        jb5 = new JButton("��Ϸ����"); 
	        jb6 = new JButton("�˳���¼");
	        jb7 = new JButton("ǩ��"); 
	        jb8 = new JButton("���а�");
	        jb9 = new JButton("������Ϣ");
	        jb10 = new JButton("����");
	        JF = new JFrame();
	        
	        jb1.setBounds( 100,350,90,60);   //����λ��
	        jb2.setBounds( 330,350,90,60);
	        jb3.setBounds( 560,350,90,60);
	        jb4.setBounds( 90,500,110,70);
	        jb5.setBounds( 320,500,110,70);
	        jb6.setBounds( 550,500,110,70);
	        jb7.setBounds( 650,20,100,45);
	        jb8.setBounds( 650,80,100,45);
	        jb9.setBounds( 650,140,100,45);
	        jb10.setBounds( 650,200,100,45);
	        
	        jb7.setBackground(Color.GREEN);	//������ɫ
	        jb8.setBackground(Color.GREEN);
	        jb9.setBackground(Color.GREEN);
	        jb10.setBackground(Color.GREEN);
	        
	        jb1.addActionListener(this);	//���ü�����
	        jb2.addActionListener(this);
	        jb3.addActionListener(this);
	        jb4.addActionListener(this);
	        jb5.addActionListener(this);
	        jb6.addActionListener(this);
	        jb7.addActionListener(this);
	        jb8.addActionListener(this);
	        jb9.addActionListener(this);
	        jb10.addActionListener(this);
	        
	        JF.add(jlb1); 	//��Ӹ����
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
	        
	        ImageIcon imageIcon = new ImageIcon("D:\\JAVA\\ThunderFight\\frame.jpg");	//�ı䴰��ͼ��
	        JF.setIconImage(imageIcon.getImage());  
	        JF.setTitle("����ս��");//���ñ���
	        JF.setSize(800, 650);   //���ô�С
	        JF.setLayout(null);           //���ò���
	             
	        Container ct = JF.getContentPane();	//���ô��屳��
	        JF.setLayout(null);
	        bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back1.jpg")).getImage());
	        bgp.setBounds(0,0,800,650);
	        ct.add(bgp);
	   	
	        JF.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
	        JF.setVisible(true);  //���ÿɼ�
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			//��¼����
			JOptionPane.showMessageDialog(null, "С��ţ�����������Ǿ���ɣ�");
			//�������Ϣ��10���ڵ�����
			GameGUI gg1 = new GameGUI(user, 10);
			this.user = gg1.getUser();
		}
		
		if(e.getSource() == jb2) {
			//��¼����
			JOptionPane.showMessageDialog(null, "�����ӳɣ�С���˽���̫������");
			//�������Ϣ��25���ڵ�����
			GameGUI gg2 = new GameGUI(user, 25);
			this.user = gg2.getUser();
		}
		
		if(e.getSource() == jb3) {
			//��¼����
			JOptionPane.showMessageDialog(null, "�����ɼΣ������ħ����ɣ�");
			//�������Ϣ��40���ڵ�����
			GameGUI gg3 = new GameGUI(user, 40);
			this.user = gg3.getUser();
		}
		
		if(e.getSource() == jb4) {
			//�̵�
			JLabel jlb1 = new JLabel("50���\t12�θ���");	//������ǩ
			JLabel jlb2 = new JLabel("100���\t30�θ���");
			JLabel jlb3 = new JLabel("500���\t160�θ���");
			JLabel jlb4 = new JLabel("������Ʒ�����ڴ�...");
			JButton jb1 = new JButton("����");		//������ť
			JButton jb2 = new JButton("����");
			JButton jb3 = new JButton("����");
			JFrame jf = new JFrame();
			
			jlb1.setFont(new java.awt.Font("����",Font.ITALIC,15));	//���������λ��
			jlb1.setBounds( 20,10,150,15); 
			jlb2.setFont(new java.awt.Font("����",Font.ITALIC,15));
			jlb2.setBounds( 20,50,150,15); 
			jlb3.setFont(new java.awt.Font("����",Font.ITALIC,15));
			jlb3.setBounds( 20,90,150,15); 
			
			jb1.setFont(new java.awt.Font("����",Font.ITALIC,12));
			jb1.setBounds(200,5,60,30);   
			jb2.setFont(new java.awt.Font("����",Font.ITALIC,12));
	        jb2.setBounds(200,45,60,30);
	        jb3.setFont(new java.awt.Font("����",Font.ITALIC,12));
	        jb3.setBounds(200,85,60,30);
	        jlb4.setFont(new java.awt.Font("����",Font.ITALIC,20));
			jlb4.setBounds( 20,120,250,20); 
			
			jf.add(jlb1);	//��Ӹ����
			jf.add(jlb2);
			jf.add(jlb3);
			jf.add(jlb4);
			jf.add(jb1);
			jf.add(jb2);
			jf.add(jb3);
			
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
	        
	        //������
	        jb1.addActionListener(new ActionListener() { 
		    	   public void actionPerformed(ActionEvent e)  {
		    		   //ֻ��ӵ��50����Ҳ��ܹ���12�θ������
		    		   if(user.getMoney() >= 50) {
		    			   //�����Ϣ����
			    		   user.setHeart(user.getHeart() + 12);
			    		   user.setMoney(user.getMoney() - 50);
			    		   
			    		   //�����ļ�
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
			    		   
			    		   JOptionPane.showMessageDialog(null,"���Ѿ��ɹ�����12�θ�����ᣡ");
		    		   }
		    		   else {
		    			   JOptionPane.showMessageDialog(null,"���Ľ�������㣬����ʧ�ܣ�");
		    		   }
		    	   }
	        });
	        jb2.addActionListener(new ActionListener() { 
		    	   public void actionPerformed(ActionEvent e)  {
		    		   //ֻ��ӵ��100����Ҳ��ܹ���30�θ������
		    		   if(user.getMoney() >= 100) {
		    			   //�����Ϣ����
			    		   user.setHeart(user.getHeart() + 30);
			    		   user.setMoney(user.getMoney() - 100);
			    		   
			    		   //�����ļ�
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
			    		   
			    		   JOptionPane.showMessageDialog(null,"���Ѿ��ɹ�����30�θ�����ᣡ");
		    		   }
		    		   else {
		    			   JOptionPane.showMessageDialog(null,"���Ľ�������㣬����ʧ�ܣ�");
		    		   }
		    	   }
	        });
	        jb3.addActionListener(new ActionListener() { 
		    	   public void actionPerformed(ActionEvent e)  {
		    		   //ֻ��ӵ��500����Ҳ��ܹ���160�θ������
		    		   if(user.getMoney() >= 500) {
		    			   //�����Ϣ����
			    		   user.setHeart(user.getHeart() + 160);
			    		   user.setMoney(user.getMoney() - 500);
			    		   
			    		   //�����ļ�
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
			    		   
			    		   JOptionPane.showMessageDialog(null,"���Ѿ��ɹ�����160�θ�����ᣡ");
		    		   }
		    		   else {
		    			   JOptionPane.showMessageDialog(null,"���Ľ�������㣬����ʧ�ܣ�");
		    		   }
		    	   }
	        });
		}
		
		if(e.getSource() == jb5) {
			//��Ϸ����
			JTextArea jta = new JTextArea("�װ���С����~����\t\n"	//�����ı����͹�����
					+ "����һ���ɻ����ը����С��Ϸ\n"
					+ "����Ҫ���¼��̵�����/����/\n"
					+ "����/���Ƽ������Ʒɻ��ķ���\n"
					+ "һ���ɻ�ײ��ը������Ϸ����\n"
					+ "�������ĸ�ѡ��\n"
					+ "1)ʹ�ø������\n"
					+ "2)����5����Ҹ���һ��\n"
					+ "3)���¿�ʼ\n"
					+ "4)�˳���Ϸ\n"
					+ "�̵���Ի��ѽ�ҹ��򸴻����\n"
					+ "��ʱǩ���������ӽ����Ŀ\n"
					+ "���а���Բ鿴�����ǵ�ս��\n"
					+ "������Ϣ���ڲ鿴�Լ�����Ϣ\n"
					+ "����Ҫ��������֣���Сд��ĸŶ\n"
					+ "ף�����ˣ�\n");
			JScrollPane jsp = new JScrollPane(jta);
			JFrame jf = new JFrame();
			jta.setBounds(10,5,250,150);	//����λ�úͲ��ɱ༭
			jta.setEditable(false);
			jsp.setBounds(10,5,250,150);	//����λ��
			jf.add(jsp);
			
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
		}
		
		if(e.getSource() == jb6) {
		    //����ȷ��Ҫ�˳���Ϸ�
			//��ʹ�˳���������
			JButton jb1,jb2;
			JLabel jlb1;
			jb1 = new JButton("�ݰ�"); 	//������ť
	        jb2 = new JButton("����");
			jlb1 = new JLabel("����ȷ��Ҫ�˳���¼�");  //��ӱ�ǩ
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
	        
	        Container ct = jf.getContentPane();	//���ô��屳��
	        jf.setLayout(null);		
	        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("D:\\JAVA\\ThunderFight\\back2.jpg")).getImage());
	        bgp.setBounds(0,0,300,200);
	        ct.add(bgp);
	        
	        jf.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
	        jf.setVisible(true);  //���ÿɼ�
	        
	        //�رյ�¼����
	        jb1.addActionListener(new ActionListener() { 
		    	   public void actionPerformed(ActionEvent e)  {
		    		   jf.dispose();
		    		   JF.dispose();
		    	   }
	        });
	        //���ر�ѯ�ʽ���
	        jb2.addActionListener(new ActionListener() { 
		    	   public void actionPerformed(ActionEvent e)  {
		    		   jf.dispose();
		    	   }
	        });
		}
		
		if(e.getSource() == jb7) {
			//ǩ��
			if(user.getSign() == 1) {
				Date date1 = new Date();
				
				//�ж��Ƿ��Ѿ�������һ����
				//����һ���Ӹ��Ľ�������µ�ǩ��ʱ��
				if(date1.getTime() - user.getDate().getTime() >= 60*1000) {
					user.setMoney(user.getMoney() + 5);
					user.setSign(1);
					user.setDate(date1);
					
					//�����ļ�
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
					
					JOptionPane.showMessageDialog(null,"ǩ���ɹ�����ý��5��\n���ǩ���������ӽ����ĿŶ! ");
				}
				else {
					JOptionPane.showMessageDialog(null,"���Ѿ�ǩ��������һ����֮��������");
				}
			}
			//��δǩ������¼������͵�ǰǩ��ʱ��
			if(user.getSign() == 0) {
				Date date1 = new Date();
				user.setMoney(user.getMoney() + 5);
				user.setSign(1);
				user.setDate(date1);
				
				//�����ļ�
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
				
				JOptionPane.showMessageDialog(null,"ǩ���ɹ�����ý��5��\n���ǩ���������ӽ����ĿŶ! ");
			}
		}
		
		if(e.getSource() == jb8) {
			//���а�
			JTextArea jta = new JTextArea();	//�����ı����͹�����
			JScrollPane jsp = new JScrollPane(jta);
			JFrame jf = new JFrame();
			//��ȡ�ļ���ת��Ϊ����
			//��������ð������
			UserInfo userinfo1 = file.readFile();
			for(int i = 0; i < userinfo1.getNumOfUsers(); i++) {
				//�����Աȣ�����ͳɼ���������
		    	for(int j = 0; j < userinfo1.getNumOfUsers() - i - 1; j++) {
						if( userinfo1.getUser(j).getTime() < userinfo1.getUser(j + 1).getTime() ) {
							User usertemp = new User(userinfo1.getUser(j));
							userinfo1.setUser(userinfo1.getUser(j), userinfo1.getUser(j + 1));
							userinfo1.setUser(userinfo1.getUser(j + 1), usertemp);
						}
					}
				}
			jta.setText("����\t�û���\t�ɼ�s\n");
			for(int i = 0; i < userinfo1.getNumOfUsers(); i++) {
				int j = i + 1;
				jta.setText(jta.getText() + j
						+ "\t" + userinfo1.getUser(i).getName() 
						+ "\t" + userinfo1.getUser(i).getTime() 
						+ "\n");
			}
			jta.setBounds(10,5,250,150);	//����λ�úͲ��ɱ༭
			jta.setEditable(false);
			jsp.setBounds(10,5,250,150);	//����λ��
			jf.add(jsp);
			
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
		}
		
		if(e.getSource() == jb9) {
			//������Ϣ
			JTextArea jta = new JTextArea();	//�����ı����͹�����
			JScrollPane jsp = new JScrollPane(jta);
			JFrame jf = new JFrame();
			jta.setText("�û���\t" + user.getName() + "\n" + "�ɼ�\t" + user.getTime() + "��\n"
						+ "�����\t" + user.getMoney() + "\n" + "�������\t" + user.getHeart() + "\n"
						+ "ǩ��ʱ��\t" + new Time().getTimeStr(user.getDate()) );
			
			jta.setBounds(10,5,250,150);	//����λ�úͲ��ɱ༭
			jta.setEditable(false);
			jsp.setBounds(10,5,250,150);
			jf.add(jta);
			
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
		}
		
		if(e.getSource() == jb10) {
			//����
			JLabel jlb1 = new JLabel("������ԭ����");	//���ñ�ǩ
			JLabel jlb2 = new JLabel("������������");	
			JLabel jlb3 = new JLabel("	���ٴ�����");
			JButton jb1 = new JButton("ȷ��");			//���ð�ť
			JButton jb2 = new JButton("����");
			JPasswordField jpf = new JPasswordField();	//���������
			JTextField jtf1 = new JTextField();			//�����ı���
			JTextField jtf2 = new JTextField();
			JTextArea jta = new JTextArea("�����ɴ�д��ĸ��Сд��ĸ��������ɣ�����λ\n");		//�����ı���
			JFrame jf = new JFrame();		//���ÿ��
			
			jlb1.setBounds(10, 5, 100, 25);	//����λ��
	        jpf.setBounds(120, 5, 150, 25);
	        jlb2.setBounds(10, 35, 100, 25);
	        jtf1.setBounds(120, 35, 150, 25);
	        jlb3.setBounds(10, 65, 100, 25);
	        jtf2.setBounds(120, 65, 150, 25);
	        jb1.setBounds(70, 100, 80, 40);
	        jb2.setBounds(160, 100, 80, 40);
			
	        jf.add(jlb1);	//��Ӹ����
	        jf.add(jpf);
	        jf.add(jlb2);
	        jf.add(jtf1);
	        jf.add(jlb3);
	        jf.add(jtf2);
	        jf.add(jb1);
	        jf.add(jb2);
	        
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
	   	     	   	     
	   	    jb1.addActionListener(new ActionListener() { // ����ȷ����ť������
				public void actionPerformed(ActionEvent e) {
				  //ԭ������ȷ
   		    	  if ( jpf.getText().equals(user.getPass()) ) {
   		    		  	  //���������Ҫ���Ҳ���ԭ������ͬ
   		    			  if(check1(jtf1.getText()) == true && check2(jtf1.getText()) == true 
   		    					  && check3(jtf1.getText()) == true && jtf1.getText().equals(jtf2.getText())
   		    					  && !jtf1.getText().equals(user.getPass())) {
   		    				  user.setPass(jtf1.getText()); 
   		    				  
   		    				  //�����ļ�
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
	   		      		     
	   		      		      //��ȡ���ݿ���Ϣ
	   		      	  		  //SQL��� 
	   		      	  		  String sql = "select * from userdata"; 
	   		      	  		  //����DataBase����
	   		      	  		  DataBase db1 = new DataBase(sql);
	   		      	  		  //�޸����ݿ�����
	   		      	  		  db1.modify(user.getName(), jtf1.getText());
	   		      	        
   		    				  JOptionPane.showMessageDialog(null,"���ܳɹ����´ε�¼�����������룡");
   		    				  jf.dispose();
   		    			  }
   		    			  else{
   		    				  //��ʾ������������Ϣ
   		    				  if (check1(jtf1.getText()) != true)
   		    					  JOptionPane.showMessageDialog(null,"����������Сд��ĸ!");
	   		    			  if (check2(jtf1.getText()) != true)
	   		    				  JOptionPane.showMessageDialog(null,"������������д��ĸ!");
	   		    			  if (check3(jtf1.getText()) != true) 
	   		    				  JOptionPane.showMessageDialog(null,"��������������!");
	   		    			  if (!jtf1.getText().equals(jtf2.getText()))
	   		    				  JOptionPane.showMessageDialog(null,"���벻ͬ������������!");
	   		    			  if (jtf1.getText().equals(user.getPass()))
	   		    				JOptionPane.showMessageDialog(null,"�����벻����ԭ������ͬ!");
		   		    	 }
		   		    }
   		    	    else {
   		    	    	JOptionPane.showMessageDialog(null,"ԭ���벻��ȷ!");
   		    	    }
				}
				//���������Ƿ����Ҫ��ĺ���
				//Сд��ĸ
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
		  		//��д��ĸ
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
		  		//����
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
					//��ո�����Ϣ
					jpf.setText("");
					jtf1.setText("");
					jtf2.setText("");
				}
		   	 });
		}
	}
}
