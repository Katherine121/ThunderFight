package file;

/**
 * �������Ӵ����û�������������ݿ����
 * add(String na, String pw)�������µ��û�����������ӵ����ݿ�ı����
 * modify(String na, String pw)�������µ�����д�����ݿ�ı����
 */

import java.sql.*;

public class DataBase {

	public static final String url = "jdbc:mysql://127.0.0.1/userbase?useSSL=false";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "123456";  
  
    public static Connection conn = null;  
    public PreparedStatement pst = null;  
  
    //���캯��
    public DataBase(String sql) {  
        try {  
        	//ָ����������  
            Class.forName(name);
            //��ȡ����  
            conn = DriverManager.getConnection(url,user,password);
            //׼��ִ�����
            pst = conn.prepareStatement(sql);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    //�������ݿ��е���Ϣ
    public void add(String na, String pw) {  
        try {  
        	String sql1 = "insert into userdata(name,pass) values('"+na+"','"+pw+"')";      
        	//����һ��Statement����
            Statement stmt = conn.createStatement();
            //ִ��sql���
            stmt.executeUpdate(sql1);
            System.out.println("���뵽���ݿ�ɹ�");
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    } 
    
    //�޸����ݿ��е���Ϣ
    public void modify(String na, String pw) {
    	 try {  
	    	String sql2 = "update userdata set pass = '"+pw+"' where name = '"+na+"'";
	    	//����һ��Statement����
	    	Statement stmt = conn.createStatement();
	    	//ִ��sql���
            stmt.executeUpdate(sql2);
            System.out.println("�޸����ݿ�ɹ�");
    	 } catch (SQLException e) {  
             e.printStackTrace();  
         }
    }
 }
