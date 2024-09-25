package com.pms.usermanagement.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pms.usermanagement.constants.MessageConstant;
import com.pms.usermanagement.dao.CompanyDao;
import com.pms.usermanagement.dao.ModuleDao;
import com.pms.usermanagement.dao.PhoneSmsDao;
import com.pms.usermanagement.dao.RoleDao;
import com.pms.usermanagement.dao.TokenDao;
import com.pms.usermanagement.dao.UserDao;
import com.pms.usermanagement.dao.UserLoginDetailsDao;
import com.pms.usermanagement.dto.SignupDto;
import com.pms.usermanagement.enums.ModuleStatus;
import com.pms.usermanagement.enums.RoleStatus;
import com.pms.usermanagement.enums.UserStatus;
import com.pms.usermanagement.model.Company;
import com.pms.usermanagement.model.DeviceTokenDetails;
import com.pms.usermanagement.model.Response;
import com.pms.usermanagement.model.Role;
import com.pms.usermanagement.model.User;
import com.pms.usermanagement.service.ModuleService;
import com.pms.usermanagement.service.UserService;

@Service
public class UserServiceImpl extends MessageConstant implements UserService {
	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	// own amit
	// private static String apiKey = "57c41a74-9282-4afc-95a1-2080b6368fdd";

	private static String apiKey = "2c1d6e89-43c9-45af-a935-08929d351c22";

	@Autowired
	private RoleDao roleDao;



	@Autowired
	private PhoneSmsDao phonesmsdao;

	@Autowired
	private UserLoginDetailsDao userLoginDetailDao;

	@Autowired
	private MessageSource messageSource;



	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;




	ModelMapper modelMapper = new ModelMapper();

	@Value("${tokenSecretKey}")
	private String tokenSecretKey;

	@Value("${jwtconfig.expirationTime}")
	private int expirationTime;

	@Value("${tokenExpirationTime}")
	private int tokenExpirationTime;

	@Value("${otpExpirationTime}")
	private int otpExpirationTime;



	@Value("${spring.project.name}")
	private String projectName;

	@Autowired
	private TokenDao tokenDao;


	@Autowired
	private ModuleDao moduleDao;

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private ModuleService moduleService;





	@Override
	public Response<User> signupService(SignupDto signupDto,List<ModuleStatus> moduleStatus, Locale locale) {
	    User user = modelMapper.map(signupDto, User.class);
	    Company company = modelMapper.map(signupDto, Company.class);
	    DeviceTokenDetails deviceTokenDetails = modelMapper.map(signupDto, DeviceTokenDetails.class);
	    List<DeviceTokenDetails> details = new ArrayList<>();
	    details.add(deviceTokenDetails);

	    Role roleDto = modelMapper.map(signupDto, Role.class);
	    if (signupDto.getRoleStatus() == null) {
	        roleDto.setRole(RoleStatus.SUBADMIN);
	    }
	    Optional<Role> existRole = roleDao.findByRole(roleDto.getRole());
	    
//	    // Fetch the module entities by their status
//	    List<Module> modules = moduleStatus.stream()
//	        .map(status -> moduleDao.findByModuleName(status))  // Find module by status
//	        .collect(Collectors.toList());
//
//	    // Associate the modules with the company
//	    company.setModules(modules);
	   

	    LOGGER.debug("Detail using Role", existRole);
	    boolean existByEmail = userDao.existsByEmail(signupDto.getEmail());
	    boolean existByPhoneNumber = userDao.existsByPhoneNo(signupDto.getPhoneNo());

	    // Check if company name is unique
	    boolean existByCompanyName = companyDao.existsByCompanyName(signupDto.getCompanyName());
	    if (existByCompanyName) {
	        return new Response<>(205,
	                messageSource.getMessage("usermanagement.signup.companyname.exist", new Object[0], locale));
	    }

	    if (existByPhoneNumber) {
	        return new Response<>(205,
	                messageSource.getMessage("usermanagement.signup.phone.exist",  new Object[0], locale)); // Error for duplicate phone number
	    }

	    user.setPhoneNo(signupDto.getPhoneNo());

	    if (!existByEmail && existRole.isPresent()) {
	        user.setPassword(bCryptPasswordEncoder.encode(signupDto.getPassword()));
	        user.setRole(existRole.get());
	        user.setEmail(signupDto.getEmail());
	        user.setCreateDate(new Date());
	        user.setUserStatus(UserStatus.UNVERIFIED);

	        // Save the company first
	        company.setUser(user); // Set user to company
	        Company savedCompany = companyDao.save(company); // Persist company
	        
	        String generatedAlphaNumeric = RandomStringUtils.randomAlphanumeric(6);
			String companyName = signupDto.getCompanyName();
			company.setOrganisationId(generatedAlphaNumeric + companyName);

	        // Now, we can save the user
	        user.setCompany(savedCompany); // Associate saved company with user
	        User savedUser = userDao.save(user); // Persist user
	 //       companyDao.save(company);

	        return new Response<>(200,
					messageSource.getMessage("usermanagement.signup.success", new Object[0], locale));
	    }

	    return new Response<>(205, messageSource.getMessage("usermanagement.signup.email.exist", new Object[0], locale));
	}

	

}
