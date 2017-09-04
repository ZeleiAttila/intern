package hu.neuron.junior.service.impl.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.junior.client.api.service.role.RoleService;
import hu.neuron.junior.client.api.vo.RoleVo;
import hu.neuron.junior.core.dao.RoleDao;
import hu.neuron.junior.core.entity.Role;
import hu.neuron.junior.service.mapper.role.RoleVoMapper;

@Service("roleService")
@Transactional(propagation=Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDao roleDao;

	@Override
	public RoleVo findByName(String name) {
		Role findByName = roleDao.findByName(name);
		return RoleVoMapper.toVo(findByName);
	}

	@Override
	public RoleVo save(RoleVo name) {
		Role role = roleDao.save(RoleVoMapper.toEntity(name));
		return RoleVoMapper.toVo(role);
	}

}
