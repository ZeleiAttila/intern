package hu.neuron.junior.web.view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.neuron.junior.client.api.service.user.UserService;
import hu.neuron.junior.client.api.vo.UserVo;

@ManagedBean(name = "registrationView")
@ViewScoped
public class RegistrationView {
	private static Logger logger = Logger.getLogger(RegistrationView.class);

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	private UserVo userVo;

	@PostConstruct
	public void init() {
		userVo = new UserVo();
	}

	public void registration() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			UserVo check = getUserService().findByUsername(userVo.getUsername());
			if (check != null) {
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Usernem already use!"));

			} else {

				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				String encryptedPass = bCryptPasswordEncoder.encode(userVo.getPassword());
				userVo.setPassword(encryptedPass);

				getUserService().registrationUser(userVo);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "Registration!"));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Registration!"));

		}
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
