package object;

/**
 * 飞机类
 * 详细描述了飞机的属性，飞机的移动方向和速度
 */

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends Object{  //继承游戏物体父类
	
    private boolean left, right, up, down;	//移动方向
    private boolean live = true;	//是否撞上炮弹
    
    //构造函数
    public Plane (Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = 20;
        this.height = img.getHeight(null);
        this.width = img.getWidth(null);
    }
    
    //画飞机
    public void drawSelf(Graphics g) {
        if (live) {
            g.drawImage(img, (int)x, (int)y, null);
            //根据方向移动飞机位置
            if(left) {
                x -= speed;
            }
            if(right) {
                x += speed;
            }
            if(up) {
                y -= speed;
            }
            if(down) {
                y += speed;
            }
        }
    }
    
    //按下上下左右键，则改变方向值
    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
	        case KeyEvent.VK_LEFT:
	            left = true;
	            break;
	        case KeyEvent.VK_RIGHT:
	            right = true;
	            break;
	        case KeyEvent.VK_UP:
	            up = true;
	            break;
	        case KeyEvent.VK_DOWN:
	            down = true;
	            break;
	        default:
	            break;
        }
    }
    
    //松开上下左右键，则改变方向值
    public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
	        case KeyEvent.VK_LEFT:
	            left = false;
	            break;
	        case KeyEvent.VK_RIGHT:
	            right = false;
	            break;
	        case KeyEvent.VK_UP:
	            up = false;
	            break;
	        case KeyEvent.VK_DOWN:
	            down = false;
	            break;
	        default:
	            break;
	    }
    }
}