package util;

import java.util.ResourceBundle;

public class ResourceBundleUtil {
	private static final String stringBundleBaseName = "string";
	public static String getString(String stringName) {
		return ResourceBundle.getBundle(stringBundleBaseName).getString(stringName);
	}
}
