package util;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class ImageUtil {
	public static Image getImage(String path) {
		URL url = ImageUtil.class.getClass().getResource(path);
		Image image = null;
		image = Toolkit.getDefaultToolkit().getImage(url);
		return image;
	}
}
