package com.dao.s;

import java.util.HashSet;
import java.util.Set;

public class SBoard {
	private long id;
	private String name;
	private SUser suser;
	private Set sposts = new HashSet();

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	public SUser getSuser() {
		return suser;
	}

	public void setSuser(SUser suser) {
		this.suser = suser;
	}

	public Set getSposts() {
		return sposts;
	}

	public void setSposts(Set sposts) {
		this.sposts = sposts;
	}



}
