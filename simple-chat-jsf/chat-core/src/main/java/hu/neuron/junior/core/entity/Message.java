package hu.neuron.junior.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Message extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Lob
	private String content;

	@ManyToOne
	private User fromUser;

	@ManyToOne
	private User toUser;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

}
