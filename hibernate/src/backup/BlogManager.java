package backup;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

import base.*;
import com.dao.*;

public class BlogManager extends BaseManager {

	// create and insert one record
	public void insert(String title, long creator, String location) {
		Session session = HibernateUtilFormal.currentSession();
		Transaction tx = session.beginTransaction();

		Blog blog = new Blog();
		blog.setTitle(title);
		blog.setCreator(creator);
		blog.setLocation(location);
		blog.setCreateTime(new Date());
		blog.setLastChangeTime(new Date());

		session.save(blog);

		tx.commit();
		HibernateUtilFormal.closeSession();
	}

	// select one record by primary key
	public Blog select(long id) {
		return (Blog) super.select("com.dao.Blog", id);
	}

	// select all records
	public List selectAll() {
		return super.selectAll("Blog");
	}

	// select one record by property
	public Blog selectOneByProperty(String property, String value) {
		return (Blog) super.selectOneByProperty("Blog", property, value);
	}

	// select all record by property
	public List selectAllByProperty(String property, String value) {
		return (List) super.selectAllByProperty("Blog", property, value);
	}

	public void delete(long id) {
		super.delete("com.dao.Blog", id);
	}

	public void deleteAllByProperty(String property, String value) {
		super.deleteAllByProperty("Blog", property, value);
	}

	public void updateAllByProperty(String property, String value) {
		super.updateProperty("Blog", property, value);
	}

	public static void main(String[] args) {
		BlogManager mgr = new BlogManager();

		String act = "list";

		if (act.equals("insert")) {
			mgr.insert("limingze", 3, "id=88207651");
		} else if (act.equals("list")) {
			List blogs = mgr.selectAll();
			for (int i = 0; i < blogs.size(); i++) {
				Blog blog = (Blog) blogs.get(i);
				System.out.println("title: " + blog.getTitle() + " creator: "
						+ blog.getCreator());
			}
		} else if (act.equals("get")) {
			Blog blog = mgr.selectOneByProperty("title", "a blog.");
			System.out.println("title: " + blog.getTitle() + " creator: "
					+ blog.getCreator());
		} else if (act.equals("delete")) {
			mgr.delete(1l);
		}

		/*
		 * int x = 5; while(true){ List blogs = mgr.selectAll(); if(x !=
		 * blogs.size()){ x = blogs.size(); System.out.println(blogs.size());
		 * break; } }
		 */

		HibernateUtilFormal.closeSession();
	}

}