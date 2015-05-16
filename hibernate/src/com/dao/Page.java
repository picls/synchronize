package com.dao;

import java.util.Date;

public class Page {
	protected long id;
	protected int boardId;
	protected long creator;
	protected int status;
	protected String url;
	protected String title;
	protected String content;
	protected int replyNumber;
	protected Date createTime;
	protected Date lastChangeTime;
	protected User user;

	public Page() {

	}

	public Page(int boardId, long creator, String title, String content) {
		this(boardId, creator, 1, "", title, content, 0, new Date(), new Date());
	}

	public Page(int boardId, long creator, int status, String url,
			String title, String content) {
		this(boardId, creator, status, url, title, content, 0, new Date(),
				new Date());
	}

	public Page(int boardId, long creator, int status, String url,
			String title, String content, int replyNumber, Date createTime,
			Date lastChangeTime) {
		this.boardId = boardId;
		this.creator = creator;
		this.status = status;
		this.url = url;
		this.title = title;
		this.content = content;
		this.replyNumber = replyNumber;
		this.createTime = createTime;
		this.lastChangeTime = lastChangeTime;

	}

	public long getId() {
		return id;
	}

	//@SuppressWarnings("unused")
	public void setId(long id) {
		this.id = id;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public long getCreator() {
		return creator;
	}

	public void setCreator(long creator) {
		this.creator = creator;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReplyNumber() {
		return replyNumber;
	}

	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		String back = null;
		back = "com.dao.Page[" + "id=" + id + ",boardId=" + boardId + ",creator="
				+ creator + ",status=" + status + ",url=" + url + ",title="
				+ title + ",content=" + content + ",replyNumber" + replyNumber
				+ ",createTime=" + createTime.toString() + ",lastChangeTime="
				+ lastChangeTime.toString() + "]";
		return back;
	}

	public String toString(String delimiter) {
		String back = null;
		back = id + delimiter + boardId + delimiter + creator + delimiter
				+ status + delimiter + url + delimiter + title + delimiter
				+ content + delimiter + replyNumber + delimiter
				+ createTime.toString() + delimiter + lastChangeTime.toString();
		return back;
	}
}
