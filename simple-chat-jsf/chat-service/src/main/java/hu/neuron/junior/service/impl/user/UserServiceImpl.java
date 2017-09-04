package hu.neuron.junior.service.impl.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.junior.client.api.service.user.UserService;
import hu.neuron.junior.client.api.vo.UserVo;
import hu.neuron.junior.core.dao.RoleDao;
import hu.neuron.junior.core.dao.UserDao;
import hu.neuron.junior.core.entity.Role;
import hu.neuron.junior.core.entity.User;
import hu.neuron.junior.service.mapper.user.UserVoMapper;

@Service("userService")
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	private static final String ROLE_USER = "ROLE_USER";

	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;

	@Override
	public UserVo findByUsername(String username) {
		User user = userDao.findByUsername(username);
		return UserVoMapper.toVo(user);

	}

	@Override
	public UserVo registrationUser(UserVo userVo) {
		User user = UserVoMapper.toEntity(userVo);

		List<Role> roles = new ArrayList<>();

		Role role = roleDao.findByName(ROLE_USER);
		roles.add(role);
		user.setRoles(roles);

		user = userDao.save(user);
		return UserVoMapper.toVo(user);
	}

	@Override
	public List<UserVo> findAll() {

		return UserVoMapper.toVo(userDao.findAll());
	}

}
