package object;

/**
 * �ڵ���
 * ��ϸ�������ڵ������Ժͷ���״̬
 */

import java.awt.*;

public class Shell extends Object{

    private double degree;
    
    //���캯��
    public Shell() {
        x = 400;	//��ʼ��λ��
        y = 40;
        width = 10;
        height = 10;
        speed = 5;	//��ʼ���ٶ�
        degree = Math.random() * Math.PI * 2;   
    }
    
    public void draw(Graphics g) {
    	//���ⲿ����g��״̬�����
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval((int)x, (int)y, width, height);
        
        //�ڵ�������Ƕ�ȥ��
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);
          
        //�ڵ������߽磬���Զ�����
        if(x < 0 || x > (800 - 10) ) {
            degree = Math.PI-degree;
        } 
        if(y < 30 || y> (650 - 10) ) {
            degree = -degree;
        }
        
        //���ظ��ⲿ�������ǰ����ɫ
        g.setColor(c);
    }
}
