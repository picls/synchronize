package backup;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

import base.HibernateUtil;

@SuppressWarnings("unused")
public class BaseManager {

	public final int[] ii = { 1, 2, 3 };

	public static void main(String args[]) {
		BaseManager bm = new BaseManager();

		List l = (List) bm.select("com.dao.s.SUser", 10, "where article > 10",
				"order by article");
		l = (List) bm.selectByProperty("com.dao.s.SPage", "boardId", "4", 0,
				"where page_num >=5 order by time desc");
		// System.out.println(l);
		// l = BaseManager.selectAll("SUser");
		System.out.println(l.get(0).toString());
		System.out.println("--------------------");
		System.out.println(l.getClass().getComponentType());

	}

	private final Session session;
	private final boolean closeOnce;

	// private String className = null;

	public BaseManager() {
		session = HibernateUtil.currentSession();
		closeOnce = false;
	}

	public BaseManager(Session session, boolean closeOnce) {
		this.session = session;
		this.closeOnce = closeOnce;
	}

	/**
	 * create and insert one record
	 * 
	 * @param object
	 * @param session
	 */
	public void insert(Object object, Session session) {
		Transaction tx = session.beginTransaction();
		session.save(object);
		tx.commit();
		// HibernateUtil.closeSession();
	}

	public void insert(Object object) {
		this.insert(object, this.session);
	}

	/**
	 * 根据id返回选择结果
	 * 
	 * @param className
	 * @param id
	 * @param session
	 * @return
	 */
	public Object select(String className, long id, Session session) {
		Transaction tx = session.beginTransaction();

		Object o = null;
		try {
			o = session.get(Class.forName(className), id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		tx.commit();
		// if (closeOnce)
		// session.close();
		return o;
	}

	public Object select(String className, long id) {
		return this.select(className, id, this.session);
	}

	/**
	 * 
	 * @param className
	 * @param con
	 * @param ord
	 * @param session
	 * @return
	 */
	public Object select(String className, String con, String ord,
			Session session) {
		Transaction tx = session.beginTransaction();
		con = con.trim();
		ord = ord.trim();
		if ((!con.startsWith("where")) && (con != null) && (con != ""))
			con = "where " + con;
		// con = con.replaceFirst("where", "");
		if ((!ord.startsWith("order by")) && (ord != null) && (ord != ""))
			ord = "order by " + con;
		// ord = ord.replaceFirst("order by", "");

		Query query = session.createQuery("from " + className + " " + con + " "
				+ ord);
		List<?> result = query.list();

		tx.commit();
		// if (this.closeOnce)
		// session.close();

		return result;
	}

	public Object select(String className, String con, String ord) {
		return this.select(className, con, ord, this.session);
	}

	/**
	 * 
	 * @param className
	 * @param num
	 * @param con
	 * @param ord
	 * @param session
	 * @return
	 */
	public Object select(String className, int num, String con, String ord,
			Session session) {
		List<?> result = (List<?>) this.select(className, con, ord, session);

		if (num == 0)
			return result;
		else if (num == 1)
			if (result.size() > 0)
				return result.get(0);
			else
				return null;
		else {
			List back = new ArrayList();
			if (num <= result.size()) {
				for (int i = 0; i < num; i++)
					back.add(result.get(i));
				return back;
			} else
				return result;
		}
	}

	public Object select(String className, int num, String con, String ord) {
		return this.select(className, num, con, ord, this.session);

	}

	/**
	 * 
	 * @param className
	 * @param property
	 * @param value
	 * @param num
	 * @param con
	 * @param session
	 * @return
	 */
	public Object selectByProperty(String className, String property,
			String value, int num, String con, Session session) {
		Transaction tx = session.beginTransaction();
		if (con.startsWith("where"))
			con = con.replaceFirst("where", "and");

		Query query = session.createQuery("from " + className + " where "
				+ property + " = '" + value + "' " + con);
		List result = query.list();

		tx.commit();
		// if (closeOnce)
		// session.close();

		if (num == 0)
			return result;
		else if (num == 1)
			if (result.size() > 0)
				return result.get(0);
			else
				return null;
		else {
			List back = new ArrayList();
			if (num <= result.size()) {
				for (int i = 0; i < num; i++)
					back.add(result.get(i));
				return back;
			} else
				return result;
		}
	}

	public Object selectByProperty(String className, String property,
			String value, int num, String con) {
		return this.selectByProperty(className, property, value, num, con,
				this.session);
	}

	/**
	 * 
	 * @param className
	 * @param property
	 * @param value
	 * @param num
	 * @param session
	 * @return
	 */
	public Object selectByProperty(String className, String property,
			String value, int num, Session session) {
		return selectByProperty(className, property, value, num, "", session);
	}

	public Object selectByProperty(String className, String property,
			String value, int num) {
		return selectByProperty(className, property, value, num, this.session);
	}

	/**
	 * 选择一个符合条件的结果
	 * 
	 * @param className
	 * @param property
	 * @param value
	 * @param session
	 * @return
	 */
	public Object selectByProperty(String className, String property,
			String value, Session session) {
		return selectByProperty(className, property, value, 1, session);
	}

	public Object selectByProperty(String className, String property,
			String value) {
		return selectByProperty(className, property, value, this.session);
	}

	/**
	 * 选择一个符合条件的结果
	 * 
	 * @param className
	 * @param property
	 * @param value
	 * @param session
	 * @return
	 */
	public Object selectOneByProperty(String className, String property,
			String value, Session session) {
		return selectByProperty(className, property, value, 1, session);
	}

	public Object selectOneByProperty(String className, String property,
			String value) {
		return this.selectOneByProperty(className, property, value,
				this.session);
	}

	/**
	 * 选作所有符合条件的结果
	 * 
	 * @param className
	 * @param property
	 * @param value
	 * @return
	 */
	public Object selectAllByProperty(String className, String property,
			String value, Session session) {
		return this.selectByProperty(className, property, value, session);
	}

	public Object selectAllByProperty(String className, String property,
			String value) {
		return this.selectAllByProperty(className, property, value, session);
	}

	/**
	 * 选择所有符合条件、排序的结果
	 * 
	 * @param className
	 * @param property
	 * @param value
	 * @param con
	 * @param session
	 * @return
	 */
	public Object selectAllByProperty(String className, String property,
			String value, String con, Session session) {
		return this.selectByProperty(className, property, value, 0, con,
				session);
	}

	public Object selectAllByProperty(String className, String property,
			String value, String con) {
		return this.selectAllByProperty(className, property, value, con,
				this.session);
	}

	/**
	 * 
	 * @param className
	 * @param con
	 * @return
	 */
	public List selectAll(String className, String con, Session session) {
		Transaction tx = session.beginTransaction();

		List result = session.createQuery("from " + className + con).list();

		tx.commit();
		// if (closeOnce)
		// session.close();
		return result;
	}

	public List selectAll(String className, String con) {
		return this.selectAll(className, con, this.session);
	}

	/**
	 * 
	 * @param className
	 * @return
	 */
	public List selectAll(String className, Session session) {
		return this.selectAll(className, "", session);
	}

	public List selectAll(String className) {
		return this.selectAll(className, this.session);
	}

	public Object selectSum(String className, String property, Session session) {
		//Transaction tx = session.beginTransaction();

		String hql = String.format("select sum(%s) from %s", property, className);
		Query query = session.createQuery(hql);
		Object back = query.iterate().next();

		//tx.commit();
		return back;
	}

	/**
	 * 
	 * @param className
	 * @param id
	 */
	public void delete(String className, long id, Session session) {
		//Transaction tx = session.beginTransaction();

		Object o = null;
		try {
			o = session.get(Class.forName(className), id);
			session.delete(o);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//tx.commit();
		// if (closeOnce)
		// session.close();
	}

	public void delete(String className, long id) {
		this.delete(className, id, this.session);
	}

	/**
	 * 
	 * @param className
	 * @param property
	 * @param value
	 */
	public void deleteAllByProperty(String className, String property,
			String value, Session session) {
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("delete from " + className
				+ " where " + property + " = " + value);

		tx.commit();
	}

	public void deleteAllByProperty(String className, String property,
			String value) {
		this.deleteAllByProperty(className, property, value, this.session);
	}
	
	public void update(Object object, Session session) {
		session.update(object);
	}

	/**
	 * 
	 * @param className
	 * @param property
	 * @param value
	 */
	public void updateProperty(String className, String property, String value,
			Session session) {
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("update from " + className
				+ " where " + property + " = " + value);

		tx.commit();
	}

	public void updateProperty(String className, String property, String value) {
		this.updateProperty(className, property, value, this.session);
	}

}
