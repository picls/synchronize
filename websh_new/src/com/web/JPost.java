package com.web;

import com.dao.Post;
import com.dao.PostManagerStatic;
import com.dao.Post;
import com.dao.PostManagerStatic;
import com.web.JPost.StateEnum;
import com.web.exception.DuplicateDataException;
import com.web.exception.NullDataException;

public class JPost {
	
	/** Cache the hash code for the User */
	private int hash;

	private Post post;
	private StateEnum state; 
	
	public enum StateEnum {
	    NULL,NEW,UPDATE,CHANGE,UNCHECK;
	}

	private JPost() {

	}
	
	public JPost(long pageId, long creator, String content) {
		Post post = new Post(pageId,creator,content);
		this.setPost(post);
	}
	
	public JPost(long pageId, long creator, String content, long reply,
			String source) {
		Post post = new Post(pageId,creator,content,reply,source);
		this.setPost(post);
	}
	
	public JPost(long id) throws NullDataException {
		this.setPost(id);
	}
	
	private void setPost(Post post) {
		this.post = post;
	}

	private void setPost(long id) throws NullDataException {
		Post post = PostManagerStatic.select(id);
		if (post == null)
			throw new NullDataException("Post with id " + id + " not existed.");
		this.setPost(post);
	}

	public void createPost() throws DuplicateDataException {
		if (this.state == StateEnum.NEW) {
			try {
				PostManagerStatic.insert(this.post);
				this.state = StateEnum.UPDATE;
			} catch (Exception e) {
				long id = this.post.getId();
				throw new DuplicateDataException("Post with id " + id
						+ " already existed.");
			}
		}
	}
	
	

}
