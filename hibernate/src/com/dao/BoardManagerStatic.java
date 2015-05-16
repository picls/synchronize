package com.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import base.BaseManager;

public class BoardManagerStatic {

	public final static Session session;
	public final static BaseManager baseManager;
	public final static String className;

	static {
		session = HibernateUtilFormal.currentSession();
		baseManager = new BaseManager(session, false);
		className = "com.dao.Board";
	}

	/**
	 * 
	 */
	private BoardManagerStatic() {

	}
	
	/**
	 * 
	 * @param board
	 */
	public static void insert(Board board) {
		baseManager.insert(board, session);
	}

	/**
	 * create and insert one record
	 * @param name
	 */
	public static void insert(String name) {
		Board board = new Board(name);
		insert(board);
	}

	/**
	 * 
	 * @param name
	 * @param createTime
	 * @param lastLoginTime
	 * @param postNumber
	 * @param master
	 * @param status
	 */
	public static void insert(String name, Date createTime, Date lastLoginTime,
			int postNumber, long master, int status) {
		Board board = new Board(name, createTime, lastLoginTime, postNumber,
				master, status);
		insert(board);
	}

	/**
	 * select one record by primary key
	 * @param id
	 * @return
	 */
	public static Board select(long id) {
		return (Board) baseManager.select(className, id);
	}

	/**
	 * select all records
	 * @return
	 */
	public static List selectAll() {
		return baseManager.selectAll(className);
	}

	/**
	 * select one record by property
	 * @param property
	 * @param value
	 * @return
	 */
	public static Board selectOneByProperty(String property, String value) {
		return (Board) baseManager.selectOneByProperty(className, property, value);
	}

	/**
	 * select all record by property
	 * @param property
	 * @param value
	 * @return
	 */
	public static List selectAllByProperty(String property, String value) {
		return (List) baseManager.selectAllByProperty(className, property, value);
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
			BoardManagerStatic.insert("testa");
		} else if (act.equals("insertx")) {
			BoardManagerStatic.insert("testb");
		} else if (act.equals("list")) {
			List boards = BoardManagerStatic.selectAll();
			for (int i = 0; i < boards.size(); i++) {
				Board board = (Board) boards.get(i);
				System.out.println(board.toString());
			}
		} else if (act.equals("get")) {
			Board board = BoardManagerStatic.selectOneByProperty("name", "admin");
			System.out.println(board.toString());
		} else if (act.equals("delete")) {
			BoardManagerStatic.delete(1l);
		} else if (act.equals("user")) {
			Board board = BoardManagerStatic.selectOneByProperty("name", "test");
			System.out.println(board.toString());
			//System.out.println(board.getUser().toString());
		}

		HibernateUtilFormal.closeSession();
	}
	
}
