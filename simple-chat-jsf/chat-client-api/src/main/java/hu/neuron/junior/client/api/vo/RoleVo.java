package hu.neuron.junior.client.api.vo;

import java.io.Serializable;

public class RoleVo extends BaseVo implements Serializable {

	private static final long serialVersionUID = -4090329349403410228L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
