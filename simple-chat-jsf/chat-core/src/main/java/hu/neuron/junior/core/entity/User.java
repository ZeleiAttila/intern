package hu.neuron.junior.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	public User() {
		super();
	}

	@Lob
	private byte[] image;

	@ManyToMany
	private List<Role> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
