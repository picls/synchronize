package com.dao;

import java.util.Date;

public class Board implements Base {

	protected long id;
	protected String name;
	protected Date createTime;
	protected Date lastChangeTime;
	protected int postNumber;
	protected long master;
	protected int status;
	//protected User masterUser;

	public Board() {

	}

	public Board(String name) {
		this(name, new Date(), new Date(), 0, 0l, 1);
	}

	public Board(String name, int postNumber, long master) {
		this(name, new Date(), new Date(), postNumber, master, 1);
	}

	public Board(String name, Date createTime, Date lastChangeTime,
			int postNumber, long master, int status) {
		this.name = name;
		this.createTime = createTime;
		this.lastChangeTime = lastChangeTime;
		this.postNumber = postNumber;
		this.master = master;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	//@SuppressWarnings("unused")
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastChangeTime() {
		return lastChangeTime;
	}

	public void setLastChangeTime(Date lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}

	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	public long getMaster() {
		return master;
	}

	public void setMaster(long master) {
		this.master = master;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

/*	public User getMasterUser() {
		return masterUser;
	}

	public void setMasterUser(User masterUser) {
		this.masterUser = masterUser;
	}*/

	@Override
	public String toString() {
		String back = null;
		back = "com.dao.Board[" + "id=" + id + ",name=" + name + ",createTime="
				+ createTime.toString() + ",lastLoginTime="
				+ lastChangeTime.toString() + ",postNumber=" + postNumber
				+ ",master=" + master + ",status=" + status + "]";
		return back;
	}

	public String toString(String delimiter) {
		String back = null;
		back = id + delimiter + name + delimiter + createTime.toString()
				+ delimiter + lastChangeTime.toString() + delimiter + postNumber
				+ delimiter + master + delimiter + status;
		return back;
	}

}
