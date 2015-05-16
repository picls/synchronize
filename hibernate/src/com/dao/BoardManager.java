package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

import base.*;

public class BoardManager extends BaseManager {

	/**
	 * 
	 */
	public BoardManager() {
		super(HibernateUtilFormal.currentSession(), false);
	}

	public BoardManager(Session session, boolean closeOnce) {
		super(session, closeOnce);
	}

	/**
	 * create and insert one record
	 * @param name
	 */
	public void insert(String name) {
		Session session = HibernateUtilFormal.currentSession();
		Transaction tx = session.beginTransaction();

		Board board = new Board(name);
		session.save(board);

		tx.commit();
		// User user = new User(name, name);
		// this.insert(name, password, email, user);
	}

	public void insert(String name, Date createTime, Date lastLoginTime,
			int postNumber, long master, int status) {
		Session session = HibernateUtilFormal.currentSession();
		Transaction tx = session.beginTransaction();

		Board board = new Board(name, createTime, lastLoginTime, postNumber,
				master, status);
		session.save(board);

		tx.commit();
		// HibernateUtilFormal.closeSession();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	// select one record by primary key
	public Board select(long id) {
		return (Board) super.select("com.dao.Board", id);
	}

	// select all records
	public List selectAll() {
		return super.selectAll("Board");
	}

	// select one record by property
	public Board selectOneByProperty(String property, String value) {
		return (Board) super.selectOneByProperty("Board", property, value);
	}

	// select all record by property
	public List selectAllByProperty(String property, String value) {
		return (List) super.selectAllByProperty("Board", property, value);
	}

	public void delete(long id) {
		super.delete("com.dao.Board", id);
	}

	public void deleteAllByProperty(String property, String value) {
		super.deleteAllByProperty("Board", property, value);
	}

	public void updateAllByProperty(String property, String value) {
		super.updateProperty("Board", property, value);
	}

	public static void main(String[] args) {
		BoardManager mgr = new BoardManager();

		/*
		 * Board accountx = mgr.select(2l); System.out.println("Name: " +
		 * accountx.getName() + " Email: " + accountx.getEmail());
		 * System.exit(0);
		 */

		String act = "insert";

		if (act.equals("insert")) {
			mgr.insert("testa");
		} else if (act.equals("insertx")) {
			mgr.insert("testb");
		} else if (act.equals("list")) {
			List accounts = mgr.selectAll();
			for (int i = 0; i < accounts.size(); i++) {
				Board board = (Board) accounts.get(i);
				System.out.println(board.toString());
				// System.out.println("Name: " + board.getName() + " Email: "
				// + board.getEmail());
			}
		} else if (act.equals("get")) {
			Board board = mgr.selectOneByProperty("name", "admin");
			System.out.println(board.toString());
		} else if (act.equals("delete")) {
			mgr.delete(1l);
		} else if (act.equals("user")) {
			Board board = mgr.selectOneByProperty("name", "test");
			System.out.println(board.toString());
			//System.out.println(board.getUser().toString());
		}

		HibernateUtilFormal.closeSession();
	}

}
