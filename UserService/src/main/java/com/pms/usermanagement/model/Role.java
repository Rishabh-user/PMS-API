package com.pms.usermanagement.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pms.usermanagement.enums.RoleStatus;

@Entity
@Table
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@Enumerated(EnumType.STRING)
	private RoleStatus role;

	private String roleName;

	@JsonIgnore
	@OneToMany(mappedBy = "role")
	private List<User> users;



	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Role(long roleId) {
		this.roleId = roleId;
	}

	public Role() {
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public RoleStatus getRole() {
		return role;
	}

	public void setRole(RoleStatus role) {
		this.role = role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


}
