package com.binhhv.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = true)
	private String email;
	@Column
	private String password;
	@Column
	private String confirm_code;
	@Column
	private int confirmed;
	@Column
	private int status;
	@Column
	private Date created_at;
	@Column
	private Date updated_at;
	@Column
	private int disable_flag;
	@Column
	private int delete_flag;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="userandrole",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="role_id")
				)
	private List<Role> roles;
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_code() {
		return confirm_code;
	}
	public void setConfirm_code(String confirm_code) {
		this.confirm_code = confirm_code;
	}
	public int getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	public int getDisable_flag() {
		return disable_flag;
	}
	public void setDisable_flag(int disabled_flag) {
		this.disable_flag = disabled_flag;
	}
	public int getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}
	
	public User(int id, String username, String email, String password,
			String confirm_code, int confirmed, int status, Date created_at,
			Date updated_at, int disabled_flag, int delete_flag,
			List<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirm_code = confirm_code;
		this.confirmed = confirmed;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.disable_flag = disabled_flag;
		this.delete_flag = delete_flag;
		this.roles = roles;
	}
	public User() {
		super();
	}
	
	public Collection<GrantedAuthority> getAuthorities(){
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role : this.getRoles()){
			authorities.add(new GrantedAuthorityImpl(role.getName()));
		}
		return authorities;
	}
	
}
