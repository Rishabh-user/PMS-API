package com.pms.usermanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.usermanagement.dao.ModuleDao;
import com.pms.usermanagement.model.Module;
import com.pms.usermanagement.service.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleDao moduleDao;

	@Override
	public Module saveModule(Module module) {
		return moduleDao.save(module);
	}


//    @Override
//    public List<Module> getModulesByNames(List<ModuleSelection> moduleSelections) {
//        // Extract module names from the ModuleSelection list
//        List<String> moduleNames = moduleSelections.stream()
//            .map(ModuleSelection::getModule) // Assuming this returns the name
//            .collect(Collectors.toList());
//
//        // Fetch modules by names
//        return moduleDao.findByNameIn(moduleNames);
//    }
//	
//	 @Override
//	 public List<Module> getModulesByNames(List<String> names) {
//	        return moduleDao.findByNameIn(names);
//	    }
	

}
