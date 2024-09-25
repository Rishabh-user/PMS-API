package com.pms.usermanagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.usermanagement.enums.RoleStatus;
import com.pms.usermanagement.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

	Optional<Role> findByRole(RoleStatus role);

	void deleteByRoleId(Long roleId);

	Optional<Role> findByRoleId(Long roleId);

	Optional<Role> findByRoleName(String role);

}
