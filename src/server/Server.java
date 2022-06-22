package server;

/**
 * �����
 * ��������sign����û�ע����Ϣ
 * �����к˶�,�Ƿ�����ע����û���Ϣ��ͬ��
 * �����Ľ�����ظ��ͻ���
 */

import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import file.*;

public class Server {

	// ��ʼ�� socket �� streams
	ServerSocket serverSocket = null; 
	Socket sSocket = null; 
	PrintStream out;
	BufferedReader in; 
	String aLine;
	InetAddress client ;
	
	public Server() {
		
		System.out.println("��������...");
        try {
			//��������2019�˿ڵķ������׽���
			serverSocket = new ServerSocket(2019);
			
			while(true) {
				//�����ͻ������ӣ�����...
				//������ӳɹ�������һ��socket����
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
			//�յ���������
			System.out.println("���ӽ���...");
			
			try {
				//ʹ�÷��ص�socket����ͨ��
				out = new PrintStream(sSocket.getOutputStream());
				in = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));
				String order = " ";
				while ( (order = in.readLine()) != null ) {
					
					if(order.equals("sign")) {
						String na = in.readLine();
						String pw = in.readLine();
						boolean flag = false;
						BufferedWriter bf = null;
						
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
				                if(na.equals(name)) {
				                	//�ҵ���Ӧ���û�
				                	out.println("Ҫ���ӵ��û����Ѵ���!");
						    		flag = true;
				                }
				            }
				            ret.close(); 
				        } catch (SQLException e) {  
				            e.printStackTrace();  
				        }
						
						//���������
						if(flag == false) {
							Date date0 = new Date();
							try {
								//����д�ļ���
								bf = new BufferedWriter(new OutputStreamWriter(
								new FileOutputStream("D:\\JAVA\\ThunderFight\\userinfo.txt", true)));
								
								//д���ļ�
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
							
							//�������ݿ���Ϣ
							db1.add(na, pw);
							
							//���ؿͻ�����ȷ���
							out.println("ע��ɹ�!");
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
