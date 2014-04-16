package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import model.DBSetting;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class SettingManager {
	private static SettingManager setting;
	private Dimension screenSize;
	private DBSetting DBS;
	
	static {
		setting = new SettingManager();
		setting.setScreenSize(Toolkit.getDefaultToolkit().getScreenSize());
		setting.getDBSetting();
	}
	
	public static SettingManager getSetting() {
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
	
	public DBSetting initDBSetting() {
		DBSetting dbs = new DBSetting();
		dbs.setBeforeSleepTime(60);
		dbs.setStatus(1);
		dbs.setId(1);
		saveDBSetting(dbs);
		return dbs;
	}
	
	public void removeAllSetting() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.createSQLQuery("delete from DBSetting");
		tx.commit();
		session.close();
	}
	
	public void saveDBSetting(DBSetting dbs) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(dbs);
		tx.commit();
		session.close();
	}
}
