package hu.neuron.junior.client.api.service.role;

import hu.neuron.junior.client.api.vo.RoleVo;

public interface RoleService {

	RoleVo findByName(String name);

	RoleVo save(RoleVo name);
}
