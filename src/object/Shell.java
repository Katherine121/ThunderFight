package object;

/**
 * 炮弹类
 * 详细描述了炮弹的属性和飞行状态
 */

import java.awt.*;

public class Shell extends Object{

    private double degree;
    
    //构造函数
    public Shell() {
        x = 400;	//初始化位置
        y = 40;
        width = 10;
        height = 10;
        speed = 5;	//初始化速度
        degree = Math.random() * Math.PI * 2;   
    }
    
    public void draw(Graphics g) {
    	//将外部传入g的状态保存好
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval((int)x, (int)y, width, height);
        
        //炮弹沿任意角度去飞
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);
          
        //炮弹碰到边界，则自动弹回
        if(x < 0 || x > (800 - 10) ) {
            degree = Math.PI-degree;
        } 
        if(y < 30 || y> (650 - 10) ) {
            degree = -degree;
        }
        
        //返回给外部，变回以前的颜色
        g.setColor(c);
    }
}
