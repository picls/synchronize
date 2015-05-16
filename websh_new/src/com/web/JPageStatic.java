package com.web;

import java.util.ArrayList;
import java.util.List;

import com.dao.Page;
import com.dao.PageManagerStatic;
import com.dao.User;

public class JPageStatic {

	public static List getPages() {
		List pages = PageManagerStatic.selectAllUnderCon("where board_id <> 101", "order by time desc");
		List back = new ArrayList();

		for (int i = 0; i < pages.size(); i++) {
			Page page = (Page)pages.get(i);
			String temp_back = page.toString("|");
			back.add(temp_back);
		}
		return back;
	}
	
	/*
	String[] p = new String[9];
	Page page = (Page) pages.get(i);
	User user = page.getUser();
	System.out.println(page.toString());
	//System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	//System.out.println(suser.toString());
	if (page != null) {
		p[0] = page.getId() + "";
		p[1] = page.getBoardId() + "";
		p[2] = page.getUrl();
		p[3] = page.getTitle();
		p[4] = page.() + "";
		p[5] = page.getCreateTime().toString();
		p[6] = page.getReplyNum() + "";
		p[7] = user.getId() + "";//page.getCreator() + "";
		if (user == null)
			p[8] = page.getCreator() + "";
		else
			p[8] = user.getName();
	}
	back.add(p);*/
	
}
