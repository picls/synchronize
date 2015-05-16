package com.web;

import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.dao.*;
import com.web.exception.*;

/**
 * 
 * @author anzhixiang
 * 
 */

public class JAccount {

	/** Cache the hash code for the User */
	private int hash;
	
	private Account account;
	private StateEnum state; 
	
	public enum StateEnum {
	    NULL,NEW,UPDATE,CHANGE,UNCHECK;
	}

	public static void main(String args[]) {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		cl.setPackageAssertionStatus("com.web", false);
		int i = 3;
		assert i>0;
//		try(FileInputStream fis = new FileInputStream();) {
//			
//		} catch(Exception e) {
//			
//		}
		
		PropertyConfigurator.configure("config/log4j.xml");
		System.out.println(JAccount.class.getName());
		Logger logger = Logger.getLogger(JAccount.class.getName());

		
		JAccount jaccount = new JAccount("test", "test", "test@163.com");
		try{
			jaccount.createAccount();
		}catch(DuplicateDataException e){
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			logger.info(e);
		}
	}



	private JAccount() {
		this.state = StateEnum.NULL;
	}

	public JAccount(String name, String password, String email) {
		setAccount(new Account(name, password, email));
		this.state = StateEnum.NEW;
	}

	public JAccount(String name, String password, String email, long qq) {
		setAccount(new Account(name, password, email, qq));
		this.state = StateEnum.NEW;
	}

	public JAccount(String name, String password, String email, long qq,
			Date createTime, Date LastLoginTime, int status) {
		setAccount(new Account(name, password, email, qq, createTime,
				LastLoginTime, status));
		this.state = StateEnum.NEW;
	}

	/**  */
	public JAccount(String name) throws NullDataException{
		setAccount(name);
	}

	/**  */
	public JAccount(long id) throws NullDataException{
		setAccount(id);
	}

	public Account getAccount() {
		return this.account;
	}
	
	private void setAccount(Account account) {
		this.account = account;
		this.state = StateEnum.UNCHECK;
	}
	
	private void setAccount(String name) throws NullDataException{
		Account account = AccountManagerStatic
				.selectOneByProperty("name", name);
		if(account == null)
			throw new NullDataException("Account with name " + name + " not existed.");
		setAccount(account);
		this.state = StateEnum.UPDATE;
	}
	
	private void setAccount(long id) throws NullDataException {
		Account account = AccountManagerStatic.select(id);
		if(account == null)
			throw new NullDataException("Account with id " + id + " not existed.");
		setAccount(account);
		this.state = StateEnum.UPDATE;
	}
	
	public String getState() {
		return this.state.toString();
	}

	/**  */
	public void createAccount() throws DuplicateDataException{
		if(this.state == StateEnum.NEW){
			try{
			AccountManagerStatic.insert(this.account);
			this.state = StateEnum.UPDATE;
			}catch(Exception e) {
				long id = this.account.getId();
				throw new DuplicateDataException("Account with id " + id + " already existed.");
			}
		}
	}

	public boolean checkAccountPassword(String password) {
		if(this.state == StateEnum.UPDATE)
			if(this.account.equals(password))
				return true;	
		return false;
	}
	
	public void login() {
		if(this.state == StateEnum.UPDATE){
			this.account.setStatus(1);
			//this.account.setLastLoginTime(new Date());
			AccountManagerStatic.update(this.account);
		}
	}
	
	public boolean login(String password) {
		if(this.state == StateEnum.UPDATE)
			if(this.checkAccountPassword(password)){
				this.account.setStatus(1);
				//this.account.setLastLoginTime(new Date());
				AccountManagerStatic.update(this.account);
				return true;
			}
		return false;
	}
	
	public void logout() {
		if(this.state == StateEnum.UPDATE){
			this.account.setStatus(0);
			AccountManagerStatic.update(this.account);
		}
	}
	
	public void changePassword(String password) {
		if(this.state == StateEnum.UPDATE){
			this.account.setPassword(password);
			AccountManagerStatic.update(this.account);
		}
	}
	
	public void changeQq(long Qq) {
		if(this.state == StateEnum.UPDATE){
			this.account.setQq(Qq);
			AccountManagerStatic.update(this.account);
		}
	}


}
