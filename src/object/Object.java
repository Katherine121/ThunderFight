package object;

/**
 * 所有游戏中涉及到的物体（飞机，炸弹）的父类
 */

import java.awt.*;

public class Object {
     protected Image img;
     protected double x, y;	//位置
     protected int speed = 20;	//速度
     protected int width, height;	//宽度高度
    
     //构造函数
     public Object() {
         
     }
     
     //构造函数
     public Object(Image img, double x, double y) {
         super();
         this.img = img;
         this.x = x;
         this.y = y;
     }

     //构造函数
     public Object(Image img, double x, double y, int speed, int width, int height) {
         super();
         this.img = img;
         this.x = x;
         this.y = y;
         this.speed = speed;
         this.width = width;
         this.height = height;
     }
     
     //画出自己
     public void drawSelf(Graphics g) {
         g.drawImage(img, (int)x, (int)y, null);
     }
 
     //返回横坐标位置
     public double getX() {
    	 return this.x;
     }
    
     //返回纵坐标位置
     public double getY() {
    	 return this.y;
     }
    
     //返回宽度长度等，用于碰撞检测
     public Rectangle getRect() {
         return new Rectangle((int)x, (int)y, width, height);
     }
}
