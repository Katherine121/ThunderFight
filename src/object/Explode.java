package object;

/**
 * ������ըЧ������
 */

import java.awt.*;
import image.GetImage;

public class Explode {
	
    private double x, y;	//��ը��ʼλ��
    private static Image[] imgs = new Image[100];	//��ʼ��100����ըͼƬ
    private int count = 0;	//���Ʊ�ը��������
    
    static {
    	for(int i = 0; i < 100; i++){
            imgs[i] = GetImage.getImage("image/explode.gif");
            imgs[i].getWidth(null);
        }
    }
    
    //��ʼ����ը��ʼλ��
    public Explode(double x, double y) {	
        this.x = x;
        this.y = y;
    }
    
    //��100�α�ըͼƬ�γ�����Ч��
    public void draw(Graphics g){
    	if(count <= 99) {   
            g.drawImage(imgs[count], (int)x,(int)y, null);
            count++; 
        }
    }
}
