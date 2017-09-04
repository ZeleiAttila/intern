package hu.neuron.junior.web.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import hu.neuron.junior.client.api.service.user.UserService;
import hu.neuron.junior.client.api.vo.UserVo;

@ManagedBean(name = "usersView")
@ViewScoped
public class UsersView {

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	private List<UserVo> users;

	@PostConstruct
	public void init() {

		setUsers(userService.findAll());

	} 

	public UserVo getCurrentUser(){
		UserVo uservo = new UserVo();
		if( FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() != null){
			String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
			uservo = userService.findByUsername(username);
			
		}
		
		return uservo;
	}
	
	public List<UserVo> getUsers() {
		return users;
	}

	public void setUsers(List<UserVo> users) {
		this.users = users;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
