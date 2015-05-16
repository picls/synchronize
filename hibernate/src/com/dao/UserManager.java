package com.dao;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.List;

import base.*;

public class UserManager extends BaseManager {

	/**
	 * 
	 * @param user
	 */
	public void insert(User user) {
		Session session = HibernateUtilFormal.currentSession();
		Transaction tx = session.beginTransaction();

		session.save(user);

		tx.commit();
		// HibernateUtilFormal.closeSession();
	}

	/**
	 * 
	 * @param name
	 * @param nickname
	 * @throws RelyException
	 */
	public void insert(String name, String nickname) throws RelyException {
		Session session = HibernateUtilFormal.currentSession();
		User user = new User(name, nickname, true);

		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	public void insert(String name, String nickname, String description,
			String constellation) throws RelyException {
		Session session = HibernateUtilFormal.currentSession();
		User user = new User(name, nickname, description, constellation, true);

		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	public void insert(String name, String nickname, String description,
			int level, int article, int integration, String constellation,
			int status) throws RelyException {
		Session session = HibernateUtilFormal.currentSession();
		User user = new User(name, nickname, description, level, article,
				integration, constellation, status, true);

		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	/**
	 * select one record by primary key
	 * 
	 * @param id
	 * @return
	 */
	public User select(long id) {
		return (User) super.select("com.dao.User", id);
	}

	/**
	 * select all records
	 * 
	 * @return
	 */
	public List selectAll() {
		return super.selectAll("User");
	}

	// select one record by property
	public User selectOneByProperty(String property, String value) {
		return (User) super.selectOneByProperty("User", property, value);
	}

	// select all record by property
	public List selectAllByProperty(String property, String value) {
		return (List) super.selectAllByProperty("User", property, value);
	}

	public void delete(long id) {
		super.delete("com.dao.User", id);
	}

	public void deleteAllByProperty(String property, String value) {
		super.deleteAllByProperty("User", property, value);
	}

	public void updateAllByProperty(String property, String value) {
		super.updateProperty("User", property, value);
	}

	public static void main(String[] args) {
		UserManager mgr = new UserManager();

		String act = "list";

		if (act.equals("insert")) {
			try {
				mgr.insert("test", "test");
			} catch (RelyException re) {
				re.printStackTrace();
			}
		} else if (act.equals("list")) {
			List users = mgr.selectAll();
			for (int i = 0; i < users.size(); i++) {
				User user = (User) users.get(i);
				System.out.println("Name: " + user.getName() + " Nickname: "
						+ user.getNickname());
			}
		} else if (act.equals("get")) {
			User user = mgr.selectOneByProperty("name", "admin");
			System.out.println("Name: " + user.getName() + " Nickname: "
					+ user.getNickname());
		} else if (act.equals("delete")) {
			mgr.delete(1l);
		} else if (act.equals("account")) {
			User user = mgr.selectOneByProperty("name", "limingze");
			System.out.println(user.toString());
			System.out.println(user.getAccount().toString());
		}

		HibernateUtilFormal.closeSession();
	}

}
