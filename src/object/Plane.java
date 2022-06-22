package object;

/**
 * �ɻ���
 * ��ϸ�����˷ɻ������ԣ��ɻ����ƶ�������ٶ�
 */

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends Object{  //�̳���Ϸ���常��
	
    private boolean left, right, up, down;	//�ƶ�����
    private boolean live = true;	//�Ƿ�ײ���ڵ�
    
    //���캯��
    public Plane (Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = 20;
        this.height = img.getHeight(null);
        this.width = img.getWidth(null);
    }
    
    //���ɻ�
    public void drawSelf(Graphics g) {
        if (live) {
            g.drawImage(img, (int)x, (int)y, null);
            //���ݷ����ƶ��ɻ�λ��
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
    
    //�����������Ҽ�����ı䷽��ֵ
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
    
    //�ɿ��������Ҽ�����ı䷽��ֵ
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