package com.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import base.RelyException;

import com.dao.*;
import com.web.JAccount.StateEnum;
import com.web.exception.DuplicateDataException;
import com.web.exception.NullDataException;

/**
 * 
 * @author anzhixiang
 * 
 */

public class JUser {

	public static void main(String args[]) {
		JUser juser = new JUser();
	}

	/** Cache the hash code for the User */
	private int hash;

	private User user;

	/**  */
	private JUser() {

	}

	public JUser(String name, String nickname, boolean attachAccount)
			throws RelyException {
		setUser(new User(name, nickname, attachAccount));
	}

	public JUser(String name, String nickname, String description,
			String constellation, boolean attachAccount) throws RelyException {
		setUser(new User(name, nickname, description, constellation,
				attachAccount));
	}

	public JUser(String name, String nickname, String description, int level,
			int article, int integration, String constellation, int status,
			boolean attachAccount) throws RelyException {
		setUser(new User(name, nickname, description, level, article,
				integration, constellation, status, attachAccount));
	}

	/**  */
	public JUser(String username) throws NullDataException {
		setUser(username);
	}

	/**  */
	public JUser(long id) throws NullDataException {
		setUser(id);
	}

	private void setUser(User user) {
		this.user = user;
	}

	private void setUser(String username) throws NullDataException {
		User user = UserManagerStatic.selectOneByProperty("name", username);
		if (user == null)
			throw new NullDataException();
		setUser(user);
	}

	private void setUser(long id) throws NullDataException {
		User user = UserManagerStatic.select(id);
		if (user == null)
			throw new NullDataException();
		setUser(user);
	}

	/**  */
	public void createUser() throws DuplicateDataException {
		// if(this.state == StateEnum.NEW){
		try {
			UserManagerStatic.insert(this.user);
			// this.state = StateEnum.UPDATE;
		} catch (Exception e) {
			long id = this.user.getId();
			throw new DuplicateDataException("User with id " + id
					+ " already existed.");
		}
	}

	/**  */
	public int hashcode() {
		int h = hash;
		h = (int) this.user.getId() * 31 + this.user.getName().hashCode();
		return h;
	}

	public String[] getUserInfo() {
		return this.user.toString("|").split("|");
	}

	public String[] getUserPostInfo() {
		List result = new ArrayList();
		//result = PostManagerStatic.selectAllByProperty("creator", this.id + "");
		String[] back = new String[result.size()];
		Post post = new Post();
		Page page = new Page();
		User user = new User();
		for (int i = 0; i < result.size(); i++) {
			post = (Post) result.get(i);
			page = post.getPage();
			user = post.getUser();
			back[i] += page.getId() + "|";
			back[i] += page.getTitle() + "|";
			back[i] += user.getName() + "|";
			back[i] += post.getContent() + "|";
			back[i] += post.getCreateTime() + "|";
			back[i] += post.getSource();
			if (back[i].endsWith("|"))
				back[i] = back[i] + "none";
		}
		return back;
	}
	
	/**  */
	public static List getUser() {
		List susers = UserManagerStatic.selectAll();
		return susers;
	}
	
	public void createPage(Page page,String title,String content) {
		
	}
	
	public void editPage() {
		
	}

	public void createPost(String title, String content) {
		
	}

	public void editPost() {

	}

	public void createReply() {

	}

	public void editReply() {

	}

	public void createMail() {

	}

	public String[] getUserOnly(String username) {
		String[] back = new String[6];
		User user = UserManagerStatic.selectOneByProperty("name", username);
		if (user != null) {
			back[0] = user.getName();
			back[1] = user.getNickname();
			back[2] = user.getLevel() + "";
			back[3] = user.getArticle() + "";
			back[4] = user.getIntegration() + "";
			back[5] = user.getConstellation();
		} else
			for (int i = 0; i < 6; i++)
				back[i] = "";
		return back;
	}

	public String[] getUserPost(String username) {
		User user = UserManagerStatic.selectOneByProperty("name", username);
		long user_id = user.getId();
		return this.getUserPostById(user_id + "");
	}

	public String[] getUserPostById(String user_id) {
		List result = new ArrayList();
		result = PostManagerStatic.selectAllByProperty("creator", user_id);
		String[] back = new String[result.size()];
		Post post = new Post();
		Page page = new Page();
		User user = new User();
		for (int i = 0; i < result.size(); i++) {
			post = (Post) result.get(i);
			page = post.getPage();
			back[i] += page.getId() + "|";
			back[i] += page.getTitle() + "|";
			back[i] += user.getName() + "|";
			back[i] += post.getContent() + "|";
			back[i] += post.getCreateTime() + "|";
			back[i] += post.getSource();
			if (back[i].endsWith("|"))
				back[i] = back[i] + "none";
		}
		return back;
	}

	public String getTime() {
		return new Date().toString();
	}

}
