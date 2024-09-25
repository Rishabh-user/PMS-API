package com.pms.usermanagement.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.pms.usermanagement.dao.ModuleDao;
import com.pms.usermanagement.dao.RoleDao;
import com.pms.usermanagement.dao.StateDao;
import com.pms.usermanagement.dao.UserDao;
import com.pms.usermanagement.enums.ModuleStatus;
import com.pms.usermanagement.enums.RoleStatus;
import com.pms.usermanagement.model.Module;
import com.pms.usermanagement.model.Role;

@Configuration
@EnableScheduling
public class InitializeUserService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModuleDao moduleDao;


	@Bean
	public InitializingBean initializeRoleTable() {
		return () -> {
			if (roleDao.findAll().isEmpty()) {
				RoleStatus[] roleStatus = RoleStatus.values();
				List<Role> roleList = new ArrayList<>();
				for (int i = 0; i < roleStatus.length; i++) {
					Role role = new Role();
					role.setRole(roleStatus[i]);
					roleList.add(role);
				}
				roleDao.saveAll(roleList);
			}
		};
	}
	
//	@Bean
//	public InitializingBean initializeModuleTable() {
//		return () -> {
//			if (moduleDao.findAll().isEmpty()) {
//				ModuleStatus[] moduleStatus = ModuleStatus.values();
//				List<Module> moduleList = new ArrayList<>();
//				for (int i = 0; i < moduleStatus.length; i++) {
//					Module module = new Module();
//					module.setModule_name(moduleStatus[i]);
//					moduleList.add(module);
//				}
//				moduleDao.saveAll(moduleList);
//			}
//		};
//	}
//
	
	  @Bean
	    public InitializingBean initializeModuleTable() {
	        return () -> {
	            if (moduleDao.findAll().isEmpty()) {
	                ModuleStatus[] moduleStatus = ModuleStatus.values();
	                List<Module> moduleList = new ArrayList<>();
	                for (ModuleStatus status : moduleStatus) {
	                    Module module = new Module();
	                    module.setModuleName(status); // Ensure correct field name
	                    moduleList.add(module);
	                }
	                moduleDao.saveAll(moduleList); // Save the list of modules
	            }
	        };
	    }

//	@Bean
//	public InitializingBean initializeStateTable(CountriesDao countriesDao) {
//		return () -> {
//			if (countriesDao.findAll().isEmpty()) {
//				String[] locales = Locale.getISOCountries();
//				for (String countryCode : locales) {
//					Countries countries = new Countries();
//					Locale obj = new Locale("", countryCode);
//					countries.setCountry(obj.getDisplayCountry());
//					countries.setCountryCode(obj.getCountry());
//					countriesDao.save(countries);
//				}
//			}
//			if (stateDao.findAll().isEmpty()) {
//				ObjectMapper mapper = new ObjectMapper();
//				TypeReference<StateList> mapType = new TypeReference<StateList>() {
//				};
//				InputStream is = TypeReference.class.getResourceAsStream("/json/state-list.json");
//				StateList stateList = mapper.readValue(is, mapType);
//				List<Countries> countryList = countriesDao.findAll();
//				if (!stateList.getCountries().isEmpty()) {
//					for (Countries countries : countryList) {
//						saveState(stateList, countries);
//					}
//				}
//			}
//		};
//	}

//	public void saveState(StateList stateList, Countries countries) {
//		for (Country country : stateList.getCountries()) {
//			if (country.getCountry().equalsIgnoreCase(countries.getCountry()) && !country.getStates().isEmpty()) {
//				for (String stateName : country.getStates()) {
//					States state = new States();
//					Countries countriess = new Countries();
//					countriess.setCountriesId(countries.getCountriesId());
//					state.setStateName(stateName);
//					state.setCountries(countriess);
//					stateDao.save(state);
//				}
//			}
//		}
//	}

}
