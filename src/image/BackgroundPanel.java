package image;

/**
 * ���ǻ�ô��ڱ���ͼƬ����
 */

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
	
		Image im;	//����ͼƬ
		
		public BackgroundPanel(Image im)
		{
		   this.im = im;
		   this.setOpaque(false);	//����͸��
		}
		
		//��������ͼƬ
		public void paintComponent(Graphics g)
		{
		   super.paintComponents(g);
		   g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
		}
}
