package com.dao;

import java.util.Date;
import base.RelyException;

public class User implements Base {
	protected long id;
	protected String name;
	protected String nickname;
	protected String description;
	protected int level;
	protected int article;
	protected int integration;
	protected String constellation;
	protected Date createTime;
	protected Date lastLoginTime;
	protected int status;
	protected Account account;

	public User() {

	}

	public User(String name, String nickname, boolean attachAccount)
			throws RelyException {
		this(name, nickname, null, 0, 0, 0, null, new Date(), new Date(), 1,
				attachAccount);
	}

	public User(String name, String nickname, String description,
			String constellation, boolean attachAccount) throws RelyException {
		this(name, nickname, description, 0, 0, 0, constellation, new Date(),
				new Date(), 1, attachAccount);
	}

	public User(String name, String nickname, String description, int level,
			int article, int integration, String constellation, int status,
			boolean attachAccount) throws RelyException {
		this(name, nickname, description, level, article, integration,
				constellation, new Date(), new Date(), status, attachAccount);
	}

	public User(String name, String nickname, String description, int level,
			int article, int integration, String constellation,
			Date createTime, Date lastLoginTime, int status,
			boolean attachAccount) throws RelyException {
		if (attachAccount) {
			if (AccountManagerStatic.selectOneByProperty("name", name) == null)
				throw new RelyException("no such account with name = " + name);
			long id = AccountManagerStatic.selectOneByProperty("name", name)
					.getId();
			this.id = id;
		}
		this.name = name;
		this.nickname = nickname;
		this.description = description;
		this.level = level;
		this.article = article;
		this.integration = integration;
		this.constellation = constellation;
		this.createTime = createTime;
		this.lastLoginTime = lastLoginTime;
		this.status = status;
	}

	public User(long id, String name, String nickname, String description,
			int level, int article, int integration, String constellation,
			Date createTime, Date lastLoginTime, int status) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.description = description;
		this.level = level;
		this.article = article;
		this.integration = integration;
		this.constellation = constellation;
		this.createTime = createTime;
		this.lastLoginTime = lastLoginTime;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getArticle() {
		return article;
	}

	public void setArticle(int article) {
		this.article = article;
	}

	public int getIntegration() {
		return integration;
	}

	public void setIntegration(int integration) {
		this.integration = integration;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		String back = null;
		back = "com.dao.User[" + "id=" + id + ",name=" + name + ",nickname="
				+ nickname + ",description=" + description + ",level=" + level
				+ ",article=" + article + ",integration=" + integration
				+ ",constellation=" + constellation + ",createTime="
				+ createTime.toString() + ",lastLoginTime="
				+ lastLoginTime.toString() + ",status=" + status + "]";
		return back;
	}

	public String toString(String delimiter) {
		String back = null;
		back = id + delimiter + name + delimiter + nickname + delimiter
				+ description + delimiter + level + delimiter + article
				+ delimiter + integration + delimiter + constellation
				+ delimiter + createTime.toString() + delimiter
				+ lastLoginTime.toString() + delimiter + status;
		return back;
	}
}
