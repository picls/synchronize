package com.dao;

import java.util.List;

import org.hibernate.Session;

import base.BaseManager;

//@SuppressWarnings("unchecked")
public class PostManagerStatic {

	public final static Session session;
	public final static BaseManager baseManager;
	public final static String className;

	static {
		session = HibernateUtilFormal.currentSession();
		baseManager = new BaseManager(session, false);
		className = "com.dao.Post";
	}

	/**
	 * 
	 */
	private PostManagerStatic() {

	}
	
	public static void insert(Post post) {
		baseManager.insert(post, session);
	}

	/**
	 * 
	 * @param pageId
	 * @param creator
	 * @param content
	 */
	public static void insert(long pageId, long creator, String content) {
		Post post = new Post(pageId, creator, content);
		insert(post);
	}

	/**
	 * 
	 * @param pageId
	 * @param creator
	 * @param content
	 * @param reply
	 * @param source
	 */
	public static void insert(long pageId, long creator, String content,
			long reply, String source) {
		Post post = new Post(pageId, creator, content, reply, source);
		insert(post);
	}

	/**
	 * select one record by primary key
	 * 
	 * @param id
	 * @return
	 */
	public static Post select(long id) {
		return (Post) baseManager.select(className, id);
	}

	/**
	 * select all records
	 * 
	 * @return
	 */
	public static List<Post> selectAll() {
		return baseManager.selectAll(className);
	}

	/**
	 * select one record by property
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public static Post selectOneByProperty(String property, String value) {
		return (Post) baseManager.selectOneByProperty(className, property,
				value);
	}

	/**
	 * select all record by property
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public static List<Post> selectAllByProperty(String property, String value) {
		return (List<Post>) baseManager.selectAllByProperty(className, property,
				value);
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
			// PageManagerStatic.insert("testa", "testa", "testa@163.com");
		} else if (act.equals("insertx")) {
			// PageManagerStatic.insert("testb", "testb", "testb@163.com");
		} else if (act.equals("list")) {
			List<Post> accounts = PostManagerStatic.selectAll();
			for (int i = 0; i < accounts.size(); i++) {
				Post post = (Post) accounts.get(i);
				System.out.println(post.toString());
			}
		} else if (act.equals("get")) {
			Post post = PostManagerStatic.selectOneByProperty("name", "admin");
			System.out.println(post.toString());
		} else if (act.equals("delete")) {
			PostManagerStatic.delete(1l);
		} else if (act.equals("user")) {
			Post post = PostManagerStatic.selectOneByProperty("name", "test");
			System.out.println(post.toString());
			//System.out.println(post.getUser().toString());
		}

		HibernateUtilFormal.closeSession();
	}

}
