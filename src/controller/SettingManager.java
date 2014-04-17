package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import java.util.ResourceBundle;

import model.DBSetting;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

/**
 * @author VellBibi
 * All Setting information come from here
 */
public class SettingManager {
	private static SettingManager setting = null;
	private Dimension screenSize = null;
	private DBSetting DBS = null;
	
	// SettingManager is a singleton
	static {
		setting = new SettingManager();
		setting.setScreenSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	
	public static SettingManager getManager() {
		return setting;
	}
	
	public Dimension getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(Dimension screenSize) {
		this.screenSize = screenSize;
	}
	public int getBeforeSleepTime () {
		return DBS.getBeforeSleepTime();
	}
	
	public DBSetting getDBSetting() {
		if(DBS == null){
			DBS = getDBSettingFromDB();
		}
		return DBS;
	}
	
	/**
	 * @return DBSetting 
	 * get a new object from database
	 */
	public DBSetting getDBSettingFromDB() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<DBSetting> DBSs = (List<DBSetting>)session.createQuery("from DBSetting DBS where DBS.status > 0").list();
		tx.commit();
		session.close();
		
		if(DBSs == null || DBSs.isEmpty()) {
			return initDBSetting();
		}
		return DBSs.get(0);
	}
	
	/**
	 * @return DBSetting
	 * initialize a DBSetting and save to database
	 */
	private DBSetting initDBSetting() {
		DBSetting dbs = new DBSetting();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("InitDBSetting"); // read properties init setting value
		dbs.setBeforeSleepTime(Integer.parseInt(resourceBundle.getString("beforeSleepTime")));
		dbs.setSleepTime(Integer.parseInt(resourceBundle.getString("sleepTime")));
		dbs.setNoticeTime(Integer.parseInt(resourceBundle.getString("noticeTime")));
		dbs.setBeforeNoticeTime(Integer.parseInt(resourceBundle.getString("beforeNoticeTime")));
		dbs.setWorkTime(Integer.parseInt(resourceBundle.getString("workTime")));
		dbs.setStatus(1);
		dbs.setId(1);
		saveDBSetting(dbs);
		return dbs;
	}
	
	private void removeAllSetting() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.createSQLQuery("delete from DBSetting");
		tx.commit();
		session.close();
	}
	
	/**
	 * @param dbs
	 * saveOrUpdate dbs to database
	 */
	public void saveDBSetting(DBSetting dbs) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(dbs);
		tx.commit();
		session.close();
	}
}
