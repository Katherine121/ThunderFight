package client;
/**
 *��¼�࣬����������û����������Ƿ���ȷ��
 * �����ȷ������ת�����û�����
 * �������ȷ���򵯳���ʾ��������������
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
	
	JButton jb1,jb2;	//��������
	JLabel jlb1,jlb2;
	JTextField jtf1;
	JPasswordField jpf1;
	JFrame jf;
	
	public Login(AudioClip ac) {
		
		//��������
		//ac.loop();
	    
		jb1 = new JButton("ȷ��"); 	//������ť
        jb2 = new JButton("����");
        
        jlb1 = new JLabel("�û���");  //��ӱ�ǩ
        jlb2 = new JLabel("����");

        jtf1 = new JTextField(10);   //�����ı���������
        jpf1 = new JPasswordField(10);
        jf = new JFrame();		
        
        jlb1.setBounds(30, 20, 50, 25);	//����λ��
        jtf1.setBounds(100, 20, 150, 25);
        jlb2.setBounds(30, 50, 50, 25);
        jpf1.setBounds(100, 50, 150, 25);
        jb1.setBounds(70, 100, 80, 40);
        jb2.setBounds(160, 100, 80, 40);
        
        jf.add(jlb1);		//��Ӹ����
        jf.add(jtf1);
        jf.add(jlb2);
        jf.add(jpf1);
        jf.add(jb1);
        jf.add(jb2);
        
        jb1.addActionListener(this); //���ü�����
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
	}
	
	//������
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			try {
				if(check(jtf1.getText(), jpf1.getText()) == true) {
					JOptionPane.showMessageDialog(null, "��¼�ɹ�!");
					//�رյ�¼���棬��ת���û�������
					jf.dispose();
					UserGUI uc = new UserGUI(jtf1.getText(), jpf1.getText());
				}
				else {
		    		JOptionPane.showMessageDialog(null,"�˺Ż����������!");
		    		//��յ�¼��Ϣ
		    		jtf1.setText("");
				    jpf1.setText("");
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		//��յ�¼��Ϣ
		if(e.getSource() == jb2) {
		    jtf1.setText("");
		    jpf1.setText("");
		}
	}
	
    //���麯���������û�����Ŀ��ź������Ƿ���ȷ
  	public boolean check(String na,String pw) {
  		//��ȡ���ݿ���Ϣ
  		//SQL��� 
  		String sql = "select * from userdata"; 
  		//����DataBase����
    	DataBase db1 = new DataBase(sql);
        try {  
        	//ִ����䣬�õ������ 
        	ResultSet ret = db1.pst.executeQuery();
        	//���ζԱ��û���Ϣ
        	while (ret.next()) {  
                String name = ret.getString(1);  
                String pass = ret.getString(2);
                if(na.equals(name) && pw.contentEquals(pass)) {
                	//�ҵ���Ӧ���û�
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
