package object;

/**
 * ������Ϸ���漰�������壨�ɻ���ը�����ĸ���
 */

import java.awt.*;

public class Object {
     protected Image img;
     protected double x, y;	//λ��
     protected int speed = 20;	//�ٶ�
     protected int width, height;	//��ȸ߶�
    
     //���캯��
     public Object() {
         
     }
     
     //���캯��
     public Object(Image img, double x, double y) {
         super();
         this.img = img;
         this.x = x;
         this.y = y;
     }

     //���캯��
     public Object(Image img, double x, double y, int speed, int width, int height) {
         super();
         this.img = img;
         this.x = x;
         this.y = y;
         this.speed = speed;
         this.width = width;
         this.height = height;
     }
     
     //�����Լ�
     public void drawSelf(Graphics g) {
         g.drawImage(img, (int)x, (int)y, null);
     }
 
     //���غ�����λ��
     public double getX() {
    	 return this.x;
     }
    
     //����������λ��
     public double getY() {
    	 return this.y;
     }
    
     //���ؿ�ȳ��ȵȣ�������ײ���
     public Rectangle getRect() {
         return new Rectangle((int)x, (int)y, width, height);
     }
}
