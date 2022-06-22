package file;

/**
 * 这是连接储存用户名和密码的数据库的类
 * add(String na, String pw)函数将新的用户名和密码添加到数据库的表格中
 * modify(String na, String pw)函数将新的密码写入数据库的表格中
 */

import java.sql.*;

public class DataBase {

	public static final String url = "jdbc:mysql://127.0.0.1/userbase?useSSL=false";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "123456";  
  
    public static Connection conn = null;  
    public PreparedStatement pst = null;  
  
    //构造函数
    public DataBase(String sql) {  
        try {  
        	//指定连接类型  
            Class.forName(name);
            //获取连接  
            conn = DriverManager.getConnection(url,user,password);
            //准备执行语句
            pst = conn.prepareStatement(sql);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    //增加数据库中的信息
    public void add(String na, String pw) {  
        try {  
        	String sql1 = "insert into userdata(name,pass) values('"+na+"','"+pw+"')";      
        	//创建一个Statement对象
            Statement stmt = conn.createStatement();
            //执行sql语句
            stmt.executeUpdate(sql1);
            System.out.println("插入到数据库成功");
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    } 
    
    //修改数据库中的信息
    public void modify(String na, String pw) {
    	 try {  
	    	String sql2 = "update userdata set pass = '"+pw+"' where name = '"+na+"'";
	    	//创建一个Statement对象
	    	Statement stmt = conn.createStatement();
	    	//执行sql语句
            stmt.executeUpdate(sql2);
            System.out.println("修改数据库成功");
    	 } catch (SQLException e) {  
             e.printStackTrace();  
         }
    }
 }
