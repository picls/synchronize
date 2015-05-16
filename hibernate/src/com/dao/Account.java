package com.dao;

import java.util.Date;

public class Account implements Base {
	protected long id;
	protected String name;
	protected String password;
	protected String email;
	protected long qq;
	protected Date createTime;
	protected Date lastLoginTime;
	protected int status;
	protected User user;

	public Account() {

	}

	public Account(String name, String password, String email) {
		this(name, password, email, 0l, new Date(), new Date(), 1);
	}

	public Account(String name, String password, String email, long qq) {
		this(name, password, email, qq, new Date(), new Date(), 1);
	}

	public Account(String name, String password, String email, long qq,
			Date createTime, Date LastLoginTime, int status) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.qq = qq;
		this.createTime = createTime;
		this.lastLoginTime = LastLoginTime;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getQq() {
		return qq;
	}

	public void setQq(long qq) {
		this.qq = qq;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		String back = null;
		back = "com.dao.Account[" + "id=" + id + ",name=" + name + ",password="
				+ password + ",email=" + email + ",qq=" + qq + ",createTime="
				+ createTime.toString() + ",lastLoginTime="
				+ lastLoginTime.toString() + ",status=" + status + "]";
		return back;
	}

	public String toString(String delimiter) {
		String back = null;
		back = id + delimiter + name + delimiter + password + delimiter + email
				+ delimiter + qq + delimiter + createTime.toString()
				+ delimiter + lastLoginTime.toString() + delimiter + status;
		return back;
	}

}
