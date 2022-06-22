package server;

/**
 * 服务端
 * 接收来自sign类的用户注册信息
 * 并进行核对,是否与已注册的用户信息相同，
 * 将最后的结果返回给客户端
 */

import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import file.*;

public class Server {

	// 初始化 socket 和 streams
	ServerSocket serverSocket = null; 
	Socket sSocket = null; 
	PrintStream out;
	BufferedReader in; 
	String aLine;
	InetAddress client ;
	
	public Server() {
		
		System.out.println("服务启动...");
        try {
			//创建侦听2019端口的服务器套接字
			serverSocket = new ServerSocket(2019);
			
			while(true) {
				//侦听客户端连接，阻塞...
				//如果连接成功，返回一个socket对象
				sSocket  = serverSocket.accept();
				if(sSocket != null)
					new Thread(new SerThread(sSocket)).start();
			}
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	class SerThread implements Runnable {
		
		private Socket sSocket;
		
		public SerThread(Socket sSocket) {
			this.sSocket = sSocket;
		}

		public void run() {
			//收到连接请求
			System.out.println("连接建立...");
			
			try {
				//使用返回的socket进行通信
				out = new PrintStream(sSocket.getOutputStream());
				in = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));
				String order = " ";
				while ( (order = in.readLine()) != null ) {
					
					if(order.equals("sign")) {
						String na = in.readLine();
						String pw = in.readLine();
						boolean flag = false;
						BufferedWriter bf = null;
						
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
				                if(na.equals(name)) {
				                	//找到相应的用户
				                	out.println("要增加的用户名已存在!");
						    		flag = true;
				                }
				            }
				            ret.close(); 
				        } catch (SQLException e) {  
				            e.printStackTrace();  
				        }
						
						//如果不存在
						if(flag == false) {
							Date date0 = new Date();
							try {
								//开启写文件流
								bf = new BufferedWriter(new OutputStreamWriter(
								new FileOutputStream("D:\\JAVA\\ThunderFight\\userinfo.txt", true)));
								
								//写入文件
								bf.write(na);
								bf.write("\t");
								bf.write(pw);
								bf.write("\t");
								bf.write("0");
								bf.write("\t");
								bf.write("0");
								bf.write("\t");
								bf.write("0");
								bf.write("\t");
								bf.write("0");
								bf.write("\t");
								bf.write(new Time().getTimeStr(date0));
								bf.write("\n");
								bf.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							
							//增加数据库信息
							db1.add(na, pw);
							
							//返回客户端正确结果
							out.println("注册成功!");
						}
					}
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
	    Server s = new Server();
	}
}
