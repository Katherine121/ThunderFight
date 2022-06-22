package image;

/**
 * 这是获得程序所使用的图片路径的类
 */

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class GetImage {

	public static Image getImage(String path) {
		BufferedImage bi = null;	//创建图片信息缓冲
		
		try {
			URL u = GetImage.class.getClassLoader().getResource(path);	//加载资源根目录，获得相对资源位置
			bi = ImageIO.read(u);	//获取图片信息并返回Image对象
		} catch(IOException e) {
			e.printStackTrace();
		}
		return bi;	//返回图片
	}
}
