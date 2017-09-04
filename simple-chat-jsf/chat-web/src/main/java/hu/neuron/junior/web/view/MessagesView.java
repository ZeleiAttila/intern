package hu.neuron.junior.web.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import hu.neuron.junior.client.api.service.message.MessageService;
import hu.neuron.junior.client.api.service.user.UserService;
import hu.neuron.junior.client.api.vo.MessageVo;
import hu.neuron.junior.client.api.vo.UserVo;

@ManagedBean(name = "messagesView")
@ViewScoped
public class MessagesView {

	@ManagedProperty(value="#{userService}")
	private UserService userService;

	@ManagedProperty(value="#{messageService}")
	private MessageService messageService;

	private UserVo fromUser;
	private UserVo toUser;
	private String content;

	private List<UserVo> users;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		String actUser = request.getUserPrincipal().getName();
		fromUser = userService.findByUsername(actUser);
		List<UserVo> findAll = userService.findAll();
		findAll.remove(fromUser);
		users = findAll;
		
	}

	public void send() {
		MessageVo message = new MessageVo();
		message.setContent(content);
		message.setFromUser(fromUser);
		message.setToUser(toUser);
		messageService.saveMessage(message);
	}
	
	

	public List<MessageVo> getMessages() {
		if (toUser != null) {
			return messageService.getMessages(fromUser, toUser);
		}
		return new ArrayList<MessageVo>();
	}

	public UserVo getToUser() {
		return toUser;
	}

	public void setToUser(UserVo toUser) {
		this.toUser = toUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public UserVo getFromUser() {
		return fromUser;
	}

	public void setFromUser(UserVo fromUser) {
		this.fromUser = fromUser;
	}

	public List<UserVo> getUsers() {
		return users;
	}

	public void setUsers(List<UserVo> users) {
		this.users = users;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


}
