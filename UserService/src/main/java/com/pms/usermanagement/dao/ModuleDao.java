package com.pms.usermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.usermanagement.enums.ModuleStatus;
import com.pms.usermanagement.model.Module;

@Repository
public interface ModuleDao extends JpaRepository<Module, Long> {

//	List<Module> findByNameIn(List<String> names);
	
	//public abstract Module findByModuleName(ModuleStatus moduleName);

	Module findByModuleName(ModuleStatus moduleName);

	
  
}

