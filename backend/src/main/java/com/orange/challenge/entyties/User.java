package com.orange.challenge.entyties;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	private String name;
	
	@Column(nullable = false, length = 250, unique=true)
	private String email;
	
	@Column(nullable = false, length = 11, unique=true)
	private String cpf;
	
	@Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant birtdate;
	
	@ManyToMany
	@JoinTable(name= "tb_user_address",
	     joinColumns = @JoinColumn(name= "user_id" ),
	     inverseJoinColumns = @JoinColumn(name= "address_id")
			)
	Set<Address> addresses = new HashSet<>();
	
	public User() {
	}

	public User(Long id, String name, String email, String cpf, Instant birtdate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birtdate = birtdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Instant getBirtDate() {
		return birtdate;
	}

	public void setBirtDate(Instant birtDate) {
		this.birtdate = birtDate;
	}

	public Set<Address> getAddresses() {
		return addresses;
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
