package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import base.BaseManager;

public class PageManagerStatic {

	public final static Session session;
	public final static BaseManager baseManager;
	public final static String className;

	static {
		session = HibernateUtilFormal.currentSession();
		baseManager = new BaseManager(session, false);
		className = "com.dao.Page";
	}

	/**
	 * 
	 */
	private PageManagerStatic() {

	}

	public static void insert(Page page) {
		baseManager.insert(page, session);
	}

	/**
	 * 
	 * @param boardId
	 * @param creator
	 * @param title
	 * @param content
	 */
	public static void insert(int boardId, long creator, String title,
			String content) {
		Page page = new Page(boardId, creator, title, content);
		insert(page);
	}

	/**
	 * 
	 * @param boardId
	 * @param creator
	 * @param status
	 * @param url
	 * @param title
	 * @param content
	 */
	public static void insert(int boardId, long creator, int status,
			String url, String title, String content) {
		Page page = new Page(boardId, creator, status, url, title, content);
		insert(page);
	}

	/**
	 * select one record by primary key
	 * 
	 * @param id
	 * @return
	 */
	public static Page select(long id) {
		return (Page) baseManager.select(className, id);
	}

	/**
	 * select all records
	 * 
	 * @return
	 */
	public static List<Page> selectAll() {
		return baseManager.selectAll(className);
	}

	/**
	 * select one record by property
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public static Page selectOneByProperty(String property, String value) {
		return (Page) baseManager.selectOneByProperty(className, property,
				value);
	}

	/**
	 * select all record by property
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public static List<Page> selectAllByProperty(String property, String value) {
		return (List) baseManager.selectAllByProperty(className, property,
				value);
	}

	/**
	 * 
	 * @param con
	 * @param ord
	 * @return
	 */
	public static List<Page> selectAllUnderCon(String con, String ord) {
		return (List) baseManager.select(className, con, ord);
	}

	/**
	 * 
	 * @param page
	 */
	public static void delete(Page page) {
		baseManager.delete(page, session);
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

	/**
	 * 
	 * @param property
	 * @param value
	 */
	public static void updateAllByProperty(String property, String value) {
		baseManager.updateProperty(className, property, value);
	}

	public static void main(String[] args) {
		String act = "list";
		if (act.equals("insert")) {
			// PageManagerStatic.insert(1, creator, title, content)
			// PageManagerStatic.insert(1, , title, content);
			// .insert("testa", "testa", "testa@163.com");
		} else if (act.equals("insertx")) {
			// PageManagerStatic.insert("testb", "testb", "testb@163.com");
		} else if (act.equals("list")) {
			List<Page> accounts = PageManagerStatic.selectAll();
			for (int i = 0; i < accounts.size(); i++) {
				Page page = (Page) accounts.get(i);
				System.out.println(page.toString());
			}
		} else if (act.equals("get")) {
			Page page = PageManagerStatic.selectOneByProperty("name", "admin");
			System.out.println(page.toString());
		} else if (act.equals("delete")) {
			PageManagerStatic.delete(1l);
		} else if (act.equals("user")) {
			Page page = PageManagerStatic.selectOneByProperty("name", "test");
			System.out.println(page.toString());
			System.out.println(page.getUser().toString());
		}

		HibernateUtilFormal.closeSession();
	}
}
