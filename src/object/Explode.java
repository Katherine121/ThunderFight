package object;

/**
 * 产生爆炸效果的类
 */

import java.awt.*;
import image.GetImage;

public class Explode {
	
    private double x, y;	//爆炸开始位置
    private static Image[] imgs = new Image[100];	//初始化100个爆炸图片
    private int count = 0;	//控制爆炸连续次数
    
    static {
    	for(int i = 0; i < 100; i++){
            imgs[i] = GetImage.getImage("image/explode.gif");
            imgs[i].getWidth(null);
        }
    }
    
    //初始化爆炸开始位置
    public Explode(double x, double y) {	
        this.x = x;
        this.y = y;
    }
    
    //画100次爆炸图片形成连续效果
    public void draw(Graphics g){
    	if(count <= 99) {   
            g.drawImage(imgs[count], (int)x,(int)y, null);
            count++; 
        }
    }
}
