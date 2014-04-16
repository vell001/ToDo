package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageUtil {
	public static Image getImage(String path) {
		URL url = ImageUtil.class.getClass().getResource(path);
		BufferedImage image =null;
		try {
			image =ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
