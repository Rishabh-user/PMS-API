package com.pms.usermanagement.emailservice;

import java.util.List;

public interface MailSender {
	// start,
	List<String> sendMail(Mail mail);
	// end,

}
