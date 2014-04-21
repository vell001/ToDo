package view;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import model.Setting;
import util.ImageUtil;
import controller.SettingManager;

public class SleepFrame extends Frame {
	private static final long serialVersionUID = -2583580578022531879L;
	private SleepDialog dialog = null;
	private Setting setting = null;
	public SleepFrame() {
		setting = SettingManager.getManager().getSetting();
		initStyle();
		dialog = new SleepDialog(this);
		try {
			lockMouse(new Robot());
		} catch (AWTException e) {
			e.printStackTrace();
		}
		setFront(this);
	}
	
	public void initStyle() {
		setTitle("Sleeping");
        Rectangle bounds = new Rectangle(setting.getScreenSize());
		setUndecorated(true); // no border
		setBounds(bounds);
		setAlwaysOnTop(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		Image img=ImageUtil.getImage("/images/logo.png");
		setIconImage(img);
	}
	
	@Override
	public void paint(Graphics g) {
		Image img=ImageUtil.getImage("/images/sleep.jpg");
		g.drawImage(img,0,0,setting.getScreenSize().width,setting.getScreenSize().height,null);
	}

	public SleepDialog getDialog() {
		return dialog;
	}

	public void setDialog(SleepDialog dialog) {
		this.dialog = dialog;
	}
	
	/**
	 * @param frame
	 * set frame always front
	 */
	public void setFront(final Frame frame) {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {}
			public void windowLostFocus(WindowEvent e) {
				frame.toFront();
			}
		});
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				frame.toFront();
			}
			@Override
			public void windowIconified(WindowEvent e) {
				frame.toFront();
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
				frame.toFront();
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				frame.toFront();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				frame.toFront();
			}
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
	}
	
	/**
	 * @param robot
	 * Lock mouse's position
	 */
	public void lockMouse(final Robot robot) {
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
				lockPoint(robot);
			}
			public void mouseDragged(MouseEvent e) {
				lockPoint(robot);
			}
		});
	}

	/**
	 * @param robot
	 * Lock mouse's point
	 */
	public void lockPoint(Robot robot){
		int width = setting.getScreenSize().width/2;
		int height = setting.getScreenSize().height/2;
		Point mousepoint = MouseInfo.getPointerInfo().getLocation();
		int x=mousepoint.x, y=mousepoint.y;
		if(x!=width || y!=height){
			robot.mouseMove(width, height);
		}
	}
}
