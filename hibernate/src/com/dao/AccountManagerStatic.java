package com.dao;

import org.hibernate.Transaction;
import org.hibernate.Session;
//import org.hibernate.Query;

//import java.util.Arrays;
//import java.util.Date;
import java.util.List;

import base.*;


public final class AccountManagerStatic {

	public final static Session session;
	public final static BaseManager baseManager;
	public final static String className;

	static {
		session = HibernateUtilFormal.currentSession();
		baseManager = new BaseManager(session, false);
		className = "com.dao.Account";
	}

	/**
	 * 
	 */
	private AccountManagerStatic() {

	}
	
	public static void insert(Account account) {
		baseManager.insert(account, session);
	}

	/**
	 * 
	 * @param name
	 * @param password
	 * @param email
	 */
	public static void insert(String name, String password, String email) {
		Account account = new Account(name, password, email);
		insert(account);
	}

	/**
	 * create and insert Account, attach User 
	 * @param name
	 * @param password
	 * @param email
	 * @param user
	 */
	public static void insert(String name, String password, String email,
			User user) {
		Account account = new Account(name, password, email);
		insert(account);
		user.setId(account.getId());
		UserManagerStatic.insert(user);
	}

	/**
	 * select one record by primary key
	 * @param id
	 * @return
	 */
	public static Account select(long id) {
		return (Account) baseManager.select(className, id);
	}

	/**
	 * select all records
	 * @return
	 */
	public static List<Account> selectAll() {
		return baseManager.selectAll(className);
	}

	/**
	 * select one record by property
	 * @param property
	 * @param value
	 * @return
	 */
	public static Account selectOneByProperty(String property, String value) {
		return (Account) baseManager.selectOneByProperty(className, property, value);
	}

	/**
	 * select all record by property
	 * @param property
	 * @param value
	 * @return
	 */
	public static List<Account> selectAllByProperty(String property, String value) {
		return (List<Account>) baseManager.selectAllByProperty(className, property, value);
	}
	
	public static Object selectSum(String property) {
		return baseManager.selectSum(className, property, session);
	}

	/**
	 * 
	 * @param id
	 */
	public static void delete(long id) {
		baseManager.delete(className, id);
	}

	/**
	 * 
	 * @param property
	 * @param value
	 */
	public static void deleteAllByProperty(String property, String value) {
		baseManager.deleteAllByProperty(className, property, value);
	}
	
	public static void update(Account account) {
		baseManager.update(account, session);
	}

	/**
	 * 
	 * @param property
	 * @param value
	 */
	public static void updateAllByProperty(String property, String value) {
		baseManager.updateProperty(className, property, value);
	}

	
	
	public static void main(String[] args) {
//		try{
//			Account accounta = new Account("d", "d", "d");
//			insert(accounta);
//			System.out.println(accounta.getId());
//		}catch(org.hibernate.exception.ConstraintViolationException e){
//			System.out.println(e.getCause().getMessage());
//			System.out.println(e.getMessage());
//		}
//		
//		System.exit(0);
		
//		long id = AccountManagerStatic.selectOneByProperty("name", "dfaf").getId();
//		System.out.println(id);
//		System.exit(0);
		
		String act = "insert";

		if (act.equals("insert")) {
			AccountManagerStatic.insert("testa", "testa", "testa@163.com");
		} else if (act.equals("insertx")) {
			AccountManagerStatic.insert("testb", "testb", "testb@163.com");
		} else if (act.equals("list")) {
			List<Account> accounts = AccountManagerStatic.selectAll();
			for (int i = 0; i < accounts.size(); i++) {
				Account account = (Account) accounts.get(i);
				System.out.println(account.toString());
			}
		} else if (act.equals("get")) {
			Account account = AccountManagerStatic.selectOneByProperty("name", "admin");
			System.out.println(account.toString());
		} else if (act.equals("delete")) {
			AccountManagerStatic.delete(1l);
		} else if (act.equals("user")) {
			Account account = AccountManagerStatic.selectOneByProperty("name", "test");
			System.out.println(account.toString());
			System.out.println(account.getUser().toString());
		}

		HibernateUtilFormal.closeSession();
	}

}