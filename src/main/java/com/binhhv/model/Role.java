package com.binhhv.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "roles")
public class Role {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	
//	@ManyToMany
//	@JoinTable(name="userandrole",
//				joinColumns=@JoinColumn(name="role_id"),
//				inverseJoinColumns=@JoinColumn(name="user_id")
//				)
//	private List<User> users;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="userandrole",
	joinColumns=@JoinColumn(name="role_id"),
	inverseJoinColumns=@JoinColumn(name="user_id")
	)
	private List<User> users;
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role(int id, String name, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}
	public Role() {
		super();
	}
	
	
}
