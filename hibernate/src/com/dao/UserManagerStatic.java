package com.dao;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.List;

import base.*;

public class UserManagerStatic extends BaseManager {

	final static Session session;
	final static BaseManager baseManager;
	final static String className;

	static {
		session = HibernateUtilFormal.currentSession();
		baseManager = new BaseManager(session, false);
		className = "com.dao.User";
	}

	/**
	 * 
	 * @param user
	 */
	public static void insert(User user) {
		baseManager.insert(user, session);
	}

	/**
	 * 
	 * @param name
	 * @param nickname
	 */
	public static void insert(String name, String nickname)
			throws RelyException {
		User user = new User(name, nickname, true);
		insert(user);
	}

	/**
	 * 
	 * @param name
	 * @param nickname
	 * @param description
	 * @param constellation
	 */
	public static void insert(String name, String nickname, String description,
			String constellation) throws RelyException {
		User user = new User(name, nickname, description, constellation, true);
		insert(user);
	}

	/**
	 * 
	 * @param name
	 * @param nickname
	 * @param description
	 * @param level
	 * @param article
	 * @param integration
	 * @param constellation
	 * @param status
	 */
	public static void insert(String name, String nickname, String description,
			int level, int article, int integration, String constellation,
			int status) throws RelyException {
		User user = new User(name, nickname, description, level, article,
				integration, constellation, status, true);
		insert(user);
	}

	/**
	 * select one record by primary key
	 * 
	 * @param id
	 * @return
	 */
	public static User select(long id) {
		return (User) baseManager.select("com.dao.User", id);
	}

	/**
	 * select all records
	 * 
	 * @return
	 */
	public static List selectAll() {
		return baseManager.selectAll("User");
	}

	/**
	 * select one record by property
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public static User selectOneByProperty(String property, String value) {
		return (User) baseManager.selectOneByProperty("User", property, value);
	}

	/**
	 * select all record by property
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public static List selectAllByProperty(String property, String value) {
		return (List) baseManager.selectAllByProperty("User", property, value);
	}

	/**
	 * 
	 * @param id
	 */
	public static void delete(long id) {
		baseManager.delete("com.dao.User", id);
	}

	/**
	 * 
	 * @param property
	 * @param value
	 */
	public static void deleteAllByProperty(String property, String value) {
		baseManager.deleteAllByProperty("User", property, value);
	}

	/**
	 * 
	 * @param property
	 * @param value
	 */
	public static void updateAllByProperty(String property, String value) {
		baseManager.updateProperty("User", property, value);
	}

	public static void main(String[] args) {
		String act = "insert";

		if (act.equals("insert")) {
			try {
				UserManagerStatic.insert("testxxx", "test", "a test user",
						"no constellation");
			} catch (RelyException re) {
				re.printStackTrace();
			}
		} else if (act.equals("list")) {
			List users = UserManagerStatic.selectAll();
			for (int i = 0; i < users.size(); i++) {
				User user = (User) users.get(i);
				System.out.println("Name: " + user.getName() + " Nickname: "
						+ user.getNickname());
			}
		} else if (act.equals("get")) {
			User user = UserManagerStatic.selectOneByProperty("name", "admin");
			System.out.println("Name: " + user.getName() + " Nickname: "
					+ user.getNickname());
		} else if (act.equals("delete")) {
			UserManagerStatic.delete(1l);
		} else if (act.equals("account")) {
			User user = UserManagerStatic.selectOneByProperty("name",
					"limingze");
			System.out.println(user.toString());
			System.out.println(user.getAccount().toString());
		}

		HibernateUtilFormal.closeSession();
	}

}
