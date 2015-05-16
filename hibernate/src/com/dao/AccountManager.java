package com.dao;

import org.hibernate.Transaction;
import org.hibernate.Session;
//import org.hibernate.Query;

//import java.util.Arrays;
import java.util.Date;
import java.util.List;

import base.*;

public class AccountManager extends BaseManager {

	private static String className;

	/**
	 * 
	 */
	public AccountManager() {
		super(HibernateUtilFormal.currentSession(), false);
		className = "com.dao.Account";
	}

	public AccountManager(Session session, boolean closeOnce) {
		super(session, closeOnce);
		className = "com.dao.Account";
	}

	/**
	 * 
	 * @param name
	 * @param password
	 * @param email
	 */
	public void insert(String name, String password, String email) {
		Session session = HibernateUtilFormal.currentSession();
		Transaction tx = session.beginTransaction();

		Account account = new Account(name, password, email);
		session.save(account);

		tx.commit();
		// User user = new User(name, name);
		// this.insert(name, password, email, user);
	}

	// create and insert one record
	public void insert(String name, String password, String email, User user) {
		Session session = HibernateUtilFormal.currentSession();
		Transaction tx = session.beginTransaction();

		Account account = new Account(name, password, email);
		session.save(account);
		//account.setUser(user);
		//user.setAccount(account);
		user.setId(account.getId());
		session.save(user);

		tx.commit();
		// HibernateUtilFormal.closeSession();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	// select one record by primary key
	public Account select(long id) {
		return (Account) super.select(className, id);
	}

	// select all records
	public List selectAll() {
		return super.selectAll(className);
	}

	// select one record by property
	public Account selectOneByProperty(String property, String value) {
		return (Account) super.selectOneByProperty(className, property, value);
	}

	// select all record by property
	public List selectAllByProperty(String property, String value) {
		return (List) super.selectAllByProperty(className, property, value);
	}

	public void delete(long id) {
		super.delete(className, id);
	}

	public void deleteAllByProperty(String property, String value) {
		super.deleteAllByProperty(className, property, value);
	}

	public void updateAllByProperty(String property, String value) {
		super.updateProperty(className, property, value);
	}

	public static void main(String[] args) {
		System.out.println(1 / 0);
		System.exit(0);
		Session session = HibernateUtilFormal.currentSession();
		Transaction tx = session.beginTransaction();

		Account account1 = new Account("a", "a", "a");
		session.save(account1);
		// User user = new User("a","a");
		// user.setAccount(account1);

		// session.save(user);

		tx.commit();
		System.exit(0);

		AccountManager mgr = new AccountManager();

		/*
		 * Account accountx = mgr.select(2l); System.out.println("Name: " +
		 * accountx.getName() + " Email: " + accountx.getEmail());
		 * System.exit(0);
		 */

		String act = "insert";

		if (act.equals("insert")) {
			mgr.insert("testa", "testa", "testa@163.com");
		} else if (act.equals("insertx")) {
			mgr.insert("testb", "testb", "testb@163.com");
		} else if (act.equals("list")) {
			List accounts = mgr.selectAll();
			for (int i = 0; i < accounts.size(); i++) {
				Account account = (Account) accounts.get(i);
				System.out.println(account.toString());
				// System.out.println("Name: " + account.getName() + " Email: "
				// + account.getEmail());
			}
		} else if (act.equals("get")) {
			Account account = mgr.selectOneByProperty("name", "admin");
			System.out.println(account.toString());
		} else if (act.equals("delete")) {
			mgr.delete(1l);
		} else if (act.equals("user")) {
			Account account = mgr.selectOneByProperty("name", "test");
			System.out.println(account.toString());
			System.out.println(account.getUser().toString());
		}

		HibernateUtilFormal.closeSession();
	}

}