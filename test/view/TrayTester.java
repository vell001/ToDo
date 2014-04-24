package view;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.SettingManager;

public class TrayTester extends JFrame {
	long setTime = 30 * 1000;

	JLabel jl = new JLabel("剩余时间：");

	JLabel jl1 = new JLabel();

	PopupMenu popupMenu1 = new PopupMenu();
	MenuItem menuItem1 = new MenuItem();

	public TrayTester() {
		this.setLocation(200, 200);
		this.setSize(300, 200);
		isTray();
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowIconified(WindowEvent evt) {
				unVisible();
			}
		});

		popupMenu1.setLabel("PopupMenu");
		menuItem1.setLabel("打开");
		menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				showw();
			}
		});
		popupMenu1.add(menuItem1);
	}

	public void unVisible() {
		this.setVisible(false);
	}

	public void showw() {
		this.setVisible(true);
	}

	public void isTray() {
		try {
			if (SystemTray.isSupported()) {// 判断当前平台是否支持系统托盘
				SystemTray st = SystemTray.getSystemTray();
				Image image = SettingManager.getManager().getSetting().getIcon();// 定义托盘图标的图片
				TrayIcon ti = new TrayIcon(image);
				ti.setToolTip("test ");
				ti.setPopupMenu(this.popupMenu1);
				st.add(ti);
			}
		} catch (Exception e) {

		}

	}

	public static void main(String[] args) {
		new TrayTester();
	}
}
