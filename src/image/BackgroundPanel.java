package image;

/**
 * 这是获得窗口背景图片的类
 */

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
	
		Image im;	//背景图片
		
		public BackgroundPanel(Image im)
		{
		   this.im = im;
		   this.setOpaque(false);	//设置透明
		}
		
		//画出背景图片
		public void paintComponent(Graphics g)
		{
		   super.paintComponents(g);
		   g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
		}
}
