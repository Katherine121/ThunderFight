package image;

/**
 * ���ǻ�ó�����ʹ�õ�ͼƬ·������
 */

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class GetImage {

	public static Image getImage(String path) {
		BufferedImage bi = null;	//����ͼƬ��Ϣ����
		
		try {
			URL u = GetImage.class.getClassLoader().getResource(path);	//������Դ��Ŀ¼����������Դλ��
			bi = ImageIO.read(u);	//��ȡͼƬ��Ϣ������Image����
		} catch(IOException e) {
			e.printStackTrace();
		}
		return bi;	//����ͼƬ
	}
}
