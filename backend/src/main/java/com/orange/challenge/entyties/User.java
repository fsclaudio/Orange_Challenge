package com.orange.challenge.entyties;

import java.time.Instant;

public class User {
	private Long id;
	private String userName;
	private String userEmail;
	private String UserCpf;
	private Instant userBirtDate;
	
	public User() {
	}

	public User(Long id, String userName, String userEmail, String userCpf, Instant userBirtDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		UserCpf = userCpf;
		this.userBirtDate = userBirtDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserCpf() {
		return UserCpf;
	}

	public void setUserCpf(String userCpf) {
		UserCpf = userCpf;
	}

	public Instant getUserBirtDate() {
		return userBirtDate;
	}

	public void setUserBirtDate(Instant userBirtDate) {
		this.userBirtDate = userBirtDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
