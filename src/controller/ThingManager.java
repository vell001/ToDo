package controller;

import java.util.List;

import model.Thing;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

/**
 * @author VellBibi
 */
public class ThingManager {
	private static ThingManager thingManager = null;
	
	static {
		thingManager = new ThingManager();
	}
	
	public static ThingManager getThingManager() {
		return thingManager;
	}
	
	public void saveThing(Thing thing) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(thing);
		tx.commit();
		session.close();
	}
	
	public List<Thing> getAllThings() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<Thing> things = (List<Thing>)session.createQuery("from Thing").list();
		tx.commit();
		session.close();
		return things;
	}
	
	public List<Thing> getToDoThings() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<Thing> things = (List<Thing>)session.createQuery("from Thing thing where thing.status > 0").list();
		tx.commit();
		session.close();
		return things;
	}
}
