package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;

import controller.SettingManager;

import util.ImageUtil;
public class ThingFrame extends Frame {
	private static final long serialVersionUID = 1950987589795392479L;
	
	public ThingFrame(){
		initStyle();
	}
	
	public void initStyle() {
		setTitle("Setting");
		Dimension screenSize = SettingManager.getManager().getSetting().getScreenSize();
        Rectangle bounds = new Rectangle(screenSize);
		setUndecorated(true); // 无边框
		setBounds(bounds);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setResizable(false);
		
		Image img=ImageUtil.getImage("/images/logo.png");
		setIconImage(img);
	}

}
