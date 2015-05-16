package com.dao;

import java.util.Date;

public class Post implements Base {
	private long id;
	private long pageId;
	private long creator;
	private String content;
	private long reply;
	private Date createTime;
	private Date lastChangeTime;
	private String source;
	private User user;
	private Page page;

	public Post() {

	}

	public Post(long pageId, long creator, String content) {
		this(pageId, creator, content, 0, new Date(), new Date(), "");
	}

	public Post(long pageId, long creator, String content, long reply,
			String source) {
		this(pageId, creator, content, reply, new Date(), new Date(), source);
	}

	public Post(long pageId, long creator, String content, long reply,
			Date createTime, Date lastChangeTime, String source) {
		this.pageId = pageId;
		this.creator = creator;
		this.content = content;
		this.reply = reply;
		this.createTime = createTime;
		this.lastChangeTime = lastChangeTime;
		this.source = source;
	}

	public long getId() {
		return id;
	}

	// @SuppressWarnings("unused")
	public void setId(long id) {
		this.id = id;
	}

	public long getPageId() {
		return pageId;
	}

	public void setPageId(long pageId) {
		this.pageId = pageId;
	}

	public long getCreator() {
		return creator;
	}

	public void setCreator(long creator) {
		this.creator = creator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getReply() {
		return reply;
	}

	public void setReply(long reply) {
		this.reply = reply;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		String back = null;
		back = "com.dao.Page[" + "id=" + id + ",pageId=" + pageId + ",creator="
				+ creator + ",content=" + content + ",createTime=" + createTime
				+ ",lastChangeTime=" + lastChangeTime + ",source=" + source
				+ "]";
		return back;
	}

	public String toString(String delimiter) {
		String back = null;
		back = id + delimiter + pageId + delimiter + creator + delimiter
				+ content + delimiter + createTime.toString() + delimiter
				+ lastChangeTime.toString() + delimiter + source;
		return back;
	}

}
