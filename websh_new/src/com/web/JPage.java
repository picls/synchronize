package com.web;

import java.util.ArrayList;
import java.util.List;

import com.dao.Page;
import com.dao.PageManagerStatic;
import com.dao.Post;
import com.dao.PostManagerStatic;
import com.dao.User;
import com.web.exception.DuplicateDataException;
import com.web.exception.NullDataException;

public class JPage {

	/** Cache the hash code for the User */
	private int hash;

	private Page page;
	private StateEnum state;

	public enum StateEnum {
		NULL, NEW, UPDATE, CHANGE, UNCHECK;
	}

	private JPage() {

	}

	public JPage(int boardId, long creator, String title, String content) {
		Page page = new Page(boardId, creator, title, content);
		this.setPage(page);
	}

	public JPage(long id) throws NullDataException {
		this.setPage(id);
	}

	public Page getPage() {
		return this.page;
	}

	private void setPage(Page page) {
		this.page = page;
	}

	private void setPage(long id) throws NullDataException {
		Page page = PageManagerStatic.select(id);
		if (page == null)
			throw new NullDataException("Page with id " + id + " not existed.");
		this.setPage(page);
	}

	public void createPage() throws DuplicateDataException {
		if (this.state == StateEnum.NEW) {
			try {
				PageManagerStatic.insert(this.page);
				this.state = StateEnum.UPDATE;
			} catch (Exception e) {
				long id = this.page.getId();
				throw new DuplicateDataException("Page with id " + id
						+ " already existed.");
			}
		}
	}

	public List<Post> getPost() {
		List<Post> back = new ArrayList<Post>();
		long id = this.page.getId();
		back = PostManagerStatic.selectAllByProperty("creator", id + "");
		return back;
	}

	public List<String[]> getPosts() {
		List<String[]> back = new ArrayList<String[]>();
		List<Post> l = this.getPost();
		for (Post p : l) {
			String[] temp = p.toString("|&*").split("|&*");
			back.add(temp);
		}
		return back;
	}

	public List<JPost> getJPost() {
		List<JPost> back = new ArrayList<JPost>();
		long id = this.page.getId();
		List temp = PostManagerStatic.selectAllByProperty("creator", id + "");
		//back = 
		return back;
	}

	public void editPage() {

	}

	public void deletePage(User user) {
		PageManagerStatic.delete(this.page);
	}

}
