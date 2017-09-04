package hu.neuron.junior.client.api.service.user;

import java.util.List;

import hu.neuron.junior.client.api.vo.UserVo;

public interface UserService {

	UserVo findByUsername(String username);

	UserVo registrationUser(UserVo userVo);
	
	List<UserVo> findAll();
}
